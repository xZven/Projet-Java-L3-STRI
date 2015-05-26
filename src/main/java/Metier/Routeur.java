/*
 * Projet L3 STRI 
 * Device Manager
 *
 */

package Metier;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * <p>
 * Cette classe défini les Routeurs appartennant à des salles.
 * Elle n'est pas implémentée dans cette version du logiciel.
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class Routeur extends EquipementReseau 
{ 
    /**
     * Constructeur <b>Routeur</b>
     * 
     * 
     * @param nom Nom du Routeur.
     * @param marque Marque du Routeur.
     * @param modele Modèle du Routeur.
     * @param OS Système d'exploitation du Routeur.
     * @param firmware Firmware du Routeur.
     * @param type Type du Routeur.
     * @param etat Etat du Routeur(UP ou DOWN).
     */
    public Routeur(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) 
    {
        super(nom, marque, modele, OS, firmware, "Routeur", etat);
    }
    
}
