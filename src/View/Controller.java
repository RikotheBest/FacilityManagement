package View;


import Auftraege.Auftrag;
import Ausstattung.*;
import Gebaeude.*;
import Kunden.*;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



public class Controller implements Initializable {
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
    private KundeDialog kundeDialog;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kunden = new Kunde_Organisator();
        createKundenListener();
        createTree();



        try {
          upload();
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
    public void createTree(){
        root = new TreeItem<>("root");
        treeView.setRoot((root));
        treeView.setShowRoot(false);
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
        int i = 0;
        for(Kunde k : kunden.getKundenListe()){
            for (Gebaeude g : list){
                root.getChildren().get(i).getChildren().add(new TreeItem<>(g));
            }
            i++;
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
    public void save() throws SQLException {
        kunden.speichern();
        kunden.speichereGebaeude();
        for(Kunde k : kunden.getKundenListe()){
            k.getGebaeude().speichereAusstattung();
            for (Gebaeude g : k.getGebaeude().getGebaeudeListe()) {
                g.getAustattung().speichereAuftraege();
            }
        }
    }
    public void upload() throws SQLException{
        kunden.upload();
        kunden.uploadGebaeude();
        for(Kunde k : kunden.getKundenListe()){
            k.getGebaeude().upload();
            for(Gebaeude g : k.getGebaeude().getGebaeudeListe()){
                g.getAustattung().upload();
            }
        }
    }
    public void addKunde(){
        KundeDialog dialog = new KundeDialog(kunden);
        Optional<Void> result = dialog.showAndWait();
        if(result.isPresent()){
            result.get();
        }



    }

}
