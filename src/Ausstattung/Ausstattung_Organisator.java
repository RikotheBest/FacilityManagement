package Ausstattung;

import Attribute.Datum;
import Auftraege.Auftrag;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Brandschutz.*;
import Ausstattung.Moebel.*;


import java.sql.*;
import java.util.ArrayList;

public class Ausstattung_Organisator {
    private final String AUFTRAGID = "AuftragID";
    private final String DATUM = "Datum";
    private final String KATEGORIE = "Kategorie";
    private final String STATUS = "Status";
    private final String AUSSTATTUNGID = "AusstattungID";
    private final String URL = "jdbc:sqlite:DB/FacilityManagement.db";

    private ArrayList<Ausstattung> austattungList;

    public Ausstattung_Organisator() {
        austattungList = new ArrayList<>();
    }
    public void addFeuerloescher(int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Feuerloescher(preis,ort,auftraege, nummer));
    }
    public void addRauchmelder( int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Rauchmelder(preis,ort,auftraege, nummer));
    }

    public void addSitzmoebel(int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Sitzmoebel (preis,ort,auftraege, nummer));
    }
    public void addTisch( int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Tisch(preis,ort,auftraege, nummer));
    }
    public void addSchrank(int preis, String ort, Auftrag_Organisator auftraege, int nummer){
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Schrank(preis, ort, auftraege, nummer));
    }

    public ArrayList<Ausstattung> getAustattungList() {
        return austattungList;
    }


    public void delete(Ausstattung a){
        austattungList.remove(a);
    }
    public ArrayList<Auftrag> getAuftragsListe(int i){
        return austattungList.get(i).getAuftraege().getAuftraege();
    }
    public void speichereAuftraege() throws SQLException { // speichert alle Auftraege von allen Austattungen


        Connection con = DriverManager.getConnection(URL);
        String loeschenSQL = "DELETE FROM Auftrag";
        PreparedStatement statement2 = con.prepareStatement(loeschenSQL);
        statement2.executeUpdate();
        statement2.close();


        String speichernSQL = "INSERT INTO Auftrag (" + AUFTRAGID +", " + DATUM + ", " + KATEGORIE +  ", " + STATUS + ", " + AUSSTATTUNGID + ") VALUES(?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(speichernSQL);

        int i = 0;

        for (Ausstattung as : austattungList) {
            for (Auftrag a : getAuftragsListe(i)) {
            statement.setString(1, a.getNummer() + "");
            statement.setString(2, a.getGeplant().toString());
            statement.setString(3, a.getKategorie());
            statement.setString(4, a.getStatus());
            statement.setString(5, austattungList.get(i).getNummer() + "");
            statement.executeUpdate();

        }
            i++;
    }

        statement.close();
        con.close();
    }

    public void upload() throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        String uploadSQL = "SELECT * FROM Auftrag";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(uploadSQL);

        while (result.next()){
            int i = result.getInt(AUSSTATTUNGID);
            for(Ausstattung a : austattungList){
                if(a.getNummer() == i){
                    a.getAuftraege().add(new Datum(result.getString(DATUM)), result.getInt(AUFTRAGID), result.getString(KATEGORIE), result.getString(STATUS));
                }
            }
        }
        statement.close();
        con.close();
    }
    public String toString(){
        for(Ausstattung a : austattungList){
            a.toString();
        }
        return "";
    }
}
