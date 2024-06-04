package Kunden;

import Attribute.Adresse;
import Attribute.Groesse;
import Ausstattung.Ausstattung_Organisator;
import Gebaeude.Gebaeude_Organisator;
import Kunden.Kunde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kunde_Organisator {
    ArrayList<Kunde> kundenListe;

    public Kunde_Organisator() {
        kundenListe = new ArrayList<>();
    }

    public void add(String name, Gebaeude_Organisator gebaeude){
        boolean existiert = false;
        for(Kunde k : kundenListe){
            if(k.getName().equals(name)) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else kundenListe.add(new Kunde(name, gebaeude));
    }
    public void delete(Kunde k ){
        kundenListe.remove(k);
    }
    Comparator<Kunde> nachBuchstaben  = new Comparator<Kunde>() {
        @Override
        public int compare(Kunde o1, Kunde o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public void sort(){
        Collections.sort(kundenListe, nachBuchstaben);
    }
}
