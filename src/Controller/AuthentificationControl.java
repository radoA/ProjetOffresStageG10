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
    
    private static Authentification authentification;
    
    //private static boolean voir_liste_offres_entreprises;

    public AuthentificationControl() {
		super();
	}

	public void initialize(){
		//voir_liste_offres_entreprises =false;
    	listeInscrit=Database.extractAuthentificationFromDB();
    }
	
   // public static boolean isVoir_liste_offres_entreprises() {
		//return voir_liste_offres_entreprises;
	//}

	//public void setVoir_liste_offres_entreprises(boolean voir_liste_offres_entreprises) {
	//	AuthentificationControl.voir_liste_offres_entreprises = voir_liste_offres_entreprises;
	//}

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
			((Node)(event.getSource())).getScene().getWindow().hide();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    @FXML
    void AddConnexion(ActionEvent event) {
    	authentification = new Authentification();
    	Authentification acces = new Authentification();
    	acces.setLogin(login.getText());
    	acces.setPassword(password.getText());
    	for (int i=0; i<listeInscrit.size(); i++) {
    		
			if(  listeInscrit.get(i).equals(acces)  ){
				acces.setType(listeInscrit.get(i).getType());
				authentification = listeInscrit.get(i);
			}
		}
    	if(MenuControl.getChoix() == MenuControl.CONNEXION){
				        if(acces.getType().equals("admin")){
				    		//JOptionPane.showMessageDialog(null, acces.getLogin() + ",Bienvenue admin");
				        	launch_authentification("Administrateur", "/View/dashBoardAdministrator.fxml", event);
				    	}
				    	else if(acces.getType().equals("etudiant")){
				    		launch_authentification("Espace Etudiant", "/View/TableDeBordEtudiant.fxml", event);
				    	}
				    	else if(acces.getType().equals("entreprise")){
				    		launch_authentification("Ajouter une offre", "/View/TableDeBordEntreprise.fxml", event);
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
    	else if(MenuControl.getChoix() == MenuControl.CONSULTER_OFFRE){
			    		if(acces.getType().equals("admin")){
			        		launch_authentification("Voir offres", "/View/ConsulterOffreStage.fxml", event);
			        	}
			        	else if(acces.getType().equals("etudiant")){
			        		launch_authentification("Voir offres", "/View/ConsulterOffreStage.fxml", event);
			        	}
			        	else if(acces.getType().equals("entreprise")){
			        		//JOptionPane.showMessageDialog(null, acces.getLogin() + ",Vous vous  etre authentifie entant qu'entreprise,"
			        		//		+ "la page demandee n'est pas appropriee");
			        		launch_authentification("Voir offres", "/View/ConsulterOffreStage.fxml", event);
			        		//voir_liste_offres_entreprises = true;
			        		//JOptionPane.showMessageDialog(null, authentification.getIdType() + " = ID de l'entreprise");
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
    	else if(MenuControl.getChoix() == MenuControl.AJOUTER_OFFRE){
		        	if(acces.getType().equals("admin")){
		        		launch_authentification("Ajouter Offres", "/View/SaisirOffreStage.fxml", event);
		        	}
		        	else if(acces.getType().equals("etudiant")){
		        		JOptionPane.showMessageDialog(null, acces.getLogin() + " ,Vous n'etes pas autorise saisir une offre ");
		        		    	
		        	}
		        	else if(acces.getType().equals("entreprise")){
		        		launch_authentification("Ajouter Offres", "/View/SaisirOffreStage.fxml", event);
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
    }
    
    public static Authentification getAuthentification(){
    	return authentification;
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
