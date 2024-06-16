package Auftraege;

import Attribute.Datum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Die Klasse Auftrag_Organisator verwaltet eine Liste von Aufträgen.
 * Sie bietet Methoden zum Hinzufügen, Löschen und Sortieren von Aufträgen
 * sowie zum Abrufen und Setzen der Auftragsliste.
 */
public class Auftrag_Organisator {
    ObservableList<Auftrag> auftraege; // Liste der Aufträge

    public Auftrag_Organisator() {
        auftraege = FXCollections.observableArrayList();
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
        FXCollections.sort(auftraege,nachDatum);
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
    	if (nummer <= 0) {
            throw new IllegalArgumentException("Die Nummer muss größer als null sein: " + nummer);
        }
        if (kategorie == null || kategorie.trim().isEmpty()) {
            throw new IllegalArgumentException("Die Kategorie darf nicht leer sein.");
        }
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Status darf nicht leer sein.");
        }
        for (Auftrag a : auftraege) {
            if (a.getNummer() == nummer) {
                throw new IllegalArgumentException("Bitte geben Sie eine andere Nummer ein. Die Nummer " + nummer + " existiert bereits.");
            }
        }
        auftraege.add(new Auftrag(geplant,nummer,kategorie,status));
    }
    /**
     * Entfernt einen Auftrag aus der Liste.
     *
     * @param auftrag Der zu entfernende Auftrag.
     */
    public void delete(Auftrag auftrag){
    	if (!auftraege.remove(auftrag)) {
            throw new IllegalArgumentException("Der Auftrag konnte nicht entfernt werden, da er nicht in der Liste vorhanden ist.");
        }
        auftraege.remove(auftrag);
    }
    /**
     * Gibt die Liste der Aufträge zurück.
     *
     * @return Die Liste der Aufträge.
     */
    public ObservableList<Auftrag> getAuftraege() {
        return auftraege;
    }

    public void setAuftraege(ObservableList<Auftrag> auftraege) {
    	if (auftraege == null) {
            throw new IllegalArgumentException("Die Liste der Aufträge darf nicht null sein.");
        }
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
