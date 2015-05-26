/*
 * Projet L3 STRI 
 * Device Manager
 *
 */
package Metier;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * <p>
 * Cette classe représente de manière générique tous les types d'équipements que
 * l'on peut avoir à gérer dans un système d'informatique.
 * </p>
 * @version 1.0, 2015, UPS.
 */
public class Machine extends JLabel {

    private ArrayList<Interface> interfaceReseau;

    //   En attente: non défini dans l'UML
    //   private ArrayList<UniteProcesseur> uniteProcesseur;
    // Ajout propriétés ArrayList<Machine> machineConnectees; 
    private String nom;
    private String marque;
    private String modele;
    private String OS;
    private String firmware;

    private String type;
    private boolean etat = false;

    private int id;

    /**
     * Constructeur générique.<p>
     * @param nom Nom de la machine.
     * @param marque Marque de la machine.
     * @param modele Modele de la machine.
     * @param OS Système d'exploitation de la machine.
     * @param firmware Firmware de la machine(BIOS par exemple).
     * @param type Type de la machine: capteur, mobile non défini, etc.
     * @param etat Etat de la machine (TRUE: UP | FALSE: DOWN).
     * </p>
     *
     */
    public Machine(String nom, String marque, String modele, String OS, String firmware, String type, boolean etat) {
        this.nom = nom;
        this.marque = marque;
        this.modele = modele;
        this.OS = OS;
        this.type = type;
        this.firmware = firmware;
        this.etat = etat;

        if (etat == true) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiVert.png"));
        } else if (etat == false) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiRouge.png"));
        } else {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordi.png"));
        }

        interfaceReseau = new ArrayList<>();

        // On peut ensuite se connecter la BD et ajouter la nouvelle machine;
    }

    /**
     * Constructeur de test pour le JTree
     *
     * @param nom Nom de la machine pour le Jtree;
     */
    public Machine(String nom) {
        this.nom = nom;
        if (etat == true) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiVert.png"));
        } else if (etat == false) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiRouge.png"));
        } else {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordi.png"));
        }

        interfaceReseau = new ArrayList<>();
    }

    /**
     * Permet de spécifier l'identifiant de la machine.
     *
     * @param id Indique l'identifiant de la machine en base de données.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet de récupérer l'identifiant de la machine en base de données.
     *
     * @return Identifiant de la machine en base de données.
     */
    public int getId() {
        return this.id;
    }


    /* Opération sur les interfaces */
    /**
     * Obtenir le tableau contenant les interface d'une machine.
     *
     * @return ArrayList d'interface réseau.
     */
    public ArrayList<Interface> getInterfaceReseau() {
        return interfaceReseau;
    }

    /**
     * <p>
     * Lors du démarrage du logiciel, on est amené à demander au serveur de BdD
     * les interfaces réseaux d'une machine.
     * <br>
     * L'attribution des interfaces réseaux dans une ArrayList peut se faire
     * hors de la classe et directement assigner une interface à la machine par
     * cette fonction.
     * </p>
     * <p>
     * Il est conseillé d'ultiliser la fonction
     * {@link #addInterfaceReseau(Interface)} pour rajouter une interface.
     * </p>
     *
     * Assigne une Arraylist d'interface à une machine.
     *
     * @param interfaceReseau ArrayList d'interface réseau.
     */
    public void setInterfaceReseau(ArrayList<Interface> interfaceReseau) {
        this.interfaceReseau = interfaceReseau;
    }

    /**
     * @param interfaceReseau Interface: Ajouter une nouvelle interface.
     * @return boolean: TRUE si l'ajout est réussi; FAlSE sinon.
     */
    public boolean addInterfaceReseau(Interface interfaceReseau) {

        return this.interfaceReseau.add(interfaceReseau);

    }

    /**
     * <p>
     * L'Interface sera supprimée en fonction d'une interface fourni en
     * paramètre.
     * <br>
     * Au moins, l'adresse MAC doit être égale à l'interface qui doit être
     * supprimé. Sinon on supprimera en fonction de l'adresse IP de l'interface.
     * </p>
     *
     * @param interfaceToDelete Interface.
     * @return boolean: TRUE si l'effacement est réussi; FALSE sinon.
     */
    public boolean deleteInterfaceReseauByInterface(Interface interfaceToDelete) {

        if (this.interfaceReseau.isEmpty() == true) {
            /* La machine n'a pas d'interface réseau*/
            /* On peut le vérifier dans la base de donnée */
            return true;

        } else {

            /* La machine a au moins une interface réseau*/
            for (Interface interface_temp : this.interfaceReseau) {

                /* Etant donnée qu'une adresse MAC est unique, on peut supprimer une Interface
                 *  par son adressse MAC
                 */
                if (interfaceToDelete.getAdresseMAC().equals(interface_temp.getAdresseMAC())) {
                    return this.interfaceReseau.remove(interfaceToDelete);
                } else { //SI aucune MAC n'a été défini dans l'interface, on peut la supprimer par l'adresse IP

                    if (interfaceToDelete.getAdresseIP().equals(interface_temp.getAdresseIP())) {
                        return this.interfaceReseau.remove(interfaceToDelete);
                    }
                }

                // Sinon on continu la boucle
            }

        }
        return false; // Aucune interface trouvé !
    }

    public String displayInterfaces() {
        int index = 0;
        String string = "";
        for (Interface i : interfaceReseau) {
            string = string
                    + "Interface " + index
                    + "\n\t*****************************"
                    + "\n\tTYPE: " + i.getType()
                    + "\n\t@MAC: " + i.getAdresseMAC()
                    + "\n\t@IP: " + i.getAdresseIP()
                    + "\n\t*****************************\n";
            index++;
        }
        return string;
    }

    /**
     * Obtenir le nom d'une machine.
     *
     * @return Retourne une chaine de caractères contenant le nom de la machine.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définir le nom d'une machine.
     *
     * @param nom Chaine de caractères permettant de définir le nom de la
     * machine.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir la marque d'une machine.
     *
     * @return Retourne une chaine de caractère contenant le nom de la machine.
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Définir la marque d'une machine
     *
     * @param marque Nouvelle marque de la machine
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Obtenir le modèle d'une machine.
     *
     * @return Retourne une chaine de caractères contenant le modèle de la
     * machine.
     */
    public String getModele() {
        return modele;
    }

    /**
     * Définir le modèle d'une machine
     *
     * N.B: Une machine ne peut changer de modèle, mais cette fonction a été
     * rajouté pour pouvoir modifier l'attribut en cas d'erreur...
     *
     * @param modele Nouveau modèle de la machine.
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     * Obtenir le Système d'exploitation d'une machine.
     *
     * @return Retourne une chaine de caractères contenant l'OS de la machine.
     */
    public String getOS() {
        return OS;
    }

    /**
     * Définir le système d'exploitation d'une machine
     *
     * @param OS Nouveau Système d'exploitation de la machine.
     */
    public void setOS(String OS) {
        this.OS = OS;
    }

    /**
     * Obtenir le Firmware d'une machine
     *
     * @return Retourne une chaine de caractère contenant le Firmware de la
     * machine.
     */
    public String getFirmware() {
        return firmware;
    }

    /**
     * Définir le Firmware d'une machine
     *
     * Le Firmware d'une machine peut être mis à jour via cette fonction.
     *
     * @param firmware Nouveau Firmware de la machine.
     */
    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    /**
     * Obtenir le type d'une machine. Type possible: <br>
     * <ul>
     * <li>Ordinateur                    </li>
     * <li>Equipement réseau générique   </li>
     * <li>Routeur                       </li>
     * <li>Commutateur                   </li>
     * <li>Automate                      </li>
     * <li>...</li>
     * </ul>
     *
     * @return Retourne une chaine de caractères contenant le nom de la machine.
     */
    public String getType() {
        return type;
    }

    /**
     * Définir le type d'une machine. Type possible: <br>
     * <ul>
     * <li>Ordinateur                    </li>
     * <li>Equipement réseau générique   </li>
     * <li>Routeur                       </li>
     * <li>Commutateur                   </li>
     * <li>Automate                      </li>
     * <li>...</li>
     * </ul>
     *
     * @param type Type de la machine
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

        if (etat == true) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiVert.png"));
        } else if (etat == false) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiRouge.png"));
        } else {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordi.png"));
        }
    }

    /**
     * Changer l'Etat d'une machine en UP ou DOWN
     */
    public void changeEtat() {
        etat = !etat;

        if (etat == true) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiVert.png"));
        } else if (etat == false) {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordiRouge.png"));
        } else {
            setIcon(new ImageIcon("src/main/java/VueJtree/ordi.png"));
        }
    }

    /**
     * Obtenir le nom de la machine
     *
     * @return Nom de la machine
     */
    @Override
    public String toString() {
        return (nom);
    }

    public String FullScreen() {

        String state;
        if (etat == true) {
            state = "UP";
        } else {
            state = "DOWN";
        }

        return ("Nom: " + nom
                + "\nMarque: " + marque
                + "\nModele: " + modele
                + "\nO.S: " + OS
                + "\nFirmware: " + firmware
                + "\nType: " + type
                + "\nEtat: " + state
                + "\nNombre d'interface: " + interfaceReseau.size());
    }
}
