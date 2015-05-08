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
public class Batiment{
    private ArrayList<Salle> salle;
    private String nom;
    private String description;
    private String localisation;

    public Batiment(int id, String name, int num) {
		this.nom = nom;
		this.localisation = localisation;
                this.description = description;
		salle = new ArrayList<Salle>();
	}

    /**
     * @return the salle
     */
    public ArrayList<Salle> getSalle() {
        return salle;
    }

    /**
     * @param salle the salle to set
     */
    public void setSalle(ArrayList<Salle> salle) {
        this.salle = salle;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the localisation
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * @param localisation the localisation to set
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public void addSalle(Salle salle) {
		salle.add(salle);
	}

	public void removeSalle(Salle salle) {
		if (!salle.contains(salle)) {
			System.out.println("Cette salle n'est pas dans ce batiment");
		} else {
			salle.remove(salle);
		}
	}

       

	public String toString() {
		return ("Batiment " + nom + ", localisation=" + localisation + ", description=" + description);
	}
}
