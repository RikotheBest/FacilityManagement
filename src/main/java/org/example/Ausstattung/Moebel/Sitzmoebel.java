package org.example.Ausstattung.Moebel;

import org.example.Auftraege.Auftrag_Organisator;
import org.example.Ausstattung.Ausstattung;
/**
 * Die Klasse Sitzmoebel erweitert die Klasse org.example.Ausstattung und repräsentiert
 * ein Sitzmöbelstück als Ausstattungselement. Sie initialisiert die Eigenschaften
 * eines Sitzmöbelstücks und setzt den Namen auf "Sitzmoebel".
 */
public class Sitzmoebel extends Ausstattung {
    /**
     * Konstruktor zum Initialisieren eines Sitzmöbelstücks mit den angegebenen
     * Preis, Ort, Auftrag_Organisator und Nummer.
     *
     * @param preis Der Preis des Sitzmöbelstücks.
     * @param ort Der Ort, an dem das Sitzmöbelstück sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Sitzmöbelstücks.
     */
    public Sitzmoebel(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Sitzmoebel");
    }
}
