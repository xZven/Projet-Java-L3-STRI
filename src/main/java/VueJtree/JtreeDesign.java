package VueJtree;

import Metier.*;


import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


/**
 *
 * @author Tempête
 */
public class JtreeDesign extends DefaultTreeCellRenderer{
      public JtreeDesign() {
          
         setBorder(BorderFactory.createEmptyBorder(1, 0, 1, 0));
      }
      
      @Override
      public Component getTreeCellRendererComponent(JTree arbre, Object n, boolean sélection, boolean ouvert, boolean feuille, int ligne, boolean focus) { 
         super.getTreeCellRendererComponent(arbre, n, sélection, ouvert, feuille, ligne, focus);
         DefaultMutableTreeNode node = (DefaultMutableTreeNode) n;
         if (feuille) {
             // Ajouter un Cast : 
            try
            {
                Machine m = (Machine)node.getUserObject();
                setIcon(m.getIcon()); // iconne des machines
            }
            catch(Exception e)
            {
                String text = (String)node.getUserObject();
                Machine m = new Machine(text);
                setIcon(m.getIcon());
            }
         }
         else
         {
            try
            {
                Batiment b = (Batiment)node.getUserObject();
                setIcon(b.getIcon()); // icon du batiment
            }
            catch(Exception e)
            {
                try
                {
                    Salle s = (Salle)node.getUserObject();
                    
                    setIcon(s.getIcon()); // icon de la salle
 /*                   if(s.getMachines().isEmpty())
                        setIcon(new ImageIcon("src/main/java/VueJtree/salle_rouge.png"));
                    else
                    {
                        int index = 0;
                        for(Machine m: s.getMachines())
                        {
                            if(m.isEtat()) // si la machine est UP.
                                index++;
                        }
                        
                        if(s.getMachines().size() == index)
                            setIcon(new ImageIcon("src/main/java/VueJtree/salle_vert.png"));

                        else
                            setIcon(new ImageIcon("src/main/java/VueJtree/salle_orange.png"));
                    }
                        
 */                   
                             
                }
                catch(Exception ex)
                {
                    
                }
            }
         }
         return this; 
      }     
}
