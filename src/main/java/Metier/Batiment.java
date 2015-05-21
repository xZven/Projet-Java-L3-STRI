/*
 * Projet L3 STRI 
 * Device Manager
 *
 */

package Metier;


import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * 
 * Cette classe défini les batiments pouvant contenir des salles
 * dans la gestion d'un système informatique.
 * 
 * @version 1.0, 2015, UPS.
 */
public class Batiment extends JLabel{
    
    private ArrayList<Salle> salles;
    private String nom;
    private String description;
    private String localisation;

    /**
     * Permet de construire un batiment
     * 
     * @param name String: nom du batiment
     * @param localisation String: localisation (ou adresse)
     * @param description  String: description du batiment
     */
    public Batiment(String name, String localisation, String description) {
		this.nom = name;
		this.localisation = localisation;
                this.description = description;
		salles = new ArrayList<>();
                
                setIcon(new ImageIcon("src/main/java/VueJtree/batiment.png"));
    }
    
    /**
     * Constructeur de test pour JTree
     * @param name 
     */
    public Batiment(String name) {
		this.nom = name;
		salles = new ArrayList<>();
                
                setIcon(new ImageIcon("src/main/java/VueJtree/batiment.png"));
    }

       /* gestion des salles */
    
    /**
     * @return ArrayList de salle.
     */
    public ArrayList<Salle> getSalles() {
        return salles;
    }

    /**
     * @param salles ArrayList de salle pour un batiment
     */
    public void setSalles(ArrayList<Salle> salles) {
        this.salles = salles;
    }

    /**
     * Ajouter une nouvelle salle au batiment
     * 
     * @param salle 
     */
    public void addSalle(Salle salle)
    {
        this.salles.add(salle);
    }
    
    /**
     * Supprimer une salle d'un Batiment.
     * 
     * @param salle de type Salle
     * @return boolean: TRUE si réussi; FALSE sinon
     */
    public boolean removeSalle(Salle salle) 
    {
        if(this.salles.isEmpty() == true) {
            // La n'a aucune salle.
            
            /* On peut le vérifier dans la base de donnée */
            return true;
        }
        
        /* Si la salles n'est pas présente dans l'ArrayList des salles */
        if (!this.salles.contains(salle)) {
                System.out.println("Cette salle n'est pas dans ce batiment");
                return false;
        } 
        else {
                this.salles.remove(salle);
                return true;
        }
    }

    /**
     * Obtenir le nom du batiment
     * 
     * @return String: nom du batiment
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définir un nom à un batiment
     * 
     * @param nom nom à définir pour le batiment
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir la desceription du batiment.
     * @return String: Description du batiment
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
     * Définir la localisation du batiment.
     * 
     * @param localisation String: localisation à définir
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    /**
     * Obtenir seulement le nom du batiment(utilisé avec le JTree).
     * 
     * @return String: nom du batiment
     */
    @Override
    public String toString() {
		return (nom + localisation);
	}
    
    /**
     * Obtenir toutes les informations sur le batiment.
     * 
     * @return String: nom, localisation, description du batiment
     */
    public String FulltoString() {
        return ("Batiment" + nom + ", localisation=" + localisation + ", description=" + description);
    }
}