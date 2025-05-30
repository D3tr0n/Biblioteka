package com.example.biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.stage.Stage;


public class LoginSprawdzanie{

    @FXML
    protected Label BladLogowania;


    public void LoginSpr(String email, String haslo){


        Connection conn;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
            if (conn != null) {
                System.out.println("Połączono");

                String zapytanie = "Select * FROM czytelnik WHERE email = ? AND haslo = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(zapytanie);


                preparedStatement.setString(1, email);
                preparedStatement.setString(2, haslo);

                ResultSet resultSet = preparedStatement.executeQuery();


                if (resultSet.next()) {
                    System.out.println("Logowanie udane!");

                    NoweOkno okno = new NoweOkno();
                    okno.otworzOkno("Rejestracja.fxml", "Menu");
                    BladLogowania.getScene().getWindow().hide();



                } else {
                    System.out.println("Błąd logowania! Niepoprawny email lub hasło.");
                    BladLogowania.setText("Błąd");

                }


                preparedStatement.close();
                conn.close();




            } else {
                System.out.println("Nie połączono");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



}
