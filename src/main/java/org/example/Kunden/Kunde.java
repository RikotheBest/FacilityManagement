package org.example.Kunden;

import org.example.Gebaeude.Gebaeude_Organisator;

/**
 * Die Klasse Kunde repräsentiert einen org.example.Kunden mit einem Namen und einem
 * Gebäudeorganisator. Sie bietet Methoden zum Abrufen und Setzen dieser org.example.Attribute.
 */
public class Kunde {
    private int nummer;
    private String name;
    private Gebaeude_Organisator gebaeude;

    /**
     * Konstruktor zum Initialisieren eines org.example.Kunden mit dem angegebenen Namen und Gebäudeorganisator.
     *
     * @param name Der Name des org.example.Kunden.
     * @param gebaeude Der Gebäudeorganisator des org.example.Kunden.
     */
    public Kunde(String name, Gebaeude_Organisator gebaeude, int nummer) {
    	if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht null oder leer sein.");
        }
        if (gebaeude == null) {
            throw new IllegalArgumentException("Gebaeude_Organisator darf nicht null sein.");
        }
        if (nummer <= 0) {
            throw new IllegalArgumentException("Nummer muss größer als null sein.");
        }
    	this.name = name;
        this.gebaeude = gebaeude;
        this.nummer = nummer;
    }

    public Kunde() {
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
    	if (nummer <= 0) {
            throw new IllegalArgumentException("Nummer muss größer als null sein.");
        }
    	this.nummer = nummer;
    }

    public String getName() {return name;}

    public void setName(String name) {
    	if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht null oder leer sein.");
        }
    	this.name = name;
    }

    public Gebaeude_Organisator getGebaeude() {
        return gebaeude;
    }


    public void setGebaeude(Gebaeude_Organisator gebaeude) {
        if (gebaeude == null) {
            throw new IllegalArgumentException("Gebaeude_Organisator darf nicht null sein.");
        }
        this.gebaeude = gebaeude;
    }

    @Override
    public String toString() {
        return name;
    }
}
