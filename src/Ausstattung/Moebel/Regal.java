package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Regal extends Ausstattung {

	public Regal(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
		super(name, preis, ort, auftraege, nummer);
	}
	public Regal() {
	}

}
