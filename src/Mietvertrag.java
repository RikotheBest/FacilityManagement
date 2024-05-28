public class Mietvertrag extends Vertrag{
    private int baujahr;
    private Adresse adresse;
    private Groesse groesse;

    public Mietvertrag(Intervall dauer, int baujahr, Adresse adresse, Groesse groesse) {
        super(dauer);
        this.baujahr = baujahr;
        this.adresse = adresse;
        this.groesse = groesse;
    }

    public Mietvertrag() {
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Groesse getGroesse() {
        return groesse;
    }

    public void setGroesse(Groesse groesse) {
        this.groesse = groesse;
    }
}
