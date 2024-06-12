package Ausstattung;

import Attribute.Datum;
import Auftraege.Auftrag;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Brandschutz.*;
import Ausstattung.Moebel.*;

import java.sql.*;
import java.util.ArrayList;
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

    private ArrayList<Ausstattung> austattungList; // Liste der Ausstattungen

    //Standardkonstruktor zum Initialisieren des Ausstattung_Organisators.
    public Ausstattung_Organisator() {
        austattungList = new ArrayList<>();
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
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Feuerloescher(preis,ort,auftraege, nummer));
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
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Rauchmelder(preis,ort,auftraege, nummer));
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
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Sitzmoebel (preis,ort,auftraege, nummer));
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
        boolean existiert = false;
        for(Ausstattung a : austattungList){
            if (a.getNummer() == nummer) {
                existiert = true;
                break;
            }
        } if(existiert) System.out.println("Bitte geben sie eine andere Nummer ein!");
        else austattungList.add(new Tisch(preis,ort,auftraege, nummer));
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

    /**
     * Entfernt eine Ausstattung aus der Liste.
     *
     * @param a Die zu entfernende Ausstattung.
     */
    public void delete(Ausstattung a){
        austattungList.remove(a);
    }

    /**
     * Gibt die Liste der Aufträge einer bestimmten Ausstattung zurück.
     *
     * @param i Der Index der Ausstattung in der Liste.
     * @return Die Liste der Aufträge der angegebenen Ausstattung.
     */
    public ArrayList<Auftrag> getAuftragsListe(int i){
        return austattungList.get(i).getAuftraege().getAuftraege();
    }

    /**
     * Speichert alle Aufträge von allen Ausstattungen in der Datenbank.
     *
     * @throws SQLException Wenn ein SQL-Fehler auftritt.
     */
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

    /**
     * Lädt alle Aufträge aus der Datenbank und fügt sie den entsprechenden Ausstattungen hinzu.
     *
     * @throws SQLException Wenn ein SQL-Fehler auftritt.
     */
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
