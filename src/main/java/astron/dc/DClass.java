package astron.dc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import astron.connection.MessageTypes;
import astron.datagram.Datagram;

public final class DClass {

    private final String _name;
    private final int _id;
    private final ArrayList<DMethod> _methods = new ArrayList<DMethod>();
    private final Map<String, DMethod> _name2method = new HashMap<String, DMethod>();
    private final Map<Integer, DMethod> _id2method = new HashMap<Integer, DMethod>();
    private final ArrayList<DClass> _parents = new ArrayList<DClass>();

    public DClass(final String name, final int id) {
        _name = name;
        _id = id;
    }

    public void addParent(final DClass parent) {
        _parents.add(parent);
    }

    public void addParents(final ArrayList<DClass> parents) {
        _parents.addAll(parents);
    }

    public DMethod getMethod(final String name) {
        return _name2method.get(name);
    }

    public DMethod getMethod(final int id) {
        return _id2method.get(id);
    }

    public int getMethodId(final String name) {
        return getMethod(name).getId();
    }

    public void addMethod(final DMethod method) {
        _methods.add(method);
        _name2method.put(method.getName(), method);
        _id2method.put(method.getId(), method);
    }

    public Datagram clientFormatUpdate(final String fieldName, final int doId) {
        Datagram datagram = new Datagram(MessageTypes.CLIENT_OBJECT_SET_FIELD);
        datagram.addUint32(doId);
        datagram.addUint16(getMethodId(fieldName));
        return datagram;
    }

    public Datagram clientFormatUpdate(final String fieldName, final int doId, final Object... args) {
        DMethod dmethod = getMethod(fieldName);

        Datagram datagram = new Datagram(MessageTypes.CLIENT_OBJECT_SET_FIELD);
        datagram.addUint32(doId);
        datagram.addUint16(dmethod.getId());

        for (int i = 0; i < dmethod.getArgCount(); i++) {
            Datagram.addDataType(datagram, dmethod.getArg(i), args[i]);
        }

        return datagram;
    }

    public Datagram clientFormatUpdate(final int fieldId, final int doId) {
        return clientFormatUpdate(getMethod(fieldId).getName(), doId);
    }

    public Datagram clientFormatUpdate(final int fieldId, final int doId, final Object... args) {
        return clientFormatUpdate(getMethod(fieldId).getName(), doId, args);
    }

    public void printInfo() {
        System.out.println(String.format("---DClass---\nName: %s\nID: %s\n---Methods---", _name, _id));
        for (DMethod dmethod: _methods) {
            dmethod.printInfo();
        }
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

}
