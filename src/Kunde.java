

public class Kunde implements Comparable {
    private int nummer;
    private String name;
    /*    String Typ; soll diese Klasse eine Mutterklasse werden, wenn es verschiede Typen gibt?
     */
    private Groesse groesse;
    private Adresse adresse;
    private Datum baujahr;

    public Kunde(int nummer, String name, Groesse groesse, Adresse adresse, Datum baujahr) {
        this.nummer = nummer;
        this.name = name;
        this.groesse = groesse;
        this.adresse = adresse;
        this.baujahr = baujahr;
    }

    public Kunde() {
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public double getGroesse() {
        return groesse.flaeche + groesse.raeume + groesse.stockwerke;
    }

    public void setGroesse(Groesse groesse) {
        this.groesse = groesse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    public int compareTo(Object o) {
        return 0;
    }
}
   */
//In Bearbeitung!