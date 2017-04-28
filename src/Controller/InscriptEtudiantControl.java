package Controller;
import javax.swing.JOptionPane;

import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import metiers.Authentification;
import metiers.Utilisateur;

public class  InscriptEtudiantControl  {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private DatePicker date;
    @FXML
    private TextArea adresse;
    @FXML
    private TextArea descrition;
    @FXML
    private TextField mail;
    @FXML
    private TextField mdp;
    @FXML
    private TextField confirmerMdp;
    @FXML
    private Button Envoyer;
    
    private ObservableList<String> sexlist = FXCollections.observableArrayList("Femme","Homme");

    @FXML
    private ChoiceBox<String> sexBox = new ChoiceBox<String>();
    private Utilisateur ut;
    private Authentification aut;
    public void initialize(){
    	sexBox.setValue("Femme");
    	sexBox.getItems().addAll(sexlist);
    }
    
	@FXML
   void AddIncripEtudiant(ActionEvent event) {
		ut = new Utilisateur(nom.getText(), prenom.getText(), sexBox.getValue(), adresse.getText(), date.getValue(), mail.getText(),mdp.getText(),confirmerMdp.getText(), descrition.getText());
		
		//Ajouter utilisateur dans la DAO
		if(Database.insertUtilisateurToDB(ut)){
			JOptionPane.showMessageDialog(null, "Votre compte utilisateur a ete cree");
			
			Database.getIDThingsFromObjet(ut);

		}
		else{
			JOptionPane.showMessageDialog(null, "Erreur creation compte utilisateur etudiant");
		}
		
		aut = new Authentification(mail.getText(), mdp.getText(), "etudiant", Database.getIDThingsFromObjet(ut));
		
		//ainsi que l'authentification
		if(Database.insertAuthentificationToDB(aut)){
			JOptionPane.showMessageDialog(null, "Votre compte authentification etudiant a ete cree");
		}
		else{
			JOptionPane.showMessageDialog(null, "Erreur creation compte authentification etudiant");
		}
		((Node)(event.getSource())).getScene().getWindow().hide();
		}
	 	
    }
    	
    	
    
 


    