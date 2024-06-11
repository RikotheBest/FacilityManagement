package Gebaeude;

import Attribute.Adresse;
import Attribute.Datum;
import Attribute.Groesse;
import Auftraege.Auftrag;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung;
import Ausstattung.Ausstattung_Organisator;

import java.sql.*;
import java.util.ArrayList;

public class Gebaeude_Organisator {
    ArrayList<Gebaeude> gebaeudeListe;
    private final String AUSSTATTUNGID = "AusstattungID";
    private final String GEBAEUDEID = "GebaeudeID";
    private final String ORT = "Ort";
    private final String PREIS = "Preis";
    private final String NAME = "Name";
    private final String URL = "jdbc:sqlite:DB/FacilityManagement.db";


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
    public ArrayList<Ausstattung> getAusstattungsListe(int i){
        return gebaeudeListe.get(i).getAustattung().getAustattungList();
    }

    public void speichereAusstattung()throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        String loeschenSQL = "DELETE FROM Ausstattug";
        PreparedStatement statement2 = con.prepareStatement(loeschenSQL);
        statement2.executeUpdate();
        statement2.close();


        String speichernSQL = "INSERT INTO Auftrag (" + AUSSTATTUNGID +", " + GEBAEUDEID + ", " + ORT +  ", " + PREIS + ", " + NAME + ") VALUES(?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(speichernSQL);

        int i = 0;

        for (Gebaeude g : gebaeudeListe) {
            for (Ausstattung a : getAusstattungsListe(i)) {
                statement.setString(1, a.getNummer() + "");
                statement.setString(2, gebaeudeListe.get(i).getNummer() + "");
                statement.setString(3, a.getOrt());
                statement.setString(4, a.getPreis() + "");
                statement.setString(5, a.getName());
                statement.executeUpdate();

            }
            i++;
        }

        statement.close();
        con.close();
    }
    public void upload() throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        String uploadSQL = "SELECT * FROM Ausstattung";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(uploadSQL);

        while (result.next()){
            int i = result.getInt(GEBAEUDEID);
            String n = result.getString(NAME);
            for(Gebaeude g : gebaeudeListe){
                if(g.getNummer() == i){
                   switch (n){
                       case "Rauchmelder": g.getAustattung().addRauchmelder(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                       break;
                       case "Feuerloescher": g.getAustattung().addFeuerloescher(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                       break;
                       case "Tisch": g.getAustattung().addTisch(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                       break;
                       case "Sitzmoebel": g.getAustattung().addSitzmoebel(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                       break;
                       case "Schrank": g.getAustattung().addSchrank(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                       break;
                   }

                }
            }
        }
        statement.close();
        con.close();
    }
}
