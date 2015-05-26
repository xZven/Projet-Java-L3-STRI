/*
 * Projet L3 STRI 
 * Device Manager
 *
 */

package Metier;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * <p>
 * Cette classe définit une salle d'un batiment.
 * Elle comporte des ArrayList de machines.
 * </p>
 * 
 * @version 1.0, 2015, UPS.
 */
public class Salle extends JLabel
{
   // Déclarations des attributs :
  
   private ArrayList<Machine> machines;
   // Pas implémenté : 
   private ArrayList<EquipementReseau> eq_reseau;
   private ArrayList<EquipementMobile> eq_mobile;
   private ArrayList<Ordinateur>       ordinateur;
   
   
   private String numero;
   private int etage;
   private String nom;
   private int id;
   
   /**
    * Constructeur Salle
    * 
    * @param nom Nom de la salle.
    * @param numero Numéro de la salle.
    * @param etage  Etage de la salle.
    */
   public Salle(String nom, String numero, int etage) 
   {
       setIcon(new ImageIcon("src/main/java/VueJtree/salles.png"));
   
        this.nom      = nom;
        this.numero   = numero;
        this.etage    = etage;
        machines      = new ArrayList<>();
        eq_reseau     = new ArrayList<>();
        eq_mobile     = new ArrayList<>();
        ordinateur    = new ArrayList<>();
    }

   /**
    * Constructeur de test pour JTree.
    * 
    * @param nom - String: nom de la salle qui sera afficher pour le Jtree.
    */
   public Salle(String nom)
    {
        setIcon(new ImageIcon("src/main/java/VueJtree/salles.png"));
        
        this.nom      = nom;
        this.numero   = "";
        this.etage    = 0;
        machines      = new ArrayList<>();
        eq_reseau     = new ArrayList<>();
        eq_mobile     = new ArrayList<>();
        ordinateur    = new ArrayList<>();
    }
    
   /**
    * Permet de spécifier l'identifiant de la salle.
    * @param id int: indiquant l'identifiant de la salle en base de données.
    */
    public void setId(int id)
    {
        this.id = id;
    }
   
    /**
     * Permet de récupérer l'identifiant de la salle.
     * @return int: identifiant de la salle en base de données.
     */
    public int getId()
    {
        return this.id;
    }
   
   /**
    * Obtenir les machines d'une salle.
    * 
    * @return ArrayList'machine'.
    */
    public ArrayList<Machine> getMachines()
    {
        return machines;
    }

    /**
     * Définir les machines d'une salle en passant une ArrayList'machine'.
     * @param machines ArrayList'machine'.
     */
    public void setMachines(ArrayList<Machine> machines)
    {
        this.machines = machines;
    }

    /**
     * Permet d'obtenir le numéro de la salle.
     * 
     * @return String: Numéro de la salle.
     */
    public String getNumero() 
    {
        return numero;
    }

    /**
     * Permet de définir le numéro de la salle
     * 
     * @param numero String: Numéro à définir
     */
    public void setNumero(String numero) 
    {
        this.numero = numero;
    }

    /**
     * Obtenir l'étage d'une salle
     * 
     * @return l'étage de la salle
     */
    public int getEtage() {
        return etage;
    }

    /**
     * Définir l'étage de la salle.
     * 
     * N.B: Une salle ne peut normalement pas changer d'étage.
     * 
     * @param etage String: nouvel étage à définir.
     */
    public void setEtage(int etage) 
    {
        this.etage = etage;
    }

    /**
     * Obtenir le nom de la salle.
     * 
     * @return String: nom de la salle.
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Définir le nom de la salle.
     * 
     * @param nom String: nouveau nom de la salle.
     */
    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    /**
     * Permet d'ajouter une nouvelle machine à l'ArrayList'machine' d'une salle. 
     * 
     * @param machine Machine: nouvelle machine à ajouter à la salle
     */
    public void addMachine(Machine machine) 
    {
		machines.add(machine);
	}
    
    /**
     * Permet de retirer une machine correspondant à celle passé en paramètre de l'ArrayList'machine'.
     * 
     * @param machine Machine: machine à retirer de la salle.
     */
    public void removeMachine(Machine machine) 
    {
                /* Si la machine n'existe pas dans l'ArrayList */
		if (!machines.contains(machine)) {
                   /* Sortie standard pour test : gestion des erreurs sans la sortie standard console,
                    Utilisation du mode graphique */
			System.out.println("Cette machine n'est pas dans cette salle.");
		} else {
			machines.remove(machine);
		}
    }
    /**
    * Obtenir le nom de la salle.
    * 
    * @return String: Nom de la salle.
    */
   @Override
    public String toString() 
    {
        return (nom);
    }

    /**
     * Obtenir toutes les informations sur la salle de manière formaté ci-dessous:
     * *******DEBUT********
     *  Nom: 
     *  Numéro
     *  Etage:
     *  **********************************
     *  Nombre de machines:
     *  Nombre d'équipement réseaux:
     *  Nombre d'ordinateur:
     *  Nombre d'équipement protable:
     * *******FIN**********
     * 
     * @return String: nom, localisation, description du batiment, nombre d'entités dans la salle.
     */
    public String FullScreen()
    {
        
                return ("Nom : " + nom
                      + "\nNuméro: "+ numero 
                       +  "\nEtage: "+etage 
                        + "\n\n******************************************\n"
                         + "\nNombre de machines: "+ machines.size() 
                          + "\nNombre d'équipement réseaux: "+eq_reseau.size()
                           + "\nNombre d'ordinateur: "+ordinateur.size()
                            + "\nNombre d'équipement portable: "+ eq_mobile.size());
    }
    
}
