package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Tisch extends Ausstattung {
    public Tisch(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Tisch");
    }


}
