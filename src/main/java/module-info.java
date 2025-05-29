module com.example.biblioteka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.biblioteka to javafx.fxml;
    exports com.example.biblioteka;
}