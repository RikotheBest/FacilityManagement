package Attribute;

public class Groesse implements Comparable<Groesse>{
    private int stockwerke;
    private double flaeche;
    private double raeume;

    public Groesse(int stockwerke, double flaeche, double raeume) {
        this.stockwerke = stockwerke;
        this.flaeche = flaeche;
        this.raeume = raeume;
    }

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
