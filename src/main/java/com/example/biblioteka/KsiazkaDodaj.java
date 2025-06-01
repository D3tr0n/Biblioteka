package com.example.biblioteka;

import java.sql.*;

public class KsiazkaDodaj {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
    }

    public void dodajKsiazke(Ksiazka ksiazka) throws SQLException {
        AutorBaza autorBaza = new AutorBaza();
        int idAutora = autorBaza.znajdzLubDodajAutora(new Autor(ksiazka.getImieAutora(), ksiazka.getNazwiskoAutora()));

        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO ksiazka (tytul, status, gatunek, id_autora) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, ksiazka.getTytul());
                stmt.setString(2, ksiazka.getStatus());
                stmt.setString(3, ksiazka.getGatunek());
                stmt.setInt(4, idAutora);

                stmt.executeUpdate();
            }
        }
    }
}
