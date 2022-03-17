package com.company;

/**
 * Modelarea unui produs detinut de casa de licitatii.
 */
public class Produs {
    private int id;
    private String nume;
    private double pretVanzare;
    private double pretMinim;
    private int an;

    /**
     * Constructor fara parametrii.
     */
    public Produs() {
    }

    /**
     * Seteaza id-ul unui produs.
     * @param id id-ul Produsului
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Seteaza numele unui produs
     * @param nume nume Produs
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Seteaza pretul de vanzare al unui produs
     * @param pretVanzare pretul de vanzare
     */
    public void setPretVanzare(double pretVanzare) {
        this.pretVanzare = pretVanzare;
    }

    /**
     * Seteaza pretul minim de vanzare al unui produs
     * @param pretMinim pretul minim de vanzare
     */
    public void setPretMinim(double pretMinim) {
        this.pretMinim = pretMinim;
    }

    /**
     * Seteaza anul unui produs.
     * @param an anul
     */
    public void setAn(int an) {
        this.an = an;
    }

    /**
     * Intoarce id-ul unui produs.
     * @return id-ul produsului
     */
    public int getId() {
        return id;
    }

    /**
     * Intoarce numele unui produs.
     * @return nume produs
     */
    public String getNume() {
        return nume;
    }

    /**
     * Intoarce pretul de vanzare al unui produs.
     * @return pret vanzare
     */
    public double getPretVanzare() {
        return pretVanzare;
    }

    /**
     * Intoarcce pretul minim pentru vanzarea unui produs.
     * @return pret minim vanzare
     */
    public double getPretMinim() {
        return pretMinim;
    }

    /**
     * Intoarce anul unui produs.
     * @return an produs
     */
    public int getAn() {
        return an;
    }

    /**
     * Reprezentarea string a unui produs
     * @return string ce contine detalii despre produs
     */
    public String toString(){
        return this.getId() + " " + this.getNume() + " " + this.getAn();
    }
}
