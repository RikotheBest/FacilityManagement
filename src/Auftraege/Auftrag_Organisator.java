package Auftraege;

import Attribute.Datum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Auftrag_Organisator {
    ArrayList<Auftrag> auftraege;

    public Auftrag_Organisator() {
        auftraege = new ArrayList<>();
    }

    Comparator<Auftrag> nachDatum = new Comparator<>() {

        public int compare(Auftrag o1, Auftrag o2) {
            return o1.getGeplant().getDate().compareTo(o2.getGeplant().getDate());
        }

    };

    public void sort(){
        Collections.sort(auftraege,nachDatum);
    }
    public void add(Datum geplant, int nummer, String kategorie, boolean status){
        boolean existiert = false;
        for(Auftrag a : auftraege){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else auftraege.add(new Auftrag(geplant,nummer,kategorie,status));
    }
    public void delete(Auftrag auftrag){
        auftraege.remove(auftrag);
    }

    public ArrayList<Auftrag> getAuftraege() {
        return auftraege;
    }

    public void setAuftraege(ArrayList<Auftrag> auftraege) {
        this.auftraege = auftraege;
    }

    @Override
    public String toString() {
        for (Auftrag a :auftraege) {
            System.out.println(a.toString());
        } return "";
    }
}
