/*
 * Projet L3 STRI 
 * Device Manager
 *
 */

package VueJtree;

/* package interne */

import Metier.*;
import BaseDeDonnees.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* autres import */

import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author E.MENAT - G.RIBAGNAC - N.ROQUES - M.TEIKITUHAAHAA
 * 
 * Cette classe défini les batiments pouvant contenir des salles
 * dans la gestion d'un système informatique.
 * 
 * @version 1.0, 2015, UPS.
 */

public class InterfaceIHM extends javax.swing.JFrame {

    DefaultTreeModel arbreModele;
    
    /**
     * Creates new form test
     */
    public InterfaceIHM() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPaneTreeTest = new javax.swing.JScrollPane();
        jTreeTest = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonTree = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTreeTest.setBackground(new java.awt.Color(204, 204, 204));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Bievenue sur Device Manager");
        jTreeTest.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeTest.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeTestValueChanged(evt);
            }
        });
        jScrollPaneTreeTest.setViewportView(jTreeTest);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jButtonTree.setBackground(new java.awt.Color(204, 0, 0));
        jButtonTree.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButtonTree.setText("Connecter");
        jButtonTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTreeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonTree, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Device Manager v1.0");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Université Paul Sabatier - UPPSITECH - STRI - Copyright \u00a9 2015");
        jLabel3.setToolTipText("");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("******************************************************************\n*\t\tBienvenue sur Device Manager v1.0\t         *\n******************************************************************\n\nLa description des objets sélectionnés dans l'arborescence s'af\n- ficheront ici.");
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(51, 204, 0));
        jTextArea2.setRows(5);
        jTextArea2.setText("Interfaces de l'équipement...");
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Ajouter");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Supprimer");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea3.setColumns(20);
        jTextArea3.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea3.setRows(5);
        jTextArea3.setText("Console >");
        jScrollPane3.setViewportView(jTextArea3);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Changer Etat");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTreeTest, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneTreeTest, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTreeActionPerformed
        // TODO add your handling code here:
         ArrayList<Batiment> batiments = new ArrayList<>();
         
       /* Connexion à la base de donnée si déconnecté */
        if(jButtonTree.getText().equals("Connecter"))
        {
             try {
                 // on se connecte à la base et on récupère les batiments
                 
                 ConnexionBDD id = new ConnexionBDD("jdbc:mysql://127.0.0.1:3306/java", "java", "java");
                 
                 
                 
                 for(int i = 0; i < 3; ++i)
                 {
                     batiments.add(new Batiment("Batiment N° "+i));
                     for(int j = 0; j < 3; ++j)
                     {
                         batiments.get(i).addSalle(new Salle("Salle "+j));
                         
                         //**********************************************************************************************
                         /* Machines */
                         for(int k = 0; k < 3; ++k) // on créer 3 machines
                         {
                             batiments.get(i).getSalles().get(j).addMachine(new Machine("Machine "+k));
                         }
                         for(Machine m :  batiments.get(i).getSalles().get(j).getMachines()) // pour chaque machine on ajoute 3 interfaces réseaux
                         {
                             for(int l = 0; l<3; ++l)
                             {
                                 m.addInterfaceReseau(new Interface(l+"F:FF:FF:FF:FF:FF", "0.0.0."+l, "Ethernet"));
                             }
                             
                         }
                         
                         //**********************************************************************************************
                         /* Ordinateurs */
                         for(int k = 0; k < 3; ++k)
                         {
                             batiments.get(i).getSalles().get(j).addMachine(new Machine("Ordinateur "+k));
                         }
                         /*                    for(Machine m :  batiments.get(i).getSalles().get(j).getMachines()) // pour chaque ordinateur on ajoute 3 interfaces réseaux
                         {
                         for(int l = 0; l<3; ++l)
                         {
                         m.addInterfaceReseau(new Interface(l+"F:FF:FF:FF:FF:FF", "0.0.0."+l, "Ethernet"));
                         }
                         
                         }
                         */
                         //**********************************************************************************************
                         /* Equipement réseaux */
                         for(int k = 0; k < 3; ++k)
                         {
                             batiments.get(i).getSalles().get(j).addMachine(new Machine("Eq_Réseaux "+k));
                         }
                         /*                   for(Machine m :  batiments.get(i).getSalles().get(j).getMachines()) // pour chaque Equipement réseaux on ajoute 3 interfaces réseaux
                         {
                         for(int l = 0; l<3; ++l)
                         {
                         m.addInterfaceReseau(new Interface(l+"F:FF:FF:FF:FF:FF", "0.0.0."+l, "Ethernet"));
                         }
                         
                         }
                         */
                         //**********************************************************************************************
                         /* Equipement Mobile */
                         for(int k = 0; k < 3; ++k)
                         {
                             batiments.get(i).getSalles().get(j).addMachine(new Machine("Equipement Mobile "+k));
                         }
                         /*                    for(Machine m :  batiments.get(i).getSalles().get(j).getMachines()) // pour chaque Equipement mobile on ajoute 3 interfaces réseaux
                         {
                         for(int l = 0; l<3; ++l)
                         {
                         m.addInterfaceReseau(new Interface(l+"F:FF:FF:FF:FF:FF", "0.0.0."+l, "Ethernet"));
                         }
                         
                         }
                         */
                         //**********************************************************************************************
                     }
                 }
                 
                 jButtonTree.setText("Deconnecter");
                 jButtonTree.setBackground(Color.green);  
             } catch (ClassNotFoundException ex) {
                // Logger.getLogger(InterfaceIHM.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                // Logger.getLogger(InterfaceIHM.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else
        {
            jButtonTree.setText("Connecter");
            jButtonTree.setBackground(Color.red);
        }

        /* 
            Le nom de la racine correspond au nom de la base de donnéee.
            On récupère donc le nom de la base de donnée.
        */
       
        DefaultMutableTreeNode racine3 = new DefaultMutableTreeNode("Etablissement");
        
        arbreModele = new DefaultTreeModel(racine3);
        
        // Comportement des noeuds sans fils mais pouvant posséder des enfants : 
        arbreModele.setAsksAllowsChildren(true);
        JTree monArbre3 = new JTree(arbreModele); 
   
        DefaultMutableTreeNode Jtree_batiment;
        DefaultMutableTreeNode Jtree_Salle;
        DefaultMutableTreeNode jTree_generique_machine;
        
        /***************************************************/
        
        
        
        /* création de batiment pour test */
        

        
        
        /***************************************************/
        for(Batiment b: batiments)
        {
            Jtree_batiment = new DefaultMutableTreeNode();
            Jtree_batiment.setUserObject(b);
           // for( int j = 0; j < 2*i; ++j)
            for(Salle s: b.getSalles())
            {
                Jtree_Salle = new DefaultMutableTreeNode();
                Jtree_Salle.setUserObject(s);
                
                jTree_generique_machine = new DefaultMutableTreeNode("*** MACHINE***");
                Jtree_Salle.add(jTree_generique_machine);
             
                // traitement Jtree des machines d'une salles
                if(s.getMachines().isEmpty() == false) // salles avec des machines
                {
                    for(Machine m: s.getMachines())
                    {                        
                        jTree_generique_machine = new DefaultMutableTreeNode(m, false);
                        jTree_generique_machine.setUserObject(m);

                        Jtree_Salle.add(jTree_generique_machine); Jtree_batiment.add(Jtree_Salle); // ajout des dev à la salle; ajout des salles aux 
                    }
                }
                else                                    // salles sans machines
                {
                    Machine f = new Machine("Empty"); // ici les machiens de la salles
                    
                    jTree_generique_machine = new DefaultMutableTreeNode(f, false);
                    jTree_generique_machine.setUserObject(f);
                    
                    Jtree_Salle.add(jTree_generique_machine); Jtree_batiment.add(Jtree_Salle); // ajout des dev à la salle; ajout des salles aux 
                }
                
                
                // traitement des Ordinateurs
                jTree_generique_machine = new DefaultMutableTreeNode("*** ORDINATEURS ***");
                Jtree_Salle.add(jTree_generique_machine); 
                
                // traitement des Equipements réseaux d'une salle
                jTree_generique_machine = new DefaultMutableTreeNode("*** EQUIPEMENTS RESEAUX ***");
                Jtree_Salle.add(jTree_generique_machine);
                
                // traitement des Equipements sans fils
                jTree_generique_machine = new DefaultMutableTreeNode("*** EQUIPEMENTS MOBILES ***");
                Jtree_Salle.add(jTree_generique_machine);
                
               
                
                Jtree_batiment.add(Jtree_Salle);
            }
            
            racine3.add(Jtree_batiment); // ajout des batiment à la racine
        }

        
        TreeModel modele = monArbre3.getModel();
        
        
        // On ajoute notre modèle au JTree déjà existant par défaut :
        jTreeTest.setModel(modele);
        
        
        TreeModel m = jTreeTest.getModel();
        Object o = m.getRoot();
        DefaultMutableTreeNode oo;
        
        // On active les modifications sur le Jtree + Sélection unique d'un noeud, pas de multi-selection : 
        jTreeTest.setEditable(true);
        jTreeTest.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        
        /* Test événement JTree : */
        // Edite la zone sans appuyer sur la touche entrer : 
        // jTreeTest.setInvokesStopCellEditing(true);
        
        
        // Ajout d'un listener permettant de détecter les changements réaliser sur un noeud : 
        modele.addTreeModelListener(new TreeModelListener() {

           
            @Override
            public void treeNodesChanged(TreeModelEvent e) {
                System.out.println("Valeur modifiée :");    System.out.println(e.getChildren()[0].toString());     
            }

            @Override
            public void treeNodesInserted(TreeModelEvent e) {
                System.out.print("Noeud ajouté: ");         System.out.println(e.getTreePath().toString());
            }

            @Override
            public void treeNodesRemoved(TreeModelEvent e) {
                System.out.print("Noeud supprimé: ");       System.out.println(e.getTreePath().toString());
            }

            
            @Override
            public void treeStructureChanged(TreeModelEvent e) {
                System.out.print("Structure changed: ");   System.out.println(e.getTreePath().toString());
                
            }
            
            
        });
        
        /* Listener lors de la sélection d'un noeud, on veut afficher ses informations */
        
        
        jTreeTest.addTreeSelectionListener(new TreeSelectionListener() {

           @Override
           public void valueChanged(TreeSelectionEvent e) {
              
             DefaultMutableTreeNode var = (DefaultMutableTreeNode) e.getPath().getLastPathComponent(); 
  //***********************************************************************************************************************               
            try{
                 Batiment temp = (Batiment) var.getUserObject();
                 jTextArea1.setText(temp.FullScreen()); // affichage dans textfield des propriété de l'objet.
                 
                 
                 jTextArea2.setText("Aucune Interface sur cet objet");
                 
                 
                 jButton1.setEnabled(true);  jButton1.setText("+ Ajouter une salle\n");
                 jButton2.setEnabled(true);  jButton2.setText("+ Supprimer '"+ temp.toString()+"'");
                 jButton3.setEnabled(false); jButton3.setText("+ Aucun changement d'Etat possible\n");
                 
                 jTextArea3.setText("Ajouter une nouvelle salle \n ou supprimer le batiment " + temp.toString()
                         + "\n\nAucun changement d'Etat n'est disponible\n sur cet objet. \n");
                 
                 
            }catch(ClassCastException exep){
                System.out.println("Ce n'est pas un batiment");
            }
 //***********************************************************************************************************************           
            try{
                 Salle temp = (Salle) var.getUserObject();
                 jTextArea1.setText(temp.FullScreen());
                 jTextArea2.setText("Aucune Interface sur cet objet");
                 
                 /* action valide sur les boutons */
                 jButton1.setEnabled(true); jButton1.setText("Ajouter une machine");
                 jButton2.setEnabled(true); jButton2.setText("Supprimer '"+ temp.toString()+"'");
                 jButton3.setEnabled(true); jButton3.setText("Changer Etat de la salle");
                 
                 /* text de la console d'aide. */
                 jTextArea3.setText("+ Ajouter une nouvelle machine à la salle\n"
                         + "+ Supprimer la salle "+ temp.toString()+"\n"
                         + "+ Changer l'Etat de la salle:\n"
                         + "Tous les Equipements seront mis dans l'Etat DOWN\n"
                         + "ou dans l'Etat UP.\n");
                 
            }catch(ClassCastException exep){
                System.out.println("Ce n'est pas une salle");
            }
 //***********************************************************************************************************************   
            try{
                 Machine temp = (Machine) var.getUserObject();
                 jTextArea1.setText(temp.FullScreen());         // affichage de la description des batiments
                 jTextArea2.setText(temp.displayInterfaces()); // affichages des inerfaces
                 
                 jButton1.setEnabled(false); jButton1.setText("Ajouter");
                 jButton2.setEnabled(true); jButton2.setText("+ Supprimer '"+ temp.toString()+"'");
                 jButton3.setEnabled(true); jButton3.setText("+ Changer Etat de la machine");
                 
                 jTextArea3.setText("Supprimer la machine "+temp.toString()+"\n"
                         + "Changer son Etat\n"
                         + "");
            }catch(ClassCastException exep){
                System.out.println("Ce n'est pas une Machine");
            } 
 //***********************************************************************************************************************               
            
               
               
 
           }
       });
     
        /* lors de l'expansion d'un noeud, on veut actualiser les données
            en interrogeant la BD.
        */
        jTreeTest.addTreeExpansionListener(new TreeExpansionListener() {

            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                /* codes lors de l'expand d'un noeud */
                String node = event.getPath().getLastPathComponent().toString();
                
                System.out.println(event.getPath().getLastPathComponent().toString()); // affiche le l'élément expand
                
                
            }

            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                /* codes lors d'un collpase d'un noeud */
                String node = event.getPath().getLastPathComponent().toString();
                
                System.out.println(event.getPath().getLastPathComponent().toString()); // affiche le l'élément expand
                
                
            }
        });
        
        /// On cache le noeud racine : 
        jTreeTest.setRootVisible(false);

        
        /* Modifier le rendu de chaque noeu d'un Jtree en fonction de sa hiérarchie : */
        jTreeTest.setCellRenderer(new JtreeDesign());
        
        arbreModele.reload();
        
    }//GEN-LAST:event_jButtonTreeActionPerformed

    private void jTreeTestValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeTestValueChanged
        // Evenement : Se déclenche à chaque sélection/désélection d'un élément de l'arbre :
        
        /* si l'on change une valeur dans le Jtree, on reporte la modif dans la BD */
        
      
        System.out.print(evt.getPath().getLastPathComponent().toString());   System.out.println(": Value changed");
        
    }//GEN-LAST:event_jTreeTestValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
         jTextArea3.setText("Tentative de supression de l'objet...");
         DefaultMutableTreeNode var = (DefaultMutableTreeNode) jTreeTest.getSelectionPath().getLastPathComponent();
         
         var.removeFromParent();
         jTextArea3.setText("Objet supprimé: "+var.toString());
         System.gc(); // nettoyage mémoire
         
         arbreModele.reload();
         
         
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         DefaultMutableTreeNode var = (DefaultMutableTreeNode) jTreeTest.getSelectionPath().getLastPathComponent();
         
         try{
                 Machine temp = (Machine) var.getUserObject();
                 
                 temp.changeEtat();
                 
                 /* on essaye de changer l'Etat de la machine dans la base de donnée */
                 
                 jTextArea3.setText("L'Etat des machines a bien été changé."); // confirmation dans la console
                 
                 arbreModele.reload(var); // rechargement de l'arborescence
                 
            }catch(ClassCastException exep){
                System.out.println("Ce n'est pas une Machine");
            }
 //***********************************************************************************************************************          
         try{
                 Salle temp = (Salle) var.getUserObject();
                 
                 for(Machine m : temp.getMachines()) // pour chaque machine de la salle
                 {
                     m.setEtat(false); // on met les machines dans l'Etat down.
                     
                     /* on essaye de changer l'Etat des machines salle dans la base de donnée */
                     
                 }
                 
                 jTextArea3.setText("L'Etat des machines a bien été changé."); // confirmation dans la console
                 
                 arbreModele.reload(var); // rechargement de l'arborescence
              
                 
            }catch(ClassCastException exep){
                System.out.println("Ce n'est pas une Salle");
            }
 //*********************************************************************************************************************** 
         
 //***********************************************************************************************************************          
         
         
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceIHM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonTree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPaneTreeTest;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTree jTreeTest;
    // End of variables declaration//GEN-END:variables
}
