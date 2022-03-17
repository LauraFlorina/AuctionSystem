package com.company;

/**
 * Faciliteaza constructia unui tablou.
 */
public class TablouBuilder {
    /*
    referinta la un obiect de tip tablou, careia ii sunt adaugate valori
    pentru atributele sale
    */
    private final Tablou tablou = new Tablou();

    /**
     * Returneaza un obiect de tip tablou
     * @return tablou
     */
    public Tablou build() {
        return tablou;
    }

    /**
     * Seteaza id-ul unui tablou
     * @param id id
     * @return tablou
     */

    public TablouBuilder withId(int id) {
        tablou.setId(id);
        return this;
    }

    /**
     * Seteaza numele unui tablou
     * @param name nume
     * @return referinta la obiectul TablouBuilder.
     */
    public TablouBuilder withName(String name) {
        tablou.setNume(name);
        return this;
    }

    /**
     * Seteaza pretMinim tablou
     * @param pretMinim pretMinim
     * @return referinta la obiectul TablouBuilder.
     */
    public TablouBuilder withPretMinim(double pretMinim) {
        tablou.setPretMinim(pretMinim);
        return this;
    }

    /**
     * Seteaza anul tabloului
     * @param an an
     * @return referinta la obiectul TablouBuilder.
     */
    public TablouBuilder withAn(int an) {
        tablou.setAn(an);
        return this;
    }

    /**
     * Seteaza numele pictorului
     * @param numePictor nume pictor
     * @return referinta la obiectul TablouBuilder.
     */
    public TablouBuilder withNumePictor(String numePictor){
        tablou.setNumePictor(numePictor);
        return this;
    }

    /**
     * Seteaza campul culori
     * @param culori culori
     * @return referinta la obiectul TablouBuilder.
     */
    public TablouBuilder withCulori(Culori culori){
        tablou.setCulori(culori);
        return this;
    }
}
