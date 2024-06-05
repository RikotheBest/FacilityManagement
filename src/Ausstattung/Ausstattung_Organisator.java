package Ausstattung;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Brandschutz.*;
import Ausstattung.Moebel.*;
import Ausstattung.Elektrogeraete.*;
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
    public void addBelechtungssystem(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Belechtungssystem(name, preis, ort, auftraege, nummer));
    }
    public void addDrucker(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Drucker(name, preis, ort, auftraege, nummer));
    }
    public void addKlimagerät(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Klimagerät(name, preis, ort, auftraege, nummer));
    }
    public void addMonitor(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Monitor(name, preis, ort, auftraege, nummer));
    }
    public void addSitzmoebel(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Sitzmoebel (name, preis,ort,auftraege, nummer));
    }
    public void addTisch(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Tisch(name, preis,ort,auftraege, nummer));
    }
    public void addSchrank(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Schrank(name, preis, ort, auftraege, nummer));
    }
    public void addRegal(String name, int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Regal(name, preis, ort, auftraege, nummer));
    }
    public void delete(Ausstattung a){
        austattungList.remove(a);
    }
}
