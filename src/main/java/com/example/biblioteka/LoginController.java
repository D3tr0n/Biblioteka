package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import java.io.IOException;

public class LoginController  extends LoginSprawdzanie{
    @FXML
    protected void onHelloButtonClick() {
        try {
            NoweOkno okno = new NoweOkno();
            okno.otworzOkno("Rejestracja.fxml", "Rejestracja",null);


        } catch (IOException e) {
            System.out.println("Nie mozna otworzyc okna");
        }
    }

   @FXML
   protected javafx.scene.control.TextField LoginEmail;


    @FXML
    protected PasswordField HasloLogin;

    @FXML
    protected javafx.scene.control.Label BladLogowania;






    @FXML
    protected void OnZalogujSie(){

        if (LoginEmail.getText().isEmpty() || HasloLogin.getText().isEmpty()) {
            BladLogowania.setText("Pola login i hasło nie mogą być puste!");
        }
        else {
            LoginSpr(LoginEmail.getText(), HasloLogin.getText());


        }

    }



}