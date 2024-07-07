package Ausstattung.Elektrogeraete;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Drucker extends Ausstattung {
	public Drucker(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
		super(name, preis, ort, auftraege, nummer);
	}
	public Drucker() {
	}

}
