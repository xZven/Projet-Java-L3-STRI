/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.ArrayList;
import javafx.geometry.Orientation;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * 
 * 
 * @version 1.0, 2015, UPS.
 */
public class Salle extends JLabel
{
   // Déclarations des attributs :
  
   private ArrayList<Machine> machines;
   private ArrayList<EquipementReseau> eq_reseau;
   private ArrayList<EquipementMobile> eq_mobile;
   private ArrayList<Ordinateur>       ordinateur;
   
   
   private int numero;
   private int etage;
   private String nom;
   private Batiment batiment;
   
   /**
    * Constructeur utilisé lors de l'interrogation de la base de donnée
    * 
    * @param batiment
    * @param nom
    * @param numero
    * @param etage 
    */
   public Salle(Batiment batiment, String nom, int numero, int etage) 
   {
       setIcon(new ImageIcon("src/main/java/VueJtree/salles.png"));
       
        this.batiment = batiment;
        this.nom      = nom;
        this.numero   = numero;
        this.etage    = etage;
        machines      = new ArrayList<>();
        eq_reseau     = new ArrayList<>();
        eq_mobile     = new ArrayList<>();
        ordinateur    = new ArrayList<>();

    }

   /**
    * Constructeur de test pour JTree
    * 
    * @param nom 
    */
   public Salle(String nom)
    {
        setIcon(new ImageIcon("src/main/java/VueJtree/salles.png"));
        
        this.nom      = nom;
        machines      = new ArrayList<>();
        eq_reseau     = new ArrayList<>();
        eq_mobile     = new ArrayList<>();
        ordinateur    = new ArrayList<>();
    }
    /**
     * @return the machines
     */
    public ArrayList<Machine> getMachines() {
        return machines;
    }

    /**
     * @param machines the machines to set
     */
    public void setMachines(ArrayList<Machine> machines) {
        this.machines = machines;
    }

    /**
     * @return the number
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the number to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the floor
     */
    public int getEtage() {
        return etage;
    }

    /**
     * @param etage the floor to set
     */
    public void setEtage(int etage) {
        this.etage = etage;
    }

    /**
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return the building
     */
    public Batiment getBatiment() {
        return batiment;
    }

    /**
     * @param batiment the building to set
     */
    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }
    
    public void addMachine(Machine machine) {
		machines.add(machine);
	}
    public void removeMachine(Machine machine) {
                /* Si la machine n'existe pas dans l'ArrayList */
		if (!machines.contains(machine)) {
                   /* Sortie standard pour test : gestion des erreurs sans la sortie standard console,
                    Utilisation du mode graphique */
			System.out.println("Cette machine n'est pas dans cette salle.");
		} else {
			machines.remove(machine);
		}
	}
   
   @Override
    public String toString() {
		return (nom);
	}

    /*
    void remove(Salle salle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean contains(Salle salle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void add(Salle salle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    }
