module com.example.biblioteka {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.biblioteka to javafx.fxml;
    exports com.example.biblioteka;
}