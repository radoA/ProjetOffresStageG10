package metiers;

import java.security.MessageDigest;

public class Authentification {
	private int idAuthentification;
	private String login;
	private String password;
	private String type;
	private int idType;
	
	public Authentification(){
		idAuthentification=0;
		login="";
		password="";
		type="";
		idType=0;
	}
	
	public Authentification(String log, String pass, int idT){
		try {
			if(VerificationFormulaire.validateMail(log)){
				login=log;
			}
			else{
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("Authentification, erreur login");
			e.printStackTrace();
		}
		try {
			if(pass.equals("")){
				throw new Exception();
			}
			password=md5(pass);
		} catch (Exception e) {
			System.out.println("Authentification, erreur mot de passe");
			e.printStackTrace();
		}
		idType = idT;
	}
	
	public Authentification(String log, String pass, String typ, int idT){
		login=log;
		password=md5(pass);
		type=typ;
		idType = idT;
	}
	
    public int getIdAuthentification() {
		return idAuthentification;
	}

	public String getLogin() {
		return login;
	}
	
	

	public void setIdAuthentification(int idAuthentification) {
		this.idAuthentification = idAuthentification;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = md5(password);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static String md5( String source ) {
        try {
            MessageDigest md = MessageDigest.getInstance( "MD5" );
            byte[] bytes = md.digest( source.getBytes("UTF-8") );
            return getString( bytes );
        } catch( Exception e )	{
            e.printStackTrace();
            return null;
        }
    }

    private static String getString( byte[] bytes )
    {
        StringBuffer sb = new StringBuffer();
        for( int i=0; i<bytes.length; i++ )
        {
            byte b = bytes[ i ];
            String hex = Integer.toHexString((int) 0x00FF & b);
            if (hex.length() == 1)
            {
                sb.append("0");
            }
            sb.append( hex );
        }
        return sb.toString();
    }
    

	public static void test(String[] args){
    	System.out.println(md5("rado"));
    }
	
	public String verifierChamp(String login, String mdp){
		return "";
	}
	
	public boolean equals(Object obj){
		if (obj!= null && (obj.getClass().equals(this.getClass()))){
			Authentification tmp = (Authentification) obj;
			return (  login.equals(tmp.getLogin()) && password.equals(md5(tmp.getPassword()))   )  ;
		}
		return false;
		
	}
	public boolean equals(Authentification tmp){
		return (  login.equals(tmp.getLogin()) && password.equals(md5(tmp.getPassword()))  )  ;
		
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	@Override
	public String toString() {
		return "Authentification [idAuthentification=" + idAuthentification + ", login=" + login + ", password="
				+ password + ", type=" + type + ", idType=" + idType + "]";
	}
	
	
}
