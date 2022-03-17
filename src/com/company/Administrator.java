package com.company;

/**
 * Administatorul casei de licitatii.
 */
public class Administrator extends Angajat {

    /**
     * Constructor cu parametrii
     * @param id id
     * @param nume nume
     */
    public Administrator(int id, String nume) {
        super(id, nume);
    }

    /**
     * Adauga un produs in casa de licitatii, si creeaza o licitatie inactiva
     * pentru acesta.
     * @param casaLicitatii casa de licitatii
     * @param produs produsul
     * @param nrParticipanti numarul de participanti necesar pentru ca licitatia
     *                       sa porneasca
     */
    public void adaugaProdus(CasaLicitatii casaLicitatii, Produs produs,
                             int nrParticipanti) {
        casaLicitatii.getProduse().add(produs);
        
        Licitatie licitatieNoua = new Licitatie(
                casaLicitatii.getLicitatiiActive().size(),
                produs.getId(), nrParticipanti,
                casaLicitatii);
        casaLicitatii.adaugaLicitatie(licitatieNoua);
    }
}
