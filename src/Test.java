import Attribute.Datum;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung_Organisator;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {



        Auftrag_Organisator auftragsListe = new Auftrag_Organisator();
        auftragsListe.add(new Datum(),4,"Wartung", "in Bearbeitung");
        auftragsListe.add(new Datum(23,12,2001),7,"Wartung", "in Bearbeitung");
        auftragsListe.add(new Datum(),8,"Wartung", "in Bearbeitung");
        Ausstattung_Organisator ausstattungsListe = new Ausstattung_Organisator();
        ausstattungsListe.addFeuerloescher("feuerloescher", 12, "flur", auftragsListe,2);
        try {
            ausstattungsListe.speichernAuftraege(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}