import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("View/Main.fxml"));
            stage.setTitle("FacilityManagement");
            stage.setScene(new Scene(root, 800, 1000));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}