package database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import metiers.Authentification;
import metiers.Entreprise;
import metiers.OffreStage;
import metiers.Postuler;
import metiers.Utilisateur;

public class Database {
	private static boolean request(Object objet ,String sql){
		try {
			// Etape 3 : Creation d'un Statement
			PreparedStatement st = Connexion.getCn().prepareStatement(sql);
			// Etape 4 : Execution de la requete
			if (st.executeUpdate(sql) == 1) {
				st.close();
				return true;
			}
			else{
				System.out.println("Erreur syntaxe requete sql");
			}
			st.close();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL, insertion " + objet.getClass().getName());
		}
		return false;
	}
	
	private static boolean insertToDB(Object objet){
		String sql="";
		if(objet instanceof Entreprise){
			Entreprise e = (Entreprise) objet;
			 sql = "INSERT INTO entreprise (`NOM`,`ADRESSENUMERORUE`,`ADRESSECODEPOSTAL`,`ADRESSEVILLE`,`MAIL`,`TELEPHONE`,`SECTEURACTIVITE`) VALUES ("
					+ "'" + e.getNom() + "'" + "," + "'" + e.getAdresseNumeroRue() + "'" + ","
					+ e.getAdresseCodePostal() + "," + "'" + e.getAdresseVille() + "'" + "," + "'" + e.getMail() + "'"
					+ "," + "'" + e.getTelephone() + "'" + "," + "'" + e.getSecteurActivite() + "'" + ")";
		}
		else if(objet instanceof Utilisateur){
			Utilisateur ut = (Utilisateur) objet;
			 sql = "INSERT INTO utilisateur (`NOM`,`PRENOM`,`SEXE`,`ADRESSE`,`MAIL`,`DESCRIPTION`,`DATE`) VALUES ("
					+ "'" + ut.getNom() + "'" + "," + "'" + ut.getPrenom() + "'" + ","
					+ "'" + ut.getSexe()+ "'" + "," + "'" + ut.getAdresse() + "'" + "," + "'" + ut.getMail() + "'"
					+ "," + "'" + ut.getDescrition() + "'" + ","+ "'" +ut.getDateNaissance()+ "'"+ ")";
		}
		else if(objet instanceof Authentification){
			Authentification a = (Authentification) objet;
			sql= "INSERT INTO `authentification` (`IDAUTHETIFICATION`, `IDENTIFIANT`, `MOTDEPASSE`, `TYPE`, `IDTYPE`) VALUES (" + "NULL" +",'"+a.getLogin()+"',"+ "'"+ a.getPassword()+ "',"+ "'"+a.getType()+ "',"+a.getIdType()+")";
		}
		return request( objet , sql);
	}
	
	
	public static boolean insertEntrepriseToDB(Entreprise e) {
		return insertToDB(e);
	}
	
	public static boolean insertAuthentificationToDB(Authentification a) {
		return insertToDB(a);
	}

	public static boolean insertUtilisateurToDB(Utilisateur ut) {
		return insertToDB(ut);
	}
	
	public static boolean createOffreDeStage(OffreStage o, int ide) {
		String sql = "INSERT INTO offrestage (`IDE`,`LIBELLEOFFRE`,`DESCRIPTIFOFFRE`,`DOMAINEOFFRE`,`DATEDEBUTOFFRE`,`DUREEOFFRE`,`CHEMINOFFRE` , `VALIDE`) VALUES ("
				+ ide +  ",'" + o.getLibeleOffre() + "','" + o.getDescriptifOffre() + "','" + o.getDomaine() + "','"
				+ o.getDateD() + "'," + o.getDuree() + ",'" + o.getCheminOffre() + "'," + o.isValide() + ")";
		 //System.out.println(sql);
		return request(o,sql);
	}
	
	private static  ArrayList<?> extractFromDB(Object objet){
		ArrayList<?> array = null;
		String sql="";
		if(objet instanceof Entreprise){
			ArrayList<Entreprise> entList = new ArrayList<Entreprise>();
			sql = "SELECT * FROM `entreprise`";
			try {
				// Etape 3 : Creation d'un Statement
				PreparedStatement st = Connexion.getCn().prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					Entreprise e= new Entreprise();
					e.setIde(rs.getString(1));//Integer.parseInt(rs.getString(1))
					e.setNom(rs.getString(2));
					e.setAdresseNumeroRue(rs.getString(3));
					e.setAdresseCodePostal(rs.getString(4));
					e.setAdresseVille(rs.getString(5));
					e.setMail(rs.getString(6));
					e.setTelephone(rs.getString(7));
					e.setSecteurActivite(rs.getString(8));
					entList.add(e);
				}
				st.close();
				return entList;
			} catch (SQLException e) {
				
				System.out.println("Erreur SQL dans la table " + objet.getClass().getName());
			}
			return entList;
		}
		else if(objet instanceof Utilisateur){ //non traité
			ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
			sql = "SELECT * FROM `utilisateur`";
			LocalDate myDate1;
			try {
				PreparedStatement st = Connexion.getCn().prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					Utilisateur ut= new Utilisateur();
					ut.setNom(rs.getString(2));
					ut.setPrenom(rs.getString(3));
					ut.setSexe(rs.getString(4));
					ut.setAdresse(rs.getString(5));
					ut.setMail(rs.getString(6));
					ut.setDescrition(rs.getString(7));
					myDate1 = LocalDate.parse(rs.getString(8));
					ut.setDateNaissance(myDate1);
					ut.setAdministrateur(Integer.parseInt(rs.getString(9)));
					utilisateurs.add(ut);
				}
				st.close();
				return utilisateurs;
			} catch (SQLException e) {
				
				System.out.println("Erreur SQL dans la table " + objet.getClass().getName());
			}
			return utilisateurs;
		}
		else if(objet instanceof OffreStage){
			ArrayList<OffreStage> offres = new ArrayList<OffreStage>();
			String date;
			LocalDate myDate;
			sql = "select * from offrestage";
			try {
				PreparedStatement st = Connexion.getCn().prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					OffreStage o= new OffreStage();
					o.setLibeleOffre(rs.getString(3));
					o.setDescriptifOffre(rs.getString(4));
					o.setDomaine(rs.getString(5));
					date = rs.getString(6);//la date en String
					myDate = LocalDate.parse(date);
					o.setDateD(myDate);
					o.setDuree(rs.getInt(7));
					o.setCheminOffre(rs.getString(8));
					o.setValide(rs.getInt(9));
					//rajout
					o.setIdeEntreprise(rs.getInt(2));
					o.setNomEntreprise(getEntrepriseNameFromDB(o.getIdeEntreprise()));
					o.setVilleOffreStage(getEntrepriseVilleFromDB(o.getIdeEntreprise()));
					o.setMailOffreStage(getEntrepriseMailFromDB(o.getIdeEntreprise()));
					o.setIdOffreStage(rs.getInt(1));
					//---- fin rajout
					offres.add(o);
					//System.out.println(o.toString());
				}
				st.close();
			} catch (SQLException e) {
				
				System.out.println("Erreur SQL dans la table " + objet.getClass().getName());
			}
			return offres;
		}
		else if(objet instanceof Authentification){
			ArrayList<Authentification> auth = new ArrayList<Authentification>();
			sql = "SELECT * FROM `authentification`";
			try {
				PreparedStatement st = Connexion.getCn().prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					Authentification o= new Authentification();
					o.setIdAuthentification(Integer.parseInt(rs.getString(1)));
					o.setLogin(rs.getString(2));
					o.setPassword(rs.getString(3));
					o.setType(rs.getString(4));
					auth.add(o);
				}
				st.close();
				return auth;
			} catch (SQLException e) {
				
				System.out.println("Erreur SQL dans la table " + objet.getClass().getName());
			}
			return auth;
		}
		else if(objet instanceof Postuler){
			ArrayList<Postuler> postuleList = new ArrayList<Postuler>();
			sql = "SELECT * FROM `postuler` ";
			try {
				PreparedStatement st = Connexion.getCn().prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					Postuler p= new Postuler();
					p.setIdPostuler(Integer.parseInt(rs.getString(1)));
					p.setReponse(Integer.parseInt(rs.getString(4)));
					p.setIdUtil(Integer.parseInt(rs.getString(2)));
					p.setIdOffre(Integer.parseInt(rs.getString(2)));
					
					postuleList.add(p);
				}
				st.close();
				return postuleList;
			} catch (SQLException e) {
				
				System.out.println("Erreur SQL dans la table postuler");
			}
			return postuleList;
		}
		return array;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Entreprise> extractAllEntrepriseFromDB(){
		return (ArrayList<Entreprise>) extractFromDB(new Entreprise());
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<OffreStage> extractOffreDeStage(){
		return  (ArrayList<OffreStage>) extractFromDB(new OffreStage());
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Authentification> extractAuthentificationFromDB(){
		return (ArrayList<Authentification>) extractFromDB(new Authentification());
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Postuler> extractAllPostulerFromDB(){
		return (ArrayList<Postuler>) extractFromDB(new Postuler());
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Utilisateur> extractAllUtilisateurFromDB(){
		return (ArrayList<Utilisateur>) extractFromDB(new Utilisateur());
	}
	
	//utile pour la saisie d'une offre dans le combobox
	public static ArrayList<String> extractEntrepriseName(){
		ArrayList<String> noms = new ArrayList<String>();
		String sql = "SELECT nom FROM entreprise";
		try {
			PreparedStatement st = Connexion.getCn().prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				noms.add(rs.getString(1));
			}
			st.close();
			return noms;
		} catch (SQLException e) {
			System.out.println("A problem during sql query execution");
			e.printStackTrace();
		}
		return noms;
	}

	public static int getEntrepriseIDEFromDB(String nomEntreprise) {
		String sql = "SELECT IDE FROM entreprise WHERE nom = '"+ nomEntreprise + "' LIMIT 1;";
		int res=0;
		String res2=null;
		try {
			PreparedStatement st = Connexion.getCn().prepareStatement(sql);
			//System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				res2= rs.getString(1);
			}
			res= Integer.parseInt(res2);
			return res;
			//st.close();
		} catch (SQLException e) {
			System.out.println("A problem during sql query execution");
			e.printStackTrace();
			//return null;
		}
		return res;	
	}
	
	public static String getEntrepriseVilleFromDB(int ide_Entreprise){
		String sql = "SELECT ADRESSEVILLE FROM entreprise WHERE ide = "+ ide_Entreprise + ";";
		String res=null;
		try {
			PreparedStatement st = Connexion.getCn().prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				res=rs.getString(1);
				return res;
			}
		} catch (SQLException e) {
			System.out.println("A problem during sql query execution, getEntrepriseVilleFromDB()");
			e.printStackTrace();
		}
		return res;
	}
	
	public static String getEntrepriseMailFromDB(int ide_Entreprise){
		String sql = "SELECT mail FROM entreprise WHERE ide = "+ ide_Entreprise + ";";
		String res=null;
		try {
			PreparedStatement st = Connexion.getCn().prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				res=rs.getString(1);
				return res;
			}
		} catch (SQLException e) {
			System.out.println("A problem during sql query execution, getEntrepriseMailFromDB(");
			e.printStackTrace();
		}
		return res;
	}
	
	public static String getEntrepriseNameFromDB(int ide_Entreprise){
		String sql = "SELECT nom FROM entreprise WHERE ide = "+ ide_Entreprise + ";";
		String res=null;
		try {
			PreparedStatement st = Connexion.getCn().prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				res=rs.getString(1);
				return res;
			}
		} catch (SQLException e) {
			System.out.println("A problem during sql query execution, getEntrepriseMailFromDB(");
			e.printStackTrace();
		}
		return res;
	}
	
	

	
	public static ArrayList<OffreStage> extractOffreDeStageFromDB(int ide){
		ArrayList<OffreStage> offres = new ArrayList<OffreStage>();
		String date;
		LocalDate myDate;
		String sql = "select * from offrestage where IDE = " + ide;
		try {
			PreparedStatement st = Connexion.getCn().prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				OffreStage o= new OffreStage();
				o.setLibeleOffre(rs.getString(3));
				o.setDescriptifOffre(rs.getString(4));
				o.setDomaine(rs.getString(5));
				date = rs.getString(6);//la date en String
				myDate = LocalDate.parse(date);
				o.setDateD(myDate);
				o.setDuree(rs.getInt(7));
				o.setCheminOffre(rs.getString(8));
				o.setValide(rs.getInt(9));
				o.setIdeEntreprise(rs.getInt(2));
				o.setNomEntreprise(getEntrepriseNameFromDB(o.getIdeEntreprise()));
				o.setVilleOffreStage(getEntrepriseVilleFromDB(o.getIdeEntreprise()));
				o.setMailOffreStage(getEntrepriseMailFromDB(o.getIdeEntreprise()));
				o.setIdOffreStage(rs.getInt(1));
				offres.add(o);
				//System.out.println(o.toString());
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Erreur SQL dans la table offrestage");
		}
		return offres;
	}
	

	private static boolean deleteToDB(Object objet , int idObject){
		String sql="";
		boolean res = false;
		if(objet instanceof Entreprise){
			sql = "DELETE FROM `entreprise` WHERE IDE = "+idObject +";";
			res = request( objet , sql);
		}
		return res;
	}
	
	public static boolean deleteEntrepriseFromDB(int ide){
		return deleteToDB(new Entreprise() , ide);
	}
	
	private static boolean updateToDB(Object objet , int idObject){
		String sql="";
		boolean res = false;
		if(objet instanceof Entreprise){
			Entreprise e = (Entreprise) objet;
			 sql = "UPDATE `entreprise` SET `NOM`="+"'"+e.getNom()+"'"+
					 ",`ADRESSENUMERORUE`="+"'"+e.getAdresseNumeroRue()+"'"+",`ADRESSECODEPOSTAL`="+e.getAdresseCodePostal()+
					 ",`ADRESSEVILLE`="+"'"+e.getAdresseVille()+"'"+",`MAIL`="+"'"+e.getMail()+"'"+",`TELEPHONE`="+e.getTelephone()+
					 ",`SECTEURACTIVITE`="+"'"+e.getSecteurActivite() +"'"+" WHERE `IDE`="+e.getIde()+";";
			 //System.out.println(sql);
			res = request( objet , sql);
		}
		return res;
	}
	
	public static boolean updateEntrepriseFromDB(Entreprise e){
		int ide = Integer.parseInt(e.getIde());
		return updateToDB(e, ide);
	}
	public static int getIDThingsFromObjet(Object objet){
		String sql ="";
		if(objet instanceof Utilisateur){
			Utilisateur ut = (Utilisateur) objet;
			sql = "SELECT * FROM `utilisateur` WHERE nom = ";
			sql = sql + "'" +ut.getNom()+ "'" + " AND prenom = ";
			sql = sql + "'" +ut.getPrenom()+ "'" + " AND mail =";
			sql = sql + "'" +ut.getMail()+ "' LIMIT 1";
			try {
				PreparedStatement st = Connexion.getCn().prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					ut.setIdUtilisateur(Integer.parseInt(rs.getString(1)));
				}
				st.close();
				return ut.getIdUtilisateur();
			} catch (SQLException e) {
				
				System.out.println("Erreur SQL dans la table " + objet.getClass().getName());
			}		
		}
		else if(objet instanceof Entreprise){
			
			Entreprise ent = (Entreprise) objet;
			sql = "SELECT * FROM `entreprise` WHERE nom = ";
			sql = sql + "'" +ent.getNom()+ "'" + " AND SECTEURACTIVITE = ";
			sql = sql + "'" +ent.getSecteurActivite()+ "'" + " AND mail =";
			sql = sql + "'" +ent.getMail()+ "' LIMIT 1";
			try {
				PreparedStatement st = Connexion.getCn().prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					ent.setIde(rs.getString(1));
				}
				st.close();
				return Integer.parseInt(ent.getIde());
			} catch (SQLException e) {
				
				System.out.println("Erreur SQL dans la table " + objet.getClass().getName());
			}
		}
		return 0;
	}

	//public static void main(String[] args){
//		ArrayList<Entreprise> auth=Database.extractAllEntrepriseFromDB();
//		System.out.println("Taille liste authentification = " + auth.size());
//		for (int i=0; i<auth.size(); i++) {
//			System.out.println(auth.get(i).toString());
//			System.out.println("----------------------------------------");
//		}
		//System.out.println(updateToDB(new Entreprise(),16));
	//}
}
