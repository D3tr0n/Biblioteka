package com.example.biblioteka;

import javafx.beans.property.SimpleStringProperty;

public class Czytelnik {
    private final SimpleStringProperty imie;
    private final SimpleStringProperty nazwisko;
    private final SimpleStringProperty email;

    public Czytelnik(String imie, String nazwisko, String email) {
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.email = new SimpleStringProperty(email);
    }

    public String getImie() { return imie.get(); }
    public String getNazwisko() { return nazwisko.get(); }
    public String getEmail() { return email.get(); }
}