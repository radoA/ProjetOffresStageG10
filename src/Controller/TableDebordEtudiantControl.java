package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TableDebordEtudiantControl {

    @FXML
    private TextField nomEntrAjout;

    @FXML
    private TextField adrNumRueEntrAjout;

    @FXML
    private TextField villeEntrAj;

    @FXML
    private TextField mailEntrAj;

    @FXML
    private TextField telEntrAj;

    @FXML
    private TextField secteurEntrAj;

    @FXML
    private Button Quitter;

    @FXML
    private Button Supprimer;

    @FXML
    private Button Actualiser;

    @FXML
    private TextField nomEntrAjout1;

    @FXML
    private Button VoirOffre;

    @FXML
    void AddActualiser(ActionEvent event) {

    }

    @FXML
    void AddQuitter(ActionEvent event) {

    }

    @FXML
    void AddSupprimer(ActionEvent event) {

    }

    @FXML
    void AddVoirOffre(ActionEvent event) {
    	 
		 Stage primaryStage= new Stage();
			primaryStage.setTitle("Voir les offres" );
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/View/ConsulterOffreStage.fxml"));
				Scene scene= new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
				//((Node)(event.getSource())).getScene().getWindow().hide();
			} catch (IOException e1){
				e1.printStackTrace();
			}
	    	

    }

}
