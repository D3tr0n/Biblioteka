package com.example.biblioteka;


import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;

public class ZczytanieCzytelnikow {


    public void wczytajDaneZCzytelnicy(ObservableList listaCzytelnikow, TableView tabelaCzytelnikow) {

        try{
            Class.forName("org.postgresql.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");

            String zapytanie = "SELECT imie, nazwisko, email FROM czytelnik";

             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(zapytanie);

            while (rs.next()) {
                listaCzytelnikow.add(new Czytelnik(
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("email")
                ));
            }

            tabelaCzytelnikow.setItems(listaCzytelnikow);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
