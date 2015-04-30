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
    
    ArrayList<InterfaceReseau> interfaceReseau;
    ArrayList<InterfaceSerie> interfaceSerie;
    ArrayList<InterfaceSansFil> interfaceSansFil;
    ArrayList<UniteProcesseur> uniteProcesseur;
    
    String nom;
    String marque;
    String modele;
    String OS;
    String firmware;
    
    String type;
    boolean etat;

    public Machine() {
  
    }
}
