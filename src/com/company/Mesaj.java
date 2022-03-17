package com.company;

public class Mesaj {
    private Licitatie licitatie;
    private Broker broker;
    private Client client;
    private String mesaj;

    public Mesaj(Licitatie licitatie, Broker broker, Client client, String mesaj) {
        this.licitatie = licitatie;
        this.broker = broker;
        this.client = client;
        this.mesaj = mesaj;
    }

    public void setLicitatie(Licitatie licitatie) {
        this.licitatie = licitatie;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Licitatie getLicitatie() {
        return licitatie;
    }

    public Broker getBroker() {
        return broker;
    }

    public Client getClient() {
        return client;
    }

    public String getMesaj() {
        return mesaj;
    }
}
