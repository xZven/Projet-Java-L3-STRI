import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("36898f27-8f00-4bc3-aab4-17e780f062c6")
public class Machine {
    @mdl.prop
    @objid ("282a3cb2-859b-43df-b38e-10ff05e06099")
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
    @objid ("d0a41d4d-5963-4dfc-bdaf-44a56126132d")
    private String marque;

    @mdl.propgetter
    private String getMarque() {
        // Automatically generated method. Please do not modify this code.
        return this.marque;
    }

    @mdl.prop
    @objid ("0a9f530b-2623-4001-b889-c55759c6203b")
    private String modele;

    @mdl.propgetter
    private String getModele() {
        // Automatically generated method. Please do not modify this code.
        return this.modele;
    }

    @mdl.prop
    @objid ("74dbc0be-452f-4ca2-88f4-66057014dc2f")
    private String operating_system;

    @mdl.propgetter
    private String getOperating_system() {
        // Automatically generated method. Please do not modify this code.
        return this.operating_system;
    }

    @mdl.propsetter
    private void setOperating_system(String value) {
        // Automatically generated method. Please do not modify this code.
        this.operating_system = value;
    }

    @mdl.prop
    @objid ("3b2028d3-05e3-4e92-86c6-c5ce2bd2b5f3")
    private String firmware;

    @mdl.propgetter
    private String getFirmware() {
        // Automatically generated method. Please do not modify this code.
        return this.firmware;
    }

    @mdl.propsetter
    private void setFirmware(String value) {
        // Automatically generated method. Please do not modify this code.
        this.firmware = value;
    }

    @objid ("a65f4b65-78e7-4bab-a2b2-c4aa01d30d8a")
    public List<Interface> networkInterface = new ArrayList<Interface> ();

}
