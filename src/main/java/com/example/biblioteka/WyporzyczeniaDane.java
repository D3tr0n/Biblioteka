package com.example.biblioteka;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;
import java.time.LocalDate;

public class WyporzyczeniaDane {

    public void wczytajDaneZWyporzyczen(ObservableList<Wyporzyczenie> listaWyporzyczen, TableView<Wyporzyczenie> tabelaWyporzyczen, String szukanyCiag) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Biblioteka2.0",
                    "postgres",
                    "kacper13"
            );

            String zapytanie = "SELECT w.id_czytelnika, w.kod_ksiazki, c.imie, c.nazwisko, k.tytul, " +
                               "w.data_wypozyczenia, w.data_oddania, k.status " +
                               "FROM wypozyczenia w " +
                               "JOIN czytelnik c ON w.id_czytelnika = c.id_czytelnika " +
                               "JOIN ksiazka k ON w.kod_ksiazki = k.kod_ksiazki";

            PreparedStatement stmt;

            szukanyCiag = szukanyCiag == null ? "" : szukanyCiag.trim();

            if (!szukanyCiag.isEmpty()) {
                zapytanie += " WHERE LOWER(k.tytul) LIKE LOWER(?) OR LOWER(c.imie) LIKE LOWER(?) OR LOWER(c.nazwisko) LIKE LOWER(?)";
                stmt = conn.prepareStatement(zapytanie);
                stmt.setString(1, "%" + szukanyCiag + "%");
                stmt.setString(2, "%" + szukanyCiag + "%");
                stmt.setString(3, "%" + szukanyCiag + "%");
            } else {
                stmt = conn.prepareStatement(zapytanie);
            }

            ResultSet rs = stmt.executeQuery();

            listaWyporzyczen.clear();

            while (rs.next()) {
                Wyporzyczenie wyporzyczenie = new Wyporzyczenie(
                        rs.getInt("id_czytelnika"),
                        rs.getInt("kod_ksiazki"),
                        rs.getString("imie"),
                        rs.getString("nazwisko"),
                        rs.getString("tytul"),
                        rs.getObject("data_wypozyczenia", LocalDate.class),
                        rs.getObject("data_oddania", LocalDate.class),
                        rs.getString("status")
                );

                listaWyporzyczen.add(wyporzyczenie);
            }

            tabelaWyporzyczen.setItems(listaWyporzyczen);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Błąd podczas pobierania danych z bazy: " + e.getMessage());
        }
    }
}