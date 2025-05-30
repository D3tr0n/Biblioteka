package com.example.biblioteka;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class BazaDanychConn {
    public static void main(String[] args) {


        Connection conn;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteka2.0", "postgres", "kacper13");
            if (conn != null) {
                System.out.println("Połączono");

                String imie = "Jan";
                String nazwisko = "Kowalski";
                String email = "jan.kowalski2@example.com";
                String haslo = "TymczasoweHaslo2";

                String sql = "INSERT INTO czytelnik (imie, nazwisko, email, haslo) VALUES (?, ?, ?,?)";

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, imie);
                pstmt.setString(2, nazwisko);
                pstmt.setString(3, email);
                pstmt.setString(4, haslo);

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Dodano nowego czytelnika!");
                }

                pstmt.close();
                conn.close();




            } else {
                System.out.println("Nie połączono");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
