package org.example.Gebaeude;

import org.example.Attribute.Adresse;
import org.example.Attribute.Groesse;
import org.example.Auftraege.Auftrag_Organisator;
import org.example.Ausstattung.Ausstattung;
import org.example.Ausstattung.Ausstattung_Organisator;
import org.example.View.AlertFenster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Die Klasse Gebaeude_Organisator verwaltet eine Liste von Gebäuden
 * und bietet Methoden zum Hinzufügen, Löschen, Speichern und Hochladen
 * von Gebäuden und deren org.example.Ausstattung.
 */
public class Gebaeude_Organisator {
    private ObservableList<Gebaeude> gebaeudeListe; // Liste der Gebäude
    private final String AUSSTATTUNGID = "AusstattungID";
    private final String GEBAEUDEID = "GebaeudeID";
    private final String ORT = "Ort";
    private final String PREIS = "Preis";
    private final String NAME = "Name";


    public Gebaeude_Organisator() {
        gebaeudeListe = FXCollections.observableArrayList();
    }

    public ObservableList<Gebaeude> getGebaeudeListe() {
        return gebaeudeListe;
    }

    /**
     * Fügt ein neues Gebäude zur Liste hinzu, falls die Nummer noch nicht existiert.
     *
     * @param nummer Die Nummer des Gebäudes.
     * @param groesse Die Größe des Gebäudes.
     * @param adresse Die Adresse des Gebäudes.
     * @param ausstattung Der Ausstattung_Organisator, der die zugehörige org.example.Ausstattung verwaltet.
     */

    public void add(int nummer, Groesse groesse, Adresse adresse, Ausstattung_Organisator ausstattung){
    	boolean nummerExistiert = false;
        for(Gebaeude a : gebaeudeListe){
        	if (a.getNummer() == nummer) {
                nummerExistiert = true;
            }
        }
        	if (nummerExistiert) {
                AlertFenster.showAlert("Nummer bereits vergeben", "Bitte geben Sie eine andere Nummer ein!");
        }else gebaeudeListe.add(new Gebaeude(nummer, groesse, adresse, ausstattung));
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
    public ObservableList<Ausstattung> getAusstattungsListe(int i){
        return gebaeudeListe.get(i).getAustattung().getAustattungList();
    }

    /**
     * Speichert alle Ausstattungen von allen Gebäuden in der Datenbank.
     *
     * @throws SQLException Wenn ein SQL-Fehler auftritt.
     */
    public void speichereAusstattung(Connection con)throws SQLException {
        String speichernSQL = "INSERT INTO Ausstattung (" + AUSSTATTUNGID +", " + GEBAEUDEID + ", " + ORT +  ", " + PREIS + ", " + NAME + ") VALUES(?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(speichernSQL);
            int i = 0;

            for (Gebaeude g : getGebaeudeListe()) {
                for (Ausstattung a : getAusstattungsListe(i)) {
                    statement.setInt(1, a.getNummer());
                    statement.setInt(2, getGebaeudeListe().get(i).getNummer());
                    statement.setString(3, a.getOrt());
                    statement.setInt(4, a.getPreis());
                    statement.setString(5, a.getName());
                    statement.addBatch();
                }
                i++;
            }
            int[] results = statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Lädt alle Ausstattungen aus der Datenbank und fügt sie den entsprechenden Gebäuden hinzu.
     *
     * @throws SQLException Wenn ein SQL-Fehler auftritt.
     */
    public void upload(Connection con) throws SQLException {
        String uploadSQL = "SELECT * FROM Ausstattung";
        Statement statement = null;
        ResultSet result = null;

        try {
            statement = con.createStatement();
            result = statement.executeQuery(uploadSQL);

            while (result.next()) {
                int i = result.getInt(GEBAEUDEID);
                String n = result.getString(NAME);
                for (Gebaeude g : gebaeudeListe) {
                    if (g.getNummer() == i) {
                        switch (n) {
                            case "Rauchmelder":
                                g.getAustattung().addRauchmelder(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                                break;
                            case "Feuerloescher":
                                g.getAustattung().addFeuerloescher(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                                break;
                            case "Tisch":
                                g.getAustattung().addTisch(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                                break;
                            case "Sitzmoebel":
                                g.getAustattung().addSitzmoebel(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                                break;
                            case "Schrank":
                                g.getAustattung().addSchrank(result.getInt(PREIS), result.getString(ORT), new Auftrag_Organisator(), result.getInt(AUSSTATTUNGID));
                                break;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String toString(){
        for (Gebaeude g:
             gebaeudeListe) {
            g.toString();
        } return "";
    }
}
