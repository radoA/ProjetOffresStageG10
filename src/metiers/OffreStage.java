package metiers;

import java.time.LocalDate;

public class OffreStage {
	private String libeleOffre;
	private String descriptifOffre;
	private String domaineOffre;
	private LocalDate dateDebut;// en date
	private int dureeStage; //en jours
	private String cheminOffre;
	private int valide;
	//champs suplementaires requis pour la consultation
	private String nomEntreprise;
	private String villeOffreStage;
	private String mailOffreStage;
	private int idEntreprise;
	private int idOffreStage;

	public OffreStage() {
		this(null, null, null, null, 0, null, 0);
	}

	public OffreStage( String libele, String descriptif, String domaine, LocalDate dateD, int duree,
			String cheminOffre, int valide) {
		this.libeleOffre = libele;
		this.descriptifOffre = descriptif;
		this.domaineOffre = domaine;
		this.dateDebut = dateD;
		this.dureeStage = duree;
		this.cheminOffre = cheminOffre;
		this.valide = valide;
		this.nomEntreprise = null;
		this.villeOffreStage = null;
		this.mailOffreStage = null;
		
	}


	public String getLibeleOffre() {
		return libeleOffre;
	}

	public void setLibeleOffre(String libele) {
		this.libeleOffre = libele;
	}

	public String getDescriptifOffre() {
		return descriptifOffre;
	}

	public void setDescriptifOffre(String descriptif) {
		this.descriptifOffre = descriptif;
	}

	public String getDomaine() {
		return domaineOffre;
	}

	public void setDomaine(String domaine) {
		this.domaineOffre = domaine;
	}

	public LocalDate getDateD() {
		return dateDebut;
	}

	public void setDateD(LocalDate string) {
		this.dateDebut = string;
	}

	public int getDuree() {
		return dureeStage;
	}

	public void setDuree(int duree) {
		this.dureeStage = duree;
	}

	public String getCheminOffre() {
		return cheminOffre;
	}

	public void setCheminOffre(String cheminOffre) {
		this.cheminOffre = cheminOffre;
	}

	public int isValide() {
		return valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}
	
	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	
	public String getVilleOffreStage() {
		return villeOffreStage;
	}

	public void setVilleOffreStage(String villeOffreStage) {
		this.villeOffreStage = villeOffreStage;
	}

	public String getMailOffreStage() {
		return mailOffreStage;
	}

	public void setMailOffreStage(String mailOffreStage) {
		this.mailOffreStage = mailOffreStage;
	}
	
	public int getIdeEntreprise() {
		return idEntreprise;
	}

	public void setIdeEntreprise(int ideEntreprise) {
		this.idEntreprise = ideEntreprise;
	}
	
	public int getIdOffreStage() {
		return idOffreStage;
	}

	public void setIdOffreStage(int idOffreStage) {
		this.idOffreStage = idOffreStage;
	}
	public String toString() {
		return "OffreStage [idOffreStage=" + idOffreStage +", nomEntreprise="+ nomEntreprise +", ideEntreprise="+ idEntreprise + ", villeOffreStage= " + villeOffreStage + ", mailOffreStage= " + mailOffreStage + ", libele= " + libeleOffre + ", descriptif= " + descriptifOffre + ", domaine=" + domaineOffre
				+ ", dateD=" + dateDebut + ", duree=" + dureeStage + ", cheminOffre=" + cheminOffre + ", valide=" + valide + "]";
	}

}
