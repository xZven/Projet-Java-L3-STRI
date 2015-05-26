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
 * Cette classe défini les équipements réseaux génériques appartennant à des salles.
 * Elle n'est pas implémentée dans cette version du logiciel.
 *</p>
 * @version 1.0, 2015, UPS.
 */
public class EquipementReseau extends Machine 
{
    
    /**
     * Constructeur <b>Equipement Réseau</b>.
     * 
     * @param nom Nom de l'équipement réseaux.
     * @param marque Marque de l'équipement réseaux.
     * @param modele Modèle de l'équipement réseaux.
     * @param OS Système d'exploitation de l'équipement réseaux.
     * @param firmware Firmware de l'équipement réseaux.
     * @param type Type de l'équipement réseaux.
     * @param etat Etat de l'équipement réseaux(UP ou DOWN).
     */
    public EquipementReseau(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) 
    {
        super(nom, marque, modele, OS, firmware, type, etat);
    }
}
