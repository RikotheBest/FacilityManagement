import Attribute.Adresse;
import Attribute.Groesse;
import Ausstattung.Ausstattung_Organisator;
import Gebaeude.Gebaeude_Organisator;
import Kunden.Kunde_Organisator;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Kunde_Organisator k = new Kunde_Organisator();
        k.add("HWR", new Gebaeude_Organisator(),1);
        k.add("FU", new Gebaeude_Organisator(),2);
        k.add("TU", new Gebaeude_Organisator(),3);

        try {
            k.uploadGebaeude();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(k.getGebaeudeListe(0));
        System.out.println(k.getGebaeudeListe(1));
        System.out.println(k.getGebaeudeListe(2));


    }
}