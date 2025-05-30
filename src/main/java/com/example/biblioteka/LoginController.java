package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;


import java.awt.*;
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

   @FXML
   protected javafx.scene.control.TextField EmailLogin;

    @FXML
    protected PasswordField HasloLogin;




    @FXML
    protected void OnZalogujSie(){
        if (EmailLogin.getText().isEmpty() || HasloLogin.getText().isEmpty()) {
            System.out.println("Pola login i hasło nie mogą być puste!");
        }
        else {
            LoginSprawdzanie.LoginSpr(EmailLogin.getText(), HasloLogin.getText());
        }




    }



}