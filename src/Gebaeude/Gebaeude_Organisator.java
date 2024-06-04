package Gebaeude;

import Attribute.Adresse;
import Attribute.Datum;
import Attribute.Groesse;
import Auftraege.Auftrag;
import Ausstattung.Ausstattung_Organisator;

import java.util.ArrayList;

public class Gebaeude_Organisator {
    ArrayList<Gebaeude> gebaeudeListe;

    public Gebaeude_Organisator() {
        gebaeudeListe = new ArrayList<Gebaeude>();
    }
    public void add(int nummer, Groesse groesse, Adresse adresse, Ausstattung_Organisator ausstattung){
        boolean existiert = false;
        for(Gebaeude a : gebaeudeListe){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else gebaeudeListe.add(new Gebaeude(nummer, groesse, adresse, ausstattung));
    }
    public void delete(Gebaeude g){
        gebaeudeListe.remove(g);
    }

}
