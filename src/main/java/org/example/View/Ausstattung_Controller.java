package org.example.View;

import org.example.Auftraege.Auftrag_Organisator;
import org.example.Ausstattung.Ausstattung_Organisator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Ausstattung_Controller implements Initializable {
    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    DialogPane dialogPane;
    @FXML
    TextField ortField;
    @FXML
    TextField preisField;
    @FXML
    TextField nummerField;
    TextFormatter<Integer> nummerFormatter;
    TextFormatter<Integer> preisFormatter;

    private Dialog<Void> dialog;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);
        dialog.setTitle("add Ausstattung");
        setChoiceBox();
        setFormatter();
        setButtonFilter();
    }

    public void setChoiceBox() {
        choiceBox.getItems().addAll("Rauchmelder", "Feuerloescher", "Schrank", "Tisch", "Sitzmoebel");
    }
    public void setFormatter(){
        StringConverter<Integer> converter = new IntegerStringConverter();
        nummerFormatter = new TextFormatter<>(converter, 0);
        preisFormatter = new TextFormatter<>(converter, 0);
        nummerField.setTextFormatter(nummerFormatter);
        preisField.setTextFormatter(preisFormatter);
    }
    public void setButtonFilter(){
        Button button = (Button)dialogPane.lookupButton(ButtonType.OK);
        button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!validateDialog()) actionEvent.consume();
            }

        });
    }
    private boolean validateDialog() {
        boolean nummerLeer = (nummerFormatter.getValue() == 0);
        boolean preisLeer = (preisFormatter.getValue() == 0);
        boolean choiceLeer = (choiceBox.getValue() == null);
        boolean ortLeer = (ortField.getText() == null || ortField.getText().isEmpty());
        boolean nummerNegative = (nummerFormatter.getValue() < 0);
        boolean preisNegative = (preisFormatter.getValue() < 0);
        
        if (nummerNegative) {
        	AlertFenster.showAlert("Fehlerhafte Eingabe", "Die Nummer darf nicht negativ sein.");
        }
        if (preisNegative) {
        	AlertFenster.showAlert("Fehlerhafte Eingabe", "Der Preis darf nicht negativ sein.");
        }
        if ((nummerLeer && preisLeer && choiceLeer && ortLeer)||(nummerLeer && preisLeer && choiceLeer)||(preisLeer && choiceLeer && ortLeer)||(nummerLeer&& choiceLeer && ortLeer)||(nummerLeer && preisLeer && ortLeer)) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte füllen Sie alle Felder aus.");
            return false;
        }
        if (nummerLeer && choiceLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer und einen Namen ein.");
            return false;
        }
        if (nummerLeer && preisLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer und einen Preis ein.");
            return false;
        }
        if (nummerLeer && ortLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer und einen Ort ein.");
            return false;
        }
        if (preisLeer && ortLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie einen Preis und einen Ort ein.");
            return false;
        }
        if (preisLeer && choiceLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie einen Preis und einen Namen ein.");
            return false;
        }
        if (ortLeer && choiceLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie einen Preis und einen Namen ein.");
            return false;
        }
        if (nummerLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer ein.");
            return false;
        }
        if (preisLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie einen Preis ein.");
            return false;
        }
        if (choiceLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte wählen Sie eine Kategorie aus.");
            return false;
        }
        if (ortLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie einen Ort ein.");
            return false;
        }

        return true;
    }
    public void checkForChoice(Ausstattung_Organisator a){
        String Choice = choiceBox.getValue();
        switch (Choice){
            case "Rauchmelder": a.addRauchmelder(preisFormatter.getValue(), ortField.getText(), new Auftrag_Organisator(), nummerFormatter.getValue());
            break;
            case "Feuerloescher": a.addFeuerloescher(preisFormatter.getValue(), ortField.getText(), new Auftrag_Organisator(), nummerFormatter.getValue());
            break;
            case "Tisch": a.addTisch(preisFormatter.getValue(), ortField.getText(), new Auftrag_Organisator(), nummerFormatter.getValue());
            break;
            case "Schrank": a.addSchrank(preisFormatter.getValue(), ortField.getText(), new Auftrag_Organisator(), nummerFormatter.getValue());
            break;
            case "Sitzmoebel": a.addSitzmoebel(preisFormatter.getValue(), ortField.getText(), new Auftrag_Organisator(), nummerFormatter.getValue());
            break;
        }
    }
    public void setResultConverter(Ausstattung_Organisator a){
        Callback<ButtonType, Void> converter = new Callback<ButtonType, Void>() {
            @Override
            public Void call(ButtonType buttonType) {
                if(buttonType == ButtonType.OK){
                    checkForChoice(a);
                }
                return null;
            }
        };
        dialog.setResultConverter(converter);
    }

    public Dialog<Void> getDialog() {
        return dialog;
    }


}
