package astron.dc;

import java.util.ArrayList;

public final class DMethod implements IDObject {

	public String name;
	public int id;
	public ArrayList<DDataTypes> args = new ArrayList<DDataTypes>();
	
	public DMethod(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void addArg(DDataTypes dataType) {
		this.args.add(dataType);
	}
	
	public void addArgs(ArrayList<DDataTypes> dataTypes) {
		this.args.addAll(dataTypes);
	}

	public ArrayList<DDataTypes> getArgs() {
		return this.args;
	}
	
	public void printInfo() {
		System.out.println(String.format("---DMethod---\nName: %s\nID: %s\nArgs: %s", this.name, this.id, this.args));
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public DObjectTypes getType() {
		return DObjectTypes.DMethod;
	}
	
}
