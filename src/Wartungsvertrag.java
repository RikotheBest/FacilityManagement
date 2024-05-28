public class Wartungsvertrag extends Vertrag {
    private String wartungsfirma;

    public Wartungsvertrag(int vertragsnummer, Datum startdatum, Datum enddatum, String wartungsfirma) {
        super(vertragsnummer, startdatum, enddatum);
        this.wartungsfirma = wartungsfirma;
    }

    public String getWartungsfirma() {
        return wartungsfirma;
    }

    public void setWartungsfirma(String wartungsfirma) {
        this.wartungsfirma = wartungsfirma;
    }
}