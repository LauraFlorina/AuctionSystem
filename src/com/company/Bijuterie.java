package com.company;

/**
 * Modeleaza un obiect de tip bijuterie.
 * Extinde clasa Produs.
 */
public class Bijuterie extends Produs{
    String material;
    boolean piatraPrețioasa;

    /**
     * Constructor fara parametrii.
     */
    public Bijuterie() {
    }

    /**
     * Seteaza materialul bijuteriei
     * @param material materialul bijuteriei
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Seteaza daca bijuteria are piatra pretioasa
     * @param piatraPrețioasa true/false
     */
    public void setPiatraPrețioasa(boolean piatraPrețioasa) {
        this.piatraPrețioasa = piatraPrețioasa;
    }

    /**
     * Returneaza materialul bijuteriei
     * @return material bijuterie
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Verifica daca bijuteria are piatra pretioasa.
     * @return
     */
    public boolean isPiatraPrețioasa() {
        return piatraPrețioasa;
    }

    /**
     * Returneaza detaliile bijuteriei sub forma unui string
     * @return reprezentare string
     */
    public String toString() {
        return super.toString() + " " + this.getMaterial() + " " + this.isPiatraPrețioasa();
    }
}
