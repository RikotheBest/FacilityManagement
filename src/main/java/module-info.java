module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;
    requires com.google.gson;

    opens org.example to javafx.fxml;
    opens org.example.View to javafx.fxml;
    opens org.example.Attribute to com.google.gson;
    exports org.example.Attribute to com.google.gson;
    exports org.example.View to javafx.fxml;
    exports org.example;

}
