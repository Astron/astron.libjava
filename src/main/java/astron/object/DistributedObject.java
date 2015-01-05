package main.java.astron.object;

import main.java.astron.connection.AstronClientRepository;
import main.java.astron.datagram.Datagram;
import main.java.astron.dc.DClass;

public class DistributedObject implements IDistributedObject {

    public int doId;
    public AstronClientRepository cr;
    public DClass dclass;

    /* Constructors */

    public DistributedObject() {}

    public DistributedObject(AstronClientRepository cr) {
        this.cr = cr;
    }

    public DistributedObject(int doId) {
        this.doId = doId;
    }

    public DistributedObject(DClass dclass) {
        this.dclass = dclass;
    }

    public DistributedObject(AstronClientRepository cr, int doId) {
        this.cr = cr;
        this.doId = doId;
    }

    public DistributedObject(AstronClientRepository cr, DClass dclass) {
        this.cr = cr;
        this.dclass = dclass;
    }

    public DistributedObject(int doId, DClass dclass) {
        this.doId = doId;
        this.dclass = dclass;
    }

    public DistributedObject(AstronClientRepository cr, int doId, DClass dclass) {
        this.cr = cr;
        this.doId = doId;
        this.dclass = dclass;
    }

    public void sendUpdate(String fieldName, Object... args) {
        Datagram datagram = this.dclass.clientFormatUpdate(fieldName, this.doId, args);
        this.cr.send(datagram);
    }

    public void sendUpdate(String fieldName) {
        this.dclass.clientFormatUpdate(fieldName);
    }

    /* Getters And Setters */

    public void setDoId(int doId) {
        this.doId = doId;
    }

    public int getDoId() {
        return this.doId;
    }

    public void setCR(AstronClientRepository cr) {
        this.cr = cr;
    }

    public AstronClientRepository getCR() {
        return this.cr;
    }

    public void setDClass(DClass dclass) {
        this.dclass = dclass;
    }

    public DClass getDClass() {
        return this.dclass;
    }

}
