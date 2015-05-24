/*
 * Projet L3 STRI 
 * Device Manager
 *
 */

package Metier;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 *<p>
 * Cette classe définit les équipements réseaux génériques appartennant à des salles.
 * Elle n'est pas implémenter dans cette version du logiciel
 *</p>
 * @version 1.0, 2015, UPS.
 */
public class EquipementReseau extends Machine {
    
    /**
     * Constructeur <b>Equipement Réseau</b>.
     * 
     * @param nom nom de l'équipement réseaux
     * @param marque marque de l'équipement réseaux
     * @param modele modèle de l'équipement réseaux
     * @param OS Système d'exploitation de l'équipement réseaux
     * @param firmware firmware de l'équipement réseaux
     * @param type type de l'équipement réseaux
     * @param etat etat de l'équipement réseaux(UP ou DOWN)
     */
    public EquipementReseau(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        super(nom, marque, modele, OS, firmware, type, etat);
    }
}
