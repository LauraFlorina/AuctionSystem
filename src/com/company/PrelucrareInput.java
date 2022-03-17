package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrelucrareInput {

    /**
     * Demersurile necesare pentru adaugarea unui produs
     * @param casaLicitatii casa licitatii
     * @param cuvinte cuvinte input
     * @param factory factory-ul pentru crearea produselor
     */
    public static void adaugaProdus(CasaLicitatii casaLicitatii, String[] cuvinte,
                             Factory factory) {
        Produs produs = factory.creeazaProdus(cuvinte);
        int nrParticipanti = Integer.parseInt(cuvinte[cuvinte.length - 1]);
        casaLicitatii.getAdmin().adaugaProdus(casaLicitatii, produs, nrParticipanti);
    }

    /**
     * Demersurile necesare pentru a adauga un client
     * @param casaLicitatii casa licitatii
     * @param cuvinte cuuvinte
     */
    public static void adaugaClient(CasaLicitatii casaLicitatii, String[] cuvinte) {
        Client client = null;
        if (cuvinte[4].equals("persoana fizica")) {
            client = new PersoanaFizicaBuilder().withId(Integer.parseInt(cuvinte[1]))
                    .withNume(cuvinte[2])
                    .withAdresa(cuvinte[3])
                    .withDataNastere(cuvinte[5]).build();
        } else if (cuvinte[4].equals("persoana juridica")) {
            client = new PersoanaJuridicaBuilder().withId(Integer.parseInt(cuvinte[1]))
                    .withNume(cuvinte[2])
                    .withAdresa(cuvinte[3])
                    .withCompanie(Companie.valueOf(cuvinte[5]))
                    .withCapitalSocial(Double.parseDouble(cuvinte[6]))
                    .build();
        }
        casaLicitatii.adaugaClient(client);

    }

    /**
     * adauga broker in casa de licitatii
     * @param casaLicitatii casa licitatii
     * @param cuvinte cuvinte input
     */
    public static void adaugaBroker(CasaLicitatii casaLicitatii, String[] cuvinte) {
        Broker broker = new Broker(Integer.parseInt(cuvinte[1]),cuvinte[2], casaLicitatii);
        casaLicitatii.adaugaBroker(broker);
    }

    /**
     * Interogare produse de catre un client
     * @param casaLicitatii casa licitatii
     * @param cuvinte cuvinte
     */
    public synchronized static void interogareProduse(CasaLicitatii casaLicitatii, String[] cuvinte) {
        System.out.println("Clientul \"" + cuvinte[2] + "\" solicita vizualizarea produselor");
        int idClient = Integer.parseInt(cuvinte[1]);
        casaLicitatii.cautaClient(idClient).vizualizareProduse(casaLicitatii);
        System.out.println();
    }

    /**
     * Solicitarea unui produs de catre un client
     * @param casaLicitatii casa licitatii
     * @param cuvinte cuvinte input
     */
    public static void solicitaProdus(CasaLicitatii casaLicitatii, String[] cuvinte) {
        int idClient = Integer.parseInt(cuvinte[1]);
        int idProdus = Integer.parseInt(cuvinte[3]);
        Double pretMaxOferit = Double.parseDouble(cuvinte[4]);

        Client client = casaLicitatii.cautaClient(idClient);
        client.solicitaProdus(casaLicitatii, idProdus, pretMaxOferit);
    }


    public static void main(String[] args) {
        CasaLicitatii casaLicitatii = CasaLicitatii.InstantaCasaLicitatii();
        Administrator admin = new Administrator(1, "Administrator");
        casaLicitatii.setAdmin(admin);
        Factory factory = new Factory();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test9.txt"));
            String linie = null;
            while((linie = reader.readLine()) != null) {
                String[] cuvinte = linie.split(",");
                if (cuvinte[0].equals("produs")){
                    PrelucrareInput.adaugaProdus(casaLicitatii, cuvinte, factory);
                } else if (cuvinte[0].equals("client")) {
                    PrelucrareInput.adaugaClient(casaLicitatii, cuvinte);
                } else if (cuvinte[0].equals("broker")) {
                    PrelucrareInput.adaugaBroker(casaLicitatii, cuvinte);
                } else if (cuvinte[0].equals("interogare_produse")) {
                    PrelucrareInput.interogareProduse(casaLicitatii, cuvinte);
                } else if (cuvinte[0].equals("solicita_produs")){
                    solicitaProdus(casaLicitatii, cuvinte);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
