package sample.Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.BazaPodataka;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.sql.Connection;

public class DodajKorisnikController implements Initializable{

//Elementi FXML datoteke -----------------------------------------------------------------------------------------------
    @FXML
    private TextField dodajEmailField;

    @FXML
    private TextField dodajLozinkaField;

    @FXML
    private ComboBox<String> dodajUlogaBox;

    @FXML
    private Label dodajLabel;

    @FXML
    private Button dodajKorisnikButton;
//----------------------------------------------------------------------------------------------------------------------

    private Connection connection;
    private BazaPodataka bazaPodataka;

    public static String IDKorisnika;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Elementi i prompt text za 'dropdown menu' Uloga
        dodajUlogaBox.getItems().add("Korisnik");
        dodajUlogaBox.getItems().add("Administrator");
        dodajUlogaBox.setPromptText("Uloga");
    }

//Metode za kontroliranje akcija tipki ---------------------------------------------------------------------------------
    public void dodajKorisnikButtonOnAction(ActionEvent event){
        bazaPodataka = new BazaPodataka();
        if(dodajEmailField.getText().isBlank() == false && dodajLozinkaField.getText().isBlank() == false
                && (dodajUlogaBox.getValue() == null) == false) {
            dodajKorisnika();
        }else{
            dodajLabel.setText("Molimo popunite sva polja!");
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    //Metoda za dodavanje korisnika u tablicu korisnika
    private void dodajKorisnika(){
        try{
            //Upit bazi podataka za dodavanje korisnika sa unesenim korisnickim imenom, lozinkom, i ulogom
            String dodajKorisnik = "INSERT INTO korisnik(KorisnickoIme, Lozinka, Uloga) " +
                    "VALUES('"+ dodajEmailField.getText() +"', '" + dodajLozinkaField.getText() + "', '" + dodajUlogaBox.getValue()+"')";

            String provjeraKorisnika = "SELECT * FROM korisnik WHERE KorisnickoIme = '"+ dodajEmailField.getText() + "'";


            //Izvrsavanje upita
            connection = bazaPodataka.getConnection();
            try {
                ResultSet set1 = connection.createStatement().executeQuery(provjeraKorisnika);
                if (set1.next()) {
                    dodajLabel.setText("Korisničko ime već postoji!");
                } else {
                    int set = connection.createStatement().executeUpdate(dodajKorisnik);
                    set1 = connection.createStatement().executeQuery(provjeraKorisnika);
                    while (set1.next()) {
                        IDKorisnika = set1.getString("ID");
                    }
                    String dodavanjePodataka = "INSERT INTO podaci(Ime, Prezime, Adresa, BrojTelefona, IDKorisnika) " +
                            "VALUES('', '', '', '', '" + IDKorisnika + "')";
                    set = connection.createStatement().executeUpdate(dodavanjePodataka);
                    Stage stageDodajKorisnik = (Stage) dodajKorisnikButton.getScene().getWindow();
                    stageDodajKorisnik.close();
                }
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
