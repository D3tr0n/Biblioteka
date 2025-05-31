package com.example.biblioteka;

import javafx.scene.control.TableColumn;
import java.sql.SQLException;

public class EdycjaDanych{


    public void ustawEdycjeKsiazek(TableColumn<Ksiazka, String> kolumnaTytul,TableColumn<Ksiazka, String> kolumnaStatus,TableColumn<Ksiazka, String> kolumnaImieAutora,TableColumn<Ksiazka, String> kolumnaNazwaAutora,TableColumn<Ksiazka, String> kolumnaGatunek) {
        aktualizacjaKsiazkiBaza aktualizacja = new aktualizacjaKsiazkiBaza();

        kolumnaTytul.setOnEditCommit(event -> {
            Ksiazka ksiazka = event.getRowValue();
            ksiazka.setTytul(event.getNewValue());
            try {
                aktualizacja.aktualizujKsiazkeWBazie(ksiazka);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        kolumnaStatus.setOnEditCommit(event -> {
            Ksiazka ksiazka = event.getRowValue();
            ksiazka.setStatus(event.getNewValue());
            try {
                aktualizacja.aktualizujKsiazkeWBazie(ksiazka);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        kolumnaImieAutora.setOnEditCommit(event -> {
            Ksiazka ksiazka = event.getRowValue();
            ksiazka.setImieAutora(event.getNewValue());
            try {
                aktualizacja.aktualizujKsiazkeWBazie(ksiazka);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        kolumnaNazwaAutora.setOnEditCommit(event -> {
            Ksiazka ksiazka = event.getRowValue();
            ksiazka.setNazwiskoAutora(event.getNewValue());
            try {
                aktualizacja.aktualizujKsiazkeWBazie(ksiazka);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        kolumnaGatunek.setOnEditCommit(event -> {
            Ksiazka ksiazka = event.getRowValue();
            ksiazka.setGatunek(event.getNewValue());
            try {
                aktualizacja.aktualizujKsiazkeWBazie(ksiazka);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
