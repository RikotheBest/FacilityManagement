package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;
/**
 * Die Klasse Tisch erweitert die Klasse Ausstattung und repräsentiert
 * einen Tisch als Ausstattungselement. Sie initialisiert die Eigenschaften
 * eines Tisches und setzt den Namen auf "Tisch".
 */
public class Tisch extends Ausstattung {
    /**
     * Konstruktor zum Initialisieren eines Tisches mit den angegebenen
     * Preis, Ort, Auftrag_Organisator und Nummer.
     *
     * @param preis Der Preis des Tisches.
     * @param ort Der Ort, an dem der Tisch sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Tisches.
     */
    public Tisch(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Tisch");
    }
}
