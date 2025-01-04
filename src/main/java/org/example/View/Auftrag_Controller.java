package org.example.View;

import org.example.Attribute.Datum;
import org.example.Auftraege.Auftrag_Organisator;
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

public class Auftrag_Controller implements Initializable {
    @FXML
    DialogPane dialogPane;
    @FXML
    TextField nummerTextField;
    @FXML
    ChoiceBox<String> kategorieChoiceBox;
    @FXML
    ChoiceBox<String> statusChoiceBox;
    @FXML
    DatePicker datePicker;
    Dialog<Void> dialog;
    TextFormatter<Integer> formatter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);
        dialog.setTitle("add Auftrag");
        setChoiceBox();
        setFormatter();
        setButtonFilter();
    }
    public void setChoiceBox(){
        kategorieChoiceBox.getItems().setAll("Wartung", "Reparatur","Inspektion");
        statusChoiceBox.getItems().setAll("Erledigt", "in Bearbeitung");
    }
    public void setFormatter(){
        StringConverter<Integer> converter = new IntegerStringConverter();
        formatter = new TextFormatter<>(converter, 0);
        nummerTextField.setTextFormatter(formatter);
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
        boolean nummerLeer = formatter.getValue() == 0;
        boolean kategorieLeer = kategorieChoiceBox.getValue() == null;
        boolean statusLeer = statusChoiceBox.getValue() == null;
        boolean datumLeer = datePicker.getValue() == null;
        boolean nummerNegative = (formatter.getValue() < 0);
        
        if (nummerNegative) {
        	AlertFenster.showAlert("Fehlerhafte Eingabe", "Die Nummer darf nicht negativ sein.");
        }
        if (nummerLeer && kategorieLeer && statusLeer && datumLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte füllen Sie alle Felder aus.");
            return false;
        }
        if (nummerLeer && kategorieLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer und eine Kategorie ein.");
            return false;
        }
        if (nummerLeer && statusLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer und einen Status ein.");
            return false;
        }
        if (nummerLeer && datumLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer und ein Datum ein.");
            return false;
        }
        if (kategorieLeer && statusLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Kategorie und einen Status ein.");
            return false;
        }
        if (kategorieLeer && datumLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Kategorie und ein Datum ein.");
            return false;
        }
        if (statusLeer && datumLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie einen Status und ein Datum ein.");
            return false;
        }
        if (nummerLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte geben Sie eine Nummer ein.");
            return false;
        }
        if (kategorieLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte wählen Sie eine Kategorie aus.");
            return false;
        }
        if (statusLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte wählen Sie einen Status aus.");
            return false;
        }
        if (datumLeer) {
            AlertFenster.showAlert("Fehlerhafte Eingabe", "Bitte wählen Sie ein Datum aus.");
            return false;
        }

        return true;
    }
    public void setResultConverter(Auftrag_Organisator a){
        Callback<ButtonType, Void> converter = new Callback<ButtonType, Void>() {
            @Override
            public Void call(ButtonType buttonType) {
                if(buttonType == ButtonType.OK){
                    a.add(new Datum(datePicker.getValue().toString()), formatter.getValue(), kategorieChoiceBox.getValue(), statusChoiceBox.getValue());
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