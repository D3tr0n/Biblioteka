package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;

public class RejestracjaController extends PobieranieRejestracja{
    @FXML
    private Label welcomeText;

    @FXML
    private TextField Imie;

    @FXML
    private TextField Nazwisko;

    @FXML
    private TextField Email;

    @FXML
    private PasswordField Haslo;

    @FXML
    protected void onRejestruj() {
       Rejestracja(Imie.getText(), Nazwisko.getText(),Haslo.getText(), Email.getText());

    }
}
