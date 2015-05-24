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
 * Cette classe défini les Tablettes appartennant à des salles.
 * Elle n'est pas implémenter dans cette version du logiciel
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class Tablettes extends EquipementMobile {

    /**
     * Constructeur <b>Tablette</b>.
     * 
     * @param nom nom de la Tablette
     * @param marque marque de la Tablette
     * @param modele modèle de la Tablette
     * @param OS Système d'exploitation de la Tablette
     * @param firmware firmwarede la Tablette
     * @param type type de la Tablette
     * @param etat etat de la Tablette(UP ou DOWN)
     */
    public Tablettes(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        super(nom, marque, modele, OS, firmware, "Tablette", etat);
    }
}
