package com.company;

/**
 * Faciliteaza constructia unui obiect de tip Mobila.
 */
public class MobilaBuilder {
    /*
    referinta la un obiect de tip mobila, careia ii sunt adaugate valori
    pentru atributele sale
    */
    private final Mobila mobila = new Mobila();

    /**
     * Returneaza elementul de tip mobila
     * @return mobila
     */
    public Mobila build() {
        return mobila;
    }

    /**
     * Seteaza campul id
     * @param id id
     * @return referinta la obiectul de tip MobilaBuilder
     */
    public MobilaBuilder withId(int id) {
        mobila.setId(id);
        return this;
    }

    /**
     * Seteaza numele
     * @param name nume
     * @return referinta la obiectul de tip MobilaBuilder
     */
    public MobilaBuilder withName(String name) {
        mobila.setNume(name);
        return this;
    }

    /**
     * Seteaza pretMinim
     * @param pretMinim pret
     * @return referinta la obiectul de tip MobilaBuilder
     */
    public MobilaBuilder withPretMinim(double pretMinim) {
        mobila.setPretMinim(pretMinim);
        return this;
    }

    /**
     * Seteaza anul
     * @param an an
     * @return referinta la obiectul de tip MobilaBuilder
     */
    public MobilaBuilder withAn(int an) {
        mobila.setAn(an);
        return this;
    }

    /**
     * Seteaza tipul mobilei
     * @param tip tip
     * @return referinta la obiectul de tip MobilaBuilder
     */
    public MobilaBuilder withTip(String tip){
        mobila.setTip(tip);
        return this;
    }

    /**
     * Seteaza materialul mobilei
     * @param material material
     * @return referinta la obiectul de tip MobilaBuilder
     */
    public MobilaBuilder withMaterial(String material){
        mobila.setMaterial(material);
        return this;
    }
}
