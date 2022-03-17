package com.company;

/**
 * Modelarea unui obiect de tip mobila detinut de o casa de licitatii.
 */
public class Mobila extends Produs{
    String tip;
    String material;

    /**
     * Constructor fara parametru
     */
    public Mobila() {
    }

    /**
     * Seteaza tipul mobilei.
     * @param tip tip mobila
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * Seteaza materialul mobilei
     * @param material material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Returneaza tipul mobilei
     * @return tip
     */
    public String getTip() {
        return tip;
    }

    /**
     * Returneaza materialul mobilei
     * @return material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Returneaza reprezentarea string a unui element de tip mobila
     * @return string mobila
     */
    public String toString(){
        return super.toString() + " " + " " + this.getMaterial();
    }
}
