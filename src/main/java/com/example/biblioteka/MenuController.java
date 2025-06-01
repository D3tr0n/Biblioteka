package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


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
        panelWyporzyczen.setVisible(false);
        panelKsiazek.setVisible(false);
    }

    @FXML
    private void pokazKsiazki() {
        panelCzytelnikow.setVisible(false);
        panelWyporzyczen.setVisible(false);
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
    private TableView<Ksiazka> tabelaKsiazek;

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
            System.out.println("Czytelnik został usunięty.");
        } else {
            System.out.println("Nie udało się usunąć czytelnika.");
        }
    } else {
        System.out.println("Nie wybrano żadnego czytelnika.");
    }
}

@FXML
public void initialize() {
    try {
        WyporzyczeniaDodanie wyporzyczeniaDodanie = new WyporzyczeniaDodanie();
        wyporzyczeniaDodanie.usunWypozyczeniaDlaStatusDostepna();
        System.out.println("Automatyczne usuwanie zakończonych wypożyczeń zakończone sukcesem.");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Nie udało się automatycznie usunąć zakończonych wypożyczeń: " + e.getMessage());
    }
    zaladujWyporzyczenia();

    tabelaKsiazek.setEditable(true);

    kolumnaTytul.setCellFactory(TextFieldTableCell.forTableColumn());
    kolumnaStatus.setCellFactory(TextFieldTableCell.forTableColumn());
    kolumnaImieAutora.setCellFactory(TextFieldTableCell.forTableColumn());
    kolumnaNazwaAutora.setCellFactory(TextFieldTableCell.forTableColumn());
    kolumnaGatunek.setCellFactory(TextFieldTableCell.forTableColumn());

    kolumnaTytul.setCellValueFactory(new PropertyValueFactory<>("tytul"));
    kolumnaImieAutora.setCellValueFactory(new PropertyValueFactory<>("imieAutora"));
    kolumnaNazwaAutora.setCellValueFactory(new PropertyValueFactory<>("nazwiskoAutora"));
    kolumnaGatunek.setCellValueFactory(new PropertyValueFactory<>("Gatunek"));
    kolumnaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

    ZczytanieKsiazek zczytanieKsiazek = new ZczytanieKsiazek();
    zczytanieKsiazek.wczytajDaneZKsiazki(listaKsiazek, tabelaKsiazek, "");

    EdycjaDanych edycja = new EdycjaDanych();
    edycja.ustawEdycjeKsiazek(kolumnaTytul, kolumnaStatus, kolumnaImieAutora, kolumnaNazwaAutora, kolumnaGatunek);
}



    @FXML
    public void onDodajKsiazke() {
        try {
            FXMLLoader fxmlLoader3 = new FXMLLoader(Login.class.getResource("MenuDodajKsiazke.fxml"));
            Scene scene3 = new Scene(fxmlLoader3.load(), 1000, 400);
            Stage stage3 = new Stage();
            stage3.setTitle("Menu");
            stage3.setScene(scene3);
            stage3.show();
        } catch (IOException e) {
            System.out.println("Nie mozna otworzyc okna");
        }

    }


    @FXML private VBox panelWyporzyczen;

    @FXML
    private TextField wyszukiwarkaWyporzyczen;

    @FXML
    private TableView<Wyporzyczenie> tabelaWyporzyczen;

    @FXML
    private TableColumn<Wyporzyczenie, String> kolumnaCzytelnikImie;

    @FXML
    private TableColumn<Wyporzyczenie, String> kolumnaCzytelnikNazwisko;

    @FXML
    private TableColumn<Wyporzyczenie, String> kolumnaTytulKsiazki;

    @FXML
    private TableColumn<Wyporzyczenie, String> kolumnaDataWyporzyczenia;

    @FXML
    private TableColumn<Wyporzyczenie, String> kolumnaDataOddania;

    @FXML
    private TableColumn<Wyporzyczenie, String> kolumnaStatus2;

    @FXML
    private TableColumn<Wyporzyczenie, String> kolumnaEamilWypo;

    private final ObservableList<Wyporzyczenie> listaWyporzyczen = FXCollections.observableArrayList();


    @FXML
    private void pokazWyporzyczenia() {
        panelWyporzyczen.setVisible(true);
        panelKsiazek.setVisible(false);
        panelCzytelnikow.setVisible(false);

        zaladujWyporzyczenia();
    }

    private void zaladujWyporzyczenia() {
        WyporzyczeniaDane wczytaneDaneWyporzyczenia = new WyporzyczeniaDane();
        listaWyporzyczen.clear();
        wczytaneDaneWyporzyczenia.wczytajDaneZWyporzyczen(listaWyporzyczen, tabelaWyporzyczen,wyszukiwarkaWyporzyczen.getText() );
        tabelaWyporzyczen.refresh();

    }

    @FXML
    private void WyszukajWyporzyczenia() {
    kolumnaCzytelnikImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
    kolumnaCzytelnikNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
    kolumnaTytulKsiazki.setCellValueFactory(new PropertyValueFactory<>("tytul"));
    kolumnaDataWyporzyczenia.setCellValueFactory(new PropertyValueFactory<>("dataWypozyczenia"));
    kolumnaDataOddania.setCellValueFactory(new PropertyValueFactory<>("dataOddania"));
    kolumnaStatus2.setCellValueFactory(new PropertyValueFactory<>("status"));
    kolumnaEamilWypo.setCellValueFactory(new PropertyValueFactory<>("email"));

    WyporzyczeniaDane wczytaneDaneWyporzyczenia = new WyporzyczeniaDane();
    wczytaneDaneWyporzyczenia.wczytajDaneZWyporzyczen(listaWyporzyczen, tabelaWyporzyczen, wyszukiwarkaWyporzyczen.getText());

    zaladujWyporzyczenia();
    tabelaWyporzyczen.refresh();
}

@FXML
private void zmienStatusWyporzyczenia() {
    Wyporzyczenie wybraneWypozyczenie = tabelaWyporzyczen.getSelectionModel().getSelectedItem();

    if (wybraneWypozyczenie == null) {
        System.out.println("Nie wybrano żadnego wypożyczenia.");
        return;
    }

    int idCzytelnika = wybraneWypozyczenie.getIdCzytelnika();
    int kodKsiazki = wybraneWypozyczenie.getKodKsiazki();
    LocalDate dataWypozyczenia = wybraneWypozyczenie.getDataWypozyczenia();

    String obecnyStatus = wybraneWypozyczenie.getStatus();
    String nowyStatus = obecnyStatus.equals("Wypożyczona") ? "Dostępna" : "Wypożyczona";

    try {
        zmienStatus zmienStatus = new zmienStatus();
        zmienStatus.zmienStatusKsiazkiIOddaWypozyczenie(idCzytelnika, kodKsiazki, dataWypozyczenia, nowyStatus);

        wybraneWypozyczenie.setStatus(nowyStatus);
        tabelaWyporzyczen.refresh();

        System.out.println("Status wypożyczenia został zaktualizowany!");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Błąd podczas aktualizacji statusu wypożyczenia!");
    }
}

@FXML
private TextField EmailWypozycz;

@FXML
private void onWyporzyczKsiazke() {
    Ksiazka wybranaKsiazka = tabelaKsiazek.getSelectionModel().getSelectedItem();
    String email = EmailWypozycz.getText().trim();


    if (wybranaKsiazka == null) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Nie wybrano książki!!!");
        alert.setHeaderText("Nie wybrano książki!!!");
        alert.showAndWait();

        return;
    }

    if (email.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText("Pole e-mail nie może być puste!!!");
        alert.showAndWait();
        return;
    }

    if (!"Dostępna".equals(wybranaKsiazka.getStatus())) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText("Wybrana książka jest już wypożyczona.");
        alert.showAndWait();

        return;
    }

    try {
        WyporzyczeniaDodanie wyporzyczeniaDodanie = new WyporzyczeniaDodanie();
        wyporzyczeniaDodanie.wypozyczKsiazke(email, wybranaKsiazka);

        wybranaKsiazka.setStatus("Wypożyczona");
        tabelaKsiazek.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operacja pomyślna!");
        alert.setHeaderText("Książka została wyporzyczona!");
        alert.showAndWait();

    } catch (SQLException e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("Podano złe email lub książka już raz została wyporzyczona");
        alert.showAndWait();
    }
}
}