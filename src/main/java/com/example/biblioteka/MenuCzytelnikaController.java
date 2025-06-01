package com.example.biblioteka;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;




public class MenuCzytelnikaController{

    @FXML
    private Label emailCzytelnika;

    private String emailCzytelnika2;

    public void setEmail(String email) {
        this.emailCzytelnika2 = email;
        emailCzytelnika.setText(emailCzytelnika2);
        zaladujWyporzyczenia();
    }


    private void zaladujWyporzyczenia() {
        if (emailCzytelnika.getText() != null && !emailCzytelnika.getText().isEmpty()) {
            WyporzyczeniaDane2 wczytaneDaneWyporzyczenia = new WyporzyczeniaDane2();
            wczytaneDaneWyporzyczenia.wczytajDaneZWyporzyczenDlaEmail(listaWyporzyczen, tabelaWyporzyczen, emailCzytelnika.getText());
        } else {
            System.out.println("E-mail użytkownika jest pusty. Nie można załadować danych.");
        }
    }


    @FXML
    public void initialize() {

        panelWyporzyczen.setVisible(true);

        kolumnaCzytelnikImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        kolumnaCzytelnikNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        kolumnaTytulKsiazki.setCellValueFactory(new PropertyValueFactory<>("tytul"));
        kolumnaDataWyporzyczenia.setCellValueFactory(new PropertyValueFactory<>("dataWypozyczenia"));
        kolumnaDataOddania.setCellValueFactory(new PropertyValueFactory<>("dataOddania"));
        kolumnaStatus2.setCellValueFactory(new PropertyValueFactory<>("status"));
    }



    @FXML private VBox panelWyporzyczen;

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

    private final ObservableList<Wyporzyczenie> listaWyporzyczen = FXCollections.observableArrayList();



}