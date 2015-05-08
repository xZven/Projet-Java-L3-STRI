/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univtlse3;

import java.util.ArrayList;

/**
 *
 * @author E.MENAT,
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
		machines = new ArrayList<Machine>();
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
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the etage
     */
    public int getEtage() {
        return etage;
    }

    /**
     * @param etage the etage to set
     */
    public void setEtage(int etage) {
        this.etage = etage;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return the batiment
     */
    public Batiment getBatiment() {
        return batiment;
    }

    /**
     * @param batiment the batiment to set
     */
    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }
    
    public void addMachine(Machine machine) {
		machines.add(machine);
	}
    public void removeMachine(Machine machine) {
		if (!machines.contains(machine)) {
			System.out.println("Cette machine n'est pas dans cette salle.");
		} else {
			machines.remove(machine);
		}
	}
   
    public String toString() {
		return ("Salle " + nom + ", étage: " + etage + ", numéro="
				+ numero + ", batiment " + getBatiment().getNom());
	}

    void remove(Salle salle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean contains(Salle salle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void add(Salle salle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    }
