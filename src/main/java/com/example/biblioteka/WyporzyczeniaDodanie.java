package com.example.biblioteka;

import java.sql.*;
import java.time.LocalDate;

public class WyporzyczeniaDodanie {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
    }

public void wypozyczKsiazke(String email, Ksiazka ksiazka) throws SQLException {
    try (Connection conn = getConnection()) {
        conn.setAutoCommit(false);

        try {
            String queryCzytelnik = "SELECT id_czytelnika FROM czytelnik WHERE email = ?";
            int idCzytelnika;
            try (PreparedStatement stmtCzytelnik = conn.prepareStatement(queryCzytelnik)) {
                stmtCzytelnik.setString(1, email);
                ResultSet result = stmtCzytelnik.executeQuery();
                if (result.next()) {
                    idCzytelnika = result.getInt("id_czytelnika");
                } else {
                    throw new SQLException("Czytelnik o podanym e-mailu nie istnieje.");
                }
            }

            String insertWypozyczenie = """
                INSERT INTO wypozyczenia (id_czytelnika, kod_ksiazki, data_wypozyczenia)
                VALUES (?, ?, ?)
            """;
            try (PreparedStatement stmtWypozyczenie = conn.prepareStatement(insertWypozyczenie)) {
                stmtWypozyczenie.setInt(1, idCzytelnika);
                stmtWypozyczenie.setInt(2, ksiazka.getKodKsiazki());
                stmtWypozyczenie.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                stmtWypozyczenie.executeUpdate();
            }

            String updateKsiazkaStatus = "UPDATE ksiazka SET status = ? WHERE kod_ksiazki = ?";
            try (PreparedStatement stmtStatus = conn.prepareStatement(updateKsiazkaStatus)) {
                stmtStatus.setString(1, "Wypożyczona");
                stmtStatus.setInt(2, ksiazka.getKodKsiazki());
                stmtStatus.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }
}
}