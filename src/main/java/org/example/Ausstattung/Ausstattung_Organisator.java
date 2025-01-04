package org.example.Ausstattung;

import org.example.Attribute.Datum;
import org.example.Auftraege.Auftrag;
import org.example.Auftraege.Auftrag_Organisator;
import org.example.Ausstattung.Brandschutz.*;
import org.example.Ausstattung.Moebel.*;
import org.example.View.AlertFenster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Die Klasse Ausstattung_Organisator verwaltet eine Liste von Ausstattungen
 * und bietet Methoden zum Hinzufügen, Löschen, Speichern und Hochladen von
 * Ausstattungen und deren zugehörigen Aufträgen.
 */
public class Ausstattung_Organisator {
    private final String AUFTRAGID = "AuftragID";
    private final String DATUM = "Datum";
    private final String KATEGORIE = "Kategorie";
    private final String STATUS = "Status";
    private final String AUSSTATTUNGID = "AusstattungID";
    private final String URL = "jdbc:sqlite:DB/FacilityManagement.db";

    private ObservableList<Ausstattung> austattungList; // Liste der Ausstattungen

    //Standardkonstruktor zum Initialisieren des Ausstattung_Organisators.
    public Ausstattung_Organisator() {
        austattungList = FXCollections.observableArrayList();
    }
    private void checkForDuplicateNumber(int nummer) {
        for (Ausstattung a : austattungList) {
            if (a.getNummer() == nummer) {
            	AlertFenster.showAlert("Nummer bereits vergeben", "Bitte geben Sie eine andere Nummer ein!");
                throw new IllegalArgumentException("Die Folgende Nummer ist bereits vergeben: " + nummer + "Bitte geben Sie eine andere Nummer ein!");
            }
        }
    }
    /**
     * Fügt einen neuen Feuerlöscher zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param preis Der Preis des Feuerlöschers.
     * @param ort Der Ort, an dem der Feuerlöscher sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Feuerlöschers.
     */
    public void addFeuerloescher(int preis, String ort, Auftrag_Organisator auftraege, int nummer){
    	checkForDuplicateNumber(nummer);
        austattungList.add(new Feuerloescher(preis, ort, auftraege, nummer));
    }

    /**
     * Fügt einen neuen Rauchmelder zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param preis Der Preis des Rauchmelders.
     * @param ort Der Ort, an dem der Rauchmelder sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Rauchmelders.
     */
    public void addRauchmelder( int preis, String ort, Auftrag_Organisator auftraege, int nummer){
    	 checkForDuplicateNumber(nummer);
         austattungList.add(new Rauchmelder(preis, ort, auftraege, nummer));
     }

    /**
     * Fügt ein neues Sitzmöbel zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param preis Der Preis des Sitzmöbels.
     * @param ort Der Ort, an dem das Sitzmöbel sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Sitzmöbels.
     */
    public void addSitzmoebel(int preis, String ort, Auftrag_Organisator auftraege, int nummer){
    	checkForDuplicateNumber(nummer);
        austattungList.add(new Sitzmoebel(preis, ort, auftraege, nummer));
    }



    /**
     * Fügt einen neuen Tisch zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param preis Der Preis des Tisches.
     * @param ort Der Ort, an dem der Tisch sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Tisches.
     */
    public void addTisch( int preis, String ort, Auftrag_Organisator auftraege, int nummer){
    	checkForDuplicateNumber(nummer);
        austattungList.add(new Tisch(preis, ort, auftraege, nummer));
    }


    /**
     * Fügt einen neuen Schrank zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param preis Der Preis des Schranks.
     * @param ort Der Ort, an dem der Schrank sich befindet.
     * @param auftraege Der Auftrag_Organisator, der die zugehörigen Aufträge verwaltet.
     * @param nummer Die Nummer des Schranks.
     */
    public void addSchrank(int preis, String ort, Auftrag_Organisator auftraege, int nummer){
    	checkForDuplicateNumber(nummer);
        austattungList.add(new Schrank(preis, ort, auftraege, nummer));
    }


    public ObservableList<Ausstattung> getAustattungList() {
        return austattungList;
    }

    /**
     * Entfernt eine org.example.Ausstattung aus der Liste.
     *
     * @param a Die zu entfernende org.example.Ausstattung.
     */
    public void delete(Ausstattung a){
    	if (!austattungList.remove(a)) {
            throw new IllegalArgumentException("Die angegebene org.example.Ausstattung existiert nicht.");
        }
    }

    /**
     * Gibt die Liste der Aufträge einer bestimmten org.example.Ausstattung zurück.
     *
     * @param i Der Index der org.example.Ausstattung in der Liste.
     * @return Die Liste der Aufträge der angegebenen org.example.Ausstattung.
     */
    public ObservableList<Auftrag> getAuftragsListe(int i){
    	if (i < 0 || i >= austattungList.size()) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + i);
        }
        return austattungList.get(i).getAuftraege().getAuftraege();
    }

    /**
     * Speichert alle Aufträge von allen Ausstattungen in der Datenbank.
     *
     * @throws SQLException Wenn ein SQL-Fehler auftritt.
     */
    public void speichereAuftraege(Connection con) throws SQLException { // speichert alle org.example.Auftraege von allen Austattungen
    	try{


            String speichernSQL = "INSERT INTO Auftrag (" + AUFTRAGID + ", " + DATUM + ", " + KATEGORIE + ", " + STATUS + ", " + AUSSTATTUNGID + ") VALUES(?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(speichernSQL);
                int i = 0;
                for (Ausstattung as : austattungList) {
                    for (Auftrag a : getAuftragsListe(i)) {
                        statement.setInt(1, a.getNummer());
                        statement.setString(2, a.getGeplant().toString());
                        statement.setString(3, a.getKategorie());
                        statement.setString(4, a.getStatus());
                        statement.setInt(5, austattungList.get(i).getNummer());
                        statement.addBatch();
                    }
                    i++;
                }
                int[] results = statement.executeBatch();
                statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Fehler beim Speichern der Aufträge in der Datenbank.", e);
        }
    }

    /**
     * Lädt alle Aufträge aus der Datenbank und fügt sie den entsprechenden Ausstattungen hinzu.
     *
     * @throws SQLException Wenn ein SQL-Fehler auftritt.
     */
    public void upload(Connection con) throws SQLException {
    	try (Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM Auftrag")) {

               while (result.next()) {
                   int i = result.getInt(AUSSTATTUNGID);
                   for (Ausstattung a : austattungList) {
                       if (a.getNummer() == i) {
                           a.getAuftraege().add(new Datum(result.getString(DATUM)), result.getInt(AUFTRAGID), result.getString(KATEGORIE), result.getString(STATUS));
                       }
                   }
               } 
               statement.close();

           } catch (SQLException e) {
               e.printStackTrace();
               throw new SQLException("Fehler beim Hochladen der Aufträge aus der Datenbank.", e);
           }
       }
    

    /**
     * Überschreibt die toString-Methode, um die Liste der Ausstattungen als String darzustellen.
     *
     * @return Eine String-Darstellung der Liste der Ausstattungen.
     */
    public String toString(){
        for(Ausstattung a : austattungList){
            a.toString();
        }
        return "";
    }
}
