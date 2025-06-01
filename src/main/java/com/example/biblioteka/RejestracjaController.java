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
    private Label BladDanych;

    @FXML
    protected void onRejestruj() {
        if(Email.getText().isEmpty() || Haslo.getText().isEmpty() || Imie.getText().isEmpty() || Nazwisko.getText().isEmpty() || !Email.getText().contains("@")){
            BladDanych.setText("Uzupełnij wszystkie dane prawidłowo!");
        }
        else if(Haslo.getText().length() < 8 || Haslo.getText().length() > 30){
            BladDanych.setText("Hasło musi składać się conajmniej 8 znków i nieprzekraczać 30");
        }
        else {
            BladDanych.setText("");
            Rejestracja(Imie.getText(), Nazwisko.getText(), Haslo.getText(), Email.getText());

        }

    }
}
