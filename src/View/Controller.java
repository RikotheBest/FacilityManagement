package View;


import Ausstattung.*;
import Gebaeude.*;
import Kunden.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    @FXML
    private TreeView<Object> treeView;
    @FXML
    private TableView<Ausstattung> tableAusstattung;
    @FXML
    private TableColumn<Ausstattung,Integer> ausstattungNummer;
    @FXML
    private TableColumn<Ausstattung,String> ausstattungName;
    @FXML
    private TableColumn<Ausstattung,String> ausstattungOrt;
    @FXML
    private TableColumn<Ausstattung,Integer> ausstattungPreis;

    private Kunde_Organisator kunden;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kunden = new Kunde_Organisator();


        try {
            kunden.upload();
            kunden.uploadGebaeude();
            for(Kunde k : kunden.getKundenListe()){
                k.getGebaeude().upload();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TreeItem<Object> root = new TreeItem<>("root");
            treeView.setRoot((root));
            treeView.setShowRoot(false);
            int i = 0;
            for(Kunde k : kunden.getKundenListe()){
                root.getChildren().add(new TreeItem<>(k));
                for (Gebaeude g : kunden.getGebaeudeListe(i)){
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
    }