package astron.dc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DCParser {

    private int _hash = 2;

    private final Map<String, String> _imports = new HashMap<String, String>();

    private final Map<String, DDataTypes> _typedefs = new HashMap<String, DDataTypes>();

    private final Map<String, ArrayList<DDataTypes>> _structs = new HashMap<String, ArrayList<DDataTypes>>();
    private final Map<Integer, String> _id2struct = new HashMap<Integer, String>();

    private final Map<String , DMethod> _name2dmethod = new HashMap<String, DMethod>();
    private final Map<Integer, DMethod> _id2dmethod = new HashMap<Integer, DMethod>();

    private final Map<String , DClass> _name2dclass = new HashMap<String, DClass>();
    private final Map<Integer, DClass> _id2dclass = new HashMap<Integer, DClass>();

    private int _currentStructId = 0;
    private int _currentMethodId = 0;

    private boolean _inStruct = false;
    private String _currentStruct;

    private boolean _inClass = false;
    private String _currentClass;

    public DCParser(final String filepath) {
        File file = new File(filepath);

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                parseLine(line.trim());
            }

            reader.close();

            for (DClass dclass: _id2dclass.values()) {
                dclass.printInfo();
            }

        } catch (Exception e) { System.out.println(e.toString()); }

    }

    public void parseLine(final String line) {
        if (_inStruct) {
            handleStructData(line);
        } else if (_inClass) {
            handleClassData(line);
        } else if (isComment(line)) {
            return;
        } else if (isImport(line)) {
            handleImport(line);
        } else if (isTypedef(line)) {
            handleTypedef(line);
        } else if (isStruct(line)) {
            handleStruct(line);
        } else if (isClass(line)) {
            handleClass(line);
        }
    }

    public boolean isComment(final String line) {
        return line.startsWith(DCTokens.COMMENT);
    }

    public boolean isTypedef(final String line) {
        return line.startsWith(DCTokens.TYPEDEF);
    }

    public void handleTypedef(final String line) {

        // Remove data we don't need
        String baseLine = line.replace(DCTokens.TYPEDEF, "");
        baseLine = baseLine.replace(DCTokens.STATEMENT_END, "");
        baseLine = baseLine.trim();

        // Split the typedef into its name and defintion
        String[] parts = baseLine.split(" ");
        String name = parts[1];
        String definition = parts[0];

        DDataTypes dataType;

        // Check if its a typedef of a typedef
        if (_typedefs.containsKey(definition)) {
            dataType = _typedefs.get(definition);
        } else {
            dataType = DCTokens.DATA_TYPES.get(definition);
        }

        // Add it to the map
        _typedefs.put(name, dataType);

    }

    public boolean isStruct(final String line) {
        return line.startsWith(DCTokens.STRUCT);
    }

    public void handleStruct(final String line) {

        // Remove data we don't need
        String baseLine = line.replace(DCTokens.STRUCT, "");
        baseLine = baseLine.replace(DCTokens.INCLOSURE_START, "");

        // Get the struct name
        String structName = baseLine.trim();

        // Make it our current struct
        _currentStruct = structName;

        // Declare that we are in a struct
        _inStruct = true;

        // Add it to the map
        _structs.put(structName, new ArrayList<DDataTypes>());
        _id2struct.put(_currentStructId, structName);

        // Increment the current struct id
        _currentStructId += 1;

    }

    public void handleStructData(final String line) {

        // Check if we reached the end of the struct
        if (line.startsWith(DCTokens.INCLOSURE_END)) {
            _inStruct = false;
            return;
        }

        // Remove data we don't need
        String baseLine = line.replace(DCTokens.STATEMENT_END, "");

        // Split the line into the name and definition
        String[] parts = baseLine.split(" ");
        String definition = parts[0];

        DDataTypes dataType;

        // Check if the definition is a typedef
        if (_typedefs.containsKey(definition)) {
            dataType = _typedefs.get(definition);
        } else {
            dataType = DCTokens.DATA_TYPES.get(definition);
        }

        // Add it to the map
        _structs.get(_currentStruct).add(dataType);

        // Increment the current method id
        _currentMethodId += 1;

    }

    public boolean isClass(final String line) {
        return line.startsWith(DCTokens.CLASS);
    }

    public void handleClass(final String line) {

        // Check if the class inherits anything
        if (line.contains(DCTokens.INHERITANCE)) {
            handleClassWithInheritance(line);
            return;
        }

        // Check if its a single line
        boolean oneLiner = line.endsWith(DCTokens.INCLOSURE_END);

        // Remove data we don't need
        String baseLine = line.replace(DCTokens.INCLOSURE_START, "");
        baseLine = baseLine.replace(DCTokens.CLASS, "");

        // Check if its a one liner
        if (oneLiner) {
            baseLine = baseLine.replace(DCTokens.INCLOSURE_END, "");
        }

        // Get the name of the DClass
        String name = baseLine.trim();

        // Create a new DClass
        DClass dclass = new DClass(name, _currentStructId);

        // Add it to the maps
        _name2dclass.put(name, dclass);
        _id2dclass.put(_currentStructId, dclass);

        // Increment the current struct id
        _currentStructId += 1;

        // We need to do some extra things if we aren't a one line
        if (!oneLiner) {
            _inClass = true;
            _currentClass = name;
        }

    }

    public void handleClassWithInheritance(final String line) {

        // Check if its a single line
        boolean oneLiner = line.endsWith(DCTokens.INCLOSURE_END);

        // Remove the data we don't need
        String baseLine = line.replace(DCTokens.CLASS, "");
        baseLine = readUpTo(baseLine, DCTokens.INCLOSURE_START);
        baseLine = baseLine.trim();

        // Break the line into its name and parents
        String[] parts = baseLine.split(DCTokens.INHERITANCE);
        String name = parts[0].trim();
        String[] parents = parts[1].split(DCTokens.SEPARATOR);

        ArrayList<DClass> dparents = new ArrayList<DClass>();

        for (String parent: parents) {
            dparents.add(_name2dclass.get(parent.trim()));
        }

        // Create a new dclass
        DClass dclass = new DClass(name, _currentStructId);
        dclass.addParents(dparents);

        // Add it to the maps
        _name2dclass.put(name, dclass);
        _id2dclass.put(_currentStructId, dclass);

        // Increment the current struct id
        _currentStructId += 1;

        // If we aren't a one liner we need to do some extra stuff
        if (!oneLiner) {
            _inClass = true;
            _currentClass = name;
        }

    }

    public void handleClassData(final String line) {

        // Check if we are at the end of the class
        if (line.startsWith(DCTokens.INCLOSURE_END)) {
            _inClass = false;
            return;
        }

        // Remove data we don't need
        String baseLine = readUpTo(line, DCTokens.METHOD_END);

        // Split up the method into its name and args
        String[] parts = baseLine.split(DCTokens.METHOD_START);
        String methodName = parts[0];
        String[] args = parts[1].split(DCTokens.SEPARATOR);

        ArrayList<DDataTypes> dataTypes = new ArrayList<DDataTypes>();

        for (String arg: args) {

            arg = arg.replace(DCTokens.EQUALS, "");
            arg = arg.trim();
            String[] argList = arg.split(" ");

            for (String dataType: argList) {

                // Check if we have a typedef
                if (_typedefs.containsKey(dataType)) {
                    dataTypes.add(_typedefs.get(dataType));
                }

                // Check if we have a struct
                else if (_structs.containsKey(dataType)) {
                    dataTypes.addAll(_structs.get(dataType));
                }

                // Check if its a data type
                else if (DCTokens.DATA_TYPES.containsKey(dataType)) {
                    dataTypes.add(DCTokens.DATA_TYPES.get(dataType));
                }

            }

        }

        // Create the DMethod
        DMethod dmethod = new DMethod(methodName, _currentMethodId);
        dmethod.addArgs(dataTypes);

        // Assign the DMethod to the current class
        _name2dclass.get(_currentClass).addMethod(dmethod);

        // Add it to the maps
        _name2dmethod.put(methodName, dmethod);
        _id2dmethod.put(_currentMethodId, dmethod);

        // Increment the current method id
        _currentMethodId += 1;

    }

    public boolean isImport(final String line) {
        return line.startsWith(DCTokens.FROM);
    };

    public void handleImport(final String line) {

        // Remove the different object types
        String baseLine = line.replace(DCTokens.FROM, "");

        if (baseLine.contains(DCTokens.TYPE_SEPARATOR)) {
            baseLine = readUpTo(baseLine, DCTokens.TYPE_SEPARATOR);
        }

        // Get the package and name
        String[] parts = baseLine.split(DCTokens.IMPORT);
        String dclassName = parts[1].trim();
        String dclassPackage = parts[0].trim();

        // Make our final strings
        String dclassImport = String.format("%s.%s", dclassPackage, dclassName);

        // Add it to the map
        _imports.put(dclassName, dclassImport);

    }

    public String readUpTo(final String line, final String token) {
        int index = line.indexOf(token);
        return line.substring(0, index);
    }

    public DCFile genDcFile() {
        DCFile file = new DCFile();
        file.setHash(_hash);
        file.setImports(_imports);
        file.setId2DClass(_id2dclass);
        file.setName2DClass(_name2dclass);
        file.setId2DMethod(_id2dmethod);
        file.setName2DMethod(_name2dmethod);
        return file;
    }

}
