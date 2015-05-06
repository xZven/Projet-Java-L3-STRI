/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univtlse3;

import java.util.ArrayList;

/**
 *
 * @author Tempête
 */
public class Machine{
    
    private ArrayList<InterfaceReseau> interfaceReseau;
    private ArrayList<UniteProcesseur> uniteProcesseur;
    
    private String nom;
    private String marque;
    private String modele;
    private String OS;
    private String firmware;
    
    private String type;
    private boolean etat;

    public Machine() {
      
        
        
    }

    public ArrayList<InterfaceReseau> getInterfaceReseau() {
        return interfaceReseau;
    }

    public void setInterfaceReseau(ArrayList<InterfaceReseau> interfaceReseau) {
        this.interfaceReseau = interfaceReseau;
    }

    public ArrayList<UniteProcesseur> getUniteProcesseur() {
        return uniteProcesseur;
    }

    public void setUniteProcesseur(ArrayList<UniteProcesseur> uniteProcesseur) {
        this.uniteProcesseur = uniteProcesseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
