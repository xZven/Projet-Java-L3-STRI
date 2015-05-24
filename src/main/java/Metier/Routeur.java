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
 * Elle n'est pas implémenter dans cette version du logiciel
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class Routeur extends EquipementReseau {

    
    /**
     * Constructeur <b>Routeur</b>
     * 
     * 
     * @param nom nom du Routeur
     * @param marque marque du Routeur
     * @param modele modèle du Routeur
     * @param OS Système d'exploitation du Routeur
     * @param firmware firmware du Routeur
     * @param type type du Routeur
     * @param etat etat du Routeur(UP ou DOWN)
     */
    public Routeur(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        super(nom, marque, modele, OS, firmware, "Routeur", etat);
    }
    
}
