package com.example.biblioteka;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;

public class ZczytanieKsiazek {

    public void wczytajDaneZKsiazki(ObservableList<Ksiazka> listaKsiazek, TableView<Ksiazka> tabelaKsiazek, String szukanyCiag) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Biblioteka2.0",
                    "postgres",
                    "kacper13"
            );

            String zapytanie = "SELECT k.tytul, k.status, k.gatunek, a.imie_autora, a.nazwisko_autora " +
                    "FROM ksiazka k " +
                    "JOIN autorzy a ON k.id_autora = a.id_autora";

            PreparedStatement stmt;
            szukanyCiag = szukanyCiag == null ? "" : szukanyCiag.trim();

            if (!szukanyCiag.isEmpty()) {
                zapytanie += " WHERE LOWER(k.tytul) LIKE LOWER(?) " +
                        "OR LOWER(a.imie_autora) LIKE LOWER(?) " +
                        "OR LOWER(a.nazwisko_autora) LIKE LOWER(?)";

                stmt = conn.prepareStatement(zapytanie);

                String pattern = "%" + szukanyCiag + "%";

                stmt.setString(1, pattern);
                stmt.setString(2, pattern);
                stmt.setString(3, pattern);

            } else {
                stmt = conn.prepareStatement(zapytanie);
            }

            ResultSet rs = stmt.executeQuery();

            listaKsiazek.clear();

            while (rs.next()) {
                listaKsiazek.add(new Ksiazka(
                        rs.getString("tytul"),
                        rs.getString("status"),
                        rs.getString("gatunek"),
                        rs.getString("imie_autora"),
                        rs.getString("nazwisko_autora")
                ));
            }

            tabelaKsiazek.setItems(listaKsiazek);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
