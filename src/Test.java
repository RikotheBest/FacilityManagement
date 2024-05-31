import Attribute.Datum;
import Auftraege.Auftrag;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Brandschutz.Feuerloescher;
import Ausstattung.Brandschutz.Feuerloescher_Organisator;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Feuerloescher_Organisator feuer = new Feuerloescher_Organisator();
        feuer.add("Feuerloescher", 50,"Flur",new Auftrag_Organisator());
        feuer.getFeuerloescher().get(0).getAuftraege().add(new Datum(23,12,2004),200,"Auftrag", false);
        feuer.getFeuerloescher().get(0).getAuftraege().add(new Datum(),201,"Auftrag", false);
        feuer.getFeuerloescher().get(0).getAuftraege().add(new Datum(12,10,2005),200,"Auftrag", false);


        System.out.println(feuer.getFeuerloescher().get(0).getAuftraege());
        feuer.getFeuerloescher().get(0).getAuftraege().sort();

        System.out.println(feuer.getFeuerloescher().get(0).getAuftraege());




    }
}