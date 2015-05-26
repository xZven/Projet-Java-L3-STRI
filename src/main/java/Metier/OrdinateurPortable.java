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
 * Cette classe définit les ordinateurs portables appartennant à des salles. Elle
 * n'est pas implémentée dans cette version du logiciel.
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class OrdinateurPortable extends EquipementMobile {

    /**
     * Constructeur <b>Ordinateur Portable</b>
     *
     * @param nom Nom de l'ordinateur.
     * @param marque Marque de l'ordinateur.
     * @param modele Modele de l'ordinateur.
     * @param OS Système d'exploitation.
     * @param firmware Firmware de l'ordinateur portable.
     * @param etat TRUE = UP | FALSE = DOWN.
     */
    public OrdinateurPortable(String nom, String marque, String modele, String OS, String firmware, boolean etat) {
        super(nom, marque, modele, OS, firmware, "Ordinateur Portable", etat);
    }
}
