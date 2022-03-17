package com.company;

/**
 * Modelarea unei persoane fizice. Extinde clasa Client.
 */
public class PersoanaFizica extends Client {
    String dataNastere;

    /**
     * Constructor fara parametrii.
     */
    public PersoanaFizica() {
    }

    /**
     * Setare data nastere
     * @param dataNastere data
     */
    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    /**
     * Intoarce data nasterii
     * @return data
     */
    public String getDataNastere() {
        return dataNastere;
    }
}
