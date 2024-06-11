package Ausstattung.Brandschutz;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Feuerloescher extends Ausstattung {



    public Feuerloescher(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Feuerloescher");
    }





}
