package org.example.Auftraege;

import org.example.Attribute.Datum;
/**
 * Die Klasse Auftrag repräsentiert einen Auftrag mit den Attributen
 * geplant (Datum), nummer, kategorie und status. Sie bietet Methoden
 * zum Abrufen und Setzen dieser org.example.Attribute sowie eine überschriebene
 * toString-Methode zur Darstellung des Auftrags als String.
 */
public class Auftrag {
    private Datum geplant;
    private int nummer;
    private String kategorie;
    private String status;
/**
 * Konstruktor zum Initialisieren eines Auftrags mit den angegebenen
 * geplanten Datum, Nummer, Kategorie und Status.
 *
 * @param geplant Das geplante Datum des Auftrags.
 * @param nummer Die Nummer des Auftrags.
 * @param kategorie Die Kategorie des Auftrags.
 * @param status Der Status des Auftrags.
 */
    public Auftrag(Datum geplant, int nummer, String kategorie, String status) {
   	 if (nummer <= 0) {
         throw new IllegalArgumentException("Die Nummer muss größer als null sein: " + nummer);
     }
     if (kategorie == null || kategorie.trim().isEmpty()) {
         throw new IllegalArgumentException("Die Kategorie darf nicht leer sein.");
     }
     if (status == null || status.trim().isEmpty()) {
         throw new IllegalArgumentException("Der Status darf nicht leer sein.");
     }
        this.geplant = geplant;
        this.nummer = nummer;
        this.kategorie = kategorie;
        this.status = status;
    }

    public Datum getGeplant() {
        return geplant;
    }

    public void setGeplant(Datum geplant) {
    	 if (geplant == null) {
             throw new IllegalArgumentException("Das geplante Datum darf nicht null sein.");
         }
        this.geplant = geplant;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
    	if (nummer <= 0) {
            throw new IllegalArgumentException("Die Nummer muss größer als null sein: " + nummer);
        }
        this.nummer = nummer;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
    	if (kategorie == null || kategorie.trim().isEmpty()) {
            throw new IllegalArgumentException("Die Kategorie darf nicht leer sein.");
        }
        this.kategorie = kategorie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
    	if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Status darf nicht leer sein.");
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return "Auftrag{" +
                "geplant=" + geplant +
                ", nummer=" + nummer +
                ", kategorie='" + kategorie + '\'' +
                ", status=" + status +
                '}';
    }
}
