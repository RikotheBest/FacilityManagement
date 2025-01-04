package org.example.View;

import org.example.Ausstattung.Ausstattung_Organisator;
import org.example.Gebaeude.Gebaeude_Organisator;
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

public class Gebaude_Controller implements Initializable {
    @FXML
    private DialogPane dialogPane;
    @FXML
    private TextField nummerTF;
    private Dialog<Void> dialog;
    private TextFormatter<Integer> formatter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);
        dialog.setTitle("add org.example.Gebaeude");
        setFormatter();
        setButtonFilter();
    }

    public void setFormatter(){
        StringConverter<Integer> toIntConvertor = new IntegerStringConverter();
        formatter = new TextFormatter<>(toIntConvertor, 0);
        nummerTF.setTextFormatter(formatter);
    }
    public void setButtonFilter(){
        Button button = (Button) dialogPane.lookupButton(ButtonType.OK);
        button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!validateDialog()){
                    actionEvent.consume();
                }
            }
        });
    }

    private boolean validateDialog() {
        if (formatter.getValue() <= 0) {
         	AlertFenster.showAlert("Fehlerhafte Eingabe", "Die Nummer muss groeßer als 0 sein.");
    	  }
        return true;
    }
    public void setResultConverter(Gebaeude_Organisator g){
        Callback<ButtonType, Void> converter = new Callback<ButtonType, Void>() {
            @Override
            public Void call(ButtonType buttonType) {
                if(buttonType == ButtonType.OK){
                    g.add(formatter.getValue(), null, null, new Ausstattung_Organisator());
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
