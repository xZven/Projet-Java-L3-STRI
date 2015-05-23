
package BaseDeDonnees;

import java.sql.*;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * 
 * Cette class représente de manière générique tous les types d'équipements
 * que l'on peut avoir à gérer dans un système d'informatique.
 * 
 * @version 1.0, 
 */
public final class ConnexionBDD {

    private final Connection connexion;
    private final String url;
    private final String user;
    private final String password;
        
    /**
     * Constructeur redéfini permettant de parametrer la connexion à la base de données.
     * @param url Identifie l'url de connexion à la Base de Données (jdbc:mysql://host:port/Base).
     * @param user Identifie l'utilisateur de la base de données. (java)
     * @param password // Identifie le mot de passe de la base de données (java).
     * @throws ClassNotFoundException Erreur lors du chargement de la classe jdbc permettant la conexion à la base de données.
     * @throws java.sql.SQLException
     */
    public ConnexionBDD(String url, String user, String password) throws ClassNotFoundException, SQLException {    
            // Chargement des drivers postgresql :
            Class.forName("com.mysql.jdbc.Driver");
            this.url=url;
            this.user=user;
            this.password=password;
            // On se connecte à la base de données :
            connexion = initConnexion();
    }
    
    /**
     * Permet d'initialiser la connexion à la base de données.
     * @return
     * @throws SQLException Erreur lors de l'ouverture de la connexion à la base de données.
     */
    private Connection initConnexion() throws SQLException
    {
        // Connexion à la base de données :
        return DriverManager.getConnection(url, user, password); 
    }
        
    /*
    public void test() throws SQLException, ClassNotFoundException
    {
    // ConnexionBDD bdd = new ConnexionBDD("jdbc:mysql://127.0.0.1:3306/java", "java", "java");
            //Connection id = bdd.initConnexion();
            // Requête de test :
            Statement state = connexion.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM machine");
            ResultSetMetaData resultMetaData = result.getMetaData();
            System.out.println(resultMetaData.getCatalogName(1));
    }
    */
    
}
