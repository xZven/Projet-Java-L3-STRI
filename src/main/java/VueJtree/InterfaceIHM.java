/*
 * Projet L3 STRI 
 * Device Manager
 *
 */
package VueJtree;

/* package  à la classe */
import Metier.*;
import BaseDeDonnees.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/* autres import */
import javax.swing.JTree;
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
 * Cette classe défini les batiments pouvant contenir des salles dans la gestion
 * d'un système informatique.
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
        jTree = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonTree = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainAreaText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        interfaceDisplayer = new javax.swing.JTextArea();
        addObj = new javax.swing.JButton();
        delObjet = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        changeEtat = new javax.swing.JButton();

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

        jTree.setBackground(new java.awt.Color(204, 204, 204));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Bievenue sur Device Manager");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPaneTreeTest.setViewportView(jTree);

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

        mainAreaText.setColumns(20);
        mainAreaText.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        mainAreaText.setRows(5);
        mainAreaText.setText("******************************************************************\n*\t\tBienvenue sur Device Manager v1.0\t         *\n******************************************************************\n\nLa description des objets sélectionnés dans l'arborescence s'af\n- ficheront ici.");
        jScrollPane1.setViewportView(mainAreaText);

        interfaceDisplayer.setBackground(new java.awt.Color(51, 51, 51));
        interfaceDisplayer.setColumns(20);
        interfaceDisplayer.setForeground(new java.awt.Color(51, 204, 0));
        interfaceDisplayer.setRows(5);
        interfaceDisplayer.setText("Interfaces de l'équipement...");
        jScrollPane2.setViewportView(interfaceDisplayer);

        addObj.setBackground(new java.awt.Color(204, 204, 204));
        addObj.setText("Ajouter");
        addObj.setEnabled(false);
        addObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addObjActionPerformed(evt);
            }
        });

        delObjet.setBackground(new java.awt.Color(204, 204, 204));
        delObjet.setText("Supprimer");
        delObjet.setEnabled(false);
        delObjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delObjetActionPerformed(evt);
            }
        });

        console.setEditable(false);
        console.setBackground(new java.awt.Color(0, 0, 0));
        console.setColumns(20);
        console.setForeground(new java.awt.Color(255, 255, 255));
        console.setRows(5);
        console.setText("Console >");
        jScrollPane3.setViewportView(console);

        changeEtat.setBackground(new java.awt.Color(204, 204, 204));
        changeEtat.setText("Changer Etat");
        changeEtat.setEnabled(false);
        changeEtat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeEtatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addObj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(delObjet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane3)
                                            .addComponent(changeEtat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(182, 182, 182)))
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
                                .addComponent(addObj, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeEtat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // gros bouton
    private void jButtonTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTreeActionPerformed
        // TODO add your handling code here:

        ArrayList<Batiment> batiments = new ArrayList<>();

        /* Connexion à la base de donnée si déconnecté */
        if (jButtonTree.getText().equals("Connecter")) {
                // modification du gros bouton

            jButtonTree.setBackground(Color.ORANGE);        // couleur orange
            jButtonTree.setText("Connexion en cours...");
            console.setText("Connexion à la base...\n");
//******************************************************************************                
            try {
                // on essaye de se connecter à la BD et on récupère les batiments

                db = new ConnexionBDD("jdbc:mysql://binary-digit.net:3306/java", "java", "java");

                console.setText("Connexion à la base réussi !\nRécupération des Objets...\n");

                batiments = db.getAllBatiment(); // onrécupère les batiments dans la BD

                console.setText(console.getText() + batiments.size() + " Batiment(s) récupéré(s)\n");
                for (Batiment b : batiments) // pour chaque batiment on affiche dans la console
                {
                    console.setText(console.getText() + "Batiment: " + b.getNom() + " ->" + b.getSalles().size() + " Salles récupéré(s)\n");
                }

//******************************************************************************   
                // modification du gros bouton
                jButtonTree.setText("Deconnecter");      // 
                jButtonTree.setBackground(Color.green);  // vert

            } catch (ClassNotFoundException | SQLException ex) {
                // si on arrive pas à se connecter on ferme le programme
                System.out.println("Impossible de se conecter à la BD\n Exiting...\n");
                System.exit(-1);
            }

            // déclaration des variables pour la construction du JTree 
            DefaultMutableTreeNode racine3 = new DefaultMutableTreeNode("Etablissement");

            arbreModele = new DefaultTreeModel(racine3);

            // Comportement des noeuds sans fils mais pouvant posséder des enfants : 
            arbreModele.setAsksAllowsChildren(true);
            JTree monArbre3 = new JTree(arbreModele);

            DefaultMutableTreeNode Jtree_batiment;
            DefaultMutableTreeNode Jtree_Salle;
            DefaultMutableTreeNode jTree_generique_machine;

            /**
             * **************************** Construction du JTree *********************************************
             */
            for (Batiment b : batiments) // pour chaque batiment
            {
                Jtree_batiment = new DefaultMutableTreeNode(); // on créer un node sur le JTree
                Jtree_batiment.setUserObject(b);               //

                for (Salle s : b.getSalles()) // pour chaque salle
                {
                    Jtree_Salle = new DefaultMutableTreeNode();// on créer un sous-node sur le JTree
                    Jtree_Salle.setUserObject(s);              //

                    // traitement Jtree des machines d'une salles
                    if (s.getMachines().isEmpty() == false) // si la salle contient des machines
                    {
                        for (Machine m : s.getMachines()) {
                            jTree_generique_machine = new DefaultMutableTreeNode(m, false);
                            jTree_generique_machine.setUserObject(m);

                            Jtree_Salle.add(jTree_generique_machine);
                            Jtree_batiment.add(Jtree_Salle); // ajout des dev à la salle; ajout des salles aux batiments
                        }
                    } else // salles sans machines
                    {
//                        s.setIcon(new ImageIcon("src/main/java/VueJtree/salles_orange.png")); // on change l'icone de la salle --> orange, salle sans machine

                        jTree_generique_machine = new DefaultMutableTreeNode("... Salle Vide ...", false);
                        Jtree_Salle.add(jTree_generique_machine);
                        Jtree_batiment.add(Jtree_Salle); // ajout des dev à la salle; ajout des salles aux batiments
                    }
                }

                racine3.add(Jtree_batiment); // ajout des batiment à la racine du Jtree
            }

            /**
             * ************************************************************************************************
             */
            TreeModel modele = monArbre3.getModel();

            jTree.setModel(modele);  // On ajoute notre modèle au JTree :

            TreeModel m = jTree.getModel();
            Object o = m.getRoot();
            DefaultMutableTreeNode oo;

            // On active les modifications sur le Jtree + Sélection unique d'un noeud, pas de multi-selection : 
            jTree.setEditable(true);
            jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

            /* Test événement JTree : */
             // Edite la zone sans appuyer sur la touche entrer : 
            // jTreeTest.setInvokesStopCellEditing(true);
            // Ajout d'un listener permettant de détecter les changements réaliser sur un noeud : 
            modele.addTreeModelListener(new TreeModelListener() {

                // apellé lorsqu'une node change de valeur.
                @Override
                public void treeNodesChanged(TreeModelEvent e) {

//                     System.out.println("Valeur modifiée :");    System.out.println(e.getChildren()[0].toString());
                    DefaultMutableTreeNode var = (DefaultMutableTreeNode) e.getTreePath().getLastPathComponent();
                    console.setText("Tentative de modification de l'objet\n");

                    // On récupère le nouveau nom de l'élément :
                    // L'ancien étant stocké dans :oldNameOfSelectedNode
                    String newName = e.getChildren()[0].toString();

                    int numberOfNodeBeforeSelected = e.getPath().length;
                    if (numberOfNodeBeforeSelected == 1) {
                        try {
                            // Noeud parent "Etablissement", noeud root, c'est un batiment qui suit immédiatement :
                            db.updateNameOfBatiment(newName, oldNameOfSelectedNode);
                        } catch (SQLException ex) {
                            // Logger.getLogger(InterfaceIHM.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Erreur lors de la consultation de la BDD pour la mise à jour d'un batiment");
                        }
                    } else if (numberOfNodeBeforeSelected == 2) {
                        // Noeud parent Batiment, c'est une salle qui suit immédiatement :
                        // Récupération de l'ID : 
                        Salle temp = (Salle) currentSelectedNode;
                        try {
                            db.updateNameOfSalle(temp.getId(), newName);
                        } catch (SQLException ex) {
                            // Logger.getLogger(InterfaceIHM.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Erreur lors de la consultation de la BDD pour la mise à jour d'une salle");
                        }
                    } else if (numberOfNodeBeforeSelected == 3) {
                        // Noeud parent Salle, c'est un ordinateur qui suit immédiatement : 
                        Machine temp = (Machine) currentSelectedNode;
                        try {
                            db.updateNomOfMachine(temp.getId(), newName);
                        } catch (SQLException ex) {
                            Logger.getLogger(InterfaceIHM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Erreur lors de la consultation de la BDD pour la mise à jour d'une machine");
                    }

                    console.setText("Objet modifié: " + var.toString());

                    arbreModele.reload(); // rechargement du Jtree en entier      

                }

                @Override
                public void treeNodesInserted(TreeModelEvent e) {
                    // System.out.print("Noeud ajouté: ");         System.out.println(e.getTreePath().toString());
                }

                // déclenché lors d'un supression d'une  jtree
                @Override
                public void treeNodesRemoved(TreeModelEvent e) {
                    // System.out.print("Noeud supprimé: ");       System.out.println(e.getTreePath().toString());
                }

                // déclenché lors de l'ajout d'une node au jtree
                @Override
                public void treeStructureChanged(TreeModelEvent e) {

                    // fait buguer l'affichage des textarea
                    //  System.out.print("Structure changed: ");   System.out.println(e.getTreePath().toString());
                }

            });

            /* Listener lors de la sélection d'un noeud, on veut afficher ses informations */
            jTree.addTreeSelectionListener(new TreeSelectionListener() {

                @Override
                public void valueChanged(TreeSelectionEvent e) {

                    DefaultMutableTreeNode var = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
       //***********************************************************************************************************************               
                    // A chaque sélection d'un noeud, on récupère le nom du noeud au cas où celui-ci est modifié.
                    oldNameOfSelectedNode = e.getPath().getLastPathComponent().toString();
                    currentSelectedNode = var.getUserObject();
                    System.out.println(oldNameOfSelectedNode);
                    try {
                        Batiment temp = (Batiment) var.getUserObject();
                        mainAreaText.setText(temp.FullScreen()); // affichage dans textfield des propriété de l'objet.

                        interfaceDisplayer.setText("Aucune Interface sur cet objet");

                        addObj.setEnabled(true);
                        addObj.setText("Ajouter une salle\n");
                        delObjet.setEnabled(true);
                        delObjet.setText("Supprimer '" + temp.toString() + "'");
                        changeEtat.setEnabled(false);
                        changeEtat.setText("Aucune action possible\n");

                        console.setText("Ajouter une nouvelle salle \n ou supprimer le batiment " + temp.toString()
                                + "\n\nAucun changement d'Etat n'est disponible\n sur cet objet. \n");

                    } catch (ClassCastException exep) {
                        System.out.println("Ce n'est pas un batiment");
                    }
                    //***********************************************************************************************************************           
                    try {
                        Salle temp = (Salle) var.getUserObject();
                        mainAreaText.setText(temp.FullScreen());
                        interfaceDisplayer.setText("Aucune Interface sur cet objet");

                        /* action valide sur les boutons */
                        addObj.setEnabled(true);
                        addObj.setText("Ajouter une machine");
                        delObjet.setEnabled(true);
                        delObjet.setText("Supprimer '" + temp.toString() + "'");
                        changeEtat.setEnabled(true);
                        changeEtat.setText("Changer Etat de la salle");

                        /* text de la console d'aide. */
                        console.setText("+ Ajouter une nouvelle machine à la salle\n"
                                + "+ Supprimer la salle " + temp.toString() + "\n"
                                + "+ Changer l'Etat de la salle:\n"
                                + "Tous les Equipements seront mis dans l'Etat DOWN\n"
                                + "ou dans l'Etat UP.\n");

                    } catch (ClassCastException exep) {
                        System.out.println("Ce n'est pas une salle");
                    }
                    //***********************************************************************************************************************   
                    try {
                        Machine temp = (Machine) var.getUserObject();
                        mainAreaText.setText(temp.FullScreen());         // affichage de la description des batiments
                        interfaceDisplayer.setText(temp.displayInterfaces()); // affichages des inerfaces

                        addObj.setEnabled(false);
                        addObj.setText("Ajouter");                                   //bouton désactivé
                        delObjet.setEnabled(true);
                        delObjet.setText("Supprimer '" + temp.toString() + "'");
                        changeEtat.setEnabled(true);
                        changeEtat.setText("Changer Etat de la machine");

                        console.setText("Supprimer la machine " + temp.toString() + "\n"
                                + "Changer son Etat\n"
                                + "");
                    } catch (ClassCastException exep) {
                        System.out.println("Ce n'est pas une Machine");
                    }
      //***********************************************************************************************************************               

                }
            });

            jTree.setRootVisible(false); // On cache le noeud racine


            /* Modifier le rendu de chaque noeu d'un Jtree en fonction de sa hiérarchie : */
            jTree.setCellRenderer(new JtreeDesign());

            arbreModele.reload();  // rechargement du Jtree avec le nouveau modèle.
        } else // si déconnecter ou autre
        {
            try {
                db.closeConnexionBDD(); // déconnexion de la BD
                console.setText("Déconnexion réussi !");
            } catch (SQLException ex) {
                System.out.println("Impossible de fermer la connxion à la DB...\nExiting...");
                System.exit(-1); // erreur.  
            }

            //modification du gros bouton
            jButtonTree.setText("Connecter");       //
            jButtonTree.setBackground(Color.red);   // 

            System.gc(); // nettoyage mémoire (Garbage collector)

            // suppresion de l'arborescense sur le JTree
            arbreModele.setRoot(null);
            arbreModele.reload();
        }

        /* désactivation des boutons */
        addObj.setEnabled(false);           // Ajouter
        delObjet.setEnabled(false);         // Supprimer
        changeEtat.setEnabled(false);       // Changer Etat

        //
        /**
         * ***************************Set des affichages **************************************************
         */
        mainAreaText.setText("******************************************************************\n"
                + "*		Bienvenue sur Device Manager v1.0	         *\n"
                + "******************************************************************\n"
                + "\n"
                + "La description des objets sélectionnés dans l'arborescence s'af\n"
                + "- ficheront ici.");

        interfaceDisplayer.setText("Interfaces de la machine sélectionnée...");
        console.setText("< CONSOLE D'AIDE >");

        /**
         * ************************************************************************************************
         */

    }//GEN-LAST:event_jButtonTreeActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        // Evenement : Se déclenche à chaque sélection/désélection d'un élément de l'arbre :

        /*
         // A chaque sélection d'un noeud, on récupère le nom du noeud au cas où celui-ci est modifié.
         oldNameOfSelectedNode = evt.getPath().getLastPathComponent().toString();
         System.out.println(oldNameOfSelectedNode);
         */
        /* si l'on change une valeur dans le Jtree, on reporte la modif dans la BD */
      //  System.out.print(evt.getPath().getLastPathComponent().toString());   System.out.println(": Value changed");

    }//GEN-LAST:event_jTreeValueChanged

    // bouton d'ajout d'un objet
    // ne marche que pour les salles au rendu de ce projet
    private void addObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addObjActionPerformed
        // TODO add your handling code here:

        // on désactive tous les boutons 
        addObj.setEnabled(false);
        delObjet.setEnabled(false);
        changeEtat.setEnabled(false);

        // on récupère le node sélectioné
        var_add = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();

        console.setText("Ajout d'un nouvel objet...");

        try { // batiment
            System.out.println("addObj: Ajout d'une salle à un Batiment");
            Batiment temp = (Batiment) var_add.getUserObject();

            // fenêtre d'ajout d'un salle
            newSalle = new AddSalle(arbreModele, var_add); // on construit un Jdialog et on lui passe la variable où il faut ajouter la nouvelle salle
            JDialog dial = new JDialog();

            dial.add(newSalle);
            dial.setSize(400, 400);
            dial.setVisible(true);

        } catch (ClassCastException exep) {
            System.out.println("addObj: Ce n'est pas un Batiment");
        }

    }//GEN-LAST:event_addObjActionPerformed

    // bouton supression d'un objet
    private void delObjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delObjetActionPerformed
        // TODO add your handling code here:

        DefaultMutableTreeNode var = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();

        console.setText("Tentative de supression de l'objet...");

        try { // machine

            Machine temp = (Machine) var.getUserObject();

            /* supression de la machine dans la base de donnée */
            // dans la BD
            try {
                db.deleteMachineAndAllAssociated(temp.getId());
            } catch (SQLException ex) {
                System.out.println("Impossible de récupercuter le changement d'Etat dans la base: " + ex.getMessage());
            }
        } catch (ClassCastException exep) {
            System.out.println("Ce n'est pas une Machine");
        }
        //***********************************************************************************************************************          

        try { // salle

            Salle temp = (Salle) var.getUserObject();

            try // supression de la salle et des machines de la salle
            {
                db.deleteSalleAndAllAssociated(temp.getId());
            } catch (SQLException ex) {
                System.out.println("Impossible de récupercuter le changement d'Etat dans la base: " + ex.getMessage());
            }

        } catch (ClassCastException exep) {
            System.out.println("Ce n'est pas une Machine");
        }

        var.removeFromParent();
        console.setText("Objet supprimé: " + var.toString());
        System.gc(); // nettoyage mémoire

        arbreModele.reload(); // rechargement du Jtree en entier      
    }//GEN-LAST:event_delObjetActionPerformed

    // bouton de changement d'etat des machine ou des salles
    private void changeEtatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeEtatActionPerformed
        // TODO add your handling code here:

// on récupère l'objet sélectionné où l'on veut procéder on changement d'etat
        DefaultMutableTreeNode var = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();

//***********************************************************************************************************************   
        try { // machine
            Machine temp = (Machine) var.getUserObject();

            temp.changeEtat();

            /* on essaye de changer l'Etat de la machine dans la base de donnée */
            console.setText("L'Etat des machines a bien été changé."); // confirmation dans la console

            mainAreaText.setText(temp.FullScreen());

            arbreModele.reload(var); // rechargement de l'arborescence

            try {
                // modification de l'etat de la machine dans la base de donnée.

                db.updateEtatOfMachine(temp.getId(), temp.isEtat()); //
            } catch (SQLException ex) {
                System.out.println("Impossible de récupercuter le changement d'Etat dans la base: " + ex.getMessage());
            }

        } catch (ClassCastException exep) {
            System.out.println("Ce n'est pas une Machine");
        }
        //***********************************************************************************************************************          
        try { //salle
            Salle temp = (Salle) var.getUserObject();

            for (Machine m : temp.getMachines()) // pour chaque machine de la salle
            {
                m.setEtat(false); // on met les machines dans l'Etat down.
                try { //  on essaye de répècuter la modification de l'etat de la machine dans la base de donnée.

                    db.updateEtatOfMachine(m.getId(), m.isEtat()); //SQL
                } catch (SQLException ex) {
                    System.out.println("Impossible de récupercuter le changement d'Etat dans la base: " + ex.getMessage());
                }

            }
            console.setText("L'Etat des machines a bien été changé."); // confirmation dans la console

                // modification sur le JTree
            arbreModele.reload(var); // rechargement de l'arborescence

        } catch (ClassCastException exep) {
            System.out.println("Ce n'est pas une Salle");
        }
 //*********************************************************************************************************************** 

 //***********************************************************************************************************************          

    }//GEN-LAST:event_changeEtatActionPerformed

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
    private javax.swing.JButton addObj;
    private javax.swing.JButton changeEtat;
    private javax.swing.JTextArea console;
    private javax.swing.JButton delObjet;
    private javax.swing.JTextArea interfaceDisplayer;
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
    private javax.swing.JTree jTree;
    private javax.swing.JTextArea mainAreaText;
    // End of variables declaration//GEN-END:variables

    // variables supplémentaires
    private ConnexionBDD db;               // base de donnée
    private String oldNameOfSelectedNode;   //
    private Object currentSelectedNode;     //

    private AddSalle newSalle;              //
    private DefaultMutableTreeNode var_add; //
}
