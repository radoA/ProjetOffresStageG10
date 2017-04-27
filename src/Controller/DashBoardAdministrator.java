/**
 * Sample Skeleton for 'dashBoardAdministrator.fxml' Controller Class
 */

package Controller;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import database.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import metiers.Entreprise;


public class DashBoardAdministrator {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    
    @FXML // fx:id="tableViewEntreprise"
    private TableView<Entreprise> tableViewEntreprise; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="idEntr"
    private TableColumn<Entreprise, String> idEntr; // Value injected by FXMLLoader

    @FXML // fx:id="nomEntr"
    private TableColumn<Entreprise,String> nomEntr; // Value injected by FXMLLoader

    @FXML // fx:id="rueEntr"
    private TableColumn<Entreprise, String> rueEntr; // Value injected by FXMLLoader

    @FXML // fx:id="codePEntr"
    private TableColumn<Entreprise, String> codePEntr; // Value injected by FXMLLoader

    @FXML // fx:id="villeEntr"
    private TableColumn<Entreprise, String> villeEntr; // Value injected by FXMLLoader

    @FXML // fx:id="mailEntr"
    private TableColumn<Entreprise, String> mailEntr; // Value injected by FXMLLoader

    @FXML // fx:id="TelEntr"
    private TableColumn<Entreprise, String> TelEntr; // Value injected by FXMLLoader

    @FXML // fx:id="secteurEntr"
    private TableColumn<Entreprise, String> secteurEntr; // Value injected by FXMLLoader

    //-------------
    @FXML // fx:id="nomEntrAjout"
    private TextField nomEntrAjout; // Value injected by FXMLLoader

    @FXML // fx:id="adrNumRueEntrAjout"
    private TextField adrNumRueEntrAjout; // Value injected by FXMLLoader

    @FXML // fx:id="cPostalEntrAj"
    private TextField cPostalEntrAj; // Value injected by FXMLLoader

    @FXML // fx:id="villeEntrAj"
    private TextField villeEntrAj; // Value injected by FXMLLoader

    @FXML // fx:id="mailEntrAj"
    private TextField mailEntrAj; // Value injected by FXMLLoader

    @FXML // fx:id="telEntrAj"
    private TextField telEntrAj; // Value injected by FXMLLoader

    @FXML // fx:id="secteurEntrAj"
    private TextField secteurEntrAj; // Value injected by FXMLLoader

    @FXML // fx:id="addEntr"
    private Button addEntr; // Value injected by FXMLLoader

    @FXML // fx:id="updatebtnEntr"
    private Button updatebtnEntr; // Value injected by FXMLLoader

    @FXML // fx:id="deleteEntrbtn"
    private Button deleteEntrbtn; // Value injected by FXMLLoader
//-----------
    
    @FXML // fx:id="tableViewStage"
    private TableView<?> tableViewStage; // Value injected by FXMLLoader

    @FXML // fx:id="idOffreStage"
    private TableColumn<?, ?> idOffreStage; // Value injected by FXMLLoader

    @FXML // fx:id="libelleStage"
    private TableColumn<?, ?> libelleStage; // Value injected by FXMLLoader

    @FXML // fx:id="descriptifStage"
    private TableColumn<?, ?> descriptifStage; // Value injected by FXMLLoader

    @FXML // fx:id="domaineStage"
    private TableColumn<?, ?> domaineStage; // Value injected by FXMLLoader

    @FXML // fx:id="dureeStage"
    private TableColumn<?, ?> dureeStage; // Value injected by FXMLLoader

    @FXML // fx:id="cheminStage"
    private TableColumn<?, ?> cheminStage; // Value injected by FXMLLoader

    @FXML // fx:id="valideStage"
    private TableColumn<?, ?> valideStage; // Value injected by FXMLLoader
    
    @FXML // fx:id="tableViewPostuler"
    private TableView<?> tableViewPostuler; // Value injected by FXMLLoader

    @FXML // fx:id="idPostuler"
    private TableColumn<?, ?> idPostuler; // Value injected by FXMLLoader

    @FXML // fx:id="idOffreP"
    private TableColumn<?, ?> idOffreP; // Value injected by FXMLLoader

    @FXML // fx:id="idUtilisateurPost"
    private TableColumn<?, ?> idUtilisateurPost; // Value injected by FXMLLoader

    @FXML // fx:id="statutPost"
    private TableColumn<?, ?> statutPost; // Value injected by FXMLLoader

    @FXML // fx:id="tableViewUtilisateur"
    private TableView<?> tableViewUtilisateur; // Value injected by FXMLLoader

    @FXML // fx:id="idUt"
    private TableColumn<?, ?> idUt; // Value injected by FXMLLoader

    @FXML // fx:id="nomUt"
    private TableColumn<?, ?> nomUt; // Value injected by FXMLLoader

    @FXML // fx:id="prenomUt"
    private TableColumn<?, ?> prenomUt; // Value injected by FXMLLoader

    @FXML // fx:id="sexeUt"
    private TableColumn<?, ?> sexeUt; // Value injected by FXMLLoader

    @FXML // fx:id="adrUt"
    private TableColumn<?, ?> adrUt; // Value injected by FXMLLoader

    @FXML // fx:id="mailUt"
    private TableColumn<?, ?> mailUt; // Value injected by FXMLLoader

    @FXML // fx:id="descrUt"
    private TableColumn<?, ?> descrUt; // Value injected by FXMLLoader

    @FXML // fx:id="dateUt"
    private TableColumn<?, ?> dateUt; // Value injected by FXMLLoader

    @FXML // fx:id="adminUt"
    private TableColumn<?, ?> adminUt; // Value injected by FXMLLoader

    @FXML // fx:id="tableViewAuthentification"
    private TableView<?> tableViewAuthentification; // Value injected by FXMLLoader

    @FXML // fx:id="idAuth"
    private TableColumn<?, ?> idAuth; // Value injected by FXMLLoader

    @FXML // fx:id="identifiantAuth"
    private TableColumn<?, ?> identifiantAuth; // Value injected by FXMLLoader

    @FXML // fx:id="cleAuth"
    private TableColumn<?, ?> cleAuth; // Value injected by FXMLLoader

    @FXML // fx:id="typeAuth"
    private TableColumn<?, ?> typeAuth; // Value injected by FXMLLoader
    
    private ObservableList<Entreprise> entrepriseList;



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	verif_erreur();//assert
        entrepriseList = FXCollections.observableArrayList(Database.extractAllEntrepriseFromDB());
        idEntr=new TableColumn<Entreprise, String>("id");
        nomEntr =new TableColumn<Entreprise, String>("nom");
        rueEntr =new TableColumn<Entreprise, String>("Num & Rue");
        codePEntr =new TableColumn<Entreprise, String>("CP");
        villeEntr =new TableColumn<Entreprise, String>("Ville");
        mailEntr =new TableColumn<Entreprise, String>("mail");
        TelEntr =new TableColumn<Entreprise, String>("tél");
        secteurEntr =new TableColumn<Entreprise, String>("Secteur");
        refreshEntreprise();        
    }
    
    private void refreshEntreprise(){

        idEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("ide"));
        idEntr.setCellFactory(TextFieldTableCell.forTableColumn());
        idEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setIde(event.getNewValue());
				
			}
		});
        
        nomEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("nom"));
        nomEntr.setCellFactory(TextFieldTableCell.forTableColumn());
        nomEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setNom(event.getNewValue());
				
			}
		});
        
        rueEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("adresseNumeroRue"));
        rueEntr.setCellFactory(TextFieldTableCell.forTableColumn());
        rueEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setAdresseNumeroRue(event.getNewValue());
				
			}
		});
        
        codePEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("adresseCodePostal"));
        codePEntr.setCellFactory(TextFieldTableCell.forTableColumn());
        codePEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setAdresseCodePostal(event.getNewValue());
				
			}
		});
        
        villeEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("adresseVille"));
        villeEntr.setCellFactory(TextFieldTableCell.forTableColumn());
        villeEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setAdresseVille(event.getNewValue());
				
			}
		});
        
        mailEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("mail"));
        mailEntr.setCellFactory(TextFieldTableCell.forTableColumn());
        mailEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setMail(event.getNewValue());
				
			}
		});
        
        TelEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("telephone"));
        TelEntr.setCellFactory(TextFieldTableCell.forTableColumn());
        TelEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setTelephone(event.getNewValue());
				
			}
		});
        

      secteurEntr.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("secteurActivite"));
      secteurEntr.setCellFactory(TextFieldTableCell.forTableColumn());
      secteurEntr.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Entreprise,String>>() {
			@Override
			public void handle(CellEditEvent<Entreprise, String> event) {
				((Entreprise) event.getTableView().getItems().get(event.getTablePosition().getRow())).setSecteurActivite(event.getNewValue());
				
			}
		});
      


        
        tableViewEntreprise.setEditable(true);
        tableViewEntreprise.setItems( entrepriseList);
        tableViewEntreprise.getColumns().add(idEntr);
        tableViewEntreprise.getColumns().add(nomEntr);//addAll(firstNameCol, lastNameCol, emailCol);
        tableViewEntreprise.getColumns().add(rueEntr);
        tableViewEntreprise.getColumns().add(codePEntr);
        tableViewEntreprise.getColumns().add(villeEntr);
        tableViewEntreprise.getColumns().add(mailEntr);
        tableViewEntreprise.getColumns().add(TelEntr);
        tableViewEntreprise.getColumns().add(secteurEntr);
        
    }
    
    @FXML
    public void addEntrEvenement(ActionEvent event) {
    	Entreprise e = new Entreprise();
    	e.setNom(nomEntrAjout.getText());
    	e.setAdresseNumeroRue(adrNumRueEntrAjout.getText());
    	e.setAdresseCodePostal(cPostalEntrAj.getText());
    	e.setAdresseVille(villeEntrAj.getText());
    	e.setMail(mailEntrAj.getText());
    	e.setTelephone(telEntrAj.getText());
    	e.setSecteurActivite(secteurEntrAj.getText());

    	//System.out.println(e.toString());//afficher l'entreprise
    	
    	if(Database.insertEntrepriseToDB(e)){//insertion dans la bdd
        	JOptionPane.showMessageDialog(null, "Ajout entreprise reussie");
        	entrepriseList.clear();
        	entrepriseList = FXCollections.observableArrayList(Database.extractAllEntrepriseFromDB());
        	tableViewEntreprise.getItems().clear();
        	tableViewEntreprise.setItems(entrepriseList);
     	}
    	else{
    		JOptionPane.showMessageDialog(null, "Echec ajout entreprise");
    	}
    
    	
    	nomEntrAjout.clear();
    	adrNumRueEntrAjout.clear();
    	cPostalEntrAj.clear();
    	villeEntrAj.clear();
    	mailEntrAj.clear();
    	telEntrAj.clear();
    	secteurEntrAj.clear();
    	
    }
    



	@FXML
    void dellEntrEvenement(ActionEvent event) {
        int selectedIndex = tableViewEntreprise.getSelectionModel().getSelectedIndex();
        //Entreprise ent = new Entreprise();
        //ent = tableViewEntreprise.getSelectionModel().getSelectedItem();
        //System.out.println(tableViewEntreprise.set);
        //System.out.println(ent.toString());
        if (selectedIndex >= 0) {
        	if(Database.deleteEntrepriseFromDB(Integer.parseInt(tableViewEntreprise.getSelectionModel().getSelectedItem().getIde()) )){
            	tableViewEntreprise.getItems().remove(selectedIndex);
        	}else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Probleme lors de la suppression");
                alert.setHeaderText("Cette entreprise contient encore des offres");
                alert.setContentText("supprimer d'abord tous ses offres");
                alert.showAndWait();
        	}
        }else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
	
    @FXML
    public void updateEntrEvenement(ActionEvent event) {
    	Entreprise ent = new Entreprise();
    	ent = tableViewEntreprise.getSelectionModel().getSelectedItem();
//    	System.out.println(ent.toString()+"\n\n");
    	Database.updateEntrepriseFromDB(ent);
    }
    
    @FXML
    void updateAllEntrEvenement(ActionEvent event) {
    	for(int i=0; i< tableViewEntreprise.getItems().size(); i++){
    		//System.out.println(tableViewEntreprise.getItems().get(i).toString());
    		Entreprise ent = new Entreprise();
    		ent = tableViewEntreprise.getItems().get(i);
    		Database.updateEntrepriseFromDB(ent);
    	}
    }
    private void verif_erreur(){
    assert tableViewEntreprise != null : "fx:id=\"tableViewEntreprise\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert idEntr != null : "fx:id=\"idEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert nomEntr != null : "fx:id=\"nomEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert rueEntr != null : "fx:id=\"rueEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert codePEntr != null : "fx:id=\"codePEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert villeEntr != null : "fx:id=\"villeEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert mailEntr != null : "fx:id=\"mailEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert TelEntr != null : "fx:id=\"TelEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert secteurEntr != null : "fx:id=\"secteurEntr\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert tableViewStage != null : "fx:id=\"tableViewStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert idOffreStage != null : "fx:id=\"idOffreStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert libelleStage != null : "fx:id=\"libelleStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert descriptifStage != null : "fx:id=\"descriptifStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert domaineStage != null : "fx:id=\"domaineStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert dureeStage != null : "fx:id=\"dureeStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert cheminStage != null : "fx:id=\"cheminStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert valideStage != null : "fx:id=\"valideStage\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert tableViewPostuler != null : "fx:id=\"tableViewPostuler\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert idPostuler != null : "fx:id=\"idPostuler\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert idOffreP != null : "fx:id=\"idOffreP\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert idUtilisateurPost != null : "fx:id=\"idUtilisateurPost\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert statutPost != null : "fx:id=\"statutPost\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert tableViewUtilisateur != null : "fx:id=\"tableViewUtilisateur\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert idUt != null : "fx:id=\"idUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert nomUt != null : "fx:id=\"nomUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert prenomUt != null : "fx:id=\"prenomUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert sexeUt != null : "fx:id=\"sexeUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert adrUt != null : "fx:id=\"adrUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert mailUt != null : "fx:id=\"mailUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert descrUt != null : "fx:id=\"descrUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert dateUt != null : "fx:id=\"dateUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert adminUt != null : "fx:id=\"adminUt\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert tableViewAuthentification != null : "fx:id=\"tableViewAuthentification\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert idAuth != null : "fx:id=\"idAuth\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert identifiantAuth != null : "fx:id=\"identifiantAuth\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert cleAuth != null : "fx:id=\"cleAuth\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    assert typeAuth != null : "fx:id=\"typeAuth\" was not injected: check your FXML file 'dashBoardAdministrator.fxml'.";
    }
}
