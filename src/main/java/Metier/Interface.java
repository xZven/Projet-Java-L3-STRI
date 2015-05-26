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
 * Cette classE repr2sente les interfaces constituant une machine.
 * Ces interfaces peuvent être stockéeS dans des ArrayList si la
 * machine a plusieurs interfaces, tel un équipement réseau
 * ou un serveur.
 * </p>
 * @version 1.0, 2015, UPS. 
 */
public class Interface 
{
    
    private String adresseMAC   = "FF:FF:FF:FF:FF:FF";
    private String adresseIP    = "0.0.0.0";
    private String type;
    private boolean etat        = false;
    
    /**
     * Constructeur d'une Interface Réseau
     * 
     * @param adresseMAC Adresse MAC de l'interface;
     * @param adresseIP  Adresse IP de l'interface ;
     * @param type  Type de l'interface, plusieurs types possibles:    
     * Type possible: <br>
     * <ul>
     * <li>Ethernet          </li>
     * <li>Wifi              </li>
     * <li>Série             </li>
     * <li>Fibre_Opt         </li>
     * <li>Tocken BUS | Ring </li>
     * <li>...</li>
     * </ul>
     */
    public Interface(String adresseMAC, String adresseIP, String type)
    {
        
        this.adresseMAC = adresseMAC;
        this.adresseIP = adresseIP;
        this.type = type;
        etat = true;
    }
    
    /**
     *  Constructeur d'interface test
     */
    public void Interface(){
        
        etat= true;
    }

    /**
     * Obtenir l'adresse MAC de l'Interface.
     * @return String: Adresse MAC de l'interface.
     */
    public String getAdresseMAC() 
    {
        return adresseMAC;
    }

    /**
     * Définir une adresse MAC pour l'Interface.
     * @param adresseMAC String: Adresse MAC à définir.
     */
    public void setAdresseMAC(String adresseMAC) 
    {
        this.adresseMAC = adresseMAC;
    }

    /**
     * Obtenir l'adresse IP d'une Interface.
     * @return String:  Adresse IP de l'interface.
     */
    public String getAdresseIP()
    {
        return adresseIP;
    }

    /**
     * Définir une adresse IP pour une Interface.
     * @param adresseIP String: Adresse IP à definir.
     */
    public void setAdresseIP(String adresseIP) 
    {
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
     * @return String: Type de l'interface.
     */
    public String getType() 
    {
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
     * @param type String: Type de l'interface à définir.
     */
    public void setType(String type) 
    {
        this.type = type;
    }

    /**
     * Etat de l'Interface.
     * 
     * @return Boolean:  TRUE si l'interface est UP; FALSE SI DOWN.
     */
    public boolean isEtat() 
    {
        return etat;
    }
    /**
     * Changer l'Etat d'une Interface
     * 
     * @param etat Bollean: Etat à définir: TRUE = UP; FALSE = DOWN.
     */
    public void setEtat(boolean etat)
    {
        this.etat = etat;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
