package View;


import Attribute.Groesse;
import Auftraege.Auftrag;
import Auftraege.Auftrag_Organisator;
import Ausstattung.*;
import Gebaeude.*;
import Kunden.*;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    private final String URL = "jdbc:sqlite:DB/FacilityManagement.db";

    @FXML
    private TreeView<Object> treeView;
    private TreeItem<Object> root;

    @FXML
    private TableView<Ausstattung> tableAusstattung;
    @FXML
    private TableView<Auftrag> tableAuftrag;
    @FXML
    private TableColumn<Ausstattung,Integer> ausstattungNummer, ausstattungPreis;
    @FXML
    private TableColumn<Ausstattung,String> ausstattungName, ausstattungOrt;
    @FXML
    private TableColumn<Auftrag, Integer> auftragNummer;
    @FXML
    private TableColumn<Auftrag, String> auftragKategorie, auftragStatus, auftragGeplant;

    private Kunde_Organisator kunden;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kunden = new Kunde_Organisator();
        try {
          upload();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTree();
        createKundenListener();

    }


    public void createTree(){
        root = new TreeItem<>("root");
        treeView.setRoot((root));
        treeView.setShowRoot(false);
        int i = 0;
        for(Kunde k : kunden.getKundenListe()) {
            root.getChildren().add(new TreeItem<>(k));
            for (Gebaeude g : k.getGebaeude().getGebaeudeListe()){
                root.getChildren().get(i).getChildren().add(new TreeItem<>(g));
            }
            i++;
        }
    }
    public void createKundenListener(){
        kunden.getKundenListe().addListener(new ListChangeListener<Kunde>() {
            @Override
            public void onChanged(Change<? extends Kunde> change) {
                while(change.next()){
                    if(change.wasAdded()){
                        fillKunde(change.getAddedSubList());
                       createGebaudeListener(change.getAddedSubList());
                    }
                }
            }

        });

    }
    public void createGebaudeListener(List<? extends Kunde> list) {
        for (Kunde k : list) {
            k.getGebaeude().getGebaeudeListe().addListener(new ListChangeListener<Gebaeude>() {
                @Override
                public void onChanged(Change<? extends Gebaeude> change) {
                    while (change.next()) {
                        if (change.wasAdded()) {
                            fillGebaeude(change.getAddedSubList());

                        }
                    }
                }
            });

        }
    }
    public void fillKunde(List<? extends Kunde> list){
        for(Kunde k : list){
            root.getChildren().add(new TreeItem<>(k));
        }
    }
    public void fillGebaeude(List<? extends Gebaeude> list){
        TreeItem<Object> treeItem = treeView.getSelectionModel().getSelectedItem();
            for (Gebaeude g : list){
                treeItem.getChildren().add(new TreeItem<>(g));
        }

    }
    public void selectGebaeude(){
            Gebaeude g = (Gebaeude)treeView.getSelectionModel().getSelectedItem().getValue();
            ausstattungNummer.setCellValueFactory(new PropertyValueFactory<Ausstattung,Integer>("nummer"));
            ausstattungName.setCellValueFactory(new PropertyValueFactory<Ausstattung, String>("name"));
            ausstattungOrt.setCellValueFactory(new PropertyValueFactory<Ausstattung, String>("ort"));
            ausstattungPreis.setCellValueFactory(new PropertyValueFactory<Ausstattung, Integer>("preis"));
            tableAusstattung.setItems(g.getAustattung().getAustattungList());
    }
    public void selectAusstattung(){
        Ausstattung a = tableAusstattung.getSelectionModel().getSelectedItem();
        auftragNummer.setCellValueFactory(new PropertyValueFactory<Auftrag, Integer>("nummer"));
        auftragKategorie.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("kategorie"));
        auftragStatus.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("status"));
        auftragGeplant.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("geplant"));
        tableAuftrag.setItems(a.getAuftraege().getAuftraege());
    }

        public void save () {
        try{
            Connection con = DriverManager.getConnection(URL);
            clearDb(con);
            kunden.speichern(con);
            kunden.speichereGebaeude(con);
            for (Kunde k : kunden.getKundenListe()) {
                k.getGebaeude().speichereAusstattung(con);
                for (Gebaeude g : k.getGebaeude().getGebaeudeListe()) {
                    g.getAustattung().speichereAuftraege(con);
                }
            }
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void addAusstattung(){
        kunden.getGebaeudeListe(0).get(0).getAustattung().addTisch(12,"flur", new Auftrag_Organisator(), 101);
        kunden.getGebaeudeListe(0).get(0).getAustattung().addTisch(12,"flur", new Auftrag_Organisator(), 102);
        kunden.getGebaeudeListe(0).get(0).getAustattung().addTisch(12,"flur", new Auftrag_Organisator(), 103);

        kunden.getGebaeudeListe(1).get(0).getAustattung().addTisch(12,"flur", new Auftrag_Organisator(), 201);
        kunden.getGebaeudeListe(1).get(0).getAustattung().addTisch(12,"flur", new Auftrag_Organisator(), 202);
    }


    public void upload() throws SQLException{
        Connection con = DriverManager.getConnection(URL);
        kunden.upload(con);
        kunden.uploadGebaeude(con);
        for(Kunde k : kunden.getKundenListe()){
            k.getGebaeude().upload(con);
            for(Gebaeude g : k.getGebaeude().getGebaeudeListe()){
                g.getAustattung().upload(con);
            }
        }
        con.close();
    }
    public void clearDb(Connection con) throws SQLException {
        String loeschenSQL1 = "DELETE FROM Ausstattung";
        String loeschenSQL2 = "DELETE FROM Auftrag";
        String loeschenSQL3 = "DELETE FROM Gebaeude";
        String loeschenSQL4 = "DELETE FROM Kunden";

        Statement statement1 = con.createStatement();
        statement1.executeUpdate(loeschenSQL1);
        statement1.close();

        Statement statement2 = con.createStatement();
        statement2.executeUpdate(loeschenSQL2);
        statement2.close();

        Statement statement3 = con.createStatement();
        statement3.executeUpdate(loeschenSQL3);
        statement3.close();

        Statement statement4 = con.createStatement();
        statement4.executeUpdate(loeschenSQL4);
        statement4.close();
    }

    public void addKunde(){
        KundeDialog dialog = new KundeDialog(kunden);
        Optional<Void> result = dialog.showAndWait();
        if(result.isPresent()){
            result.get();
        }
    }

    }


