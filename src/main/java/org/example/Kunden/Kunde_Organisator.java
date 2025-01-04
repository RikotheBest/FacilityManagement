package org.example.Kunden;

import org.example.Attribute.Adresse;
import org.example.Attribute.Groesse;
import org.example.Ausstattung.Ausstattung_Organisator;
import org.example.Gebaeude.Gebaeude;
import org.example.Gebaeude.Gebaeude_Organisator;
import org.example.View.AlertFenster;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Die Klasse Kunde_Organisator verwaltet eine Liste von org.example.Kunden und bietet Methoden zum Hinzufügen,
 * Löschen und Sortieren von org.example.Kunden.
 */
public class Kunde_Organisator {
    private final String GEBAEUDEID = "GebaeudeID";
    private final String ADRESSE = "Adresse";
    private final String GROESSE = "Groesse";
    private final String KUNDEID = "KundeID";
    private final String NAME = "Name";
    private final String URL = "jdbc:sqlite:DB/FacilityManagement.db";

    private ObservableList<Kunde> kundenListe; // Liste der org.example.Kunden

    public Kunde_Organisator() {
        kundenListe = FXCollections.observableArrayList();
    }

    public ObservableList<Kunde> getKundenListe() {
        return kundenListe;
    }

    /**
     * Fügt einen neuen org.example.Kunden zur Liste hinzu, falls der Name noch nicht existiert.
     *
     * @param name Der Name des org.example.Kunden.
     * @param gebaeude Der Gebäudeorganisator des org.example.Kunden.
     */
    public void add(String name, Gebaeude_Organisator gebaeude, int nummer){
    	boolean nameExistiert = false;
    	boolean nummerExistiert = false;
        for (Kunde k : kundenListe) {
            if (k.getName().equals(name)) {
            	nameExistiert = true;
            }	
            if (k.getNummer() == nummer) {
            	nummerExistiert = true;
            }
            
        }
        if (nameExistiert && nummerExistiert) {
            AlertFenster.showAlert("Name und Nummer bereits vergeben", "Bitte geben Sie einen anderen Namen und eine andere Nummer ein!");
        } else if (nameExistiert) {
            AlertFenster.showAlert("Name bereits vergeben", "Bitte geben Sie einen anderen Namen ein!");
        } else if (nummerExistiert) {
            AlertFenster.showAlert("Nummer bereits vergeben", "Bitte geben Sie eine andere Nummer ein!");
        } else {
            kundenListe.add(new Kunde(name, gebaeude, nummer));
        }
    }

    /**
     * Entfernt einen org.example.Kunden aus der Liste.
     *
     * @param k Der zu entfernende Kunde.
     */
    public void delete(Kunde k ){
        kundenListe.remove(k);
    }


    public ObservableList<Gebaeude> getGebaeudeListe(int i){
        return kundenListe.get(i).getGebaeude().getGebaeudeListe();
    }

    public void speichereGebaeude(Connection con)throws SQLException {
        String speichernSQL = "INSERT INTO Gebaeude (" + GEBAEUDEID +", " + ADRESSE + ", " + GROESSE +  ", " + KUNDEID + ") VALUES(?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(speichernSQL)) {
            Gson gson = new Gson();
            int i = 0;

            for (Kunde k : kundenListe) {
                for (Gebaeude g : getGebaeudeListe(i)) {
                    statement.setInt(1, g.getNummer());
                    statement.setString(2, gson.toJson(g.getAdresse()));
                    statement.setString(3, gson.toJson(g.getGroesse()));
                    statement.setInt(4, kundenListe.get(i).getNummer());
                    statement.addBatch();
                }
                i++;
            }
            int[] results = statement.executeBatch();
        } catch (SQLException e) {
            System.err.println("Fehler beim Speichern der Gebäude: " + e.getMessage());
        }
    }
    
    public void uploadGebaeude(Connection con) throws SQLException {
        String uploadSQL = "SELECT * FROM Gebaeude";
        try (Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(uploadSQL)) {
               Gson gson = new Gson();

               while (result.next()) {
                   int i = result.getInt(KUNDEID);
                   for (Kunde k : kundenListe) {
                       if (k.getNummer() == i) {
                           k.getGebaeude().add(result.getInt(GEBAEUDEID), gson.fromJson(result.getString(GROESSE), Groesse.class),
                                   gson.fromJson(result.getString(ADRESSE), Adresse.class), new Ausstattung_Organisator());
                       }
                   }
               }
           } catch (SQLException e) {
               System.err.println("Fehler beim Hochladen der Gebäude: " + e.getMessage());
           }
       }
    
    public void speichern(Connection con)throws SQLException{
        String speichernSQL = "INSERT INTO Kunden (" + KUNDEID +", " + NAME +  ") VALUES(?,?)";
        try (PreparedStatement statement = con.prepareStatement(speichernSQL)) {
            for (Kunde k : kundenListe) {
                statement.setInt(1, k.getNummer());
                statement.setString(2, k.getName());
                statement.addBatch();
            }
            int[] results = statement.executeBatch();
        } catch (SQLException e) {
            System.err.println("Fehler beim Speichern der org.example.Kunden: " + e.getMessage());
        }
    }
    
    public void upload(Connection con) throws SQLException {
        String uploadSQL = "SELECT * FROM Kunden";
        try (Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(uploadSQL)) {
               while (result.next()) {
                   kundenListe.add(new Kunde(result.getString(NAME), new Gebaeude_Organisator(), result.getInt(KUNDEID)));
               }
           } catch (SQLException e) {
               System.err.println("Fehler beim Hochladen der org.example.Kunden: " + e.getMessage());
           }
       }
   }
