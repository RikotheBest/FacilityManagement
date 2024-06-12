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

/**
 * Die Klasse Gebaeude_Organisator verwaltet eine Liste von Gebäuden
 * und bietet Methoden zum Hinzufügen, Löschen, Speichern und Hochladen
 * von Gebäuden und deren Ausstattung.
 */
public class Gebaeude_Organisator {
    private ArrayList<Gebaeude> gebaeudeListe; // Liste der Gebäude
    private final String AUSSTATTUNGID = "AusstattungID";
    private final String GEBAEUDEID = "GebaeudeID";
    private final String ORT = "Ort";
    private final String PREIS = "Preis";
    private final String NAME = "Name";
    private final String URL = "jdbc:sqlite:DB/FacilityManagement.db";


    public Gebaeude_Organisator() {
        gebaeudeListe = new ArrayList<Gebaeude>();
    }

    public ArrayList<Gebaeude> getGebaeudeListe() {
        return gebaeudeListe;
    }

    /**
     * Fügt ein neues Gebäude zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param nummer Die Nummer des Gebäudes.
     * @param groesse Die Größe des Gebäudes.
     * @param adresse Die Adresse des Gebäudes.
     * @param ausstattung Der Ausstattung_Organisator, der die zugehörige Ausstattung verwaltet.
     */

    public void add(int nummer, Groesse groesse, Adresse adresse, Ausstattung_Organisator ausstattung){
        boolean existiert = false;
        for(Gebaeude a : gebaeudeListe){
            if(a.getNummer() == nummer) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else gebaeudeListe.add(new Gebaeude(nummer, groesse, adresse, ausstattung));
    }

    /**
     * Entfernt ein Gebäude aus der Liste.
     *
     * @param g Das zu entfernende Gebäude.
     */
    public void delete(Gebaeude g){
        gebaeudeListe.remove(g);
    }

    /**
     * Gibt die Liste der Ausstattungen eines bestimmten Gebäudes zurück.
     *
     * @param i Der Index des Gebäudes in der Liste.
     * @return Die Liste der Ausstattungen des angegebenen Gebäudes.
     */
    public ArrayList<Ausstattung> getAusstattungsListe(int i){
        return gebaeudeListe.get(i).getAustattung().getAustattungList();
    }

    /**
     * Speichert alle Ausstattungen von allen Gebäuden in der Datenbank.
     *
     * @throws SQLException Wenn ein SQL-Fehler auftritt.
     */
    public void speichereAusstattung()throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        String loeschenSQL = "DELETE FROM Ausstattung";
        PreparedStatement statement2 = con.prepareStatement(loeschenSQL);
        statement2.executeUpdate();
        statement2.close();


        String speichernSQL = "INSERT INTO Ausstattung (" + AUSSTATTUNGID +", " + GEBAEUDEID + ", " + ORT +  ", " + PREIS + ", " + NAME + ") VALUES(?,?,?,?,?)";
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

        /**
         * Lädt alle Ausstattungen aus der Datenbank und fügt sie den entsprechenden Gebäuden hinzu.
         *
         * @throws SQLException Wenn ein SQL-Fehler auftritt.
         */
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
