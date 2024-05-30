package Ausstattung.Brandschutz;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Rauchmelder extends Ausstattung {
    public Rauchmelder(String name, int preis, String ort, Auftrag_Organisator auftraege) {
        super(name, preis, ort, auftraege);
    }

    public Rauchmelder() {
    }
}
