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


    public Wyporzyczenie(int idCzytelnika, int kodKsiazki, String imie,
                         String nazwisko, String tytul, LocalDate dataWypozyczenia,
                         LocalDate dataOddania, String status) {

        this.idCzytelnika = idCzytelnika;
        this.kodKsiazki = kodKsiazki;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.tytul = tytul;
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataOddania = dataOddania;
        this.status = status;
    }


    public String getImie() {
        return imie;
    }

    public int getkodKsiazki() {
        return kodKsiazki;
    }




    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public LocalDate getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(LocalDate dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public LocalDate getDataOddania() {
        return dataOddania;
    }

    public void setDataOddania(LocalDate dataOddania) {
        this.dataOddania = dataOddania;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}