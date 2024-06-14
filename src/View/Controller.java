package View;


import Attribute.Adresse;
import Attribute.Groesse;
import Ausstattung.Ausstattung_Organisator;
import Gebaeude.Gebaeude;
import Kunden.Kunde;
import Kunden.Kunde_Organisator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

import Gebaeude.*;

public class Controller implements Initializable {
    @FXML
    private TreeView<String> treeView;
    public Kunde_Organisator kunden;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kunden = new Kunde_Organisator();
        kunden.add("HWR",new Gebaeude_Organisator(), 12);
        kunden.getKundenListe().get(0).getGebaeude().add(12,new Groesse(12,12,12), new Adresse("asdasd", 12,"asd"), new Ausstattung_Organisator());

            TreeItem<String> root = new TreeItem<>("root");
            treeView.setRoot(root);
            treeView.setShowRoot(false);
            int i = 0;
            for(Kunde k : kunden.getKundenListe()){
                root.getChildren().add(new TreeItem<>(k.getName()));
                for (Gebaeude g : kunden.getGebaeudeListe(i)){
                    root.getChildren().get(i).getChildren().add(new TreeItem<>(g.getNummer() + ""));
                }
                i++;
            }

        }
    }
