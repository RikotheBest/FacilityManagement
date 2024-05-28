public class Wartungsintervall {
    private int intervallNummer;
    private Datum startdatum;
    private Datum enddatum;

    public Wartungsintervall(int intervallNummer, Datum startdatum, Datum enddatum) {
        this.intervallNummer = intervallNummer;
        this.startdatum = startdatum;
        this.enddatum = enddatum;
    }

    public int getIntervallNummer() {
        return intervallNummer;
    }

    public void setIntervallNummer(int intervallNummer) {
        this.intervallNummer = intervallNummer;
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