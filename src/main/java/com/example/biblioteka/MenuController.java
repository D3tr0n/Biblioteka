package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;




public class MenuController extends ZczytanieCzytelnikow {
    @FXML
    private TableView<Czytelnik> tabelaCzytelnikow;

    @FXML
    private TableColumn<Czytelnik, String> kolumnaImie;

    @FXML
    private TableColumn<Czytelnik, String> kolumnaNazwisko;

    @FXML
    private TableColumn<Czytelnik, String> kolumnaEmail;

    private final ObservableList<Czytelnik> listaCzytelnikow = FXCollections.observableArrayList();


    @FXML
    private void wyszukajCzytelnika() {
        kolumnaImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        kolumnaNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        kolumnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        wczytajDaneZCzytelnicy(listaCzytelnikow, tabelaCzytelnikow);
    }





}