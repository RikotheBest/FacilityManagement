package Ausstattung.Elektrogeraete;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Monitor extends Ausstattung {

	public Monitor(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
		super(name, preis, ort, auftraege, nummer);
	}
	public Monitor() {
	}

}
