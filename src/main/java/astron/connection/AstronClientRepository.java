package astron.connection;

import astron.datagram.Datagram;
import astron.datagram.DatagramIterator;
import astron.dc.DCFile;
import astron.dc.DCTokens;
import astron.dc.DDataTypes;
import astron.dc.DMethod;
import astron.object.IDistributedObject;
import astron.object.ObjectFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class AstronClientRepository extends Connection {

    private final String _version;
    private final DCFile _dcFile;
    private final ObjectFactory _objectFactory;

    protected int _clientState = ClientStates.CONNECTING;

    public AstronClientRepository(String address, int port, String version, DCFile dcFile) {
        super(address, port);

        _objectFactory = new ObjectFactory(this);

        _version = version;
        _dcFile = dcFile;

        if (this.isConnected()) {
            this.sendHello();
        }
    }

    public IDistributedObject generateGlobalObject(int doId, String dclassName) {
        return _objectFactory.requestObject(doId, dclassName);
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

    public IDistributedObject getDo(int doId) {
        return _objectFactory.getDo(doId);
    }

    public String getVersion() {
        return _version;
    }

    public int getDcHash() {
        return _dcFile.getHash();
    }

    public DCFile getDcFile() {
        return _dcFile;
    }

    public int getClientState() {
        return _clientState;
    }

    public void setClientState(int clientState) {
        _clientState = clientState;
    }

    private void sendHello() {
        Datagram datagram = new Datagram(MessageTypes.CLIENT_HELLO);
        datagram.addUint32(this.getDcHash());
        datagram.addString(_version);
        this.send(datagram);
    }

    protected void handleHelloResp() {
        System.out.println("Handle hello response");
    }

    private void handleObjectSetField(DatagramIterator datagram) {

        // Get the doId and the fieldId
        int doId = datagram.getDoId();
        int fieldId = datagram.getUint16();

        // Get the DMethod from the DCFile
        DMethod dmethod = _dcFile.getDMethod(fieldId);

        // Create an ArrayList of the args and the argClasses
        ArrayList<Object> args = new ArrayList<Object>();
        ArrayList<Class<?>> argClasses = new ArrayList<Class<?>>();

        for (int i = 0; i < dmethod.getArgCount(); i++) {
            DDataTypes argType = dmethod.getArg(i);

            args.add(DatagramIterator.getDataType(datagram, argType));
            argClasses.add(DCTokens.DATA_CLASSES.get(argType));
        }

        // Get the DistributedObject
        IDistributedObject dobject = this.getDo(doId);

        try {

            // Get the Method we need to invoke
            Method method = dobject.getClass().getMethod(dmethod.getName(), argClasses.toArray(new Class[argClasses.size()]));

            // Invoke the method
            method.invoke(dobject, args.toArray(new Object[args.size()]));

        } catch (NoSuchMethodException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (InvocationTargetException e) {

            e.printStackTrace();

        }

    }

    public void handleDatagram(DatagramIterator datagram, int messageType) {
        if (_clientState == ClientStates.CONNECTING && messageType == MessageTypes.CLIENT_HELLO_RESP) {
            this.handleHelloResp();
        } else if (messageType == MessageTypes.CLIENT_OBJECT_SET_FIELD) {
            this.handleObjectSetField(datagram);
        }
    }

}
