package Attribute;
/**
 * Die Klasse Groesse repräsentiert die Größe eines Gebäudes mit
 * den Attributen Stockwerke, Fläche und Räume. Sie implementiert
 * die Schnittstelle Comparable, um eine Vergleichsmethode basierend
 * auf der Fläche zu ermöglichen.
 */
public class Groesse implements Comparable<Groesse>{
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
        this.stockwerke = stockwerke;
        this.flaeche = flaeche;
        this.raeume = raeume;
    }

    /**
     * Vergleicht dieses Groesse-Objekt mit einem anderen Groesse-Objekt
     * basierend auf der Fläche.
     *
     * @param o Das andere Groesse-Objekt zum Vergleich.
     * @return -1 wenn dieses Objekt eine kleinere Fläche hat, sonst 1.
     */
    public int compareTo(Groesse o) {
        if(this.flaeche < o.flaeche) return -1;
        else return 1;
    }

    public int getStockwerke() {
        return stockwerke;
    }

    public void setStockwerke(int stockwerke) {
        this.stockwerke = stockwerke;
    }

    public double getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(double flaeche) {
        this.flaeche = flaeche;
    }

    public double getRaeume() {
        return raeume;
    }

    public void setRaeume(double raeume) {
        this.raeume = raeume;
    }
}
