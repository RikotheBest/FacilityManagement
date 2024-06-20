package View;

import Kunden.Kunde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.w3c.dom.Text;

public class KundeDialog extends Dialog<Kunde> {
    private TextField nummerField;
    private TextField nameField;
    public KundeDialog() {
        super();
        this.setTitle("add Kunde");
        buildUI();
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


        this.show();

    }

    private boolean validateDialog() {
        if ((nameField.getText().isEmpty()) || (nummerField.getText().isEmpty())){
            return false;
        }
        return true;
    }

    public Pane createGridPane(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        nameField = new TextField();
        nummerField = new TextField();

        grid.add(new Label("Name: "), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label( "Nummer"), 0, 1);
        grid.add(nummerField, 1, 1);

        return grid;
    }
}
