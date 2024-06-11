package Ausstattung;

import Auftraege.Auftrag_Organisator;


public abstract class Ausstattung {
	private String name;
	private int preis;
	private String ort;
	private int nummer;
	private Auftrag_Organisator auftraege;

	public Ausstattung(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {

		this.preis = preis;
		this.ort = ort;
		this.auftraege = auftraege;
		this.nummer = nummer;
	}

	public Ausstattung() {
	}


	public int getNummer() {
		return nummer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
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

	public String getName() {
		return name;
	}

	public String toString() {
		return "Ausstattung{" +
				"name='" + name + '\'' +
				", preis=" + preis +
				", ort='" + ort + '\'' +
				", nummer=" + nummer +
				'}';
	}
}
