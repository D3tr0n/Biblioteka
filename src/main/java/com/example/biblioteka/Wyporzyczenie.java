package com.example.biblioteka;

import java.time.LocalDate;

public class Wyporzyczenie {
    private int idCzytelnika;
    private int kodKsiazki;
    private String imie;
    private String nazwisko;
    private String tytul;
    private LocalDate dataWypozyczenia;
    private LocalDate dataOddania;
    private String status;
    private String email;

    public Wyporzyczenie(int idCzytelnika, int kodKsiazki, String imie, String nazwisko, String tytul,
                         LocalDate dataWypozyczenia, LocalDate dataOddania, String status, String email) {
        this.idCzytelnika = idCzytelnika;
        this.kodKsiazki = kodKsiazki;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.tytul = tytul;
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataOddania = dataOddania;
        this.status = status;
        this.email = email;
    }


    public int getIdCzytelnika() {
        return idCzytelnika;
    }

    public int getKodKsiazki() {
        return kodKsiazki;
    }

    public LocalDate getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getEmail() {
        return email;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getTytul() {
        return tytul;
    }

    public LocalDate getDataOddania() {
        return dataOddania;
    }

    public void setDataOddania(LocalDate dataOddania) {
        this.dataOddania = dataOddania;
    }


}