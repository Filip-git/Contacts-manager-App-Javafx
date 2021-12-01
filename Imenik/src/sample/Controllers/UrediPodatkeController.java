package sample.Controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.BazaPodataka;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;

public class UrediPodatkeController {

//Elementi FXML datoteke -----------------------------------------------------------------------------------------------
    @FXML
    private TextField podaciImeField;

    @FXML
    private TextField podaciPrezimeField;

    @FXML
    private TextField podaciAdresaField;

    @FXML
    private TextField podaciBrojTelField;

    @FXML
    private Label urediLabel;

    @FXML
    private Button urediPodatkeButton;
//----------------------------------------------------------------------------------------------------------------------

    private Connection connection;
    private BazaPodataka bazaPodataka;

    ImenikController podaci = new ImenikController();

//Metode za kontrolu akcija tipki --------------------------------------------------------------------------------------
    public void urediPodatkeButtonOnAction(ActionEvent event){
        bazaPodataka = new BazaPodataka();
        if(podaciImeField.getText().isBlank() == false && podaciPrezimeField.getText().isBlank() == false && podaciBrojTelField.getText().isBlank() == false
                && podaciAdresaField.getText().isBlank() == false) {
            urediPodatke();
            Stage stageUrediPodatke = (Stage) urediPodatkeButton.getScene().getWindow();
            stageUrediPodatke.close();
        }else{
            urediLabel.setText("Molimo popunite sva polja!");
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    private void urediPodatke(){
        try{
            //Upit bazi podataka za azuriranje podataka o korisniku u tablici 'podaci'
            String query = "UPDATE podaci " +
                    "SET Ime = '" + podaciImeField.getText() + "', Prezime = '" + podaciPrezimeField.getText() + "', Adresa = '" + podaciAdresaField.getText() + "', BrojTelefona = '" + podaciBrojTelField.getText() + "' " +
                    "WHERE IDKorisnika = " + podaci.ID;

            connection = bazaPodataka.getConnection();
            int set = connection.createStatement().executeUpdate(query);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
