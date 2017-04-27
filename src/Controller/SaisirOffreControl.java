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
import metiers.OffreStage;

public class SaisirOffreControl {
    @FXML
    private TextField libeleOffre;
    @FXML
    private TextField cheminStockage;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private TextField duree;
    @FXML
    private TextArea descriptif;
    @FXML
    private ChoiceBox<String> nomEntreprise;
    @FXML
    private ChoiceBox<String> domaineOffre;
    @FXML
    private Button Vider;
    @FXML
    private Button Valider;
    
    private ObservableList<String> EntrepriseList;
    private ObservableList<String> domainlist ;


    public void initialize(){
    	//nom de l'entreprise
    	EntrepriseList= FXCollections.observableArrayList(Database.extractEntrepriseName());
    	nomEntreprise.getItems().addAll(EntrepriseList);
    	nomEntreprise.setValue(EntrepriseList.get(0));

    	//domaine de l'offre
    	domainlist = FXCollections.observableArrayList("Developpement","Comptabilite","Reseaux");
    	domaineOffre.setValue("Developpement");
    	domaineOffre.getItems().addAll(domainlist);
    	
    	
    	
    }
    
    @FXML
    void AddOffre(ActionEvent event) {
    	OffreStage offre =new OffreStage(libeleOffre.getText(), descriptif.getText(), domaineOffre.getValue(), dateDebut.getValue(), Integer.parseInt(duree.getText()), cheminStockage.getText(), 1);
    	offre.setNomEntreprise(nomEntreprise.getValue());
    	
    	//mettre a jour l'ide de l'entreprise
    	offre.setIdeEntreprise(Database.getEntrepriseIDEFromDB(offre.getNomEntreprise()));
    	//System.out.println(offre);
    	
    	// insertion dans la base
    	if(Database.createOffreDeStage(offre, offre.getIdeEntreprise())){
    		JOptionPane.showMessageDialog(null, "votre offre a ete enregistee");
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "erreur ajout offre");
    	}

		((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @FXML
    void SupOnClick(ActionEvent event) {

    }

}

