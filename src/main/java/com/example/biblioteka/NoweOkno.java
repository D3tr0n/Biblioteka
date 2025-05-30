package com.example.biblioteka;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NoweOkno {
    public void otworzOkno(String fxml, String nazwa) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(nazwa);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
