package org.example.Attribute;
/**
 * Die Klasse Adresse repräsentiert eine physische Adresse mit
 * den Attributen Straße, Postleitzahl und Land. Sie bietet Methoden
 * zum Abrufen und Ändern dieser org.example.Attribute.
 */
public class Adresse {
    private String strasse;
    private int post;
    private String land;
    /**
     * Konstruktor zum Initialisieren einer Adresse mit Straße, Postleitzahl und Land.
     *
     * @param strasse Die Straße der Adresse.
     * @param postleitzahl Die Postleitzahl der Adresse.
     * @param land Das Land der Adresse.
     */
    public Adresse(String strasse, int post, String land) {
    	if (strasse == null || strasse.trim().isEmpty()) {
            throw new IllegalArgumentException("Das Feld Straße darf nicht leer sein.");
        }
        if (post <= 0) {
            throw new IllegalArgumentException("Die Postleitzahl muss eine positive Zahl sein.");
        }
        if (land == null || land.trim().isEmpty()) {
            throw new IllegalArgumentException("Das Feld Land darf nicht leer sein.");
        }
        
        this.strasse = strasse;
        this.post = post;
        this.land = land;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
    	if (strasse == null || strasse.trim().isEmpty()) {
            throw new IllegalArgumentException("Das Feld Straße darf nicht leer sein.");
    	}
        this.strasse = strasse;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
    	if (post <= 0) {
            throw new IllegalArgumentException("Die Postleitzahl muss eine positive Zahl sein.");
        }
        this.post = post;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
    	if (land == null || land.trim().isEmpty()) {
            throw new IllegalArgumentException("Das Feld Land darf nicht leer sein.");
        }
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
