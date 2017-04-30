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
    
    private static int choix;
    
    public static final int CONNEXION 			= 2;
    public static final int CONSULTER_OFFRE 	= 3;
    public static final int AJOUTER_OFFRE 		= 4;

    private void launch_authentification(String titre, String source, ActionEvent event){
    	Stage primaryStage= new Stage();
    	primaryStage.setTitle(titre );
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(source));
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
    	setChoix(CONNEXION);
    	//System.out.println("TEEEEST");

        launch_authentification("Connexion","/View/Authentification.fxml", event);
    }


    @FXML
    void AddConsulterOffre(ActionEvent event) {
    	setChoix(CONSULTER_OFFRE);
    	launch_authentification("Connexion","/View/Authentification.fxml", event);
	}


	@FXML
    void AddOffreStage(ActionEvent event)  {
//		primaryStage.setTitle("Ajout offres" );
		setChoix(AJOUTER_OFFRE);
		launch_authentification("Connexion","/View/Authentification.fxml", event);
	}
		
	 	@FXML
	    void AddVoirEntreprise(ActionEvent event) {

	    }
	 	@FXML
	    void AddRechercher(ActionEvent event) {
	   
	    }

	    public static int getChoix(){
	    	return choix;
	    }
   
	    public static void setChoix(int choix) {
			MenuControl.choix = choix;
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

