package com.example.biblioteka;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;

public class ZczytanieCzytelnikow {

    public void wczytajDaneZCzytelnicy(ObservableList<Czytelnik> listaCzytelnikow, TableView<Czytelnik> tabelaCzytelnikow, String szukanyCiag) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Biblioteka2.0",
                    "postgres",
                    "kacper13"
            );


            String zapytanie = "SELECT id_czytelnika, imie, nazwisko, email FROM czytelnik";
            PreparedStatement stmt;

            szukanyCiag = szukanyCiag == null ? "" : szukanyCiag.trim();

            if (!szukanyCiag.isEmpty()) {
                String[] slowa = szukanyCiag.split("\\s+", 2);

                if (slowa.length == 2) {

                    zapytanie += " WHERE LOWER(imie) LIKE LOWER(?) AND LOWER(nazwisko) LIKE LOWER(?)";
                    stmt = conn.prepareStatement(zapytanie);
                    stmt.setString(1, "%" + slowa[0] + "%");
                    stmt.setString(2, "%" + slowa[0] + "%");

                } else {

                    zapytanie += " WHERE LOWER(imie) LIKE LOWER(?) OR LOWER(nazwisko) LIKE LOWER(?)";
                    stmt = conn.prepareStatement(zapytanie);
                    stmt.setString(1, "%" + slowa[0] + "%");
                    stmt.setString(2, "%" + slowa[0] + "%");
                }
            } else {
                stmt = conn.prepareStatement(zapytanie);
            }

            ResultSet rs = stmt.executeQuery();
            listaCzytelnikow.clear();


            while (rs.next()) {
                Czytelnik czytelnik = new Czytelnik(
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("email")
                );
                czytelnik.setIdCzytelnika(rs.getInt("id_czytelnika"));

                listaCzytelnikow.add(czytelnik);
            }

            tabelaCzytelnikow.setItems(listaCzytelnikow);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}