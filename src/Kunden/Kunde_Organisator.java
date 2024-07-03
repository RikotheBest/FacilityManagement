package Kunden;

import Attribute.Adresse;
import Attribute.Groesse;
import Ausstattung.Ausstattung_Organisator;
import Gebaeude.Gebaeude;
import Gebaeude.Gebaeude_Organisator;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Die Klasse Kunde_Organisator verwaltet eine Liste von Kunden und bietet Methoden zum Hinzufügen,
 * Löschen und Sortieren von Kunden.
 */
public class Kunde_Organisator {
    private final String GEBAEUDEID = "GebaeudeID";
    private final String ADRESSE = "Adresse";
    private final String GROESSE = "Groesse";
    private final String KUNDEID = "KundeID";
    private final String NAME = "Name";
    private final String URL = "jdbc:sqlite:DB/FacilityManagement.db";

    private ObservableList<Kunde> kundenListe; // Liste der Kunden

    public Kunde_Organisator() {
        kundenListe = FXCollections.observableArrayList();
    }

    public ObservableList<Kunde> getKundenListe() {
        return kundenListe;
    }

    /**
     * Fügt einen neuen Kunden zur Liste hinzu, falls der Name noch nicht existiert.
     *
     * @param name Der Name des Kunden.
     * @param gebaeude Der Gebäudeorganisator des Kunden.
     */
    public void add(String name, Gebaeude_Organisator gebaeude, int nummer){
        boolean existiert = false;
        for(Kunde k : kundenListe){
            if(k.getName().equals(name)) existiert = true;
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else kundenListe.add(new Kunde(name, gebaeude, nummer));
    }

    /**
     * Entfernt einen Kunden aus der Liste.
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
        PreparedStatement statement = con.prepareStatement(speichernSQL);
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
        statement.close();
    }
    public void uploadGebaeude(Connection con) throws SQLException {
        String uploadSQL = "SELECT * FROM Gebaeude";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(uploadSQL);

        Gson gson = new Gson();

        while (result.next()){
            int i = result.getInt(KUNDEID);
            for(Kunde k : kundenListe){
                if(k.getNummer() == i){
                    k.getGebaeude().add(result.getInt(GEBAEUDEID), gson.fromJson(result.getString(GROESSE), Groesse.class),
                            gson.fromJson(result.getString(ADRESSE), Adresse.class), new Ausstattung_Organisator());
                }
            }
        }
        statement.close();
    }
    public void speichern(Connection con)throws SQLException{
        String speichernSQL = "INSERT INTO Kunden (" + KUNDEID +", " + NAME +  ") VALUES(?,?)";
        PreparedStatement statement = con.prepareStatement(speichernSQL);
        Gson gson = new Gson();

        for (Kunde k : kundenListe) {
                statement.setInt(1, k.getNummer());
                statement.setString(2, k.getName());
                statement.addBatch();
        }
        int[] results = statement.executeBatch();
        statement.close();
    }
    public void upload(Connection con) throws SQLException {
        String uploadSQL = "SELECT * FROM Kunden";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(uploadSQL);


        while (result.next()){
                 kundenListe.add(new Kunde(result.getString(NAME), new Gebaeude_Organisator(),result.getInt(KUNDEID)));
        }
        statement.close();
    }

}
