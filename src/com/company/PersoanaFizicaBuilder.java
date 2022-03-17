package com.company;

public class PersoanaFizicaBuilder {
    private final PersoanaFizica persoanaFizica = new PersoanaFizica();

    public PersoanaFizica build() {
        return persoanaFizica;
    }

    public PersoanaFizicaBuilder withId(int id) {
        persoanaFizica.setId(id);
        return this;
    }

    public PersoanaFizicaBuilder withNume(String nume) {
        persoanaFizica.setNume(nume);
        return this;
    }

    public PersoanaFizicaBuilder withAdresa(String adresa) {
        persoanaFizica.setAdresa(adresa);
        return this;
    }

    public PersoanaFizicaBuilder withNrParticipari(int nrParticipari) {
        persoanaFizica.setNrParticipari(nrParticipari);
        return this;
    }

    public PersoanaFizicaBuilder withNrLicitatiiCastigate(
            int nrLicitatiiCastigate){
        persoanaFizica.setNrLicitatiiCastigate(nrLicitatiiCastigate);
        return this;
    }

    public PersoanaFizicaBuilder withDataNastere(String dataNastere) {
        persoanaFizica.setDataNastere(dataNastere);
        return this;
    }
}
