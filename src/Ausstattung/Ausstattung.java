package Ausstattung;

import Auftraege.Auftrag_Organisator;


public abstract class Ausstattung {
	private String name;
	int preis;
	String ort;
	Auftrag_Organisator auftraege;

	public Ausstattung(String name, int preis, String ort, Auftrag_Organisator auftraege) {
		this.name = name;
		this.preis = preis;
		this.ort = ort;
		this.auftraege = auftraege;
	}

	public Ausstattung() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Auftrag_Organisator getAuftraege() {
		return auftraege;
	}

	public void setAuftraege(Auftrag_Organisator auftraege) {
		this.auftraege = auftraege;
	}
}
