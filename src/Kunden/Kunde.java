package Kunden;

import Gebaeude.Gebaeude_Organisator;
import javafx.scene.control.TreeItem;

/**
 * Die Klasse Kunde repräsentiert einen Kunden mit einem Namen und einem
 * Gebäudeorganisator. Sie bietet Methoden zum Abrufen und Setzen dieser Attribute.
 */
public class Kunde {
    private int nummer;
    private String name;
    private Gebaeude_Organisator gebaeude;

    /**
     * Konstruktor zum Initialisieren eines Kunden mit dem angegebenen Namen und Gebäudeorganisator.
     *
     * @param name Der Name des Kunden.
     * @param gebaeude Der Gebäudeorganisator des Kunden.
     */
    public Kunde(String name, Gebaeude_Organisator gebaeude, int nummer) {
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
        this.nummer = nummer;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Gebaeude_Organisator getGebaeude() {return gebaeude;}

    public void setGebaeude(Gebaeude_Organisator gebaeude) {this.gebaeude = gebaeude;}

    @Override
    public String toString() {
        return name;
    }
}
