/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.ArrayList;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * 
 * 
 * @version 1.0, 2015, UPS.
 */
public class Batiment{
    private ArrayList<Salle> salles;
    private String nom;
    private String description;
    private String localisation;

    public Batiment(String name, String localisation, String description) {
		this.nom = name;
		this.localisation = localisation;
                this.description = description;
		salles = new ArrayList<>();
	}

    /**
     * @return the room
     */
    public ArrayList<Salle> getSalles() {
        return salles;
    }

    /**
     * @param salles the room to set
     */
    public void setSalles(ArrayList<Salle> salles) {
        this.salles = salles;
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
     * @return the location
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * @param localisation the location to set
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public void addSalle(Salle salle) {
		salles.add(salle);
	}

	public void removeSalle(Salle salle) {
            /* Si la salles n'est pas présente dans l'ArrayList des salles */
		if (!salles.contains(salle)) {
			System.out.println("Cette salle n'est pas dans ce batiment");
		} else {
			salles.remove(salle);
		}
	}

    @Override
	public String toString() {
		return ("Batiment " + nom + ", localisation=" + localisation + ", description=" + description);
	}
}