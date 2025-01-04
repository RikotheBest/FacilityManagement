package org.example.Ausstattung.Brandschutz;

import org.example.Auftraege.Auftrag_Organisator;
import org.example.Ausstattung.Ausstattung;
/**
 * Die Klasse Rauchmelder erweitert die Klasse org.example.Ausstattung und repräsentiert
 * einen Rauchmelder als Ausstattungselement. Sie initialisiert die Eigenschaften
 * eines Rauchmelders und setzt den Namen auf "Rauchmelder".
 */
public class Rauchmelder extends Ausstattung {
    /**
     * Konstruktor zum Initialisieren eines Rauchmelders mit den angegebenen
     * Preis, Ort, Auftrag_Organisator und Nummer.
     *
     * @param preis Der Preis des Rauchmelders.
     * @param ort Der Ort, an dem der Rauchmelder sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Rauchmelders.
     */
    public Rauchmelder(int preis, String ort, Auftrag_Organisator auftraege, int nummer) {
        super(preis, ort, auftraege, nummer);
        super.setName("Rauchmelder");
    }



}
