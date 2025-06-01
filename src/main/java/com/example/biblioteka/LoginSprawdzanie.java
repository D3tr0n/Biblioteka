package com.example.biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
                    if ( resultSet.getString("email").equals("admin@") && resultSet.getString("haslo").equals("admin123")){
                        System.out.println("Logowanie udane!");
                        FXMLLoader fxmlLoader2 = new FXMLLoader(Login.class.getResource("Menu.fxml"));
                        Scene scene2 = new Scene(fxmlLoader2.load(), 1200, 400);
                        Stage stage = new Stage();
                        stage.setTitle("Menu");
                        stage.setScene(scene2);
                        stage.show();
                        BladLogowania.getScene().getWindow().hide();
                    }
                    else {
                        System.out.println("Logowanie udane!");
                        String emailBazy = resultSet.getString("email");
                        NoweOkno okno = new NoweOkno();
                        okno.otworzOkno("MenuCzytelnika.fxml", "Menu", emailBazy);
                        BladLogowania.getScene().getWindow().hide();
                    }



                } else {
                    BladLogowania.setText("Błędne dane!!!");

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
