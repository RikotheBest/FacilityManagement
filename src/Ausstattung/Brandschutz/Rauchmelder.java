package Ausstattung.Brandschutz;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Rauchmelder extends Ausstattung {
    public Rauchmelder(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(name, preis, ort, auftraege, nummer);
    }

    public Rauchmelder() {
    }
}
