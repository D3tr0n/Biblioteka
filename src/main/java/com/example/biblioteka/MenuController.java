package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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




}