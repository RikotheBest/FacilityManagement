package Ausstattung.Brandschutz;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;
/**
 * Die Klasse Feuerloescher erweitert die Klasse Ausstattung und repräsentiert
 * einen Feuerlöscher als Ausstattungselement. Sie initialisiert die Eigenschaften
 * eines Feuerlöschers und setzt den Namen auf "Feuerloescher".
 */
public class Feuerloescher extends Ausstattung {

/**
 * Konstruktor zum Initialisieren eines Feuerlöschers mit den angegebenen
 * Preis, Ort, Auftrag_Organisator und Nummer.
 *
 * @param preis Der Preis des Feuerlöschers.
 * @param ort Der Ort, an dem der Feuerlöscher sich befindet.
 * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
 * @param nummer Die Nummer des Feuerlöschers.
*/
    public Feuerloescher(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Feuerloescher");
    }
}
