package com.example.biblioteka;

import javafx.beans.property.SimpleStringProperty;

public class Ksiazka {
    private final int kodKsiazki;
    private final SimpleStringProperty tytul;
    private final SimpleStringProperty status;
    private final SimpleStringProperty gatunek;
    private final SimpleStringProperty imieAutora;
    private final SimpleStringProperty nazwiskoAutora;

    public Ksiazka(int kodKsiazki, String tytul, String status, String gatunek, String imieAutora, String nazwiskoAutora) {
        this.kodKsiazki = kodKsiazki;
        this.tytul = new SimpleStringProperty(tytul);
        this.status = new SimpleStringProperty(status);
        this.gatunek = new SimpleStringProperty(gatunek);
        this.imieAutora = new SimpleStringProperty(imieAutora);
        this.nazwiskoAutora = new SimpleStringProperty(nazwiskoAutora);
    }

    public int getKodKsiazki() {
        return kodKsiazki;
    }

    public String getTytul() {
        return tytul.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getGatunek() {
        return gatunek.get();
    }

    public String getImieAutora() {
        return imieAutora.get();
    }

    public String getNazwiskoAutora() {
        return nazwiskoAutora.get();
    }

    public void setTytul(String tytul) {
        this.tytul.set(tytul);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public void setGatunek(String gatunek) {
        this.gatunek.set(gatunek);
    }

    public void setImieAutora(String imieAutora) {
        this.imieAutora.set(imieAutora);
    }

    public void setNazwiskoAutora(String nazwiskoAutora) {
        this.nazwiskoAutora.set(nazwiskoAutora);
    }


}
