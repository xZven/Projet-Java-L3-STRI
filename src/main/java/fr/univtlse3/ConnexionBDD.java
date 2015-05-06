/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univtlse3;

import java.sql.*;

/**
 *
 * @author Tempête
 */
public class ConnexionBDD {

    private Connection connexion;
    private final String url;
    private final String user;
    private final String password;
    
    /**
     * Constructeur redéfini permettant de parametrer la connexion à la base de données.
     * @param url Identifie l'url de connexion à la Base de Données (jdbc:postgresql://host:port/Base).
     * @param user Identifie l'utilisateur de la base de données. (postgres par défaut)
     * @param password // Identifie le mot de passe de la base de données (en local sur mon PC : gregory).
     * @throws ClassNotFoundException Erreur lors du chargement de la classe jdbc permettant la conexion à la base de données.
     */
    public ConnexionBDD(String url, String user, String password) throws ClassNotFoundException {    
    // Chargement des drivers postgresql :
    Class.forName("org.postgresql.Driver");
    this.url=url;
    this.user=user;
    this.password=password;            
    }
    
    /**
     * 
     * @return
     * @throws SQLException Erreur lors de l'ouverture de la connexion à la base de données.
     */
    public Connection initConnexion() throws SQLException
    {
        // Connexion à la base de données :
        return DriverManager.getConnection(url, user, password); 
    }
    
}
