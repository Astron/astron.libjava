package main.java.astron.dc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DCParser {

    private int hash = 2;

    private Map<String, String> imports = new HashMap<String, String>();

    private Map<String, DDataTypes> typedefs = new HashMap<String, DDataTypes>();

    private Map<String, ArrayList<DDataTypes>> structs = new HashMap<String, ArrayList<DDataTypes>>();
    private Map<Integer, String> id2struct = new HashMap<Integer, String>();

    private Map<String , DMethod> name2dmethod = new HashMap<String, DMethod>();
    private Map<Integer, DMethod> id2dmethod = new HashMap<Integer, DMethod>();

    private Map<String , DClass> name2dclass = new HashMap<String, DClass>();
    private Map<Integer, DClass> id2dclass = new HashMap<Integer, DClass>();

    private int currentStructId = 0;
    private int currentMethodId = 0;

    private boolean inStruct = false;
    private String currentStruct;

    private boolean inClass = false;
    private String currentClass;

    public DCParser(String filepath) {
        File file = new File(filepath);

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                this.parseLine(line.trim());
            }

            reader.close();

            for (DClass dclass: this.id2dclass.values()) {
                dclass.printInfo();
            }

        } catch (Exception e) { System.out.println(e.toString()); }

    }

    public void parseLine(String line) {
        if (this.inStruct) {
            this.handleStructData(line);
        } else if (this.inClass) {
            this.handleClassData(line);
        } else if (this.isComment(line)) {
            return;
        } else if (this.isImport(line)) {
            this.handleImport(line);
        } else if (this.isTypedef(line)) {
            this.handleTypedef(line);
        } else if (this.isStruct(line)) {
            this.handleStruct(line);
        } else if (this.isClass(line)) {
            this.handleClass(line);
        }
    }

    public boolean isComment(String line) {
        return line.startsWith(DCTokens.COMMENT);
    }

    public boolean isTypedef(String line) {
        return line.startsWith(DCTokens.TYPEDEF);
    }

    public void handleTypedef(String line) {

        // Remove data we don't need
        line = line.replace("typedef ", "");
        line = line.replace(";", "");

        // Split the typedef into its name and defintion
        String[] parts = line.split(" ");
        String name = parts[1];
        String definition = parts[0];
        DDataTypes dataType;

        // Check if its a typedef of a typedef
        if (this.typedefs.containsKey(definition)) {
            dataType = this.typedefs.get(definition);
        } else {
            dataType = DCTokens.DATA_TYPES.get(definition);
        }

        // Add it to the map
        this.typedefs.put(name, dataType);

    }

    public boolean isStruct(String line) {
        return line.startsWith(DCTokens.STRUCT_START);
    }

    public void handleStruct(String line) {

        // Remove data we don't need
        line = line.replace("struct ", "");
        String structName = line.replace(" {", "");

        // Make it our current struct
        this.currentStruct = structName;

        // Declare that we are in a struct
        this.inStruct = true;

        // Add it to the map
        this.structs.put(structName, new ArrayList<DDataTypes>());
        this.id2struct.put(this.currentStructId, structName);

        // Increment the current struct id
        this.currentStructId += 1;
    }

    public void handleStructData(String line) {

        if (line.startsWith(DCTokens.INCLOSURE_END)) {
            this.inStruct = false;
            return;
        }

        // Remove data we don't need
        line = line.replace(";", "");

        // Split the line into the name and definition
        String[] parts = line.split(" ");
        String definition = parts[0];
        DDataTypes dataType;

        // Check if the definition is a typedef
        if (this.typedefs.containsKey(definition)) {
            dataType = this.typedefs.get(definition);
        } else {
            dataType = DCTokens.DATA_TYPES.get(definition);
        }

        // Add it to the map
        this.structs.get(this.currentStruct).add(dataType);

        // Increment the current method id
        this.currentMethodId += 1;

    }

    public boolean isClass(String line) {
        return line.startsWith(DCTokens.CLASS_START);
    }

    public void handleClass(String line) {
        if (line.contains(DCTokens.INHERITANCE)) {
            this.handleClassWithInheritance(line);
            return;
        }

        // Check if its a single line
        boolean oneLiner = line.endsWith(DCTokens.INCLOSURE_END);

        // Remove data we don't need
        line = line.replace(" {", "");
        line = line.replace("dclass ", "");

        if (oneLiner) {
            line = line.replace("};", "");
        }

        // Create a new DClass
        DClass dclass = new DClass(line, this.currentStructId);

        // Add it to the maps
        this.name2dclass.put(line, dclass);
        this.id2dclass.put(this.currentStructId, dclass);

        // Increment the current struct id
        this.currentStructId += 1;

        // We need to do some extra things if we aren't a one line
        if (!oneLiner) {
            this.inClass = true;
            this.currentClass = line;
        }

    }

    public void handleClassWithInheritance(String line) {

        // Check if its a single line
        boolean oneLiner = line.endsWith(DCTokens.INCLOSURE_END);

        // Remove the data we dont need
        line = line.replace("dclass", "");
        line = this.readUpTo(line, "{");
        line = line.trim();

        // Break the line into its name and parents
        String[] parts = line.split(":");
        String name = parts[0].trim();
        String[] parents = parts[1].split(",");

        ArrayList<DClass> dparents = new ArrayList<DClass>();

        for (String parent: parents) {
            parent = parent.trim();
            dparents.add(this.name2dclass.get(parent));
        }

        // Create a new dclass
        DClass dclass = new DClass(name, this.currentStructId);
        dclass.addParents(dparents);

        // Add it to the maps
        this.name2dclass.put(name, dclass);
        this.id2dclass.put(this.currentStructId, dclass);

        // Increment the current struct id
        this.currentStructId += 1;

        // If we aren't a one liner we need to do some extra stuff
        if (!oneLiner) {
            this.inClass = true;
            this.currentClass = name;
        }

    }

    public void handleClassData(String line) {

        if (line.startsWith(DCTokens.INCLOSURE_END)) {
            this.inClass = false;
            return;
        }

        // Remove data we don't need
        line = this.readUpTo(line, ")");

                              // I hate you Java
        String[] parts = line.split("\\(");

        String methodName = parts[0];
        String[] args = parts[1].split(", ");

        ArrayList<DDataTypes> dataTypes = new ArrayList<DDataTypes>();

        for (String arg: args) {

            arg = arg.replace("=", "");
            arg = arg.trim();
            String[] argList = arg.split(" ");

            for (String dataType: argList) {

                // Check if we have a typedef
                if (this.typedefs.containsKey(dataType)) {
                    dataTypes.add(this.typedefs.get(dataType));
                }

                // Check if we have a struct
                else if (this.structs.containsKey(dataType)) {
                    dataTypes.addAll(this.structs.get(dataType));
                }

                // Check if its a data type
                else if (DCTokens.DATA_TYPES.containsKey(dataType)) {
                    dataTypes.add(DCTokens.DATA_TYPES.get(dataType));
                }

            }

        }

        // Create the DMethod
        DMethod dmethod = new DMethod(methodName, this.currentMethodId);
        dmethod.addArgs(dataTypes);

        // Assign the DMethod to the current class
        this.name2dclass.get(this.currentClass).addMethod(dmethod);

        // Add it to the maps
        this.name2dmethod.put(methodName, dmethod);
        this.id2dmethod.put(this.currentMethodId, dmethod);

        // Increment the current method id
        this.currentMethodId += 1;

    }

    public boolean isImport(String line) {
        return line.startsWith(DCTokens.IMPORT_START);
    };

    public void handleImport(String line) {

        // Remove the different object types
        if (line.contains("/")) {
            line = this.readUpTo(line, "/");
        }

        // Get the package and name
        String[] parts = line.split(" import ");
        String dclassName = parts[1];
        String dclassPackage = parts[0].replace("from ", "");

        // Make our final strings
        String dclassImport = String.format("%s.%s", dclassPackage, dclassName);

        // Add it to the map
        this.imports.put(dclassName, dclassImport);

    }

    public String readUpTo(String line, String chr) {
        int index = line.indexOf(chr);
        line = line.substring(0, index);
        return line;
    }

    public DCFile genDcFile() {
        DCFile file = new DCFile();
        file.setHash(this.hash);
        file.setImports(this.imports);
        file.setId2DClass(this.id2dclass);
        file.setName2DClass(this.name2dclass);
        file.setId2DMethod(this.id2dmethod);
        file.setName2DMethod(this.name2dmethod);
        return file;
    }

}
