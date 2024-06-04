package Ausstattung;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Brandschutz.Feuerloescher;
import Ausstattung.Brandschutz.Rauchmelder;
import Ausstattung.Moebel.Fenster;
import Ausstattung.Moebel.Tisch;
import Ausstattung.Moebel.Tuer;

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
        else austattungList.add(new Fenster(name, preis,ort,auftraege, nummer));
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
        else austattungList.add(new Tuer(name, preis,ort,auftraege, nummer));
    }
    public void delete(Ausstattung a){
        austattungList.remove(a);
    }
}
