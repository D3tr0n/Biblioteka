package com.example.biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class aktualizacjaKsiazkiBaza {

    public boolean aktualizujKsiazkeWBazie(Ksiazka ksiazka) throws SQLException {
        Connection conn;
        String sql = """
            UPDATE autorzy
            SET imie_autora = ?, nazwisko_autora = ?
            WHERE id_autora = (
                SELECT id_autora FROM ksiazka WHERE kod_ksiazki = ?
            );

            UPDATE ksiazka
            SET tytul = ?, status = ?, gatunek = ?
            WHERE kod_ksiazki = ?
        """;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, ksiazka.getImieAutora());
            stmt.setString(2, ksiazka.getNazwiskoAutora());

            stmt.setInt(3, ksiazka.getKodKsiazki());

            stmt.setString(4, ksiazka.getTytul());
            stmt.setString(5, ksiazka.getStatus());
            stmt.setString(6, ksiazka.getGatunek());

            stmt.setInt(7, ksiazka.getKodKsiazki());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}