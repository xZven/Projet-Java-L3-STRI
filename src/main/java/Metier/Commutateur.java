/*
 * Projet L3 STRI 
 * Device Manager
 *
 */

package Metier;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 *
 *<p>
 * Cette classe défini les commutateurs appartennant à des salles.
 * Elle n'est pas implémenter dans cette version du logiciel
 * </p>
 * @version 1.0, 2015, UPS.
 */


public class Commutateur extends EquipementReseau {
    /**
     * Constructer <b>Commutateur</b>
     * 
     * @param nom nom du commutateur
     * @param marque marque du commutateur
     * @param modele modèle du commutateur
     * @param OS Système d'exploitation du commutateur
     * @param firmware firmware du commutateur
     * @param type type du commutateur
     * @param etat etat du commutateur(UP ou DOWN)
     */
    public Commutateur(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        super(nom, marque, modele, OS, firmware, "Commutateur", etat);
    }
}
