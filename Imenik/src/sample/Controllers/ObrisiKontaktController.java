package sample.Controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.BazaPodataka;
import sample.Controllers.ImenikController;

import java.sql.Connection;

public class ObrisiKontaktController {

//Elementi FXML datoteke -----------------------------------------------------------------------------------------------
    @FXML
    private Button odustaniButton;

    @FXML
    private Button obrisiKontaktButton;
//----------------------------------------------------------------------------------------------------------------------

    private Connection connection;
    private BazaPodataka bazaPodataka;

    ImenikController podaci = new ImenikController();

//Metode za kontrolu akcija tipki --------------------------------------------------------------------------------------
    public void obrisiKontaktButtonOnAction(ActionEvent event){
        bazaPodataka = new BazaPodataka();
        obrisiOsobu();

        Stage stageObrisiKontakt = (Stage) obrisiKontaktButton.getScene().getWindow();
        stageObrisiKontakt.close();
    }

    public void odustaniButtonOnAction(ActionEvent event){
        Stage stageObrisiKontakt = (Stage) odustaniButton.getScene().getWindow();
        stageObrisiKontakt.close();
    }
//----------------------------------------------------------------------------------------------------------------------

    private void obrisiOsobu(){
        try{
            //Upit bazi podataka za brisanje kontakta iz imenika
            String query = "DELETE FROM Imenik " +
                            "WHERE ID = " + podaci.ID1;

            //Izvrsavanje upita
            connection = bazaPodataka.getConnection();
            int set = connection.createStatement().executeUpdate(query);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
