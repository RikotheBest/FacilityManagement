package org.example.Gebaeude;

import org.example.Attribute.Adresse;
import org.example.Attribute.Groesse;
import org.example.Ausstattung.Ausstattung_Organisator;
/**
 * Die Klasse org.example.Gebaeude repräsentiert ein Gebäude mit den Attributen Nummer,
 * Groesse, Adresse und org.example.Ausstattung. Sie bietet Methoden zum Abrufen und
 * Setzen dieser org.example.Attribute.
 */
public class Gebaeude {
    private int nummer;
    private Groesse groesse;
    private Adresse adresse;
    private Ausstattung_Organisator austattung;

    /**
     * Konstruktor zum Initialisieren eines Gebäudes mit den angegebenen
     * Nummer, Groesse, Adresse und Ausstattung_Organisator.
     *
     * @param nummer Die Nummer des Gebäudes.
     * @param groesse Die Größe des Gebäudes.
     * @param adresse Die Adresse des Gebäudes.
     * @param austattung Der Ausstattung_Organisator, der die zugehörige org.example.Ausstattung verwaltet.
     * @throws IllegalArgumentException Wenn die Nummer kleiner oder gleich null ist.
     */
    public Gebaeude(int nummer, Groesse groesse, Adresse adresse, Ausstattung_Organisator austattung) {
    	if (nummer <= 0) {
            throw new IllegalArgumentException("Die Nummer muss größer als null sein: " + nummer);
        }
        this.nummer = nummer;
        this.groesse = groesse;
        this.adresse = adresse;
        this.austattung = austattung;
    }

    public int getNummer() {
    	return nummer;
    }

    public void setNummer(int nummer) {
    	if (nummer <= 0) {
            throw new IllegalArgumentException("Die Nummer muss größer als null sein: " + nummer);
        }
    	this.nummer = nummer;
    }

    public Groesse getGroesse() {
    	return groesse;
    }

    public void setGroesse(Groesse groesse) {
    	this.groesse = groesse;
    }

    public Adresse getAdresse() {
    	return adresse;
    }

    public void setAdresse(Adresse adresse) {
    	this.adresse = adresse;
    }

    public Ausstattung_Organisator getAustattung() {
    	return austattung;
    }

    public void setAustattung(Ausstattung_Organisator austattung) {
    	this.austattung = austattung;
    }

    @Override
    public String toString() {
        return "Gebaeude: " + nummer;
    }
}


