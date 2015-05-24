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
 * <p>
 * Cette classe définit les équipements mobiles génériques appartennant à des salles.
 * Elle n'est pas implémenter dans cette version du logiciel
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class EquipementMobile extends Machine{
    
    /**
     * Constructeur <b>Equipement Mobile</b>.
     * 
     * @param nom nom de l'équipement mobile
     * @param marque marque de l'équipement mobile
     * @param modele modèle de l'équipement mobile
     * @param OS Système d'exploitation de l'équipement mobile
     * @param firmware firmware de l'équipement mobile
     * @param type type de l'équipement mobile
     * @param etat etat de l'équipement mobile(UP ou DOWN)
     */
    public EquipementMobile(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat)
    {
        super(nom, marque, modele, OS, firmware, type, etat);
    }
}


