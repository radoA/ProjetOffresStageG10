package Controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class TableDeBordEntrepriseControl {

    @FXML
    private TextField nomEntrAjout;

    @FXML
    private TextField adrNumRueEntrAjout;

    @FXML
    private TextField cPostalEntrAj;

    @FXML
    private TextField villeEntrAj;

    @FXML
    private TextField mailEntrAj;

    @FXML
    private TextField telEntrAj;

    @FXML
    private TextField secteurEntrAj;
    @FXML
    private Button AjouterOffre;

    @FXML
    private Button Accepter;

    @FXML
    private Button Supprimer;

    @FXML
    private Button Actualiser;

    @FXML
    private TextField offrePost;
    
    //private Entreprise entreprise;
    
    //private ArrayList<OffreStage>  offres;
   
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	//int idType =0;
    	//offres = Database.extractOffreDeStageFromDB(idType);
    }
    
    @FXML
    void AddAccepter(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "Etudiant Acceptés");

    }

    @FXML
    void AddActualiser(ActionEvent event) {

    }

    @FXML
    void AddSupprimer(ActionEvent event) {

    }
    @FXML
    void AddOffre(ActionEvent event) {
    	Stage primaryStage= new Stage();
    	primaryStage.setTitle("Entreprise" );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/SaisirOffreStage.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }

}
