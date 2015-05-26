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
 * <p>
 * Cette classe défini les batiments pouvant contenir des salles
 * dans la gestion d'un système informatique.
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class Batiment extends JLabel
{
    
    private ArrayList<Salle> salles;
    private String nom;
    private String description;
    private String localisation;

    /**
     * Permet de construire un batiment.
     * 
     * @param name Nom du batiment
     * @param localisation Localisation (ou adresse).
     * @param description  Description du batiment.
     */
    public Batiment(String name, String localisation, String description) 
    {
		this.nom = name;
		this.localisation = localisation;
                this.description = description;
		salles = new ArrayList<>();
                
                setIcon(new ImageIcon("src/main/java/VueJtree/batiment.png"));
    }
    
    /**
     * Constructeur de test pour JTree.
     * @param name Nom du batiment.
     */
    public Batiment(String name) 
    {
		this.nom = name;
		salles = new ArrayList<>();
                
                setIcon(new ImageIcon("src/main/java/VueJtree/batiment.png"));
    }

       /* gestion des salles */
    
    /**
     * Permet d'obtenir l'ArrayList de salles d'un batiment.
     * 
     * @return ArrayList de Salle.
     */
    public ArrayList<Salle> getSalles()
    {
        return salles;
    }

    /**
     * @param salles ArrayList de salle pour un batiment.
     */
    public void setSalles(ArrayList<Salle> salles)
    {
        this.salles = salles;
    }

    /**
     * Ajouter une nouvelle salle au batiment.
     * 
     * @param salle Permet d'ajouter une salle à l'ArrayList de la classe Batiment.
     */
    public void addSalle(Salle salle)
    {
        this.salles.add(salle);
    }
    
    /**
     * Supprimer une salle au batiment.
     * 
     * @param salle Salle
     * @return boolean: TRUE si réussi; FALSE sinon.
     */
    public boolean removeSalle(Salle salle) 
    {
        if(this.salles.isEmpty() == true) 
        {
            // La salle est vide.
            
            /* On peut le vérifier dans la base de donnée */
            return true;
        }
        
        /* Si la salle n'est pas présente dans l'ArrayList des salles */
        if (!this.salles.contains(salle)) 
        {
                System.out.println("Cette salle n'est pas dans ce batiment");
                return false;
        } 
        else {
                this.salles.remove(salle);
                return true;
        }
    }

    /**
     * Obtenir le nom du batiment.
     * 
     * @return Nom du batiment.
     */
    public String getNom() 
    {
        return nom;
    }

    /**
     * Définir un nom à un batiment.
     * 
     * @param nom Nom à définir pour le batiment.
     */
    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    /**
     * Obtenir la desceription du batiment.
     * @return Description du batiment.
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * @param description Description à definir  pour le batiment.
     */
    public void setDescription(String description) 
    {
        this.description = description;
    }

    /**
     * @return Localisation du batiment.
     */
    public String getLocalisation() 
    {
        return localisation;
    }

    /**
     * Définir la localisation du batiment.
     * 
     * @param localisation Localisation à définir.
     */
    public void setLocalisation(String localisation) 
    {
        this.localisation = localisation;
    }

    /**
     * Obtenir seulement le nom du batiment(utilisé avec le JTree).
     * 
     * @return Nom du batiment.
     */
    @Override
    public String toString() 
    {
        return (nom);
    }
    
    /**
     * Obtenir toutes les informations sur le batiment.
     * 
     * @return Nom, localisation, description du batiment.
     */
   
    public String FullScreen() 
    {
        return ("Nom: " + nom 
                + "\nLocalisation:" + localisation 
                 + "\nDescription:" + description
                  + "\nNombre de salle: "+salles.size());
    }
}