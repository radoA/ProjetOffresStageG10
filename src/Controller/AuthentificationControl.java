package Controller;
import metiers.Authentification;
import metiers.VerificationFormulaire;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AuthentificationControl {
    @FXML
    private Pane Authentification;
    @FXML
    private Button Connexion;
    @FXML
    private Button Inscription;
    @FXML
    private Button mdpOublie;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    private ArrayList<Authentification> listeInscrit;

    public void initialize(){
    	listeInscrit=Database.extractAuthentificationFromDB();
    }
    @FXML
    void AddConnexion(ActionEvent event) {
    	Authentification acces = new Authentification();
    	acces.setLogin(login.getText());
    	acces.setPassword(password.getText());
    	for (int i=0; i<listeInscrit.size(); i++) {
    		
			if(  listeInscrit.get(i).equals(acces)  ){
				acces.setType(listeInscrit.get(i).getType());
			}
			//System.out.println(listeInscrit.get(i).toString());
		}
    	if(acces.getType().equals("admin")){
    		JOptionPane.showMessageDialog(null, acces.getLogin() + ",Bienvenue admin");
    			   Stage primaryStage= new Stage();
    		    	
    		    	primaryStage.setTitle("Administrateur" );
    		    	Parent root;
    		    	try {
    		    		//root = FXMLLoader.load(getClass().getResource("/View/MenuAdminstrateur.fxml"));
    		    		root = FXMLLoader.load(getClass().getResource("/View/dashBoardAdministrator.fxml"));
    		    		Scene scene= new Scene(root);
    		    		primaryStage.setScene(scene);
    		    		primaryStage.show();
    		    		primaryStage.setResizable(false);
    		    		((Node)(event.getSource())).getScene().getWindow().hide();
    		    	} catch (IOException e1) {
    		    		e1.printStackTrace();
    		    	}
    	}
    	else if(acces.getType().equals("etudiant")){
    		JOptionPane.showMessageDialog(null, acces.getLogin() + " ,  Bienvenue etudiant");
    			   Stage primaryStage= new Stage();
    		    	primaryStage.setTitle("Espace Etudiant" );
    		    	Parent root;
    		    	try {
    		    		root = FXMLLoader.load(getClass().getResource("/View/TableDeBordEtudiant.fxml"));
    		    		Scene scene= new Scene(root);
    		    		primaryStage.setScene(scene);
    		    		primaryStage.show();
    		    		primaryStage.setResizable(false);
    		    		((Node)(event.getSource())).getScene().getWindow().hide();
    		    	} catch (IOException e1) {
    		    		e1.printStackTrace();
    		    	}
    	}
    	else if(acces.getType().equals("entreprise")){
    		JOptionPane.showMessageDialog(null, acces.getLogin() + " , Bienvenue entreprise");
    			   Stage primaryStage= new Stage();
    		    	
    		    	primaryStage.setTitle("Ajouter une offre" );
    		    	Parent root;
    		    	try {
    		    		root = FXMLLoader.load(getClass().getResource("/View/TableDeBordEntreprise.fxml"));
    		    		Scene scene= new Scene(root);
    		    		primaryStage.setScene(scene);
    		    		primaryStage.show();
    		    		primaryStage.setResizable(false);
    		    		((Node)(event.getSource())).getScene().getWindow().hide();
    		    	} catch (IOException e1) {
    		    		e1.printStackTrace();
    		    	}
    	}
    	else{
        	if( ((! VerificationFormulaire.validateMail(password.getText()))   )){
        		JOptionPane.showMessageDialog(null, " le login ou le mot de passe ne correspond a aucun compte, veuillez creer un compte");
        	}
        	else if(password.getText().equals("")){
        		JOptionPane.showMessageDialog(null,  " le login ou le mot de passe ne correspond a aucun compte, veuillez creer un compte");
        	}
    	}
    }
    
     @FXML
     void AddMdpOublie(ActionEvent event) {
     }
    
   @FXML
   void AddInscription(ActionEvent event) {
	   Stage primaryStage= new Stage();
    	
    	primaryStage.setTitle("CHOISIR VOTRE STATUT" );
    	Parent root;
    	try {
    		root = FXMLLoader.load(getClass().getResource("/View/Choix.fxml"));
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
