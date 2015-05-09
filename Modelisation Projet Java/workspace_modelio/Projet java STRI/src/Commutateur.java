import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("bf9597a4-47bb-4b64-a7aa-3134657673e8")
public class Commutateur extends ElementActif {
    @objid ("44a1327d-7ddd-4a8a-a35f-a78bfa25b0be")
    public List<Routeur> connecter_routeur = new ArrayList<Routeur> ();

    @objid ("5576ad1e-a146-46d2-b154-75dae8320f39")
    public List<Commutateur> connecter_commutateur = new ArrayList<Commutateur> ();

    @objid ("24e8b1ba-6d06-4fa4-bbcd-2e9cad91989c")
    public List<Ordinateur> connecter_ordinateur = new ArrayList<Ordinateur> ();

    @objid ("623876a5-34a8-4fce-9e48-190442cf3275")
    public List<Pont> connecter_pont = new ArrayList<Pont> ();

}
