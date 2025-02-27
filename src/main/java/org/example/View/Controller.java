package org.example.View;


import org.example.Auftraege.Auftrag;
import org.example.Ausstattung.*;
import org.example.Gebaeude.*;
import org.example.Kunden.*;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
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
        createGebaudeListener();

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
                    } else if (change.wasRemoved()) {
                        rmKundeFromTree();
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
                        } else if (change.wasRemoved()) {
                            rmGebaeudeFromTree();
                        }
                    }
                }
            });

        }
    }
    public void createGebaudeListener() {
        for (Kunde k : kunden.getKundenListe()) {
            k.getGebaeude().getGebaeudeListe().addListener(new ListChangeListener<Gebaeude>() {
                @Override
                public void onChanged(Change<? extends Gebaeude> change) {
                    while (change.next()) {
                        if (change.wasAdded()) {
                            fillGebaeude(change.getAddedSubList());
                        } else if (change.wasRemoved()) {
                            rmGebaeudeFromTree();
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
    public void rmKundeFromTree(){
        TreeItem<Object> t = treeView.getSelectionModel().getSelectedItem();
        if(t != null) t.getParent().getChildren().remove(t);
    }
    public void rmGebaeudeFromTree(){
        TreeItem<Object> t = treeView.getSelectionModel().getSelectedItem();
        if(t != null) t.getParent().getChildren().remove(t);
    }
    public void selectGebaeude(){
        if(treeView.getSelectionModel().getSelectedItem() != null){
            Object object = treeView.getSelectionModel().getSelectedItem().getValue();
            if(object instanceof Gebaeude){
                Gebaeude g = (Gebaeude) object;
                ausstattungNummer.setCellValueFactory(new PropertyValueFactory<Ausstattung,Integer>("nummer"));
                ausstattungName.setCellValueFactory(new PropertyValueFactory<Ausstattung, String>("name"));
                ausstattungOrt.setCellValueFactory(new PropertyValueFactory<Ausstattung, String>("ort"));
                ausstattungPreis.setCellValueFactory(new PropertyValueFactory<Ausstattung, Integer>("preis"));
                tableAusstattung.setItems(g.getAustattung().getAustattungList());
            }
        }
    }
    public void selectAusstattung(){
        Ausstattung a = tableAusstattung.getSelectionModel().getSelectedItem();
        if(a != null){
            auftragNummer.setCellValueFactory(new PropertyValueFactory<Auftrag, Integer>("nummer"));
            auftragKategorie.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("kategorie"));
            auftragStatus.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("status"));
            auftragGeplant.setCellValueFactory(new PropertyValueFactory<Auftrag, String>("geplant"));
            tableAuftrag.setItems(a.getAuftraege().getAuftraege());
        }
    }

        public void save() throws SQLException {
            Connection con = DriverManager.getConnection(URL);
            con.setAutoCommit(false);
            clearDb(con);
            kunden.speichern(con);
            kunden.speichereGebaeude(con);
            for (Kunde k : kunden.getKundenListe()) {
                k.getGebaeude().speichereAusstattung(con);
                for (Gebaeude g : k.getGebaeude().getGebaeudeListe()) {
                    g.getAustattung().speichereAuftraege(con);
                }
            }
            con.setAutoCommit(true);
            con.close();



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
    public void start() throws SQLException {
        kunden = new Kunde_Organisator();
        upload();
        createTree();
        createKundenListener();
        createGebaudeListener();
    }
    public void clearDb(Connection con) throws SQLException {
        String loeschenSQL1 = "DELETE FROM Ausstattung";
        String loeschenSQL2 = "DELETE FROM Auftrag";
        String loeschenSQL3 = "DELETE FROM Gebaeude";
        String loeschenSQL4 = "DELETE FROM Kunden";

        Statement statement1 = con.createStatement();
        statement1.addBatch(loeschenSQL1);
        statement1.addBatch(loeschenSQL2);
        statement1.addBatch(loeschenSQL3);
        statement1.addBatch(loeschenSQL4);
        int[] results = statement1.executeBatch();
        statement1.close();
    }

    public void addKunde(){
        KundeDialog dialog = new KundeDialog(kunden);
        Optional<Void> result = dialog.showAndWait();
        if(result.isPresent()){
            result.get();
        }
    }
    public void deleteKunde(){
        Object object = treeView.getSelectionModel().getSelectedItem().getValue();
        if(object instanceof Kunde) kunden.delete((Kunde)object);
    }

    public void addGebaeude() throws IOException {
        Object object = treeView.getSelectionModel().getSelectedItem().getValue();
        if(object instanceof Kunde){
            Kunde k = (Kunde)object;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/GebaeudeDialog.fxml"));
            fxmlLoader.load();
            Gebaude_Controller controller = fxmlLoader.getController();
            controller.setResultConverter(k.getGebaeude());
            Optional<Void> result = controller.getDialog().showAndWait();
            if(result.isPresent()) result.get();
        }

    }
    public void deleteGebaeude(){
        Object objectK =  treeView.getSelectionModel().getSelectedItem().getParent().getValue();
        Object objectG =  treeView.getSelectionModel().getSelectedItem().getValue();
        if(objectK instanceof Kunde && objectG instanceof Gebaeude){
            Kunde k = (Kunde)objectK;
            Gebaeude g = (Gebaeude)objectG;
            k.getGebaeude().delete(g);
        }
    }
    public void addAusstattung() throws IOException {
        Object object = treeView.getSelectionModel().getSelectedItem().getValue();
        if(object instanceof Gebaeude){
            Gebaeude g = (Gebaeude)object;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/AusstattungDialog.fxml"));
            fxmlLoader.load();
            Ausstattung_Controller controller = fxmlLoader.getController();
            controller.setResultConverter(g.getAustattung());
            Optional<Void> result = controller.getDialog().showAndWait();
            if(result.isPresent()) result.get();
        }
    }
    public void deleteAusstattung(){
        Ausstattung a = tableAusstattung.getSelectionModel().getSelectedItem();
        if(a != null) tableAusstattung.getItems().remove(a);
    }
    public void addAuftrag() throws IOException {
        Ausstattung a = tableAusstattung.getSelectionModel().getSelectedItem();
        if(a != null){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/AuftragDialog.fxml"));
            fxmlLoader.load();
            Auftrag_Controller controller = fxmlLoader.getController();
            controller.setResultConverter(a.getAuftraege());
            Optional<Void> result = controller.getDialog().showAndWait();
            if(result.isPresent()) result.get();
        }

    }
    public void deleteAuftrag(){
        Auftrag a = tableAuftrag.getSelectionModel().getSelectedItem();
        tableAuftrag.getItems().remove(a);
    }

    }


