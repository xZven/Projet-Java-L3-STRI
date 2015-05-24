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
 * Cette classe défini les Ponts réseaux à des salles.
 * Elle peut aussi définir les Pont sans-fils connectant les ordinateurs portables.
 * Elle n'est pas implémenter dans cette version du logiciel.
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class Pont extends EquipementReseau {

    /**
     * Constructeur <b>pont réseau</b>
     * 
     * @param nom nom du pont réseau
     * @param marque marque du pont réseau
     * @param modele modèle du pont réseau
     * @param OS Système d'exploitation du pont réseau
     * @param firmware firmware du pont réseau
     * @param type type du pont réseau
     * @param etat etat du pont réseau(UP ou DOWN)
     */
    public Pont(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        super(nom, marque, modele, OS, firmware, "Pont", etat);
    }
}

