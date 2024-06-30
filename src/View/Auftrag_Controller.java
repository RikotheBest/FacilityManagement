package View;

import Attribute.Datum;
import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung_Organisator;
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
                if(!validateDialog()){
                    actionEvent.consume();
                }
            }

            private boolean validateDialog() {
                if((formatter.getValue() == null) || (kategorieChoiceBox.getValue() == null) || (statusChoiceBox.getValue() == null) || (datePicker.getValue() == null)){
                    return false;
                }
                return true;
            }
        });
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
