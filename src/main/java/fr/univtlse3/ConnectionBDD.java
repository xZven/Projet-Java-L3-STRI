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
public class ConnectionBDD {

    public ConnectionBDD() throws ClassNotFoundException, SQLException {    
    Class.forName("org.postgresql.Driver");
    // System.out.println("Driver O.K.");

    String url = "jdbc:postgresql://localhost:5432/Ecole";
    String user = "postgres";
    String passwd = "postgres";

    Connection conn = DriverManager.getConnection(url, user, passwd);
    // System.out.println("Connexion effective !");              
    }
}
