package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Tuer extends Ausstattung {
    public Tuer(String name, int preis, String ort, Auftrag_Organisator auftraege) {
        super(name, preis, ort, auftraege);
    }

    public Tuer() {
    }
}
