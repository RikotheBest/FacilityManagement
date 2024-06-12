package Kunden;

import Gebaeude.Gebaeude_Organisator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Die Klasse Kunde_Organisator verwaltet eine Liste von Kunden und bietet Methoden zum Hinzufügen,
 * Löschen und Sortieren von Kunden.
 */
public class Kunde_Organisator {
    ArrayList<Kunde> kundenListe; // Liste der Kunden

    public Kunde_Organisator() {
        kundenListe = new ArrayList<>();
    }

    /**
     * Fügt einen neuen Kunden zur Liste hinzu, falls der Name noch nicht existiert.
     *
     * @param name Der Name des Kunden.
     * @param gebaeude Der Gebäudeorganisator des Kunden.
     */
    public void add(String name, Gebaeude_Organisator gebaeude){
        boolean existiert = false;
        for(Kunde k : kundenListe){
            if(k.getName().equals(name)) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else kundenListe.add(new Kunde(name, gebaeude));
    }

    /**
     * Entfernt einen Kunden aus der Liste.
     *
     * @param k Der zu entfernende Kunde.
     */
    public void delete(Kunde k ){
        kundenListe.remove(k);
    }

    //Comparator zum Vergleichen von Kunden nach Namen.
    Comparator<Kunde> nachBuchstaben  = new Comparator<Kunde>() {
        @Override
        public int compare(Kunde o1, Kunde o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    //Sortiert die Liste der Kunden nach Namen in alphabetischer Reihenfolge.
    public void sort(){
        Collections.sort(kundenListe, nachBuchstaben);
    }
}
