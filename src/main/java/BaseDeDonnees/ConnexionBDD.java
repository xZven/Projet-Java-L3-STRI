
package BaseDeDonnees;

import Metier.Batiment;
import java.sql.*;
import java.util.ArrayList;

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
     * @param url Identifie l'url de connexion à la Base de Données (jdbc:postgresql://host:port/Base).
     * @param user Identifie l'utilisateur de la base de données. (postgres par défaut)
     * @param password // Identifie le mot de passe de la base de données (en local sur mon PC : gregory).
     * @throws ClassNotFoundException Erreur lors du chargement de la classe jdbc permettant la conexion à la base de données.
     * @throws java.sql.SQLException
     */
    public ConnexionBDD(String url, String user, String password) throws ClassNotFoundException, SQLException {    
            // Chargement des drivers postgresql :
            Class.forName("org.postgresql.Driver");
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
    
    // A Terminer : Attente requête Nicolas
    public ArrayList<Batiment> getAllBatimentsObject()
    {
        // Requête SQL permettant de récupérer l'ensemble des batiments ainsi que leurs attributs :
        return new ArrayList<Batiment>();
    }
    
    // A terminer : Attente requête Nicolas
    public ArrayList<Batiment> getAllBatimentsName()
    {
        // Requête SQL permettant de récupérer l'ensemble des noms des batiments :
        return new ArrayList<Batiment>();
    }
    
    // A terminer : Attente requête Nicolas
    public ArrayList<Batiment> getAllBatimentsNameAndSalles()
    {
        // Requête SQL permettant de récupérer l'ensemble des noms des batiments ainsi que leurs salles :
        return new ArrayList<Batiment>();
    }
    
    /*
    
    ConnexionBDD bdd = new ConnexionBDD("jdbc:postgresql://127.0.0.1:5432/java", "postgres", "gregory");
            Connection id = bdd.initConnexion();
            // Requête de test :
            Statement state = id.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM machine");
            ResultSetMetaData resultMetaData = result.getMetaData();
            System.out.println(resultMetaData.getCatalogName(1).toString());
    
    */
}
