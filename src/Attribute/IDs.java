package Attribute;

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
}
