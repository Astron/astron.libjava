package astron.object;

import astron.client.AstronClientRepository;
import astron.dc.Class;

/**
 * @author chandler14362
 */
public class DistributedObject implements IDistributedObject {

    private int _doId;
    private AstronClientRepository _cr;
    private Class _dclass;

    /* Constructors */

    public DistributedObject() {}

    public DistributedObject(final AstronClientRepository cr) {
        _cr = cr;
    }

    public DistributedObject(final int doId) {
        _doId = doId;
    }

    public DistributedObject(final Class dclass) {
        _dclass = dclass;
    }

    public DistributedObject(final AstronClientRepository cr, final int doId) {
        _cr = cr;
        _doId = doId;
    }

    public DistributedObject(final AstronClientRepository cr, final Class dclass) {
        _cr = cr;
        _dclass = dclass;
    }

    public DistributedObject(final int doId, final Class dclass) {
        _doId = doId;
        _dclass = dclass;
    }

    public DistributedObject(final AstronClientRepository cr, final int doId, final Class dclass) {
        _cr = cr;
        _doId = doId;
        _dclass = dclass;
    }

    // TODO
    public void sendUpdate(final String fieldName, final Object... args) {}

    // TODO
    public void sendUpdate(final String fieldName) {}

    // TODO
    public void sendUpdate(final int fieldId, final Object... args) {}

    // TODO
    public void sendUpdate(final int fieldId) {}
    
    /* Getters And Setters */

    public void setDoId(final int doId) {
        _doId = doId;
    }

    public int getDoId() {
        return _doId;
    }

    public void setCR(final AstronClientRepository cr) {
        _cr = cr;
    }

    public AstronClientRepository getCR() {
        return _cr;
    }

    public void setDClass(final Class dclass) {
        _dclass = dclass;
    }

    public Class getDClass() {
        return _dclass;
    }

}
