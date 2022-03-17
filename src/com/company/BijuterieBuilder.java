package com.company;

/**
 * Clasa ce faciliteaza constructia unui obiect de tip Bijuterie.
 */
public class BijuterieBuilder {
    private final Bijuterie bijuterie = new Bijuterie();

    /**
     * Returneaza referinta la un obiect bijuterie
     * @return obiect bijuterie
     */
    public Bijuterie build() {
        return bijuterie;
    }

    /**
     * Seteaza id-ul bijuteriei
     * @param id id
     * @return referinta la obiectul de tip BijuterieBuilder
     */
    public BijuterieBuilder withId(int id) {
        bijuterie.setId(id);
        return this;
    }

    /**
     * Seteaza campul nume
     * @param name mume
     * @return referinta la obiectul de tip BijuterieBuilder
     */
    public BijuterieBuilder withName(String name) {
        bijuterie.setNume(name);
        return this;
    }

    /**
     * Seteaza pretul minim
     * @param pretMinim pret
     * @return referinta la obiectul de tip BijuterieBuilder
     */
    public BijuterieBuilder withPretMinim(double pretMinim) {
        bijuterie.setPretMinim(pretMinim);
        return this;
    }

    /**
     * Seteaza campul an
     * @param an an
     * @return referinta la obiectul de tip BijuterieBuilder
     */
    public BijuterieBuilder withAn(int an) {
        bijuterie.setAn(an);
        return this;
    }

    /**
     * Seteaza campul material
     * @param material material
     * @return referinta la obiectul de tip BijuterieBuilder
     */
    public BijuterieBuilder withMaterial(String material){
        bijuterie.setMaterial(material);
        return this;
    }

    /**
     * Seteaza daca bijuteria are piatra pretioasa.
     * @param piatraPretioasa true/false
     * @return referinta la obiectul de tip BijuterieBuilder
     */
    public BijuterieBuilder hasPiatraPretioasa(boolean piatraPretioasa){
        bijuterie.setPiatraPrețioasa(piatraPretioasa);
        return this;
    }
}
