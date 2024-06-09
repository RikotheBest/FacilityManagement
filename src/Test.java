import Attribute.Datum;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung_Organisator;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {

        Ausstattung_Organisator ausstattungsListe = new Ausstattung_Organisator();

        ausstattungsListe.addFeuerloescher("feuerloescher", 12, "flur", new Auftrag_Organisator(),2);
        ausstattungsListe.addRauchmelder("Rauchmelder", 32, "flur", new Auftrag_Organisator(), 3);

        try {
            ausstattungsListe.upload();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(ausstattungsListe.getAustattungList().get(0).getAuftraege());
        System.out.println(ausstattungsListe.getAustattungList().get(1).getAuftraege());





    }
}