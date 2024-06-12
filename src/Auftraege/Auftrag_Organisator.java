package Auftraege;

import Attribute.Datum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Die Klasse Auftrag_Organisator verwaltet eine Liste von Aufträgen.
 * Sie bietet Methoden zum Hinzufügen, Löschen und Sortieren von Aufträgen
 * sowie zum Abrufen und Setzen der Auftragsliste.
 */
public class Auftrag_Organisator {
    ArrayList<Auftrag> auftraege; // Liste der Aufträge

    public Auftrag_Organisator() {
        auftraege = new ArrayList<>();
    }
    /**
     * Comparator zum Vergleichen von Aufträgen nach geplantem Datum.
     */
    Comparator<Auftrag> nachDatum = new Comparator<>() {

        public int compare(Auftrag o1, Auftrag o2) {
            return o1.getGeplant().getDate().compareTo(o2.getGeplant().getDate());
        }

    };
    /**
     * Sortiert die Liste der Aufträge nach geplantem Datum.
     */
    public void sort(){
        Collections.sort(auftraege,nachDatum);
    }
    /**
     * Fügt einen neuen Auftrag zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param geplant Das geplante Datum des Auftrags.
     * @param nummer Die Nummer des Auftrags.
     * @param kategorie Die Kategorie des Auftrags.
     * @param status Der Status des Auftrags.
     */
    public void add(Datum geplant, int nummer, String kategorie, String status){
        boolean existiert = false;
        for(Auftrag a : auftraege){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else auftraege.add(new Auftrag(geplant,nummer,kategorie,status));
    }
    /**
     * Entfernt einen Auftrag aus der Liste.
     *
     * @param auftrag Der zu entfernende Auftrag.
     */
    public void delete(Auftrag auftrag){
        auftraege.remove(auftrag);
    }
    /**
     * Gibt die Liste der Aufträge zurück.
     *
     * @return Die Liste der Aufträge.
     */
    public ArrayList<Auftrag> getAuftraege() {
        return auftraege;
    }

    public void setAuftraege(ArrayList<Auftrag> auftraege) {
        this.auftraege = auftraege;
    }

    /**
     * Gibt eine String-Darstellung aller Aufträge zurück.
     *
     * @return Eine String-Darstellung aller Aufträge.
     */
    public String toString() {
        for (Auftrag a :auftraege) {
            a.toString();
        } return "";
    }
}
