package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Sitzmoebel extends Ausstattung {
    public Sitzmoebel(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Sitzmoebel");
    }

}
