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
 * Cette classe définit les commutateurs appartennant à des salles. Elle n'est
 * pas implémentés dans cette version du logiciel
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class Commutateur extends EquipementReseau {

    /**
     * Constructer <b>Commutateur</b>
     *
     * @param nom Nom du commutateur.
     * @param marque Marque du commutateur.
     * @param modele Modèle du commutateur.
     * @param OS Système d'exploitation du commutateur.
     * @param firmware Firmware du commutateur.
     * @param type Type du commutateur.
     * @param etat Etat du commutateur(UP ou DOWN).
     */
    public Commutateur(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        super(nom, marque, modele, OS, firmware, "Commutateur", etat);
    }
}
