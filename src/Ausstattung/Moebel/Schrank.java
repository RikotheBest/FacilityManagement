package Ausstattung.Moebel;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;
/**
 * Die Klasse Schrank erweitert die Klasse Ausstattung und repräsentiert
 * einen Schrank als Ausstattungselement. Sie initialisiert die Eigenschaften
 * eines Schranks und setzt den Namen auf "Schrank".
 */
public class Schrank extends Ausstattung {
    /**
     * Konstruktor zum Initialisieren eines Schranks mit den angegebenen
     * Preis, Ort, Auftrag_Organisator und Nummer.
     *
     * @param preis Der Preis des Schranks.
     * @param ort Der Ort, an dem der Schrank sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Schranks.
     */
    public Schrank(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Schrank");
    }
}

