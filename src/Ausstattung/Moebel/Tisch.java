package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Tisch extends Ausstattung {
    public Tisch(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(name, preis, ort, auftraege, nummer);
    }
    public Tisch() {
    }
}
