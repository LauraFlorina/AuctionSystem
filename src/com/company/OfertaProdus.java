package com.company;

public class OfertaProdus {
    private Produs produs;
    private double pretOferit;
    private double pretMaximOferit;

    public OfertaProdus(Produs produs, double pretOferit, double pretMaximOferit) {
        this.produs = produs;
        this.pretOferit = pretOferit;
        this.pretMaximOferit = pretMaximOferit;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public void setPretOferit(double pretOferit) {
        this.pretOferit = pretOferit;
    }

    public void setPretMaximOferit(double pretMaximOferit) {
        this.pretMaximOferit = pretMaximOferit;
    }

    public Produs getProdus() {
        return produs;
    }

    public double getPretOferit() {
        return pretOferit;
    }

    public double getPretMaximOferit() {
        return pretMaximOferit;
    }
}
