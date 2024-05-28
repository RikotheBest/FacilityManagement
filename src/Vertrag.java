public class Vertrag {
    private int vertragsnummer;
    private Datum startdatum;
    private Datum enddatum;

    public Vertrag(int vertragsnummer, Datum startdatum, Datum enddatum) {
        this.vertragsnummer = vertragsnummer;
        this.startdatum = startdatum;
        this.enddatum = enddatum;
    }

    public int getVertragsnummer() {
        return vertragsnummer;
    }

    public void setVertragsnummer(int vertragsnummer) {
        this.vertragsnummer = vertragsnummer;
    }

    public Datum getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Datum startdatum) {
        this.startdatum = startdatum;
    }

    public Datum getEnddatum() {
        return enddatum;
    }

    public void setEnddatum(Datum enddatum) {
        this.enddatum = enddatum;
    }
}