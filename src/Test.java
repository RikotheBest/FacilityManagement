import Attribute.Adresse;
import Attribute.Datum;
import Attribute.Groesse;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;
import Ausstattung.Ausstattung_Organisator;
import Ausstattung.Brandschutz.Feuerloescher;
import Ausstattung.Moebel.Schrank;
import Gebaeude.Gebaeude;
import Gebaeude.Gebaeude_Organisator;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {


        Gebaeude_Organisator test = new Gebaeude_Organisator();
        test.add(1, new Groesse(1,2,3), new Adresse("asdasd", 12312, "dasdasd"), new Ausstattung_Organisator());
        test.add(2, new Groesse(1,2,3), new Adresse("asdasd", 12312, "dasdasd"), new Ausstattung_Organisator());

        try {
            test.upload();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        System.out.println(test.getAusstattungsListe(0));
        System.out.println(test.getAusstattungsListe(1));


    }
}