/*
 * Projet L3 STRI 
 * Device Manager
 *
 */
package Metier;

import java.util.ArrayList;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * 
 * Cette class représente de manière générique tous les types d'équipements
 * que l'on peut avoir à gérer dans un système d'informatique.
 * 
 * @version 1.0, 
 */
public class Machine{
    
  
    private ArrayList<Interface> interfaceReseau;
    
 //   En attente: non défini dans l'UML
 //   private ArrayList<UniteProcesseur> uniteProcesseur;
    
    
    
    private String nom;
    private String marque;
    private String modele;
    private String OS;
    private String firmware;
    
    private String type;
    private boolean etat;

     /**
     * Constructeur générique.
     * <p>
     * @param nom nom de la machine
     * @param marque marque de la machine
     * @param modele modele de la machine
     * @param OS Système d'exploitation de la machine
     * @param type  Type de la machine: capteur, mobile non défini, etc.
     * </p>
     */
    
    
    public void Machine(String nom, String marque, String modele, String OS, String type) {
      
        this.nom    =   nom;
        this.marque =   marque;
        this.modele =   modele;
        this.OS     =   OS;
        this.type   =   type;
        
        // On peut ensuite se connecter la BD et ajouter la nouvelle machine
        
    }

    /* Opération sur les interfaces */
    
    /**
     * Obtenir le tableau contenant les interface d'une machine.
     * @return ArrayList d'interface réseau.
     */
    public ArrayList<Interface> getInterfaceReseau() {
        return interfaceReseau;
    }
    
    /**
     * <p>
     * Lors du démarrage du logiciel, on est amené à demander au serveur
     * de BdD les interfaces réseaux d'une machine.
     * <br>
     * L'attribution des interfaces réseaux dans une ArrayList peut se faire
     * hors de la class et directement assigné à la machine par cette fonction
     *</p>
     * <p>
     * Il est conseillé d'ultiliser la fonction {@link #addInterfaceReseau(Interface)} pour rajouter
     * une ou plusieurs interfaces en utilisant une boucle.
     * </p>
     * 
     * Assigne une Arraylist d'interface à une machine.
     * @param interfaceReseau ArrayList d'interface réseau.
     */
    public void setInterfaceReseau(ArrayList<Interface> interfaceReseau) {
        this.interfaceReseau = interfaceReseau;        
    }
    
    /**
     * Ajouter une nouvel interface
     * 
     * @param interfaceReseau de type Interface
     * @return boolean: TRUE si l'ajout est réussi; FAlSE sinon.
     */
    public boolean addInterfaceReseau(Interface interfaceReseau){
     
        return this.interfaceReseau.add(interfaceReseau);
        
    }
    
    /**
     * <p>
     * L'Interface sera supprimé en fonction d'une interface fourni en paramètre.
     * <br>
     * Au moins, l'adresse MAC doit être égale à l'interface qui doit être supprimé.
     * Sinon on supprimera en fonction de l'adresse IP de l'interface.
     * </p>
     * 
     * @param interfaceToDelete de type Interface
     * @return boolean: TRUE si l'effacement est réussi; FALSE sinon.
     */
    public boolean deleteInterfaceReseauByInterface(Interface interfaceToDelete){
        
        if(this.interfaceReseau.isEmpty() == true) {
            // La machine n'a pas d'interface réseau
            /* On peut le vérifier dans la base de donnée */
            return true;

        }
        else{
            
            // La machine a au moins une interface réseau
            
            for(Interface interface_temp : this.interfaceReseau){
                
                /* Etant donnée q'une adresse MAC est unique, on peut supprimer une Interface
                 *  par son adressse MAC
                 */
                
                if(interfaceToDelete.getAdresseMAC().equals(interface_temp.getAdresseMAC())){
                   return this.interfaceReseau.remove(interfaceToDelete);
                }
                else{ //SI aucune MAC n'a été défini dans l'interface, on peut le supprimé par l'adresse IP
                    
                     if(interfaceToDelete.getAdresseIP().equals(interface_temp.getAdresseIP())){
                        return this.interfaceReseau.remove(interfaceToDelete);
                    }                        
                }
                
                // Sinon on continu la boucle
            }
      
            
        }
            return false; // Aucune interface trouvé !
    }
  
    
/* 
    public ArrayList<UniteProcesseur> getUniteProcesseur() {
        return uniteProcesseur;
    }

    public void setUniteProcesseur(ArrayList<UniteProcesseur> uniteProcesseur) {
        this.uniteProcesseur = uniteProcesseur;
    }
*/
    
    /**
     * Obtenir le nom d'une machine.
     * 
     * @return Retourne une chaine de caractère contenant le nom de la machine.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définir le nom d'une machine.
     * 
     * @param nom : Chaine de caractère permettant de définir le nom de la machine.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir la marque d'une machine
     * 
     * @return  Retourne une chaine de caractère contenant le nom de la machine.
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Définir la marque d'une machine
     * 
     * @param marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Obtenir le modèle d'une machine.
     * 
     * @return  Retourne une chaine de caractère contenant le modèle de la machine.
     */
    public String getModele() {
        return modele;
    }

    /**
     * Définir le modèle d'une machine
     * 
     * @param modele
     */
    public void setModele(String modele) {
        this.modele = modele;
    }
    
    /**
     * Obtenir le Système d'exploitation d'une machine
     * 
     * @return  Retourne une chaine de caractère contenant l'OS de la machine.
     */
    public String getOS() {
        return OS;
    }

    /**
     * Définir le système d'exploitation d'une machine
     *
     * @param OS
     */
    public void setOS(String OS) {
        this.OS = OS;
    }

    /**
     * Obtenier le Firmware d'une machine
     * 
     * @return  Retourne une chaine de caractère contenant le Firmware de la machine.
     */
    public String getFirmware() {
        return firmware;
    }

    /**
     * Définir le Firmware d'une machine
     * 
     * @param firmware
     */
    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }
    
    /**
     * Obtenir le type d'une machine.
     * 
     * @return  Retourne une chaine de caractère contenant le nom de la machine.
     */ 
    public String getType() {
        return type;
    }

    /**
     * Définir le type d'une machine.
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtenir l'état d'une machine.
     * 
     * @return boolean: TRUE = UP; FALSE = DOWN
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * Définir l'etat d'une machine
     *
     * @param etat TRUE = UP; FALSE = DOWN
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
