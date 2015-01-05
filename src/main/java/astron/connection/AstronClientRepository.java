package main.java.astron.connection;

import main.java.astron.datagram.Datagram;
import main.java.astron.datagram.DatagramIterator;
import main.java.astron.dc.DCFile;
import main.java.astron.object.IDistributedObject;
import main.java.astron.object.ObjectFactory;

public class AstronClientRepository extends Connection {

    private final String version;
    private final DCFile dcFile;
    private final ObjectFactory objectFactory;

    protected int clientState = ClientStates.CONNECTING;

    public AstronClientRepository(String address, int port, String version, DCFile dcFile) {
        super(address, port);

        this.objectFactory = new ObjectFactory(this);

        this.version = version;
        this.dcFile = dcFile;

        if (this.isConnected()) {
            this.sendHello();
        }
    }

    public IDistributedObject generateGlobalObject(int doId, String dclassName) {
        return this.objectFactory.requestObject(doId, dclassName);
    }

    public void addInterest(int parentId, int zoneId) {
        this.sendAddInterest(1, 2, parentId, zoneId);
    }

    public void sendAddInterest(int context, int interestId, int parentId, int zoneId) {
        Datagram datagram = new Datagram(MessageTypes.CLIENT_ADD_INTEREST);
        datagram.addUint32(context);
        datagram.addUint16(interestId);
        datagram.addUint32(parentId);
        datagram.addUint32(zoneId);
        this.send(datagram);
    };

    public void sendAddInterestMultiple(int context, int interestId, int parentId, int[] zoneIds) {
        Datagram datagram = new Datagram(MessageTypes.CLIENT_ADD_INTEREST_MULTIPLE);
        datagram.addUint32(context);
        datagram.addUint16(interestId);
        datagram.addUint32(parentId);
        datagram.addUint16(zoneIds.length);
        for (int zoneId: zoneIds) {
            datagram.addUint32(zoneId);
        }
        this.send(datagram);
    }

    public void sendRemoveInterest(int context, int interestId) {
        Datagram datagram = new Datagram(MessageTypes.CLIENT_REMOVE_INTEREST);
        datagram.addUint32(context);
        datagram.addUint16(interestId);
        this.send(datagram);
    }

    public String getVersion() {
        return this.version;
    }

    public int getDcHash() {
        return this.dcFile.getHash();
    }

    public DCFile getDcFile() {
        return this.dcFile;
    }

    public int getClientState() {
        return this.clientState;
    }

    public void setClientState(int clientState) {
        this.clientState = clientState;
    }

    private void sendHello() {
        Datagram datagram = new Datagram(MessageTypes.CLIENT_HELLO);
        datagram.addUint32(this.getDcHash());
        datagram.addString(this.version);
        this.send(datagram);
    }

    protected void handleHelloResp() {
        System.out.println("Handle hello response");
    }

    public void handleDatagram(DatagramIterator datagram, int messageType) {
        if (this.clientState == ClientStates.CONNECTING && messageType == MessageTypes.CLIENT_HELLO_RESP) {
            this.handleHelloResp();
        }
    }

}
