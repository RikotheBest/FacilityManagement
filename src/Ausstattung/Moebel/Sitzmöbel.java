package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Sitzmöbel extends Ausstattung {
    public Sitzmöbel(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(name, preis, ort, auftraege, nummer);
    }

    public Sitzmöbel() {
    }
}
