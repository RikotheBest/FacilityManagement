package View;

import Gebaeude.Gebaeude_Organisator;
import Kunden.Kunde;
import Kunden.Kunde_Organisator;
import com.sun.jdi.VoidType;
import com.sun.jdi.VoidValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.w3c.dom.Text;

public class KundeDialog extends Dialog<Void> {
    private TextField nummerField;
    private TextField nameField;
    private TextFormatter<Integer> nummerFormatter;
    public KundeDialog(Kunde_Organisator kunde) {
        super();
        this.setTitle("add Kunde");
        buildUI();
        createResultConverter(kunde);

    }
    public void buildUI(){
        Pane pane = createGridPane();
        this.getDialogPane().setContent(pane);
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
        Button button = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
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
        if ((nameField.getText().isEmpty()) || (nummerField.getText().isEmpty())){
            return false;
        }
        return true;
    }
    public void createResultConverter(Kunde_Organisator kunde){
        Callback<ButtonType,Void> resultConverter = new Callback<ButtonType, Void>() {
            @Override
            public Void call(ButtonType buttonType) {
             if(buttonType == ButtonType.OK){
                 kunde.add(nameField.getText(), new Gebaeude_Organisator(), nummerFormatter.getValue());
             }
             return null;
            }
        };
        setResultConverter(resultConverter);
    }



    public Pane createGridPane(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        nameField = new TextField();
        nummerField = new TextField();

        StringConverter<Integer> toIntConvertor = new IntegerStringConverter();
        nummerFormatter = new TextFormatter<>(toIntConvertor, 0);
        nummerField.setTextFormatter(nummerFormatter);

        grid.add(new Label("Name: "), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label( "Nummer"), 0, 1);
        grid.add(nummerField, 1, 1);

        return grid;
    }
}
