package Attribute;

import Auftraege.Auftrag;
import Ausstattung.Ausstattung;
import Gebaeude.Gebaeude;
import Gebaeude.Gebaeude_Organisator;
import Kunden.Kunde;

import java.util.ArrayList;

public class IDs {
    private static ArrayList<Integer> auftragIDs;
    private static ArrayList<Integer> ausstattungIDs;
    private static ArrayList<Integer> gebaeudeIDs;
    private static ArrayList<Integer> kundenIDs;

    public IDs() {
        auftragIDs = new ArrayList<>();
        ausstattungIDs = new ArrayList<>();
        gebaeudeIDs = new ArrayList<>();
        kundenIDs = new ArrayList<>();
    }
    public static void addAuftragID(Integer e){
        auftragIDs.add(e);
    }
    public static void addAusstattungID(Integer e){
        ausstattungIDs.add(e);
    }
    public static void addGebaeudeID(Integer e){
        gebaeudeIDs.add(e);
    }
    public static void addKundenID(Integer e){
        kundenIDs.add(e);
    }

    public static ArrayList<Integer> getAuftragIDs() {
        return auftragIDs;
    }

    public static ArrayList<Integer> getAusstattungIDs() {
        return ausstattungIDs;
    }

    public static ArrayList<Integer> getGebaeudeIDs() {
        return gebaeudeIDs;
    }

    public static ArrayList<Integer> getKundenIDs() {
        return kundenIDs;
    }
    public static void rmvKundeId(Kunde k, Integer i){
        kundenIDs.remove(i);
        for(Gebaeude g : k.getGebaeude().getGebaeudeListe()){
            rmvGebaeudeId(g, g.getNummer());
        }
    }
    public static void rmvGebaeudeId(Gebaeude g, Integer i){
        gebaeudeIDs.remove(i);
        for(Ausstattung a : g.getAustattung().getAustattungList()){
            rmvAusstattungId(a, a.getNummer());
        }
    }
    public static void rmvAusstattungId(Ausstattung a, Integer i){
        ausstattungIDs.remove(i);
        for(Auftrag auftrag : a.getAuftraege().getAuftraege()){
            rmvAuftragId(auftrag.getNummer());
        }
    }
    public static void rmvAuftragId(Integer i){
        auftragIDs.remove(i);
    }
}
