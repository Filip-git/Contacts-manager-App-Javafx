package sample.Controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.BazaPodataka;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;

public class DodajKontaktController /*implements Initializable*/{

//Elementi FXML datoteke -----------------------------------------------------------------------------------------------
    @FXML
    private TextField dodajImeField;

    @FXML
    private TextField dodajPrezimeField;

    @FXML
    private TextField dodajBrojTelField;

    @FXML
    private Label dodajLabel;

    @FXML
    private Button dodajKontaktButton;
//----------------------------------------------------------------------------------------------------------------------

    private Connection connection;
    private BazaPodataka bazaPodataka;

    ImenikController podaci = new ImenikController();

//Metode za kontroliranje akcija tipki ---------------------------------------------------------------------------------
    public void dodajKontaktButtonOnAction(ActionEvent event){
        bazaPodataka = new BazaPodataka();
        if(dodajImeField.getText().isBlank() == false && dodajPrezimeField.getText().isBlank() == false
                && dodajBrojTelField.getText().isBlank() == false) {
            dodajOsobu();
            Stage stageDodajKontakt = (Stage) dodajKontaktButton.getScene().getWindow();
            stageDodajKontakt.close();
        }else{
            dodajLabel.setText("Molimo popunite sva polja!");
        }
    }
//----------------------------------------------------------------------------------------------------------------------

//Metoda za dodavanje kontakta u imenik
    private void dodajOsobu(){
        try{
            //Upit bazi podataka za ubacivanje podatka u tablicu imenik
            String query = "INSERT INTO imenik(Ime, Prezime, BrojTelefona, IDKorisnika) " +
                            "VALUES('"+ dodajImeField.getText() +"', '" + dodajPrezimeField.getText() + "', '" + dodajBrojTelField.getText()+"', " + podaci.ID + ")";

            //Izvrsavanje upita
            connection = bazaPodataka.getConnection();
            int set = connection.createStatement().executeUpdate(query);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
