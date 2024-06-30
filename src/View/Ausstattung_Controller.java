package View;

import Auftraege.Auftrag_Organisator;
import Ausstattung.Ausstattung_Organisator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;
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
        if((nummerFormatter.getValue() == 0) || (preisFormatter.getValue() == 0) || (choiceBox.getValue() == null) || (ortField.getText() == null)){
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
