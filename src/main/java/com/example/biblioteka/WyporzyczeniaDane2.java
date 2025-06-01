package com.example.biblioteka;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;
import java.time.LocalDate;

public class WyporzyczeniaDane2 {

    public void wczytajDaneZWyporzyczenDlaEmail(ObservableList<Wyporzyczenie> listaWyporzyczen, 
                                                TableView<Wyporzyczenie> tabelaWyporzyczen, 
                                                String emailCzytelnika) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Biblioteka2.0",
                    "postgres",
                    "kacper13"
            );

            String zapytanie = "SELECT w.id_czytelnika, w.kod_ksiazki, c.imie, c.nazwisko, c.email, k.tytul, " +
                               "w.data_wypozyczenia, w.data_oddania, k.status " +
                               "FROM wypozyczenia w " +
                               "JOIN czytelnik c ON w.id_czytelnika = c.id_czytelnika " +
                               "JOIN ksiazka k ON w.kod_ksiazki = k.kod_ksiazki " +
                               "WHERE LOWER(c.email) = LOWER(?)";

            PreparedStatement stmt = conn.prepareStatement(zapytanie);
            stmt.setString(1, emailCzytelnika);

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
                        rs.getString("status"),
                        rs.getString("email")
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