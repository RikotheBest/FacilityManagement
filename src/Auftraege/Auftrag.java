package Auftraege;

import Attribute.Datum;

public class Auftrag {
    private Datum geplant;
    private int nummer;
    private String kategorie;
    private String status;

    public Auftrag(Datum geplant, int nummer, String kategorie, String status) {
        this.geplant = geplant;
        this.nummer = nummer;
        this.kategorie = kategorie;
        this.status = status;
    }

    public Datum getGeplant() {
        return geplant;
    }

    public void setGeplant(Datum geplant) {
        this.geplant = geplant;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
