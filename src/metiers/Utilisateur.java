package metiers;

import java.time.LocalDate;


public class Utilisateur {
	private int idUtilisateur;
	private int administrateur;
	private String  nom;
    private String prenom;
    private  String sexe;
    private  String adresse;
    private  LocalDate dateNaissance;
    private  String mail;
    private  String descrition;
    
    private int idAuthentification;

	public Utilisateur() {
	}

	public Utilisateur( String nom, String prenom, String sexe,
			String adresse, LocalDate dateNaissance, String mail, String mdP,String confMdp, String descrition) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.descrition = descrition;
		
Authentification.md5(mdP);
			Authentification.md5(confMdp);

	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(int i) {
		this.administrateur = i;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public int getIdAuthentification() {
		return idAuthentification;
	}

	public void setIdAuthentification(int idAuthentification) {
		this.idAuthentification = idAuthentification;
	}

	public String toString() {
		return "Utilisateur [administrateur=" + administrateur + ", nom=" + nom + ", prenom=" + prenom + ", sexe="
				+ sexe + ", adresse=" + adresse + ", dateNaissance=" + dateNaissance + ", mail=" + mail
				+ ", descrition=" + descrition + "]";
	}
    
    
	
}
