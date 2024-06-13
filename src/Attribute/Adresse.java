package Attribute;
/**
 * Die Klasse Adresse repräsentiert eine physische Adresse mit
 * den Attributen Straße, Postleitzahl und Land. Sie bietet Methoden
 * zum Abrufen und Ändern dieser Attribute.
 */
public class Adresse {
    private String strasse;
    private int post;
    private String land;
    /**
     *Konstruktor zum Initialisieren eines Datums mit Tag, Monat und Jahr.
     *
     * @param strasse Die Straße der Adresse.
     * @param post Die Postleitzahl der Adresse.
     * @param land Das Land der Adresse.
     */
    public Adresse(String strasse, int post, String land) {
        this.strasse = strasse;
        this.post = post;
        this.land = land;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "strasse='" + strasse + '\'' +
                ", post=" + post +
                ", land='" + land + '\'' +
                '}';
    }
}
