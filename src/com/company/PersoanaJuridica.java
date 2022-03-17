package com.company;

/**
 * Modelarea unei persoaneJuridice. Extinde Client.
 */
public class PersoanaJuridica extends Client {
    Companie companie;
    double capitalSocial;

    /**
     * Constructori fara parametrii.
     */
    public PersoanaJuridica() {
    }

    /**
     * Seteaza tipul companiei.
     * @param companie tip companie
     */
    public void setCompanie(Companie companie) {
        this.companie = companie;
    }

    /**
     * Seteaza capitalulSocial
     * @param capitalSocial
     */
    public void setCapitalSocial(double capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    /**
     * Returneaza tip companie
     * @return tip companie
     */
    public Companie getCompanie() {
        return companie;
    }

    /**
     * Returneaza capitalul social
     * @return capital social
     */
    public double getCapitalSocial() {
        return capitalSocial;
    }
}
