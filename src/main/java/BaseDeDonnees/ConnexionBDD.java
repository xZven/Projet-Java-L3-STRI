
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
    
    /* MISE A JOUR EN BASE DE DONNEES : MEHODE UPDATE */
    // Mise à jour des interfaces réseaux non implémentées.
    
    /**
     * Permet de mettre à jour un batiment et l'ensemble des informations associées.
     * @param b Batiment à mettre à jour.
     * @param oldName ancien nom du batiment à mettre à jour.
     * @throws java.sql.SQLException
     */
    public void updateAllBatiment(Batiment b, String oldName) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE batiment SET nom=?, localisation=?, description=? where batiment.nom=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, b.getNom());
        state.setString(1, b.getLocalisation());
        state.setString(2, b.getDescription());
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour le nom d'un batiment.
     * @param newName nouveau nom donné au batiment.
     * @param oldName ancien nom du batiment à mettre à jour.
     * @throws java.sql.SQLException
     */
    public void updateNameOfBatiment(String newName, String oldName) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE batiment SET nom=? where nom=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, newName);
        state.setString(1, oldName);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour la description d'un batiment.
     * @param name nom du batiment.
     * @param description description du batiment à mettre à jour.
     * @throws SQLException 
     */
    public void updateDescriptionOfBatiment(String name, String description) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE batiment SET description=? where nom=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, description);
        state.setString(1, name);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close(); 
    }
    
    
    /**
     * Permet de mettre à jour les informations d'une salle appartenant à un batiment donné.
     * @param s Salle à mettre à jour.
     * @param nameBatiment nom du batiment de la salle à mettre à jour.
     * @throws java.sql.SQLException
     */
    public void updateSalleOfBatiment(Salle s, String nameBatiment) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE salle SET numero=?, etage=?, nom=? where (salle.batiment=? and salle.id=?)");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, s.getNumero());
        state.setInt(1, s.getEtage());
        state.setString(2, s.getNom());
        state.setString(3, nameBatiment);
        state.setInt(4, s.getId());
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour les informations d'une salle.
     * @param s Salle à mettre à jour.
     * @throws java.sql.SQLException
     */
    public void updateAllSalle(Salle s) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE salle SET numero=?, etage=?, nom=? where salle.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, s.getNumero());
        state.setInt(1, s.getEtage());
        state.setString(2, s.getNom());
        state.setInt(3, s.getId());
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour le nom d'une salle.
     * @param id Identifiant de la salle en base de données à mettre à jour.
     * @param nom nouveau nom de la salle.
     * @throws java.sql.SQLException
     */
    public void updateNameOfSalle(int id, String nom) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE salle SET nom=? where salle.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, nom);
        state.setInt(1, id);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour le numéro d'une salle.
     * @param id identifiant de la salle en base de données à mettre à jour.
     * @param numero nouveau numéro de la salle.
     * @throws java.sql.SQLException
     */
    public void updateNumeroOfSalle(int id, String numero) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE salle SET numero=? where salle.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, numero);
        state.setInt(1, id);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour une machine.
     * @param m Machine à mettre à jour.
     * @param idSalle identifiant de la salle en base de données : -1 pour ne pas tenir compte du paramètre.
     * @throws java.sql.SQLException
     */
    public void updateAllMachine(Machine m, int idSalle) throws SQLException
    {
        PreparedStatement state;
        if(idSalle != -1)
        {
            // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
            state = connexion.prepareStatement("UPDATE machine SET nom=?, marque=?, modele=?, os=?, firmware=?, etat=?, salle=?, typem=? where machine.id=?");
            state.setInt(6, idSalle);
            state.setString(7, m.getType());
            state.setInt(8, m.getId());
        }
        else
        {
            state = connexion.prepareStatement("UPDATE machine SET nom=?, marque=?, modele=?, os=?, firmware=?, etat=?, typem=? where machine.id=?");
            state.setString(6, m.getType());
            state.setInt(7, m.getId());
        }
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, m.getNom());
        state.setString(1, m.getMarque());
        state.setString(2, m.getModele());
        state.setString(3, m.getOS());
        state.setString(4, m.getFirmware());
        state.setBoolean(5, m.isEtat());
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour le nom d'une machine.
     * @param id identifiant de la machine en base de données.
     * @param nom nouveau nom de la machine.
     * @throws java.sql.SQLException
     */
    public void updateNomOfMachine(int id, String nom) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE machine SET nom=? where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, nom);
        state.setInt(1, id);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour l'os d'une machine.
     * @param id identifiant de la machine en base de données.
     * @param os nouveau os de la machine.
     * @throws java.sql.SQLException
     */
    public void updateOSOfMachine(int id, String os) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE machine SET os=? where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, os);
        state.setInt(1, id);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour le firmware d'une machine.
     * @param id identifiant de la machine en base de données.
     * @param firmware nouveau firmware de la machine.
     * @throws java.sql.SQLException
     */
    public void updateFirmwareOfMachine(int id, String firmware) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE machine SET firmware=? where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, firmware);
        state.setInt(1, id);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour l'état d'une machine.
     * @param id identifiant de la machine en base de données.
     * @param etat nouvel etat de la machine.
     * @throws java.sql.SQLException
     */
    public void updateEtatOfMachine(int id, boolean etat) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE machine SET etat=? where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setBoolean(0, etat);
        state.setInt(1, id);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour la salle associée à une machine.
     * @param idMachine identifiant de la machine en base de données.
     * @param idSalle identifiant de la salle en base de donénes.
     * @throws java.sql.SQLException
     */
    public void updateSalleOfMachine(int idMachine, int idSalle) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE machine SET salle=? where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, idSalle);
        state.setInt(1, idMachine);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de mettre à jour le type d'une machine.
     * @param id Identifiant de la machine en base de données.
     * @param type Type de la machine (Routeur, Pont, Commutateur, Ordinateur fixe, Ordinateur portable).
     * @throws java.sql.SQLException
     */
    public void updateTypeOfMachine(int id, String type) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("UPDATE machine SET typem=? where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, type);
        state.setInt(1, id);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /* INSERTION EN BASE DE DONNEES : MEHODE INSERT */
    
    /**
     * Permet d'ajouter un nouveau batiment.
     * @param b Batiment à rajouter en base de données.
     * @return l'identifiant "nom" du batiment en base de données.
     * @throws java.sql.SQLException
     */
    public String insertBatiment(Batiment b) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("INSERT INTO batiment (nom, localisation, description) VALUES (?, ?, ?)");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, b.getNom());
        state.setString(1, b.getLocalisation());
        state.setString(2, b.getDescription());
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
        return b.getNom();
    }
    
    /**
     * Permet d'ajouter une salle à un batiment.
     * @param s Salle à rajouter en base de données.
     * @param nomBatiment nom du batiment pour l'ajout d'une salle.
     * @return le dernier identifiant "id" de la salle ajouter en base de données.
     * @throws java.sql.SQLException
     */
    public int insertSalleIntoBatiment(Salle s, String nomBatiment) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("INSERT INTO salle (numero, etage, batiment) VALUES (?, ?, ?)");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, s.getNumero());
        state.setInt(1, s.getEtage());
        state.setString(2, nomBatiment);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
        Statement lastID = connexion.createStatement();
        ResultSet result = lastID.executeQuery("SELECT LAST_INSERT_ID()");
        result.next();
        int id = result.getInt("LAST_INSERT_ID()");
        result.close();
        lastID.close();
        return id;
    }
    
    /**
     * Permet d'ajouter une machine à une salle.
     * @param m Machine à rajouter en base de données.
     * @param idSalle identifiant de la salle en base de données où la machine doit être ajoutée.
     * @return identifiant "id" de la machine en base de données.
     * @throws SQLException 
     */
    public int insertMachineIntoSalle(Machine m, int idSalle) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("INSERT INTO machine (nom, marque, os, firmware, etat, salle, typem) VALUES (?, ?, ?, ?, ?, ?, ?)");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, m.getNom());
        state.setString(1, m.getMarque());
        state.setString(2, m.getOS());
        state.setString(3, m.getFirmware());
        state.setBoolean(4, m.isEtat());
        state.setInt(5, idSalle);
        state.setString(6, m.getType());
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
        Statement lastID = connexion.createStatement();
        ResultSet result = lastID.executeQuery("SELECT LAST_INSERT_ID()");
        result.next();
        int id = result.getInt("LAST_INSERT_ID()");
        result.close();
        lastID.close();
        // On ajoute les interfaces réseaux en base de données : 
        insertInterfaceReseauOnMachine(id, m);
        return id;
    }
    
    // Implémenté pour compatibilité avec le JTree et l'affichage graphique :
    /**
     * 
     * @param idMachine
     * @param m
     * @throws SQLException 
     */
    private void insertInterfaceReseauOnMachine(int idMachine, Machine m) throws SQLException
    {
        // Pour l'ensemble des interfaceRéseaux de la machine considérée :
        /* Ethernet, Token Bus, Token Ring, Wifi 2.4, Bluetooth, ProfiBUS, CAN, ZigBee, Wifi 5.0 */
        ArrayList<Interface> interfaceMachine = m.getInterfaceReseau();
        for(Interface i : interfaceMachine)
        {
            // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
           PreparedStatement state = connexion.prepareStatement("INSERT INTO interfacereseau (mac, ipv4, ipv6, etat, machine, typer) VALUES (?, ?, ?, ?, ?, ?)");
           // Préparation de la requête avant exécution de celle-ci :
           state.setString(0, i.getAdresseMAC());
           state.setString(1, i.getAdresseIP());
           // Adresse IPv6 non implémentée :
           state.setString(2, "");
           // Etat de l'interface non implémentée :
           state.setBoolean(3, true);
           state.setInt(4, idMachine);
           state.setString(5, i.getType());
           // Récupéaratino des valeurs lues en base de données :
           int res = state.executeUpdate();
           // On met fin au statement et au resultSet :
           state.close();
        }
    }
    
    /* SUPPRESSION EN BASE DE DONNEES : MEHODE DELETE */
    
    /**
     * Permet de supprimer un batiment et tous les éléments associés en base de données (salle, machine et interface).
     * @param nomBatiment nom du batiment à supprimer en base de données.
     * @throws java.sql.SQLException
     */
    public void deleteBatimentAndAllAssociated(String nomBatiment) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("DELETE FROM batiment where batiment.nom=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setString(0, nomBatiment);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de supprimer une salle et tous les éléments associés en base de données (machine, interface).
     * @param idSalle identifiant la salle en base de données.
     * @throws java.sql.SQLException
     */
    public void deleteSalleAndAllAssociated(int idSalle) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("DELETE FROM salle where salle.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, idSalle);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
    
    /**
     * Permet de supprimer une machine et tous les élémentd associées en base de donénes (interface...).
     * @param idMachine  identifiant la machine en base de données.
     * @throws java.sql.SQLException
     */
    public void deleteMachineAndAllAssociated(int idMachine) throws SQLException
    {
        // Création du statement nous permettant de réaliser des instructions en base de données en limitant les injections SQL :
        PreparedStatement state = connexion.prepareStatement("DELETE FROM machine where machine.id=?");
        // Préparation de la requête avant exécution de celle-ci :
        state.setInt(0, idMachine);
        // Récupéaratino des valeurs lues en base de données :
        int res = state.executeUpdate();
        // On met fin au statement et au resultSet :
        state.close();
    }
}
