package Ausstattung.Brandschutz;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Moebel.Fenster_Organisator;

import java.util.ArrayList;

public class Feuerloescher_Organisator {
    ArrayList<Feuerloescher> feuerloescher;

    public Feuerloescher_Organisator() {
        feuerloescher = new ArrayList<>();
    }
    public void add(String name, int preis, String ort, Auftrag_Organisator auftraege){
        feuerloescher.add(new Feuerloescher(name,preis,ort,auftraege));
    }

    public ArrayList<Feuerloescher> getFeuerloescher() {
        return feuerloescher;
    }

    public void setFeuerloescher(ArrayList<Feuerloescher> feuerloescher) {
        this.feuerloescher = feuerloescher;
    }
}
