package com.company;

/**
 * Crearea produselor
 */
public class Factory {
    /**
     * Avand o serie de cuvinte introduse in input, aceasta metoda
     * creeaza produsul descris.
     * @param cuvinte
     * @return
     */
    public Produs creeazaProdus(String[] cuvinte) {
        switch(cuvinte[1]) {
            case "tablou":
                return new TablouBuilder().withId(Integer.parseInt(cuvinte[2]))
                        .withName(cuvinte[3])
                        .withPretMinim(Double.parseDouble(cuvinte[4]))
                        .withNumePictor(cuvinte[5])
                        .withCulori(Culori.valueOf(cuvinte[6]))
                        .withAn(Integer.parseInt(cuvinte[7])).build();
            case "mobila":
                return new MobilaBuilder().withId(Integer.parseInt(cuvinte[2]))
                        .withName(cuvinte[3])
                        .withPretMinim(Double.parseDouble(cuvinte[4]))
                        .withMaterial(cuvinte[5])
                        .withAn(Integer.parseInt(cuvinte[6])).build();
            case "bijuterie":
                return new BijuterieBuilder().withId(Integer.parseInt(cuvinte[2]))
                        .withName(cuvinte[3])
                        .withPretMinim(Double.parseDouble(cuvinte[4]))
                        .withMaterial(cuvinte[5])
                        .hasPiatraPretioasa(Boolean.parseBoolean(cuvinte[6]))
                        .withAn(Integer.parseInt(cuvinte[7])).build();
            default:
                return null;
        }
    }
}
