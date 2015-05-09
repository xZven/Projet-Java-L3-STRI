import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e752d5d8-bf49-448e-ad65-b8204f983f15")
public class Interface {
    @mdl.prop
    @objid ("27a757d8-4293-44c6-bc05-2e1214fb34e3")
    private String MAC;

    @mdl.propgetter
    private String getMAC() {
        // Automatically generated method. Please do not modify this code.
        return this.MAC;
    }

    @mdl.prop
    @objid ("9d44cdec-80e5-4aba-95dd-2939757e76bd")
    private String IP;

    @mdl.propgetter
    private String getIP() {
        // Automatically generated method. Please do not modify this code.
        return this.IP;
    }

    @mdl.propsetter
    private void setIP(String value) {
        // Automatically generated method. Please do not modify this code.
        this.IP = value;
    }

    @mdl.prop
    @objid ("de0dda69-3d4b-4664-862c-c453630328cd")
    private String type;

    @mdl.propgetter
    private String getType() {
        // Automatically generated method. Please do not modify this code.
        return this.type;
    }

    @mdl.prop
    @objid ("cdf52ed2-0341-45d1-bebe-adc936348437")
    private boolean etat;

    @mdl.propgetter
    private boolean isEtat() {
        // Automatically generated method. Please do not modify this code.
        return this.etat;
    }

    @mdl.propsetter
    private void setEtat(boolean value) {
        // Automatically generated method. Please do not modify this code.
        this.etat = value;
    }

}
