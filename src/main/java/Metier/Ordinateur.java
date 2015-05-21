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
 *
 * @version 1.0, 2015, UPS.
 */



public class Ordinateur extends Machine {

    /**
     * Constructeur Ordinateur
     * 
     * @param nom Nom de l'ordinateur
     * @param marque marque de l'ordinateur
     * @param modele modele de l'ordinateur
     * @param OS    Système d'exploitation
     * @param firmware Firmware de l'ordinateur
     * @param etat  TRUE = UP | FALSE = DOWN
     */
    public Ordinateur(String nom, String marque, String modele, String OS, String firmware, boolean etat) {
        
        super(nom, marque, modele, OS, firmware, "Ordinateur", etat);
    }
}
