/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univtlse3;

import java.util.ArrayList;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * 
 * 
 * @version 1.0, 2015, UPS.
 */
public class Salle
{
   // Déclarations des attributs :
   private ArrayList<Machine> machines;
   private int numero;
   private int etage;
   private String nom;
   private Batiment batiment;
   
   public Salle(Batiment batiment, String nom, int numero, int etage) {
		this.batiment = batiment;
		this.nom = nom;
		this.numero = numero;
		this.etage = etage;
		machines = new ArrayList<>();
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
		return ("Salle " + nom + ", étage: " + etage + ", numéro="
				+ numero + ", batiment " + getBatiment().getNom());
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
