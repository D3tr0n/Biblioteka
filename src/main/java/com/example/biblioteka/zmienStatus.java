package com.example.biblioteka;

import java.sql.*;
import java.time.LocalDate;

public class zmienStatus {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
    }

    public void zmienStatusKsiazkiIOddaWypozyczenie(int kodKsiazki, String nowyStatus) throws SQLException {
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            try {
                String sqlKsiazka = "UPDATE ksiazka SET status = ? WHERE kod_ksiazki = ?";
                try (PreparedStatement stmtKsiazka = conn.prepareStatement(sqlKsiazka)) {
                    stmtKsiazka.setString(1, nowyStatus);
                    stmtKsiazka.setInt(2, kodKsiazki);
                    stmtKsiazka.executeUpdate();
                }

                String sqlWypozyczenia = "UPDATE wypozyczenia SET data_oddania = ? WHERE kod_ksiazki = ? AND data_oddania IS NULL";
                try (PreparedStatement stmtWypozyczenia = conn.prepareStatement(sqlWypozyczenia)) {
                    stmtWypozyczenia.setDate(1, Date.valueOf(LocalDate.now()));
                    stmtWypozyczenia.setInt(2, kodKsiazki);
                    int rowsUpdated = stmtWypozyczenia.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Data oddania zaktualizowana na dzisiejszą dla książki o kodzie: " + kodKsiazki);
                    } else {
                        System.out.println("Nie znaleziono aktywnego wypożyczenia dla książki o kodzie: " + kodKsiazki);
                    }
                }


                conn.commit();
            } catch (SQLException e) {

                conn.rollback();
                throw new SQLException("Błąd podczas zmiany statusu i aktualizacji daty oddania: " + e.getMessage(), e);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}