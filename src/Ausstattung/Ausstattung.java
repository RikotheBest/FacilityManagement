package Ausstattung;

import Auftraege.Auftrag_Organisator;
/**
 * Die abstrakte Klasse Ausstattung repräsentiert ein allgemeines Ausstattungselement.
 * Sie enthält gemeinsame Eigenschaften wie Name, Preis, Ort, Nummer und zugehörige Aufträge.
 * Abstrakte Klassen können nicht instanziiert werden und dienen als Basis für spezifische Ausstattungstypen.
 */
public abstract class Ausstattung {
	private String name;
	private int preis;
	private String ort;
	private int nummer;
	private Auftrag_Organisator auftraege;
	/**
	 * Konstruktor zum Initialisieren einer Ausstattung mit den angegebenen
	 * Preis, Ort, Auftrag_Organisator und Nummer.
	 *
	 * @param preis Der Preis der Ausstattung.
	 * @param ort Der Ort, an dem die Ausstattung sich befindet.
	 * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
	 * @param nummer Die Nummer der Ausstattung.
	 */
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
	//Gibt den Auftrag_Organisator der Ausstattung zurück.

	public void setAuftraege(Auftrag_Organisator auftraege) {
		this.auftraege = auftraege;
	} //Setzt den Auftrag_Organisator der Ausstattung.

	/**
	 * Überschreibt die toString-Methode, um die Ausstattung als String darzustellen.
	 *
	 * @return Eine String-Darstellung der Ausstattung.
	 */
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
