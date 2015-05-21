package Metier;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 *
 *
 * @version 1.0, 2015, UPS.
 */
public class OrdinateurPortable extends EquipementMobile {

    /**
     * Constructeur Ordinateur Portable
     * 
     * @param nom Nom de l'ordinateur
     * @param marque marque de l'ordinateur
     * @param modele modele de l'ordinateur
     * @param OS    Système d'exploitation
     * @param firmware Firmware de l'ordinateur portable
     * @param etat  TRUE = UP | FALSE = DOWN
     */
    public OrdinateurPortable(String nom, String marque, String modele, String OS, String firmware,  boolean etat) {
        super(nom, marque, modele, OS, firmware, "Ordinateur Portable", etat);
    }
}

