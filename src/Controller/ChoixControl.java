package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChoixControl {

    @FXML
    private Button etudiant;

    @FXML
    private Button Entreprise;

    @FXML
    public void AddEntreprise(ActionEvent event) {
    	Stage primaryStage= new Stage();
    	
    	primaryStage.setTitle("Inscription" );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/CreerEntreprise.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			((Node)(event.getSource())).getScene().getWindow().hide();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }

    

    @FXML
    public void AddInscripEtudiant(ActionEvent event) {
    	Stage primaryStage= new Stage();
    	
    	primaryStage.setTitle("Inscription" );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/InscripEtudiant.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			((Node)(event.getSource())).getScene().getWindow().hide();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }

}