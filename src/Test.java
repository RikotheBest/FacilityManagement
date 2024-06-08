import Attribute.Datum;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung_Organisator;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {



        Auftrag_Organisator auftragsListe = new Auftrag_Organisator();
        auftragsListe.add(new Datum(),20,"Wartung", "in Bearbeitung");
        auftragsListe.add(new Datum(23,12,2001),21,"Wartung", "in Bearbeitung");
        auftragsListe.add(new Datum(),22,"Wartung", "in Bearbeitung");
        Ausstattung_Organisator ausstattungsListe = new Ausstattung_Organisator();



        Auftrag_Organisator auftragsListe2 = new Auftrag_Organisator();
        auftragsListe2.add(new Datum(),100,"Wartung", "in Bearbeitung");
        auftragsListe2.add(new Datum(23,12,2001),101,"Wartung", "in Bearbeitung");
        auftragsListe2.add(new Datum(),102,"Wartung", "in Bearbeitung");


        ausstattungsListe.addFeuerloescher("feuerloescher", 12, "flur", auftragsListe,2);
        ausstattungsListe.addRauchmelder("Rauchmelder", 32, "flur", auftragsListe2, 3);
        try {
            ausstattungsListe.speichernAuftraege();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}