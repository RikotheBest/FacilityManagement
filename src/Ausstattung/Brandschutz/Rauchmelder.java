package Ausstattung.Brandschutz;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Rauchmelder extends Ausstattung {
    public Rauchmelder(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Rauchmelder");
    }



}
