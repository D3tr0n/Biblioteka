package com.example.biblioteka;

import java.sql.*;
import java.time.LocalDate;

public class zmienStatus {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
    }

public void zmienStatusKsiazkiIOddaWypozyczenie(int idCzytelnika, int kodKsiazki, LocalDate dataWypozyczenia, String nowyStatus) throws SQLException {
    try (Connection conn = getConnection()) {
        conn.setAutoCommit(false);

        try {

            String sqlKsiazka = "UPDATE ksiazka SET status = ? WHERE kod_ksiazki = ?";
            try (PreparedStatement stmtKsiazka = conn.prepareStatement(sqlKsiazka)) {
                stmtKsiazka.setString(1, nowyStatus);
                stmtKsiazka.setInt(2, kodKsiazki);
                stmtKsiazka.executeUpdate();
            }


            String sqlWypozyczenia = "UPDATE wypozyczenia " +
                                     "SET data_oddania = ? " +
                                     "WHERE id_czytelnika = ? AND kod_ksiazki = ? AND data_wypozyczenia = ? AND data_oddania IS NULL";
            try (PreparedStatement stmtWypozyczenia = conn.prepareStatement(sqlWypozyczenia)) {
                stmtWypozyczenia.setDate(1, Date.valueOf(LocalDate.now()));
                stmtWypozyczenia.setInt(2, idCzytelnika);
                stmtWypozyczenia.setInt(3, kodKsiazki);
                stmtWypozyczenia.setDate(4, Date.valueOf(dataWypozyczenia));
                int rowsUpdated = stmtWypozyczenia.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Data oddania zaktualizowana dla wypożyczenia (czytelnik: " + idCzytelnika + ", książka: " + kodKsiazki + ").");
                } else {
                    System.out.println("Nie znaleziono odpowiedniego wypożyczenia do zaktualizowania.");
                }
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw new SQLException("Błąd podczas zmiany statusu i aktualizacji wypożyczenia: " + e.getMessage(), e);
        }
    }
}
}