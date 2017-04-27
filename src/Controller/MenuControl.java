package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//import metiers.Entreprise;

public class MenuControl {
    protected static final Node scene = null;
	@FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button EspaceInscription;
    @FXML
    private Button EspaceConnexion;
    @FXML
    private Button ConsulterOffre;
    @FXML
    private Button CreerOffreStage;
    @FXML
    private Button CreerEntreprise;
    @FXML
    private Button Rechercher;
    
    //private Entreprise e;


    @FXML
    public void AddInscription(ActionEvent e){
    	Stage primaryStage= new Stage();
    	
    	primaryStage.setTitle("Choisir le Statut" );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/Choix.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
    }
    
    @FXML
    void AddConnexion(ActionEvent event) {
    	Stage primaryStage= new Stage();
    	primaryStage.setTitle("Connexion" );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/Authentification.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			//((Node)(event.getSource())).getScene().getWindow().hide();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }


    @FXML
    void AddConsulterOffre(ActionEvent event) {
      Stage primaryStage= new Stage();
    	
      primaryStage.setTitle("Connexion" );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/AuthVO.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			//((Node)(event.getSource())).getScene().getWindow().hide();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		}


	@FXML
    void AddOffreStage(ActionEvent event)  {
		Stage primaryStage= new Stage();
		primaryStage.setTitle("Connexion" );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/AuthAO.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			//((Node)(event.getSource())).getScene().getWindow().hide();
		} catch (IOException e1){
			e1.printStackTrace();
		}

		
		}
		
	 @FXML
	    void AddVoirEntreprise(ActionEvent event) {
		 
		 Stage primaryStage= new Stage();
			primaryStage.setTitle("Connexion" );
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/View/Authentification.fxml"));
				Scene scene= new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
				//((Node)(event.getSource())).getScene().getWindow().hide();
			} catch (IOException e1){
				e1.printStackTrace();
			}
	    	

	    }
	 @FXML
	    void AddRechercher(ActionEvent event) {
		 Stage primaryStage= new Stage();

	    	
	    	primaryStage.setTitle("Connexion" );
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/View/Authentification.fxml"));
				
				Scene scene= new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
				//((Node)(event.getSource())).getScene().getWindow().hide();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

	   
	    }

    
   
    @FXML
    void initialize() {
        assert EspaceInscription != null : "fx:id=\"EspaceEtudiant\" was not injected: check your FXML file 'Menu.fxml'.";
        assert EspaceConnexion != null : "fx:id=\"CreerEntreprise\" was not injected: check your FXML file 'Menu.fxml'.";
        assert  ConsulterOffre != null : "fx:id=\"Rapport\" was not injected: check your FXML file 'Menu.fxml'.";
        assert CreerOffreStage != null : "fx:id=\"CreerOffreStage\" was not injected: check your FXML file 'Menu.fxml'.";
        assert Rechercher != null : "fx:id=\"BoutonCompte\" was not injected: check your FXML file 'Menu.fxml'.";

    }
}

