package Controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import metiers.OffreStage;


public class ConsulterOffreStageControl {
    @FXML
    private Button precedent;
    @FXML
    private Button Annuler;
    @FXML
    private Button Suivant;
    @FXML
    private Button Postuler;
    @FXML
    private TextField nomE;
    @FXML
    private TextField mailE;
    @FXML
    private TextField dureeStage;
    @FXML
    private TextField libele;
    @FXML
    private TextArea descriptifOffre;
    @FXML
    private TextField villeE;
    @FXML
    private TextField domaineE;
    @FXML
    private DatePicker dateDebut;

    
    private ArrayList<OffreStage> listeOffres;
    private int index_offre = 1;
    

    
    public void initialize(){
    	listeOffres = Database.extractOffreDeStage();
    	nomE.setText(listeOffres.get(0).getNomEntreprise());
    	mailE.setText(listeOffres.get(0).getMailOffreStage());
    	dureeStage.setText(Integer.toString(listeOffres.get(0).getDuree()));
    	libele.setText(listeOffres.get(0).getLibeleOffre());
    	descriptifOffre.setText(listeOffres.get(0).getDescriptifOffre());
    	villeE.setText(listeOffres.get(0).getVilleOffreStage());
    	domaineE.setText(listeOffres.get(0).getDomaine());
    	dateDebut.setValue(listeOffres.get(0).getDateD());
    }
    


	@FXML
    void AddAnnuler(ActionEvent event) {

    }
    
    @FXML
    void AddPrec(ActionEvent event) {

		if(index_offre>1){//hasPrev()
			index_offre--;
	    	nomE.setText(listeOffres.get(index_offre).getNomEntreprise());
	    	mailE.setText(listeOffres.get(index_offre).getMailOffreStage());
	    	dureeStage.setText(Integer.toString(listeOffres.get(index_offre).getDuree()));
	    	libele.setText(listeOffres.get(index_offre).getLibeleOffre());
	    	descriptifOffre.setText(listeOffres.get(index_offre).getDescriptifOffre());
	    	villeE.setText(listeOffres.get(index_offre).getVilleOffreStage());
	    	domaineE.setText(listeOffres.get(index_offre).getDomaine());
	    	dateDebut.setValue(listeOffres.get(index_offre).getDateD());
		}
		else{
			JOptionPane.showMessageDialog(null, "Parcours terminee, on arrive au debut de la liste");
			index_offre++;
		}

    }

    @FXML
    void AddSuiv(ActionEvent event) {
		if(index_offre < listeOffres.size()){//hasNext()
			//System.out.println(listeOffres.get(index_offre).toString());
	    	nomE.setText(listeOffres.get(index_offre).getNomEntreprise());
	    	mailE.setText(listeOffres.get(index_offre).getMailOffreStage());
	    	dureeStage.setText(Integer.toString(listeOffres.get(index_offre).getDuree()));
	    	libele.setText(listeOffres.get(index_offre).getLibeleOffre());
	    	descriptifOffre.setText(listeOffres.get(index_offre).getDescriptifOffre());
	    	villeE.setText(listeOffres.get(index_offre).getVilleOffreStage());
	    	domaineE.setText(listeOffres.get(index_offre).getDomaine());
	    	dateDebut.setValue(listeOffres.get(index_offre).getDateD());
			index_offre++;
		}
		else{
			JOptionPane.showMessageDialog(null, "Parcours terminee, on arrive a la fin de la liste");
			index_offre--;
		}
    }
    
    @FXML
    void AddPostuler(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "Votre candidature a bien été envoyée.");
    	

    }
}


