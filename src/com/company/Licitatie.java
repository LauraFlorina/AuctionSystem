package com.company;

public class Licitatie implements Runnable {
    private int id;
    private int nrParticipanti;
    private int nrInscrisi;
    private int idProdus;
    private int nrPasiMaxim;
    private boolean activa;
    private double pretAtins;
    private CasaLicitatii casaLicitatii;
    private Client castigator;

    /**
     * constructor fara parametrii
     */
    public Licitatie() {
    }

    /**
     * constructor cu parametrii
     * @param id id
     * @param idProdus id produs
     * @param nrParticipanti nr participanti
     * @param casaLicitatii casa licitatii
     */
    public Licitatie(int id, int idProdus, int nrParticipanti,
                     CasaLicitatii casaLicitatii) {
        this.id = id;
        this.idProdus = idProdus;
        this.nrParticipanti = nrParticipanti;
        this.activa = false;
        this.casaLicitatii = casaLicitatii;
        this.nrPasiMaxim = nrParticipanti + 1;
    }

    /**
     * Demersurile necesasre pentru rularea unei licitatii
     */
    public void run() {
        for (int i = 0; i < nrPasiMaxim; i++) {
            for (IntrareLicitatie intrare : casaLicitatii.getIntrariLicitatie().get(this)) {
                Client client = intrare.getClient();
                double pretMaxOferit = intrare.getPretMaximOferit(); //pretul maxim oferit de client
                Broker broker = client.getBroker();
                double sumaLicitata = broker.obtineSumaLicitata(client,
                        this.pretAtins, pretMaxOferit);
                broker.notificaCasaLicitatii(intrare, sumaLicitata);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        double sumaMax = casaLicitatii.notificaSumaMax(this);
        Client castigator = casaLicitatii.determinaCastigator(this);
        calculareComision(sumaMax, castigator);
        casaLicitatii.notificaCastigator(this, castigator);
        seteazaPretVanzare(sumaMax, castigator);
        analizaLicitatie(castigator);
    }

    /**
     * Determina brokerul sa calculeze comisionul
     * @param sumaMax suuma max
     * @param castigator castigator
     */
    public void calculareComision(Double sumaMax, Client castigator) {
        if (castigator != null) {
            castigator.getBroker().calculComision(castigator, sumaMax);
        }
    }

    /**
     * Seteaza pretul de vanzare pentru un produs
     * @param sumaMax suma max
     * @param castigator castigator
     */
    public void seteazaPretVanzare(double sumaMax, Client castigator) {
        if (castigator != null) {
            casaLicitatii.seteazaPretVanzare(this, sumaMax);
        }
    }

    /**
     * Analizeaza licitatia dupa ce aceasta s-a incheiat.
     * @param castigator castigator
     */
    public void analizaLicitatie(Client castigator) {
        if (castigator != null) {
            castigator.getBroker().incheieLicitatie(this, castigator);
        } else {
            casaLicitatii.getListaBrokeri().get(0).
                    incheieLicitatie(this, castigator);
        }
    }

    /**
     * seteaza castigator
     * @param castigator castigator
     */
    public void setCastigator(Client castigator) {
        this.castigator = castigator;
    }

    /**
     * seteaza pretAtins
     * @param pretAtins pret
     */
    public void setPretAtins(double pretAtins) {
        this.pretAtins = pretAtins;
    }

    /**
     * returneaza pret atins
     * @return pret
     */
    public double getPretAtins() {
        return pretAtins;
    }

    /**
     * seteazaz id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * seteaza nr participanti
     * @param nrParticipanti nr
     */
    public void setNrParticipanti(int nrParticipanti) {
        this.nrParticipanti = nrParticipanti;
    }

    /**
     * seteaza id produs
     * @param idProdus id
     */
    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    /**
     * seteaza nr maxim pasi
     * @param nrPasiMaxim nr
     */
    public void setNrPasiMaxim(int nrPasiMaxim) {
        this.nrPasiMaxim = nrPasiMaxim;
    }

    /**
     * seteaza nr inscriisi
     * @param nrInscrisi nr
     */
    public void setNrInscrisi(int nrInscrisi) {
        this.nrInscrisi = nrInscrisi;
    }

    /**
     * seteaza activa licitatiie
     * @param activa true/false
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * verifica daca e activa
     * @return
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * return numar inscrisi
     * @return nr
     */
    public int getNrInscrisi() {
        return nrInscrisi;
    }

    /**
     * returneaza id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * return numar participanti
     * @return nr
     */
    public int getNrParticipanti() {
        return nrParticipanti;
    }

    /**
     * return produs
     * @return
     */
    public int getIdProdus() {
        return idProdus;
    }

    /**
     * return nr maxim pasi
     * @return nr maxim pasi
     */
    public int getNrPasiMaxim() {
        return nrPasiMaxim;
    }


}
