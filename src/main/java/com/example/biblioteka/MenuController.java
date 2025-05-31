package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;




public class MenuController extends ZczytanieCzytelnikow {
    @FXML
    private TableView<Czytelnik> tabelaCzytelnikow;

    @FXML
    private TextField szukanyCiag;

    @FXML
    private TableColumn<Czytelnik, String> kolumnaImie;

    @FXML
    private TableColumn<Czytelnik, String> kolumnaNazwisko;

    @FXML
    private TableColumn<Czytelnik, String> kolumnaEmail;

    private final ObservableList<Czytelnik> listaCzytelnikow = FXCollections.observableArrayList();

    @FXML
    private VBox panelCzytelnikow;

    @FXML
    private VBox panelKsiazek;

    @FXML
    private void pokazCzytelnikow() {
        panelCzytelnikow.setVisible(true);
        panelKsiazek.setVisible(false);
    }

    @FXML
    private void pokazKsiazki() {
        panelCzytelnikow.setVisible(false);
        panelKsiazek.setVisible(true);
    }


    @FXML
    private void wyszukajCzytelnika() {
        kolumnaImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        kolumnaNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        kolumnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        wczytajDaneZCzytelnicy(listaCzytelnikow, tabelaCzytelnikow,szukanyCiag.getText() );
    }

    @FXML
    protected TextField wyszukiwarkaKsiazek;

    @FXML
    protected TableView<Ksiazka> tabelaKsiazek;

    @FXML
    protected TableColumn<Ksiazka, String> kolumnaTytul;

    @FXML
    protected TableColumn<Ksiazka, String> kolumnaStatus;

    @FXML
    protected TableColumn<Ksiazka, String> kolumnaNazwaAutora;

    @FXML
    protected TableColumn<Ksiazka, String> kolumnaGatunek;


    @FXML
    protected TableColumn<Ksiazka, String> kolumnaImieAutora;

    private final ObservableList<Ksiazka> listaKsiazek = FXCollections.observableArrayList();





    @FXML
    private void wyszukajKsiazki(){
        kolumnaTytul.setCellValueFactory(new PropertyValueFactory<>("tytul"));
        kolumnaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        kolumnaImieAutora.setCellValueFactory(new PropertyValueFactory<>("imieAutora"));
        kolumnaNazwaAutora.setCellValueFactory(new PropertyValueFactory<>("nazwiskoAutora"));
        kolumnaGatunek.setCellValueFactory(new PropertyValueFactory<>("gatunek"));

        ZczytanieKsiazek zczytanieKsiazek = new ZczytanieKsiazek();
        zczytanieKsiazek.wczytajDaneZKsiazki(listaKsiazek, tabelaKsiazek,wyszukiwarkaKsiazek.getText() );
    }


    @FXML
    private void onUsunKsiazke() {
        UsuwanieDanych usuwanieDanych = new UsuwanieDanych();
        Ksiazka wybranaKsiazka = tabelaKsiazek.getSelectionModel().getSelectedItem();
        if (wybranaKsiazka != null) {
            if (usuwanieDanych.usunKsiazkeZBazy(wybranaKsiazka)) {
                tabelaKsiazek.getItems().remove(wybranaKsiazka);
            }
        }
    }

    @FXML
    private void onUsunCzytelnika() {
        UsuwanieDanych usuwanieDanych = new UsuwanieDanych();
        Czytelnik wybranyCzytelnik = tabelaCzytelnikow.getSelectionModel().getSelectedItem();
        if (wybranyCzytelnik != null) {
            if (usuwanieDanych.usunCzytelnikaZBazy(wybranyCzytelnik)) {
                tabelaCzytelnikow.getItems().remove(wybranyCzytelnik);
            }
        }
    }

    @FXML
    public void initialize() {
        tabelaKsiazek.setEditable(true);

        kolumnaTytul.setCellFactory(TextFieldTableCell.forTableColumn());
        kolumnaStatus.setCellFactory(TextFieldTableCell.forTableColumn());
        kolumnaImieAutora.setCellFactory(TextFieldTableCell.forTableColumn());
        kolumnaNazwaAutora.setCellFactory(TextFieldTableCell.forTableColumn());
        kolumnaGatunek.setCellFactory(TextFieldTableCell.forTableColumn());



        EdycjaDanych edycja = new EdycjaDanych();
        edycja.ustawEdycjeKsiazek(kolumnaTytul, kolumnaStatus, kolumnaImieAutora, kolumnaNazwaAutora, kolumnaGatunek);
    }



}