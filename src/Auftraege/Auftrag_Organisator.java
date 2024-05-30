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
            if(o1.getGeplant().getDate().getYear() < o2.getGeplant().getDate().getYear()) return 1;
            else if (o1.getGeplant().getDate().getMonthValue() < o2.getGeplant().getDate().getMonthValue()) return 1;
            else if (o1.getGeplant().getDate().getDayOfMonth() < o2.getGeplant().getDate().getDayOfMonth()) return 1;
            else return -1;

        }

    };

    public void sort(){
        Collections.sort(auftraege,nachDatum);
    }
}
