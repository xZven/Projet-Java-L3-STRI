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
 * Cette class représente de manière générique tous les types d'équipements
 * que l'on peut avoir à gérer dans un système d'informatique.
 * 
 * @version 1.0, 
 */
public class Interface {
    

    
    private String adresseMAC   = "FF:FF:FF:FF:FF:FF";
    private String adresseIP    = "0.0.0.0";
    private String type;
    private boolean etat        = false;

    /**
     * Obtenir l'adresse MAC de l'Interface.
     * @return the adresseMAC
     */
    public String getAdresseMAC() {
        return adresseMAC;
    }

    /**
     * Définir une adresse MAC pour l'Interface.
     * @param adresseMAC the adresseMAC to set
     */
    public void setAdresseMAC(String adresseMAC) {
        this.adresseMAC = adresseMAC;
    }

    /**
     * Obtenir l'adresse IP d'une Interface.
     * @return the adresseIP
     */
    public String getAdresseIP() {
        return adresseIP;
    }

    /**
     * Définir une adresse IP pour une Interface.
     * @param adresseIP the adresseIP to set
     */
    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

    /**
     * Obtenir le type d'une interface.
     * <br>
     * 
     * Type possible: <br>
     * <ul>
     * <li>Ethernet          </li>
     * <li>Wifi              </li>
     * <li>Série             </li>
     * <li>Fibre_Opt         </li>
     * <li>Tocken BUS | Ring </li>
     * <li>...</li>
     * </ul> 
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Définir le type d'une interface.
     * <br>
     * 
     * Type possible: <br>
     * <ul>
     * <li>Ethernet          </li>
     * <li>Wifi              </li>
     * <li>Série             </li>
     * <li>Fibre_Opt         </li>
     * <li>Tocken BUS | Ring </li>
     * <li>...</li>
     * </ul> 
     * 
     * 
     * @param type type à définir au format: "Type"
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Etat de l'Interface.
     * 
     * @return TRUE si l'interface est UP; FALSE SI DOWN.
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * Changer l'Etat d'une Interface
     * 
     * @param etat Etat à définir: TRUE = UP; FALSE = DOWN.
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    
    /* ToString pour affichage -> MANU */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
