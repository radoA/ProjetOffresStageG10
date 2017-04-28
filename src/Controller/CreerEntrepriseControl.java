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
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import metiers.Authentification;
import metiers.Entreprise;

public class CreerEntrepriseControl {
    @FXML
    private Tab Formulaire;
    @FXML
    private TextField nomEntreprise;
    @FXML
    private TextField adresse;
    @FXML
    private TextField codePostal;
    @FXML
    private TextField ville;
    @FXML
    private TextField tel;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField confirmeMdp;
    private Entreprise e;
    private Authentification aut;
    @FXML
    private Button Envoyer;
    
    private ObservableList<String> domainlist = FXCollections.observableArrayList("Developpement","Comptabilite","Reseaux");
    
    @FXML
    private ChoiceBox<String> secteurActivite;
    
    public void initialize(){
    	secteurActivite.setValue("Developpement");
    	secteurActivite.getItems().addAll(domainlist);
    }
    	
   


    @FXML
    void AddEntreprise(ActionEvent event) {

		e = new Entreprise();
		e.setNom(nomEntreprise.getText());
		e.setAdresseNumeroRue(adresse.getText());
		e.setAdresseVille(ville.getText());
		e.setAdresseCodePostal(codePostal.getText());
		e.setTelephone(tel.getText());
		e.setMail(mail.getText());
		e.setSecteurActivite(secteurActivite.getValue());
		//inserer Entreprise dans DAO
		Boolean insertEntreprise=Database.insertEntrepriseToDB(e);
		if(insertEntreprise){
			JOptionPane.showMessageDialog(null, "Votre entreprise a ete enregistee");
		}
		else{
			JOptionPane.showMessageDialog(null, "Erreur ajout entreprise");
		}
		//System.out.println(e.toString());
		
		aut = new Authentification(e.getMail(), mdp.getText(), "entreprise", Database.getIDThingsFromObjet(e));
		
		//inserer dans Authentification aussi
		Boolean insertAuthentification=Database.insertAuthentificationToDB(aut);
		if(insertAuthentification){
			JOptionPane.showMessageDialog(null, "Votre authentification entreprise a ete cree");
		}
		else{
			JOptionPane.showMessageDialog(null, "Erreur creation authentification compte entreprise");
		}
		//System.out.println(aut.toString());
		
		
    	

		((Node)(event.getSource())).getScene().getWindow().hide();

    }


}
