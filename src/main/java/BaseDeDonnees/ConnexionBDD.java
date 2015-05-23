
package BaseDeDonnees;

import Metier.Batiment;
import Metier.Interface;
import Metier.Machine;
import Metier.Salle;
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
    
    /**
     * Permet de fermer proprement la connexion à la base de données.
     * @throws SQLException 
     */
    public void closeConnexionBDD() throws SQLException
    {
        connexion.close();
    }
    
    /*** LECTURE EN BASE DE DONNEES : MEHODE SELECT ***/
    /**
     * Permet de récupérer en base de données l'ensemble des batiments et des informations associés.
     * @return ArrayList<> avec l'ensemble des informations associées à un batiment.
     * @throws java.sql.SQLException
     */
    public ArrayList<Batiment> getAllBatiment() throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT nom, localisation, description FROM batiment");
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        ArrayList<Batiment> batiment = new ArrayList<>();
        ArrayList<Salle> salle;
        while(res.next())
        {
            String nomBatiment = res.getString("nom");
            Batiment b = new Batiment(nomBatiment, res.getString("localisation"), res.getString("description"));
            salle = getAllSalleFromBatiment(nomBatiment);
            b.setSalles(salle);
            batiment.add(b);
        }
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return batiment;
    }
    
    /**
     * 
     * @param nom du batiment.
     * @return String indiquant la localisation du batiment.
     * @throws java.sql.SQLException
     */
    public String getLocalisationOfBatiment(String nom) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT nom, localisation FROM batiment where batiment.nom=?");
        // Récupéaratino des valeurs lues en base de données :
        state.setString(0, nom);
        ResultSet res = state.executeQuery();
        res.next(); // Permet de sélectionner la première ligne.
        String localisation = res.getString(nom);
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return localisation;
    }
    
    /**
     * 
     * @param nom du batiment.
     * @return String indiquant la description du batiment.
     * @throws java.sql.SQLException
     */
    public String getDescriptionOfBatiment(String nom) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT nom, description FROM batiment where batiment.nom=?");
        // Récupéaratino des valeurs lues en base de données :
        state.setString(0, nom);
        ResultSet res = state.executeQuery();
        res.next(); // Permet de sélectionner la première ligne.
        String description = res.getString(nom);
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return description;
    }
    
    /**
     * 
     * @param nom du batiment.
     * @return ArrayList<> avec l'ensemble des informations associées à une salle.
     * @throws java.sql.SQLException
     */
    public ArrayList<Salle> getAllSalleFromBatiment(String nom) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, numero, etage, nom, batiment FROM salle where salle.batiment=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, nom);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        ArrayList<Salle> salle = new ArrayList<>();
        ArrayList<Machine> machine;
        while(res.next())
        {
            Salle s = new Salle(res.getString("nom"), res.getString("numero"), res.getInt("etage"));
            // On renseigne le champ id :
            int identifiant = res.getInt("id");
            s.setId(identifiant);
            // Obtention de la liste des machines d'une salle donnée :
            machine = getAllMachineFromSalle(identifiant);
            s.setMachines(machine);
            salle.add(s);
        }
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return salle;
    }
   
    /**
     * 
     * @param id indiquant la référence de la salle en base de données.
     * @return String indiquant le nom de la salle.
     * @throws java.sql.SQLException
     */
    public String getNomOfSalle(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, nom FROM salle where salle.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String nom = res.getString("nom");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return nom;
    }

    /**
     * 
     * @param id indiquant la référence de la salle en base de données.
     * @return String indiquant le numéro de la salle.
     * @throws java.sql.SQLException
     */
    public String getNumeroOfSalle(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, numero FROM salle where salle.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String numero = res.getString("numero");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return numero;
    }
    
    /**
     * 
     * @param id indiquant la référence de la salle en base de données.
     * @return String indiquant l'étage de la salle.
     * @throws java.sql.SQLException
     */
    public int getEtageOfSalle(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, etage FROM salle where salle.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        int etage = res.getInt("etage");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return etage;
    }
    
    /**
     * 
     * @param id indiquant la référence de la salle en base de données.
     * @return Batiment associé à la salle avec l'ensemble des informations associées au batiment.
     * @throws java.sql.SQLException
     */
    public Batiment getBatimentOfSalle(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT nom, localisation, description FROM batiment where batiment.nom=(SELECT batiment FROM salle where salle.id=?)");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String nomBatiment = res.getString("nom");
        Batiment batiment = new Batiment(nomBatiment, res.getString("localisation"), res.getString("description"));
        // Ajout des informations des salles du batiment :
        ArrayList<Salle> s = getAllSalleFromBatiment(nomBatiment);
        batiment.setSalles(s);
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return batiment;
    }
    
    // + Méthodes pour les machines des salles permettant de ne récupérer qu'un seul type d'élément par nature.
    /* Routeur, Pont, Commutateur, Ordinateur fixe, Ordinateur portable, Ordinateur, Equipements mobiles, Equipements réseaux... */
    
    /**
     * 
     * @param id indiquant la référence de la salle en base de données.
     * @return ArrayList<> contenant l'ensemble des machines associées à la salle.
     * @throws java.sql.SQLException
     */
    public ArrayList<Machine> getAllMachineFromSalle(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, nom, marque, modele, os, firmware, etat, salle, typem FROM machine where machine.salle=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        ArrayList<Machine> machine = new ArrayList<>();
        ArrayList<Interface> interfaceMachine = new ArrayList<>();
        while(res.next())
        {
            boolean etat = false;
            if(res.getInt("etat")==1)
            {
                etat=true;
            }
            Machine m = new Machine(res.getString("nom"), res.getString("marque"), res.getString("modele"), res.getString("os"), res.getString("firmware"), res.getString("typem"), etat);
            // On renseigne le champ id : 
            int identifiant = res.getInt("id");
            m.setId(identifiant);
            // Pour l'ensemble des machines, on sélectionne la liste des interfaces de celle-ci [ainsi que la liste des unités processeurs] :
            PreparedStatement stateInterface = connexion.prepareStatement("SELECT mac, ipv4, ipv6, typer, etat, machine FROM interfacereseau where interfacereseau.machine=?;");
            stateInterface.setInt(0, identifiant);
            ResultSet resInterface = stateInterface.executeQuery();
            while(resInterface.next())
            {
                Interface i = new Interface(resInterface.getString("mac"), resInterface.getString("ipv4"), resInterface.getString("typer"));
                // Ajout de l'état de l'interface :
                etat = false;
                if(res.getInt("etat")==1)
                {
                    etat=true;
                }
                i.setEtat(etat);
                interfaceMachine.add(i);
            }
            m.setInterfaceReseau(interfaceMachine);
            machine.add(m);
            // On met fin au statement et au resultSet :
            resInterface.close();
            stateInterface.close();
        }
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return machine;
    }
    
    /**
     * 
     * @param id indiquant la référence de la machine en base de données.
     * @return boolean : true si la machine est allumée, false si elle est éteinte.
     * @throws java.sql.SQLException
     */
    public boolean getEtatMachine(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, etat FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        boolean etat = false;
        if(res.getInt("etat")==1)
        {
            etat=true;
        }  
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return etat;
    }
    
    /**
     * 
     * @param id indiquant la référence de la machine en base de données.
     * @return String indiquant la nature de la machine (Ordinateur portable, Tablette, 
     * Ordnateur fixe, PDA, SmartPhone, Routeur, Commutateur, Pont, Autre).
     * @throws java.sql.SQLException
     */
    public String getTypeMachine(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, typem FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String typeMachine = res.getString("typem");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return typeMachine;
    }
    
    /**
     * 
     * @param id indiquant la référence de la machine en base de données.
     * @return String indiquant le firmware de la machine.
     * @throws java.sql.SQLException
     */
    public String getFirmwareMachine(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, firmware FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String firmware = res.getString("firmware");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return firmware;
    }
    
    /**
     * 
     * @param id indiquant la référence de la machine en base de données.
     * @return String indiquant le système d'exploitation de la machine.
     * @throws java.sql.SQLException
     */
    public String getOSMachine(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, os FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String os = res.getString("os");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return os;
    }
    
    /**
     * 
     * @param id indiquant la référence de la machine en base de données.
     * @return String indiquant le modele de la machine.
     * @throws java.sql.SQLException
     */
    public String getModeleMachine(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, modele FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String modele = res.getString("modele");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return modele;
    }
    
    /**
     * 
     * @param id indiquant la référence de la machine en base de données.
     * @return String indiquant la marque de la machine.
     * @throws java.sql.SQLException
     */
    public String getMarqueMachine(int id) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, marque FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String marque = res.getString("marque");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return marque;
    }
    
    /**
     * 
     * @param id indiquant la référence de la machine en base de données.
     * @return String indiquant le nom de la machine.
     * @throws java.sql.SQLException
     */
    public String getNomMachine(int id) throws SQLException
    {
         // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("SELECT id, nom FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, id);
        // Récupéaratino des valeurs lues en base de données :
        ResultSet res = state.executeQuery();
        res.next();
        String nom = res.getString("nom");
        // On met fin au statement et au resultSet :
        res.close();
        state.close();
        return nom;
    }
    
}
