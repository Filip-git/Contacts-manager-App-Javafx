package sample.Controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;


public class FavoritKontaktController {

//Elementi FXML datoteke -----------------------------------------------------------------------------------------------
    @FXML
    private Button odustaniButton;

    @FXML
    private Button dodajFavoritButton;
//----------------------------------------------------------------------------------------------------------------------

    private Connection connection;
    private sample.BazaPodataka bazaPodataka;

    ImenikController podaciImenik = new ImenikController();

//Metode za kontroliranje akcija tipki ---------------------------------------------------------------------------------
    public void dodajFavoritButtonOnAction(ActionEvent event){
        bazaPodataka = new sample.BazaPodataka();
        dodajFavorita();

        Stage stageBlokirajKontakt = (Stage) dodajFavoritButton.getScene().getWindow();
        stageBlokirajKontakt.close();
    }

    public void odustaniButtonOnAction(ActionEvent event){
        Stage stageBlokirajKontakt = (Stage) odustaniButton.getScene().getWindow();
        stageBlokirajKontakt.close();
    }
//----------------------------------------------------------------------------------------------------------------------

    private void dodajFavorita(){
        try{
            //Upit bazi podataka za ubacivanje kontakta u tablicu favorita
            String query1 = "INSERT INTO favoriti(Ime, Prezime, BrojTelefona, IDImenika, IDKorisnika) " +
                    "VALUES('" + podaciImenik.ime + "', '" + podaciImenik.prezime +"', '" + podaciImenik.brojTel +"', " + podaciImenik.ID1 + ", " + podaciImenik.ID + ")";

            //Izvrsavanje upita
            connection = bazaPodataka.getConnection();
            int set1 = connection.createStatement().executeUpdate(query1);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
