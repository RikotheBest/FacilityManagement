public class Groesse implements Comparable<Groesse>{
    int stockwerke;
    double flaeche;
    double raeume;

    public Groesse(int stockwerke, double flaeche, double raeume) {
        this.stockwerke = stockwerke;
        this.flaeche = flaeche;
        this.raeume = raeume;
    }

    public int compareTo(Groesse o) {
        if(this.flaeche < o.flaeche) return -1;
        else return 1;
    }
}
