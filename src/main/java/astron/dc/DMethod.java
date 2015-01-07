package astron.dc;

import java.util.ArrayList;

public final class DMethod {

    private final String _name;
    private final int _id;
    private final ArrayList<DDataTypes> _args = new ArrayList<DDataTypes>();

    public DMethod(String name, int id) {
        _name = name;
        _id = id;
    }

    public void addArg(DDataTypes dataType) {
        _args.add(dataType);
    }

    public void addArgs(ArrayList<DDataTypes> dataTypes) {
        _args.addAll(dataTypes);
    }

    public ArrayList<DDataTypes> getArgs() {
        return _args;
    }

    public DDataTypes getArg(int index) {
        return _args.get(index);
    }

    public int getArgCount() {
        return _args.size();
    }

    public void printInfo() {
        System.out.println(String.format("---DMethod---\nName: %s\nID: %s\nArgs: %s", _name, _id, _args));
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

}
