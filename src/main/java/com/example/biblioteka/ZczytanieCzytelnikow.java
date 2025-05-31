package com.example.biblioteka;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;

public class ZczytanieCzytelnikow {

    public void wczytajDaneZCzytelnicy(ObservableList listaCzytelnikow, TableView tabelaCzytelnikow, String szukanyCiag) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Biblioteka2.0",
                    "postgres",
                    "kacper13"
            );

            String zapytanie = "SELECT imie, nazwisko, email FROM czytelnik";
            PreparedStatement stmt;

            szukanyCiag = szukanyCiag == null ? "" : szukanyCiag.trim();

            if (!szukanyCiag.isEmpty()) {
                String[] slowa = szukanyCiag.split("\\s+", 2); // podziel na maks 2 słowa

                if (slowa.length == 2) {
                    // Imię i nazwisko podane
                    zapytanie += " WHERE LOWER(imie) LIKE LOWER(?) AND LOWER(nazwisko) LIKE LOWER(?)";
                    stmt = conn.prepareStatement(zapytanie);
                    stmt.setString(1, "%" + slowa[0] + "%");
                    stmt.setString(2, "%" + slowa[1] + "%");

                } else {
                    // Tylko jedno słowo – szukaj jako imię LUB nazwisko
                    zapytanie += " WHERE LOWER(imie) LIKE LOWER(?) OR LOWER(nazwisko) LIKE LOWER(?)";
                    stmt = conn.prepareStatement(zapytanie);
                    stmt.setString(1, "%" + slowa[0] + "%");
                    stmt.setString(2, "%" + slowa[0] + "%");
                }
            } else {
                // Brak filtru – pokaż wszystko
                stmt = conn.prepareStatement(zapytanie);
            }

            ResultSet rs = stmt.executeQuery();
            listaCzytelnikow.clear();

            while (rs.next()) {
                listaCzytelnikow.add(new Czytelnik(
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("email")
                ));
            }

            tabelaCzytelnikow.setItems(listaCzytelnikow);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
