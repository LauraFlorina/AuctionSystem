package com.company;

public class PersoanaJuridicaBuilder {
    private final PersoanaJuridica persoanaJuridica = new PersoanaJuridica();

    public PersoanaJuridica build() {
        return persoanaJuridica;
    }

    public PersoanaJuridicaBuilder withId(int id){
        persoanaJuridica.setId(id);
        return this;
    }

    public PersoanaJuridicaBuilder withNume(String nume){
        persoanaJuridica.setNume(nume);
        return this;
    }

    public PersoanaJuridicaBuilder withAdresa(String adresa) {
        persoanaJuridica.setAdresa(adresa);
        return this;
    }

    public PersoanaJuridicaBuilder withNrParticipari(int nrParticipari) {
        persoanaJuridica.setNrParticipari(nrParticipari);
        return this;
    }

    public PersoanaJuridicaBuilder withNrLicitatiiCastigate(
            int nrLicitatiiCastigate) {
        persoanaJuridica.setNrLicitatiiCastigate(nrLicitatiiCastigate);
        return this;
    }

    public PersoanaJuridicaBuilder withCompanie(Companie companie) {
        persoanaJuridica.setCompanie(companie);
        return this;
    }

    public PersoanaJuridicaBuilder withCapitalSocial(double capitalSocial) {
        persoanaJuridica.setCapitalSocial(capitalSocial);
        return this;
    }
}
