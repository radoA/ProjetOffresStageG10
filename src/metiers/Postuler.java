package metiers;

public class Postuler {
	private int idPostuler;
	private int idUtil;
	private int idOffre;
	private int reponse;

	
	
	public Postuler() {
		super();
	}



	public int getIdPostuler() {
		return idPostuler;
	}



	public void setIdPostuler(int idPostuler) {
		this.idPostuler = idPostuler;
	}



	public int getIdUtil() {
		return idUtil;
	}



	public void setIdUtil(int idUtil) {
		this.idUtil = idUtil;
	}



	public int getIdOffre() {
		return idOffre;
	}



	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}



	public int getReponse() {
		return reponse;
	}



	public void setReponse(int reponse) {
		this.reponse = reponse;
	}



	@Override
	public String toString() {
		return "Postuler [idPostuler=" + idPostuler + ", idUtil=" + idUtil + ", idOffre=" + idOffre + ", reponse="
				+ reponse + "]";
	}


	
	

	

}
