package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Modelarea unei entitati client.
 */
public class Client {
    private int id;
    private String nume;
    private String adresa;
    private int nrParticipari;
    private int nrLicitatiiCastigate;
    private HashMap<Licitatie, Double> maxPerLicitatie;
    private Broker broker;
    private ArrayList<Mesaj> mesaje;

    /**
     * Constructor fara parametrii.
     */
    public Client() {
        this.maxPerLicitatie = new HashMap<>();
        this.mesaje = new ArrayList<>();
    }

    /**
     * Constructor cu parametrii.
     * @param id id
     * @param nume nume
     * @param adresa adresa
     */
    public Client(int id, String nume, String adresa) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.nrParticipari = 0;
        this.nrLicitatiiCastigate = 0;
        this.maxPerLicitatie = new HashMap<>();
        this.mesaje = new ArrayList<>();
    }

    /**
     * Seteaza id-ul
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Seteaza numele
     * @param nume nume
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Seteaza adresa
     * @param adresa adresa
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Seteaza numarul de participanti
     * @param nrParticipari numar participanti
     */
    public void setNrParticipari(int nrParticipari) {
        this.nrParticipari = nrParticipari;
    }

    /**
     * Seteaza numarul de licitatii castigate
     * @param nrLicitatiiCastigate numar licitatii castigate
     */
    public void setNrLicitatiiCastigate(int nrLicitatiiCastigate) {
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
    }

    /**
     * Seteaza broker
     * @param broker broker
     */
    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    /**
     * Seteaza un mesaj
     * @param mesaje
     */
    public void setMesaje(ArrayList<Mesaj> mesaje) {
        this.mesaje = mesaje;
    }

    /**
     * Returneaza un mesaj
     * @return mesaj
     */
    public ArrayList<Mesaj> getMesaje() {
        return mesaje;
    }

    /**
     * Returneaza un hashMap, in care cheia e reprezentata de o licitatie,
     * iar valoarea reprezinta suma maxima atinsa la pasul curent
     * al licitatiei
     * @return hashmap ce asociaza unei licitatii, suma atinsa
     */
    public HashMap<Licitatie, Double> getMaxPerLicitatie() {
        return maxPerLicitatie;
    }

    /**
     * Returneaza id-ul clientului
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returneaza numele
     * @return nume
     */
    public String getNume() {
        return nume;
    }

    /**
     * Returneaza adresa
     * @return adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Returneaza numarul de participanti
     * @return numar participanti
     */
    public int getNrParticipari() {
        return nrParticipari;
    }

    /**
     * returneaza numarul de licitatii castigate
     * @return numar licitatii
     */
    public int getNrLicitatiiCastigate() {
        return nrLicitatiiCastigate;
    }

    /**
     * Returneaza brokerul asociat
     * @return broker
     */
    public Broker getBroker() {
        return broker;
    }

    /**
     * Afiseaza produsele disponibile din casa de licitatii
     * @param casaLicitatii casa de licitatii
     */
    public void vizualizareProduse(CasaLicitatii casaLicitatii) {
        casaLicitatii.afisareProduse();
    }

    /**
     * Solicitarea unui produs din casa de licitatii.
     * @param casaLicitatii casa licitatii
     * @param id id produs
     * @param pretMaxim pret maxim oferit
     */
    public void solicitaProdus(CasaLicitatii casaLicitatii, int id, double pretMaxim) {
        casaLicitatii.intampinaSolicitare(this, id, pretMaxim);
    }

    /**
     * Ofera o anumita suma pentru un produs din casa de licitatii,
     * cuprinsa intre pretul curent si pretul maxim oferit.
     * @param pretCurent pret curent
     * @param pretMaxOferit pret maxim oferit
     * @return suma licitata
     */
    public double liciteaza(double pretCurent, double pretMaxOferit) {
        // se genereaza un numar random de la 0 la 9
        int probabilitate = new Random().nextInt(10);
        // daca acesta este mai mic decat 5, atunci clientul nu mai pluseaza
        if (probabilitate < 5) {
            return pretCurent;
        } else {
            // altfel clientul creste pretul pe care il ofera pentru produs
            return (int)(((Math.random() * (pretMaxOferit - pretCurent)) + pretCurent) * 10)/10.0 ;
        }
    }

    /**
     * Initializeaza hashmap-ul maxPerLicitatie, adaugant valoarea 0.0
     * @param licitatie licitatie
     */
    public void initMaxPerLicitatie(Licitatie licitatie) {
        maxPerLicitatie.put(licitatie, 0.0);
    }

    /**
     * Seteaza un pret pentru o anumita licitatie in hashmap-ul
     * maxPerLicitatie
     * @param licitatie licitatie
     * @param pret pret
     */
    public void setMaxPerLicitatie(Licitatie licitatie, double pret) {
        maxPerLicitatie.replace(licitatie, pret);
    }

    /**
     * Primirea unui mesaj de la broker
     * @param mesaj mesaj
     */
    public void primesteMesaj(Mesaj mesaj) {
        mesaje.add(mesaj);
    }

    /**
     * Metoda care reseteaza licitatia pentru client, simuland
     * astfel parasirea acesteia
     * @param licitatie licitatie
     */
    public void parasesteLicitatia(Licitatie licitatie) {
        maxPerLicitatie.replace(licitatie, 0.0);
    }

    /**
     * Creste numarul de licitatii castigate.
     */
    public void incNrLicitatiiCastigate(){
        setNrLicitatiiCastigate(getNrLicitatiiCastigate() + 1);
    }
}
