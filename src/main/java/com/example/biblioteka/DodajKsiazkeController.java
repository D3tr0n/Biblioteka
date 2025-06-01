package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DodajKsiazkeController {

    @FXML
    private TextField DodajTytul;

    @FXML
    private ChoiceBox<String> DodajStatus;

    @FXML
    private TextField DodajGatunek;

    @FXML
    private TextField DodajImieAutora;

    @FXML
    private TextField DodajNazwiskoAutora;

    @FXML
    public void initialize() {
        DodajStatus.getItems().addAll("Dostępna", "Wypożyczona");
        DodajStatus.setValue("Dostępna");
    }

    @FXML
    private void onDodajKsiazke() {
        try {
            int kodKsiazki = -1;
            String tytul = DodajTytul.getText().trim();
            String status = DodajStatus.getValue();
            String gatunek = DodajGatunek.getText().trim();
            String imie = DodajImieAutora.getText().trim();
            String nazwisko = DodajNazwiskoAutora.getText().trim();

            Ksiazka ksiazka = new Ksiazka(kodKsiazki, tytul, status, gatunek, imie, nazwisko);


            new KsiazkaDodaj().dodajKsiazke(ksiazka);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dodano książkę!!!");
            alert.setHeaderText("Dodałeś nową książkę!");
            alert.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
