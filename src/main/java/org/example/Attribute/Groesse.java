package org.example.Attribute;
/**
 * Die Klasse Groesse repräsentiert die Größe eines Gebäudes mit
 * den Attributen Stockwerke, Fläche und Räume. Sie implementiert
 * die Schnittstelle Comparable, um eine Vergleichsmethode basierend
 * auf der Fläche zu ermöglichen.
 */
public class Groesse{
    private int stockwerke;
    private double flaeche;
    private double raeume;
    /**
     * Konstruktor zum Initialisieren der Größe eines Gebäudes mit
     * den angegebenen Stockwerken, Fläche und Räumen.
     *
     * @param stockwerke Die Anzahl der Stockwerke.
     * @param flaeche Die Fläche in Quadratmetern.
     * @param raeume Die Anzahl der Räume.
     */

    public Groesse(int stockwerke, double flaeche, double raeume) {
    	if (stockwerke < 0) {
            throw new IllegalArgumentException("Die Anzahl der Stockwerke darf nicht negativ sein: " + stockwerke);
        }
        if (flaeche <= 0) {
            throw new IllegalArgumentException("Die Fläche muss größer als null sein: " + flaeche);
        }
        if (raeume <= 0) {
            throw new IllegalArgumentException("Die Anzahl der Räume muss größer als null sein: " + raeume);
        }
        this.stockwerke = stockwerke;
        this.flaeche = flaeche;
        this.raeume = raeume;
    }


    public int getStockwerke() {
        return stockwerke;
    }

    public void setStockwerke(int stockwerke) {
    	if (stockwerke < 0) {
            throw new IllegalArgumentException("Die Anzahl der Stockwerke darf nicht negativ sein: " + stockwerke);
        }
        this.stockwerke = stockwerke;
    }

    public double getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(double flaeche) {
    	if (flaeche <= 0) {
            throw new IllegalArgumentException("Die Fläche muss größer als null sein: " + flaeche);
        }
        this.flaeche = flaeche;
    }

    public double getRaeume() {
        return raeume;
    }

    public void setRaeume(double raeume) {
    	if (raeume <= 0) {
            throw new IllegalArgumentException("Die Anzahl der Räume muss größer als null sein: " + raeume);
        }
        this.raeume = raeume;
    }

    @Override
    public String toString() {
        return "Groesse{" +
                "stockwerke=" + stockwerke +
                ", flaeche=" + flaeche +
                ", raeume=" + raeume +
                '}';
    }
}
