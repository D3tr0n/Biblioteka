package com.example.biblioteka;

import java.sql.*;

public class AutorBaza {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
    }

    public int znajdzLubDodajAutora(Autor autor) throws SQLException {
        try (Connection conn = getConnection()) {
            String sqlSelect = "SELECT id_autora FROM autorzy WHERE LOWER(imie_autora) = LOWER(?) AND LOWER(nazwisko_autora) = LOWER(?)";
            try (PreparedStatement selectStmt = conn.prepareStatement(sqlSelect)) {
                selectStmt.setString(1, autor.getImieAutora());
                selectStmt.setString(2, autor.getNazwiskoAutora());

                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_autora");
                }
            }

            String sqlInsert = "INSERT INTO autorzy (imie_autora, nazwisko_autora) VALUES (?, ?) RETURNING id_autora";
            try (PreparedStatement insertStmt = conn.prepareStatement(sqlInsert)) {
                insertStmt.setString(1, autor.getImieAutora());
                insertStmt.setString(2, autor.getNazwiskoAutora());

                ResultSet rs = insertStmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_autora");
                }
            }
        }
        throw new RuntimeException("błąd");
    }
}
