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
        auftraege.add(new Auftrag(geplant, nummer, kategorie, status));
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
