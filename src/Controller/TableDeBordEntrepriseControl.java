package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
//import metiers.Entreprise;
import metiers.OffreStage;
import metiers.Utilisateur;

public class TableDeBordEntrepriseControl {

    @FXML
    private Tab allOffresPostes;

    @FXML
    private TextField nomEntrAjout1;

    @FXML
    private TextField adrNumRueEntrAjout1;

    @FXML
    private TextField cPostalEntrAj1;

    @FXML
    private TextField villeEntrAj1;

    @FXML
    private TextField mailEntrAj1;

    @FXML
    private TextField telEntrAj1;

    @FXML
    private Button Supprimer1;

    @FXML
    private Button Actualiser1;

    @FXML
    private TableView<OffreStage> offresAll;
    
    @FXML
    private TableColumn<OffreStage, String> libelleOffre;

    @FXML
    private TableColumn<OffreStage, String> domaineOffre;

    @FXML
    private TableColumn<OffreStage, String> debuteLe;

    @FXML
    private TableColumn<OffreStage, String> duree;

    @FXML
    private TextField nomEtreprise;

    @FXML
    private TextField nomEntrAjout11;

    @FXML
    private TextField adrNumRueEntrAjout11;

    @FXML
    private TextField secteurEntrAj11;

    @FXML
    private TextField offrePost11;

    @FXML
    private TextField premon;

    @FXML
    private TextField adresseE;

    @FXML
    private TextField code;

    @FXML
    private TextField ville;

    @FXML
    private TextField mail;

    @FXML
    private TextField tel;

    @FXML
    private Button Accepter;

    @FXML
    private Button Supprimer;

    @FXML
    private Button Actualiser;

    @FXML
    private TableView<Utilisateur> etudiantsCandidats;

    @FXML
    private TextField nom;

    @FXML
    private Button Accepter2;
    
    private ObservableList<OffreStage> offreStageList;
    
    @FXML 
    void initialize() {
    	
    	offreStageList = FXCollections.observableArrayList(Database.extractOffreDeStageFromDB(AuthentificationControl.getAuthentification().getIdType()));
    	//System.out.println("----|----- " + AuthentificationControl.getAuthentification().getIdType());
    	libelleOffre=new TableColumn<OffreStage, String>("libeleOffre");
    	domaineOffre =new TableColumn<OffreStage, String>("domaineOffre");
    	debuteLe =new TableColumn<OffreStage, String>("dateDebut");
    	duree =new TableColumn<OffreStage, String>("dureeStage");
    	refreshOffres();
    }
    
    private void refreshOffres(){

    	libelleOffre.setCellValueFactory(new PropertyValueFactory<OffreStage,String>("libeleOffre"));
    	libelleOffre.setCellFactory(TextFieldTableCell.forTableColumn());
    	libelleOffre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<OffreStage,String>>() {
			@Override
			public void handle(CellEditEvent<OffreStage, String> event) {
				((OffreStage) event.getTableView().getItems().get(event.getTablePosition().getRow())).setLibeleOffre(event.getNewValue());
				
			}
		});
        
    	domaineOffre.setCellValueFactory(new PropertyValueFactory<OffreStage,String>("domaineOffre"));
    	domaineOffre.setCellFactory(TextFieldTableCell.forTableColumn());
    	domaineOffre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<OffreStage,String>>() {
			@Override
			public void handle(CellEditEvent<OffreStage, String> event) {
				((OffreStage) event.getTableView().getItems().get(event.getTablePosition().getRow())).setDomaine(event.getNewValue());
				
			}
		});
        
//    	debuteLe.setCellValueFactory(new PropertyValueFactory<OffreStage,String>("dateDebutString"));
//    	debuteLe.setCellFactory(TextFieldTableCell.forTableColumn());
//    	debuteLe.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<OffreStage,String>>() {
//			@Override
//			public void handle(CellEditEvent<OffreStage, String> event) {
//				((OffreStage) event.getTableView().getItems().get(event.getTablePosition().getRow())).setDateD(event.getNewValue());
//				
//			}
//		});
        
//    	duree.setCellValueFactory(new PropertyValueFactory<OffreStage,String>("dureeStageString"));
//    	duree.setCellFactory(TextFieldTableCell.forTableColumn());
//    	duree.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<OffreStage,String>>() {
//			@Override
//			public void handle(CellEditEvent<OffreStage, String> event) {
//				((OffreStage) event.getTableView().getItems().get(event.getTablePosition().getRow())).setDuree(event.getNewValue());
//				
//			}
//		});
    	
    	offresAll.setEditable(true);
    	offresAll.setItems( offreStageList);

    	offresAll.getColumns().add(libelleOffre);
    	offresAll.getColumns().add(domaineOffre);
    	//offresAll.getColumns().add(debuteLe);
    	//offresAll.getColumns().add(duree);
    }

    @FXML
    void AddAccepter(ActionEvent event) {

    }

    @FXML
    void AddActualiser(ActionEvent event) {

    }

    @FXML
    void AddSupprimer(ActionEvent event) {

    }

}
