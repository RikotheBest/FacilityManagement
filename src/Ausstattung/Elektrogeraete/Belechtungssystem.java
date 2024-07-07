package Ausstattung.Elektrogeraete;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;

public class Belechtungssystem extends Ausstattung {
	public Belechtungssystem(String name, int preis, String ort, int nummer, Auftrag_Organisator auftraege) {
		super(name, preis, ort, nummer, auftraege);
	}
	public Belechtungssystem() {
	}

}
