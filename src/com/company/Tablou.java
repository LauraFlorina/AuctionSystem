package com.company;

/**
 * Modelarea unui tablou detinut de o casa de licitatii.
 */
public class Tablou extends Produs{
    String numePictor;
    Culori culori;

    /**
     * Constructor fara parametru.
     */
    public Tablou() {
    }

    /**
     * Seteaza numele pictorului
     * @param numePictor nume
     */
    public void setNumePictor(String numePictor) {
        this.numePictor = numePictor;
    }

    /**
     * Seteaza culorile
     * @param culori culori
     */
    public void setCulori(Culori culori) {
        this.culori = culori;
    }

    /**
     * Returneaza numele pictorului
     * @return nume pictor
     */
    public String getNumePictor() {
        return numePictor;
    }

    /**
     * Returneaza culorile
     * @return culori
     */
    public Culori getCulori() {
        return culori;
    }

    /**
     * Returneaza reprezentarea string a unui tablou
     * @return string tablou
     */
    public String toString() {
        return super.toString() + " " +
                this.getNumePictor() + " " + this.getCulori();
    }
}
