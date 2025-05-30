package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends NoweOkno{
    @FXML
    protected void onHelloButtonClick() {
        try {
            otworzOkno("Rejestracja.fxml", "Rejestracja");


        } catch (IOException e) {
            System.out.println("Nie mozna otworzyc okna");
        }
    }
}