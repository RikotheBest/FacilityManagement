package Ausstattung;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Brandschutz.Feuerloescher;
import Ausstattung.Brandschutz.Rauchmelder;
import Ausstattung.Moebel.Sitzmöbel;
import Ausstattung.Moebel.Tisch;
import Ausstattung.Moebel.Schrank;

import java.util.ArrayList;

public class Ausstattung_Organisator {
    ArrayList<Ausstattung> austattungList;

    public Ausstattung_Organisator() {
        austattungList = new ArrayList<>();
    }
    public void addFeuerloescher(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Feuerloescher(name, preis,ort,auftraege, nummer));
    }

    public void addRauchmelder(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Rauchmelder(name, preis,ort,auftraege, nummer));
    }
    public void addFenster(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Sitzmöbel(name, preis,ort,auftraege, nummer));
    }
    public void addTisch(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Tisch(name, preis,ort,auftraege, nummer));
    }
    public void addTuer(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Schrank(name, preis,ort,auftraege, nummer));
    }
    public void delete(Ausstattung a){
        austattungList.remove(a);
    }
}
