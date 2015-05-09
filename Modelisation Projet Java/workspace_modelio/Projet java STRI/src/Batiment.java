import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f6be02c4-e474-48a3-ba4b-034b29261026")
public class Batiment {
    @mdl.prop
    @objid ("b231b6b1-12f5-4658-aa17-503152e91af3")
    private String nom;

    @mdl.propgetter
    private String getNom() {
        // Automatically generated method. Please do not modify this code.
        return this.nom;
    }

    @mdl.propsetter
    private void setNom(String value) {
        // Automatically generated method. Please do not modify this code.
        this.nom = value;
    }

    @mdl.prop
    @objid ("1f757a91-b2d7-4472-8a82-6e82e8e0ec72")
    private String localisation;

    @mdl.prop
    @objid ("a7790b64-cd2e-4dda-8e29-431da440a727")
    private String description;

    @objid ("bab17d8f-ed39-4b74-bc35-8b5cd0572c37")
    public List<Salle> salle = new ArrayList<Salle> ();

}
