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


    private void zaladujWyporzyczenia() {
        WyporzyczeniaDane wczytaneDaneWyporzyczenia = new WyporzyczeniaDane();
        wczytaneDaneWyporzyczenia.wczytajDaneZWyporzyczen(listaWyporzyczen, tabelaWyporzyczen,"");
    }

    @FXML
    public void initialize() {

        panelWyporzyczen.setVisible(true);

        zaladujWyporzyczenia();

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

    @FXML
    private Label emailCzytelnika;

    private String emailCzytelnika2;

    public void setEmail(String email) {
        this.emailCzytelnika2 = email;
        System.out.println("Email w MenuCzytelnikaController: " + emailCzytelnika2);

        emailCzytelnika.setText(emailCzytelnika2);
    }




}