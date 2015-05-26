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
 * Cette classe définit les équipements mobiles génériques appartennant à des
 * salles. Elle n'est pas implémentée dans cette version du logiciel.
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class EquipementMobile extends Machine {

    /**
     * Constructeur <b>Equipement Mobile</b>.
     *
     * @param nom Nom de l'équipement mobile.
     * @param marque Marque de l'équipement mobile.
     * @param modele Modèle de l'équipement mobile.
     * @param OS Système d'exploitation de l'équipement mobile.
     * @param firmware Firmware de l'équipement mobile.
     * @param type Type de l'équipement mobile.
     * @param etat Etat de l'équipement mobile(UP ou DOWN).
     */
    public EquipementMobile(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        super(nom, marque, modele, OS, firmware, type, etat);
    }
}
