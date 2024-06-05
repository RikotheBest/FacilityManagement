package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Sitzmoebel extends Ausstattung {
    public Sitzmoebel(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(name, preis, ort, auftraege, nummer);
    }
}
