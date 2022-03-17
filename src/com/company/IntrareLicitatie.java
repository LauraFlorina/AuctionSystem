package com.company;

/**
 * Contine informatii despre o intrare la licitatie
 */
public class IntrareLicitatie {
    private Client client;
    private Produs Produs;
    private double pretMaximOferit;
    private double sumaCurenta;

    public IntrareLicitatie(Client client, Produs produs, double pretMaximOferit) {
        this.client = client;
        Produs = produs;
        this.pretMaximOferit = pretMaximOferit;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProdus(com.company.Produs produs) {
        Produs = produs;
    }

    public void setPretMaximOferit(double pretMaximOferit) {
        this.pretMaximOferit = pretMaximOferit;
    }

    public void setSumaCurenta(double sumaCurenta) {
        this.sumaCurenta = sumaCurenta;
    }

    public Client getClient() {
        return client;
    }

    public Produs getProdus() {
        return Produs;
    }

    public double getPretMaximOferit() {
        return pretMaximOferit;
    }

    public double getSumaCurenta() {
        return sumaCurenta;
    }
}
