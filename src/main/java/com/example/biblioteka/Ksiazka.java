package com.example.biblioteka;

import javafx.beans.property.SimpleStringProperty;

public class Ksiazka {
    private final SimpleStringProperty tytul;
    private final SimpleStringProperty status;
    private final SimpleStringProperty gatunek;
    private final SimpleStringProperty imieAutora;
    private final SimpleStringProperty nazwiskoAutora;

    public Ksiazka(String tytul, String status, String gatunek, String imieAutora, String nazwiskoAutora) {
        this.tytul = new SimpleStringProperty(tytul);
        this.status = new SimpleStringProperty(status);
        this.gatunek = new SimpleStringProperty(gatunek);
        this.imieAutora = new SimpleStringProperty(imieAutora);
        this.nazwiskoAutora = new SimpleStringProperty(nazwiskoAutora);
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
}
