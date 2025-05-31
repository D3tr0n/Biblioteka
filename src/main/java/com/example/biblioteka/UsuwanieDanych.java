package com.example.biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuwanieDanych {

    boolean usunKsiazkeZBazy(Ksiazka ksiazka) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13")) {

            String sql = "DELETE FROM ksiazka WHERE tytul = ? AND id_autora = (SELECT id_autora FROM autorzy WHERE imie_autora = ? AND nazwisko_autora = ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ksiazka.getTytul());
            stmt.setString(2, ksiazka.getImieAutora());
            stmt.setString(3, ksiazka.getNazwiskoAutora());

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usunCzytelnikaZBazy(Czytelnik czytelnik) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13")) {

            String sql = "DELETE FROM czytelnik WHERE email = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, czytelnik.getEmail());

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
