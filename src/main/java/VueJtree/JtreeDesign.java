package VueJtree;

import Metier.*;


import java.awt.Component;
import javax.swing.BorderFactory;
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
                setIcon(m.getIcon()); 
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
                setIcon(b.getIcon());
            }
            catch(Exception e)
            {
                try
                {
                    Salle s = (Salle)node.getUserObject();
                    setIcon(s.getIcon());
                }
                catch(Exception ex)
                {
                    
                }
            }
         }
         return this; 
      }     
}
