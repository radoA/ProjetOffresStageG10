package metiers;

public class Entreprise {
	private String nom;
	private String adresseNumeroRue;
	private String adresseCodePostal;//int
	private String adresseVille;
	private String mail;
	private String telephone;
	private String secteurActivite;
	private String ide;

	public Entreprise(){super();}
	
	public Entreprise(String nom, String adresseNumeroRue, String adresseCodePostal, String adresseVille, String mail,
			String telephone, String secteurActivite) {
		super();
		this.nom = nom;
		this.adresseNumeroRue = adresseNumeroRue;
		this.adresseCodePostal = adresseCodePostal;
		this.adresseVille = adresseVille;
		this.mail = mail;
		this.telephone = telephone;
		this.secteurActivite = secteurActivite;
	}
	public String getIde(){ return ide; }
	public void setIde(String string){ide = string;}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseNumeroRue() {
		return adresseNumeroRue;
	}
	

	public void setAdresseNumeroRue(String adresseNumeroRue) {
		this.adresseNumeroRue = adresseNumeroRue;
	}

	public String getAdresseCodePostal() {
		return adresseCodePostal;
	}

	public void setAdresseCodePostal(String adresseCodePostal) {
		this.adresseCodePostal = adresseCodePostal;
	}

	public String getAdresseVille() {
		return adresseVille;
	}

	public void setAdresseVille(String adresseVille) {
		this.adresseVille = adresseVille;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	@Override
	public String toString() {
		return "Entreprise [nom=" + nom + ", adresseNumeroRue=" + adresseNumeroRue + ", adresseCodePostal="
				+ adresseCodePostal + ", adresseVille=" + adresseVille + ", mail=" + mail + ", telephone=" + telephone
				+ ", secteurActivite=" + secteurActivite + ", ide=" + ide + "]";
	}
}
