package com.example.biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class aktualizacjaKsiazkiBaza {

    public boolean aktualizujKsiazkeWBazie(Ksiazka ksiazka) throws SQLException {
        Connection conn;
        String sql = """
    UPDATE ksiazka
    SET tytul = ?, status = ?, gatunek = ?
    WHERE kod_ksiazki = ?
    """;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ksiazka.getTytul());
            stmt.setString(2, ksiazka.getStatus());
            stmt.setString(3, ksiazka.getGatunek());
            stmt.setInt(4, ksiazka.getKodKsiazki());
            stmt.executeUpdate();

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
