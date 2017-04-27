package database;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    /**
     *
     * @author rado
     */
    public class Connexion {
        private static String login = "root";
        private static String password = "";
        private static String url = "jdbc:mysql://localhost/gestionoffrestage";//"jdbc:mysql://localhost:3306/gestionoffrestage"
        private static Connection cn;
        static {
            try {
                //Etape 1 : Charger le driver de la base de donnees
                // cible
                Class.forName("com.mysql.jdbc.Driver");
                //Etape 2 : Authentification aupres de la base de donnees
                // et selectionner le schema
                cn = (Connection) DriverManager.getConnection(url, login, password);
                System.out.println("creation de connexion");
            } catch (ClassNotFoundException ex) {
                System.out.println("Impossible de charger le driver");
            } catch (SQLException ex) {
                System.out.println("Erreur de connexion");
            }
        }
        public static Connection getCn() {
            return cn;
        }
        
    }
