package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Modelarea unui broker ce lucreaza la o casa de licitatii.
 */
public class Broker extends Angajat{
    private ArrayList<Client> clienti;
    private HashMap<Licitatie, Double> maxPerLicitatie;
    private CasaLicitatii casaLicitatii;
    private int nrLicitatiiActive;
    private double comision;

    /**
     * Constructor cu parametrii
     * @param id id
     * @param nume nume
     * @param casaLicitatii casa licitatii
     */
    public Broker(int id, String nume, CasaLicitatii casaLicitatii) {
        super(id, nume);
        this.clienti = new ArrayList<>();
        this.maxPerLicitatie = new HashMap<>();
        this.casaLicitatii = casaLicitatii;
        this.casaLicitatii.adaugaBroker(this);
    }

    /**
     * Returneaza lista clientilor
     * @return lista clienti
     */
    public ArrayList<Client> getClienti() {
        return clienti;
    }

    /**
     * Returneaza HashMap-ul maxPerLicitatie.
     * @return HashMap-ul maxPerLicitatie
     */
    public synchronized HashMap<Licitatie, Double> getPretMaxPasCurrent() {
        return maxPerLicitatie;
    }

    /**
     * Returneaza casa de licitatii
     * @return casa licitatii
     */
    public CasaLicitatii getCasaLicitatii() {
        return casaLicitatii;
    }

    /**
     * Returneaza numarul licitatiilor active
     * @return
     */
    public int getNrLicitatiiActive() {
        return nrLicitatiiActive;
    }

    /**
     * Seteaza comisionul
     * @param comision
     */
    public void setComision(int comision) {
        this.comision = comision;
    }

    /**
     * Returneaza HashMap-ul maxPerLicitatiee
     * @return HashMap-ul maxPerLicitatie
     */
    public HashMap<Licitatie, Double> getMaxPerLicitatie() {
        return maxPerLicitatie;
    }

    /**
     * returneaza comisionul
     * @return comision
     */
    public double getComision() {
        return comision;
    }

    /**
     * Adauga un client
     * @param client client
     */
    public void adaugaClient(Client client) {
        clienti.add(client);
    }

    /**
     * Returneaza numarul de clienti
     * @return nr clienti
     */
    public int numarClienti() {
        return clienti.size();
    }

    /**
     * Sterge un client
     * @param client client
     */
    public void stergeClient(Client client) {
        clienti.remove(client);
    }

    /**
     * Sterge un produs
     * @param casaLicitatii casa licitatii
     * @param produs produs
     */
    public void stergeProdus(CasaLicitatii casaLicitatii, Produs produs) {
        casaLicitatii.getProduse().remove(produs);
    }

    /**
     * Incrementare numar licitatii active
     */
    public void actualizareNrLicitatiiActive(){
        nrLicitatiiActive += 1;
    }

    /**
     * Adauga in HashMap ul maxPerLicitatie, o intrare avand cheia licitatie
     * si valoarea 0.0
     * @param licitatie licitatie
     */
    public void initMaxPerLicitatie(Licitatie licitatie) {
        maxPerLicitatie.put(licitatie, 0.0);
        notificaClientiStart(licitatie);
    }

    /**
     * Notifica clientii unei licitatii ca licitatia a pornit
     * @param licitatie licitatie
     */
    public void notificaClientiStart(Licitatie licitatie) {
        for (Client client : clienti) {
            for (IntrareLicitatie intrare : casaLicitatii.intrariPentruLicitatie(licitatie)) {
                if (intrare.getClient() == client) {
                    client.initMaxPerLicitatie(licitatie);
                }
            }
        }
    }

    /**
     * Solicita clientului sa liciteze o suma, intre pretul curent si pretul maxim
     * oferit de client
     * @param client client
     * @param pretCurent pret curent
     * @param pretMaxOferit pret maxim
     * @return
     */
    public double obtineSumaLicitata(Client client, double pretCurent,
                                     double pretMaxOferit) {
        return client.liciteaza(pretCurent, pretMaxOferit);
    }

    /**
     * Notifica casa de licitatii de suma pe care a oferit-o clientul
     * @param intrareLicitatie intrare licitatie
     * @param sumaLicitata suma
     */
    public void notificaCasaLicitatii(IntrareLicitatie intrareLicitatie, double sumaLicitata) {
        anuntaSumaLicitata(intrareLicitatie, sumaLicitata);
        casaLicitatii.setPretPerPas(intrareLicitatie, sumaLicitata);
    }

    /**
     * Metoda care afiseaza suma licitata pentru un produs de catre cliennt
     * @param intrareLicitatie intrare licitatie
     * @param sumaLicitata suma
     */
    public void anuntaSumaLicitata(IntrareLicitatie intrareLicitatie, double sumaLicitata) {
        Client client = intrareLicitatie.getClient();
        System.out.println("Clientul \"" + client.getNume() + "\" ofera " + sumaLicitata +
                " pentru produsul " + intrareLicitatie.getProdus().getNume()
                + "      [cu specificatiile:" + intrareLicitatie.getProdus() +
                "]");
    }

    /**
     * Seteaza in hashMap ul maxPerLicitatie pentru o licitatie, pretul maxim
     * la pasul curent
     * @param licitatie licitatie
     * @param pret pret
     */
    public void setMaxPerLicitatie(Licitatie licitatie, double pret) {
        maxPerLicitatie.replace(licitatie, pret);
        notificaClientPretCurent(licitatie, pret);
    }

    /**
     * Notifica clientul de suma maxima oferita la pasul curent pentru licitatie
     * @param licitatie licitatie
     * @param pret pret
     */
    public void notificaClientPretCurent(Licitatie licitatie, double pret) {
        for (Client client : clienti) {
            // se verifica daca clientul participa la licitatie
            if (client.getMaxPerLicitatie().get(licitatie) != null) {
                client.setMaxPerLicitatie(licitatie, pret);
            }
        }
    }


    /**
     * Brokerul afiseaza un mesaj cu privire la castigator.
     * Acesta trimite un mesaj clientilor care au participat la licitatie,
     * anuntand castigatorul.
     * Acesta incrementeaza si numarul de licitatii castigate, pentru
     * castigator.
     * @param licitatie licitatie
     * @param castigator castigator
     */
    public void notificaCastigator(Licitatie licitatie, Client castigator) {
        String text = "Clientul castigator al licitatiei" + licitatie + "este: " +
                castigator;
        Mesaj mesaj = new Mesaj(licitatie, this, castigator, text);
        for (Client client : clienti) {
            if (client.getMaxPerLicitatie().get(licitatie) != null) {
                client.primesteMesaj(mesaj);
            }
        }
        castigator.incNrLicitatiiCastigate();
    }

    /**
     * Algoritmul de calcul al comisionului
     * @param castigator castigator
     * @param suma suma
     */
    public void calculComision(Client castigator, Double suma) {
        if (castigator instanceof PersoanaFizica) {
            if (castigator.getNrParticipari() < 5) {
                comision += 0.2 * suma;
            } else {
                comision += 0.15 * suma;
            }
        } else if (castigator instanceof PersoanaJuridica) {
            if (castigator.getNrParticipari() < 25) {
                comision += 0.25 * suma;
            } else {
                comision += 0.1 * suma;
            }
        }
    }

    /**
     * Reseteaza licitatia. Face licitatia inactiva.
     * @param licitatie licitatie
     */
    public void reseteazaLicitatie(Licitatie licitatie) {
        licitatie.setActiva(false);
        licitatie.setCastigator(null);
        licitatie.setNrInscrisi(0);
        maxPerLicitatie.replace(licitatie, 0.0);
    }

    /**
     * Inchide licitatia.
     * Se notifica clientii ca licitatia s-a incheiat.
     * Daca nu exista un castigator pentru licitatie, ea este resetata
     * altfel, produsul si licitatia sunt sterse
     * @param licitatie licitatie
     * @param castigator castigato
     */
    public synchronized void incheieLicitatie(Licitatie licitatie, Client castigator) {
        notificaLicitatieIncheiata(licitatie, castigator);
        if (castigator == null) {
            reseteazaLicitatie(licitatie);
        } else {
            casaLicitatii.stergeProdus(licitatie.getIdProdus());
            casaLicitatii.stergeLicitatie(licitatie);
            maxPerLicitatie.remove(licitatie);
        }
    }

    /**
     * Se notifica clientii care au participat la licitatie, ca aceasta s-a incheiat.
     * @param licitatie licitatie
     * @param castigator castigator
     */
    public void notificaLicitatieIncheiata(Licitatie licitatie, Client castigator) {
        ArrayList<Client> clientiLicitatieCurenta = new ArrayList<>();
        for (Client client : clienti) {
            // Se verifica daca clientul a participat la licitatie
            if (client.getMaxPerLicitatie().get(licitatie) != null) {
                clientiLicitatieCurenta.add(client);
                client.parasesteLicitatia(licitatie);
            }
        }
        for (Client client : clientiLicitatieCurenta) {
            clienti.remove(client);
        }
    }
}
