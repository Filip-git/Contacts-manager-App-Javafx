package sample.Controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.BazaPodataka;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;

public class ObrisiFavoritAdministratorController {

//Elementi FXML datoteke -----------------------------------------------------------------------------------------------
    @FXML
    private Button odustaniButton;

    @FXML
    private Button obrisiFavoritButton;
//----------------------------------------------------------------------------------------------------------------------

    private Connection connection;
    private BazaPodataka bazaPodataka;

    FavoritiAdministratorController podaci = new FavoritiAdministratorController();

//Metode za kontrolu akcija tipki --------------------------------------------------------------------------------------
    public void obrisiFavoritButtonOnAction(ActionEvent event){
        bazaPodataka = new BazaPodataka();
        obrisiFavorita();

        Stage stageObrisiKontakt = (Stage) obrisiFavoritButton.getScene().getWindow();
        stageObrisiKontakt.close();
    }

    public void odustaniButtonOnAction(ActionEvent event){
        Stage stageObrisiKontakt = (Stage) odustaniButton.getScene().getWindow();
        stageObrisiKontakt.close();
    }
//----------------------------------------------------------------------------------------------------------------------

    private void obrisiFavorita(){
        try{
            //Upit bazi podataka za brisanje kontakta iz favorita
            String query = "DELETE FROM favoriti " +
                    "WHERE ID = " + podaci.IDFavoriti;

            //Izvrsavanje upita
            connection = bazaPodataka.getConnection();
            int set = connection.createStatement().executeUpdate(query);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
