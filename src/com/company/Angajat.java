package com.company;

/**
 * Modelarea unui angajat.
 * Clasa parinte pentru Broker si Administrator.
 */
public class Angajat {
    private int id;
    private String nume;

    /**
     * Constructor fara parametrii.
     */
    public Angajat() {
    }

    /**
     * Cosntructor cu parametrii
     * @param id id
     * @param nume nume
     */
    public Angajat(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    /**
     * Seteaza id angajat
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * seteaza nume angajat
     * @param nume nume
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * returneaza id-ul angajatului
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * returneaza numele angajatului
     * @return nume
     */
    public String getNume() {
        return nume;
    }
}
