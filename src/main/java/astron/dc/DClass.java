package astron.dc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import astron.connection.MessageTypes;
import astron.datagram.Datagram;

public final class DClass implements IDObject {
	
	public String name;
	public int id;
	public ArrayList<DMethod> methods = new ArrayList<DMethod>();
	public Map<String, DMethod> name2method = new HashMap<String, DMethod>();
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
	
	public int getMethodId(String name) {
		return this.getMethod(name).getId();
	}
	
	public void addMethod(DMethod method) {
		this.methods.add(method);
		this.name2method.put(method.getName(), method);
	}
	
	public Datagram clientFormatUpdate(String fieldName) {
		return new Datagram();
	}
	
	public Datagram clientFormatUpdate(String fieldName, int doId, Object... args) {
		Datagram datagram = new Datagram(MessageTypes.CLIENT_OBJECT_SET_FIELD);
		datagram.addUint32(doId);
		datagram.addUint16(this.getMethodId(fieldName));
		
		ArrayList<DDataTypes> dataTypes = this.getMethod(fieldName).getArgs();
		
		for (int i = 0; i < args.length; i++) {
			Datagram.addDataType(datagram, dataTypes.get(i), args[i]);
		}
		
		return datagram;
	}
	
	public Datagram clientFormatUpdate(int fieldId) {
		return new Datagram();
	}
	
	public Datagram clientFormatUpdate(int fieldId, Object[] args) {
		return new Datagram();
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
	
	public DObjectTypes getType() {
		return DObjectTypes.DClass;
	}
	
}
