package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Fenster extends Ausstattung {
    public Fenster(String name, int preis, String ort, Auftrag_Organisator auftraege) {
        super(name, preis, ort, auftraege);
    }

    public Fenster() {
    }
}
