package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Modelarea unei case de licitatii
 */
public class CasaLicitatii {
    private Administrator admin;
    private List<Produs> produse;
    private ArrayList<Client> clienti;
    private ArrayList<Licitatie> licitatiiActive;
    private HashMap<Licitatie, ArrayList<IntrareLicitatie>> intrariLicitatie;
    private ArrayList<Broker> listaBrokeri;

    private static CasaLicitatii instantaUnica;

    /**
     * Constructor fara parametrii
     */
    private CasaLicitatii() {
        this.produse = Collections.synchronizedList(new CopyOnWriteArrayList<>());
        this.clienti = new ArrayList<>();
        this.licitatiiActive = new ArrayList<>();
        this.intrariLicitatie = new HashMap();
        this.listaBrokeri = new ArrayList<>();
    }

    /**
     * Creaza instanta unica a casei de licitatii
     * @return instanta unica casa licitatii
     */
    public static CasaLicitatii InstantaCasaLicitatii() {
        if (instantaUnica == null) {
            instantaUnica = new CasaLicitatii();
        }
        return instantaUnica;
    }


    /**
     * Seteaza admin
     * @param admin
     */
    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    /**
     * Returneaza admin
     * @return admin
     */
    public Administrator getAdmin() {
        return admin;
    }

    /**
     * Returneaza produse
     * @return produse
     */
    public List<Produs> getProduse() {
        return produse;
    }

    /**
     * Returneaza lista clienti
     * @return clientii
     */
    public ArrayList<Client> getClienti() {
        return clienti;
    }

    /**
     * adauga un broker
     * @param broker broker
     */
    public void adaugaBroker(Broker broker) {
        listaBrokeri.add(broker);
    }

    /**
     * Returneaza licitatiile active
     * @return licitatii active
     */
    public ArrayList<Licitatie> getLicitatiiActive() {
        return licitatiiActive;
    }

    /**
     * returneaza intrarile la o licitatie
     * @return hashmap intrari licitatie
     */
    public HashMap<Licitatie, ArrayList<IntrareLicitatie>> getIntrariLicitatie() {
        return intrariLicitatie;
    }

    /**
     * returneaza lista brokeri
     * @return lista brokeri
     */
    public ArrayList<Broker> getListaBrokeri() {
        return listaBrokeri;
    }


    /**
     * Adauga un client
     * @param client client
     */
    public void adaugaClient(Client client) {
        clienti.add(client);
    }

    /**
     * Cauta client dupa id
     * @param id id
     * @return client
     */
    public Client cautaClient(int id) {
        for (Client client : clienti)  {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    /**
     * cauta produs dupa id
     * @param idProdus id
     * @return produs
     */
    public Produs produsDisponibil(int idProdus) {
        for (Produs produs : produse) {
            if (produs.getId() == idProdus) {
                return produs;
            }
        }
        return null;
    }

    /**
     * afiseaza produsele
     */
    public synchronized void afisareProduse() {
        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }

    /**
     * Cauta licitatie dupa produs
     * @param idProdus id
     * @return licitatie
     */
    public Licitatie cautaLicitatieDupaProdus(int idProdus) {
        for (Licitatie licitatie : licitatiiActive) {
            if (licitatie.getIdProdus() == idProdus) {
                return licitatie;
            }
        }
        return null;
    }

    /**
     * cauta intrare la licitatie dupa client
     * @param licitatie licitatie
     * @param client client
     * @return intrare licitatie
     */
    public IntrareLicitatie cautaIntrareDupaClient(Licitatie licitatie,
                                                   Client client) {
        for (IntrareLicitatie intrare : intrariLicitatie.get(licitatie)) {
            if (client == intrare.getClient()) {
                return intrare;
            }
        }
        return null;
    }

    /**
     * modifica pretuul curent pentru o licitatie
     * @param intrareLicitatie intrare licitatie
     * @param sumaCurenta suma
     */
    public void modificaPretCurent(IntrareLicitatie intrareLicitatie, double sumaCurenta) {
        intrareLicitatie.setSumaCurenta(sumaCurenta);
    }

    /**
     * adauga licitatie
     * @param licitatie licitatie
     */
    public void adaugaLicitatie(Licitatie licitatie) {
        this.licitatiiActive.add(licitatie);
        intrariLicitatie.put(licitatie, new ArrayList<>());
    }

    /**
     * sterge licitatie
     * @param licitatie licitatie
     */
    public void stergeLicitatie(Licitatie licitatie) {
        licitatiiActive.remove(licitatie);
    }

    /**
     * sterge produs
     * @param idProdus idProdus
     */
    public void stergeProdus(int idProdus) {
        Produs produs = produsDisponibil(idProdus);
        if (produs != null) {
            produse.remove(produs);
        }
    }

    /**
     * Intoarce numele unui produus licitat
     * @param licitatie licitatie
     * @return nume
     */
    public String getNumeProdusLicitat(Licitatie licitatie) {
        return getProdusLicitat(licitatie).getNume();
    }

    /**
     * Intoarce produs liciitat
     * @param licitatie liciitatie
     * @return produs
     */
    public Produs getProdusLicitat(Licitatie licitatie) {
        int idProdus = licitatie.getIdProdus();
        for (Produs produs : produse) {
            if (produs.getId() == idProdus) {
                return produs;
            }
        }
        return null;
    }

    /**
     * sterge produs
     * @param produs produs
     */
    public void stergeProdus(Produs produs) {
        produse.remove(produs);
    }

    /**
     * cauta broker
     * @return broker
     */
    public Broker cautaBroker() {
        int numarClientiFavorabil = 0;
        while(true) {
            for (Broker broker : listaBrokeri) {
                if (broker.numarClienti() == numarClientiFavorabil){
                    return broker;
                }
            }
            numarClientiFavorabil += 1;
        }
    }

    /**
     * asociata unui client un broker.
     * @param client client
     * @param broker broker
     */
    public void AsociazaBroker(Client client, Broker broker) {
        System.out.println("Clientul : " + client.getNume() + " are brokerul " +
                broker.getNume());
        broker.adaugaClient(client);
        client.setBroker(broker);
    }

    /**
     * Mesaj licitatie inceputa
     * @param nume nume
     * @param produs produs
     */
    public void mesajLicitatieInceputa(String nume, String produs) {
        System.out.println("Draga " + nume + " licitatia pentru " +
                produs + " a inceput deja. Ne pare rau.");
    }

    /**
     * Intampina o solicitare din partea unui client
     * Daca licitatia e deja activa, atunci se opreste.
     * Altfel, asociaza un broker clientului.
     * @param client client
     * @param idProdus id produs
     * @param pretMaxim pret maxim
     */
    public void intampinaSolicitare(Client client, int idProdus, double pretMaxim) {
        Produs produsSolicitat = produsDisponibil(idProdus);
        if (produsSolicitat == null) {
            return;
        }

        Licitatie licitatieProdus = cautaLicitatieDupaProdus(idProdus);
        if (licitatieProdus.isActiva() == true) {
            mesajLicitatieInceputa(client.getNume(), produsSolicitat.getNume());
            return;
        }
        licitatieProdus.setNrInscrisi(licitatieProdus.getNrInscrisi() + 1);

        // creeaza o noua intrare la licitatie
        IntrareLicitatie intrareLicitatie = new IntrareLicitatie
                (client, produsSolicitat, pretMaxim);
        intrariLicitatie.get(licitatieProdus).add(intrareLicitatie);

        AsociazaBroker(client, cautaBroker());

        if (licitatieProdus.getNrInscrisi() ==
                licitatieProdus.getNrParticipanti()) {
            pornesteLicitatia(licitatieProdus);
        }
    }

    /**
     * returneaza intrarile pentru licitatie
     * @param licitatie
     * @return
     */
    public ArrayList<IntrareLicitatie> intrariPentruLicitatie(Licitatie licitatie) {
        return intrariLicitatie.get(licitatie);
    }

    /**
     * notifica brokerul cand incepe o licitatie
     * @param licitatie licitatie
     * @param broker broker
     */
    public void notificaBrokerStart(Licitatie licitatie, Broker broker) {
        broker.actualizareNrLicitatiiActive();
        broker.initMaxPerLicitatie(licitatie);
    }

    /**
     * porneste licitatie. Seteaza licitatia activa
     * Creeaza un nouu thread pe care il porneste.
     * Notifica brokerii de start
     * @param licitatie licitatiie
     */
    public void pornesteLicitatia(Licitatie licitatie) {
        licitatie.setActiva(true);
        Thread threadLicitatie = new Thread(licitatie);
        threadLicitatie.start();
        for (Broker broker : listaBrokeri){
            notificaBrokerStart(licitatie, broker);
        }
    }

    /**
     * Seteaza pentru intrarea la o licitatie, pretul curent
     * @param intrareLicitatie intrare liciitatie
     * @param pretCurent pret
     */
    public void setPretPerPas(IntrareLicitatie intrareLicitatie, double pretCurent) {
        intrareLicitatie.setSumaCurenta(pretCurent);
    }

    /**
     * Calculeaza suma maxima la un pas al licitatiei
     * @param licitatie licitatie
     * @return suma max
     */
    public double sumaMaxPerPas(Licitatie licitatie) {
        double sumaMax = 0.0;
        for (IntrareLicitatie intrare : intrariLicitatie.get(licitatie)) {
            if (intrare.getSumaCurenta() > sumaMax) {
                sumaMax = intrare.getSumaCurenta();
            }
        }
        return sumaMax;
    }

    /**
     * notifica brokerii de suma maxima per pas
     * @param licitatie licitatie
     * @return suma
     */
    public double notificaSumaMax(Licitatie licitatie) {
        double sumaMax = sumaMaxPerPas(licitatie);
        licitatie.setPretAtins(sumaMax);

        for (Broker broker : listaBrokeri) {
            if (broker.getPretMaxPasCurrent().get(licitatie) != null) { // brokerul are licitatia activa
                broker.setMaxPerLicitatie(licitatie, sumaMax);
            }
        }
        return sumaMax;
    }

    /**
     * Determina castigator
     * @param licitatie licitatie
     * @return castigator
     */
    public Client determinaCastigator(Licitatie licitatie) {
        double sumaMax = sumaMaxPerPas(licitatie);
        ArrayList<Client> potentialiCastigatori = new ArrayList<>();
        for (IntrareLicitatie intrare : intrariPentruLicitatie(licitatie)) {
            if (intrare.getSumaCurenta() == sumaMax) {
                potentialiCastigatori.add(intrare.getClient());
            }
        }
        if (potentialiCastigatori.size() == 1) {
            return potentialiCastigatori.get(0);
        } else {
            Client castigator = null;
            int maxLicitatiiCastigate = 0;
            for (Client client : potentialiCastigatori) {
                if (client.getNrLicitatiiCastigate() > maxLicitatiiCastigate) {
                    maxLicitatiiCastigate = client.getNrLicitatiiCastigate();
                    castigator = client;
                }
            }
            licitatie.setCastigator(castigator);
            return castigator;
        }
    }

    /**
     * anunta castigatorul
     * @param licitatie licitatie
     * @param castigator castigator
     */
    public synchronized void anuntaCastigator(Licitatie licitatie, Client castigator) {
        System.out.println("Castigatorul licitatiei pentru produsul \"" +
                produsDisponibil(licitatie.getIdProdus()).getNume() +
                " \" este: " + castigator.getNume());
        System.out.println("_____Licitatie incheiata_____");
    }

    public synchronized void mesajLicitatieNecastigata(String numeProdus) {
        System.out.println("Licitatia pentru produsul " + numeProdus +
                " nu are niciun castigator.");
    }

    /**
     * notiifica castigatorul
     * @param licitatie licitatie
     * @param castigator castigaatoor
     */
    public synchronized void notificaCastigator(Licitatie licitatie, Client castigator) {
        if (castigator == null) {
            mesajLicitatieNecastigata(getNumeProdusLicitat(licitatie));
            return;
        }
        anuntaCastigator(licitatie, castigator);
        for (Broker broker : listaBrokeri) {
            if (broker.getPretMaxPasCurrent().get(licitatie) != null) { // brokerul are licitatia activa
                broker.notificaCastigator(licitatie, castigator);
            }
        }
    }

    /**
     * seteaza pretul de vanzazre pentru un produs licitat
     * @param licitatie licitatie
     * @param sumaMax suma
     */
    public void seteazaPretVanzare(Licitatie licitatie, double sumaMax) {
        getProdusLicitat(licitatie).setPretVanzare(sumaMax);
    }
}
