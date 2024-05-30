package Ausstattung.Brandschutz;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Feuerloescher extends Ausstattung {
    public Feuerloescher(String name, int preis, String ort, Auftrag_Organisator auftraege) {
        super(name, preis, ort, auftraege);
    }

    public Feuerloescher() {
    }
}
