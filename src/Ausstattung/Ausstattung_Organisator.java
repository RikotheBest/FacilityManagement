package Ausstattung;

import Auftraege.Auftrag;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Brandschutz.*;
import Ausstattung.Moebel.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public void delete(Ausstattung a){
        austattungList.remove(a);
    }
    public ArrayList<Auftrag> getAuftragsListe(int i){
        return austattungList.get(i).getAuftraege().getAuftraege();
    }
    public void speichernAuftraege(int i) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\riyad\\OneDrive\\Рабочий стол\\sqlite-tools\\FacilityManagement.db");
        String speichernSQL = "INSERT INTO Auftrag(AuftragID, Datum, Kategorie, Status, AusstattungID) VALUES(?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(speichernSQL);
        for(Auftrag a : getAuftragsListe(i) ) {
            statement.setString(1, a.getNummer() + "");
            statement.setString(2, a.getGeplant().toString());
            statement.setString(3, a.getKategorie());
            statement.setString(4,a.getStatus());
            statement.setString(5, austattungList.get(i).getNummer() + "");
            statement.executeUpdate();

        }
        statement.close();
        con.close();


    }
}
