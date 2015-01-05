package astron.dc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import astron.connection.MessageTypes;
import astron.datagram.Datagram;

public final class DClass {

    public String name;
    public int id;
    public ArrayList<DMethod> methods = new ArrayList<DMethod>();
    public Map<String, DMethod> name2method = new HashMap<String, DMethod>();
    public Map<Integer, DMethod> id2method = new HashMap<Integer, DMethod>();
    public ArrayList<DClass> parents = new ArrayList<DClass>();

    public DClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addParent(DClass parent) {
        this.parents.add(parent);
    }

    public void addParents(ArrayList<DClass> parents) {
        this.parents.addAll(parents);
    }

    public DMethod getMethod(String name) {
        return this.name2method.get(name);
    }

    public DMethod getMethod(int id) {
        return this.id2method.get(id);
    }

    public int getMethodId(String name) {
        return this.getMethod(name).getId();
    }

    public void addMethod(DMethod method) {
        this.methods.add(method);
        this.name2method.put(method.getName(), method);
        this.id2method.put(method.getId(), method);
    }

    public Datagram clientFormatUpdate(String fieldName, int doId) {
        Datagram datagram = new Datagram(MessageTypes.CLIENT_OBJECT_SET_FIELD);
        datagram.addUint32(doId);
        datagram.addUint16(this.getMethodId(fieldName));
        return datagram;
    }

    public Datagram clientFormatUpdate(String fieldName, int doId, Object... args) {
        DMethod dmethod = this.getMethod(fieldName);

        Datagram datagram = new Datagram(MessageTypes.CLIENT_OBJECT_SET_FIELD);
        datagram.addUint32(doId);
        datagram.addUint16(dmethod.getId());

        for (int i = 0; i < dmethod.getArgCount(); i++) {
            Datagram.addDataType(datagram, dmethod.getArg(i), args[i]);
        }

        return datagram;
    }

    public Datagram clientFormatUpdate(int fieldId, int doId) {
        return this.clientFormatUpdate(this.getMethod(fieldId).getName(), doId);
    }

    public Datagram clientFormatUpdate(int fieldId, int doId, Object... args) {
        return this.clientFormatUpdate(this.getMethod(fieldId).getName(), doId, args);
    }

    public void printInfo() {
        System.out.println(String.format("---DClass---\nName: %s\nID: %s\n---Methods---", this.name, this.id));
        for (DMethod dmethod: this.methods) {
            dmethod.printInfo();
        }
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
