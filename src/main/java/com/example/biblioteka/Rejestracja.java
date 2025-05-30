package com.example.biblioteka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Rejestracja extends Application {
    @Override
    public void start(Stage stage) throws IOException{
            FXMLLoader fxmlLoader2 = new FXMLLoader(Rejestracja.class.getResource("Rejestracja.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
            stage.setTitle("Rejestracja");
            stage.setScene(scene2);
            stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}