import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d95fc63d-205e-481f-96ee-33fc702e627a")
public class Salle {
    @mdl.prop
    @objid ("5252655b-20bf-4da7-8fc3-6ac91089754c")
    private int numero;

    @mdl.propgetter
    private int getNumero() {
        // Automatically generated method. Please do not modify this code.
        return this.numero;
    }

    @mdl.propsetter
    private void setNumero(int value) {
        // Automatically generated method. Please do not modify this code.
        this.numero = value;
    }

    @mdl.prop
    @objid ("be232ce9-acb3-4b39-8be9-66f414a3466d")
    private int etage;

    @mdl.propgetter
    private int getEtage() {
        // Automatically generated method. Please do not modify this code.
        return this.etage;
    }

    @mdl.prop
    @objid ("6d88515d-65c7-493c-bba1-6f20a7684a02")
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

    @objid ("6a94a607-050c-4a2c-adb8-35dbff5277ad")
    public List<Machine> machine = new ArrayList<Machine> ();

}
