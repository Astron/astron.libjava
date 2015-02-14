package astron.dc;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public final class DMethod extends DType {

    private final ArrayList<DType> _args = new ArrayList<DType>();

    public DMethod(String alias, int id) {
        _alias = alias;
        _id = id;
    }

    public FundamentalType getFundamentalType() {
        return FundamentalType.METHOD;
    }

    public void addArg(DType dType) {
        _args.add(dType);
    }

    public ArrayList<DType> getArgs() {
        return _args;
    }

    public DType getArg(int index) {
        return _args.get(index);
    }

    public int getArgCount() {
        return _args.size();
    }

    public void printInfo() {
        System.out.println(String.format("---DMethod---\nName: %s\nID: %s\nArgs: %s", _alias, _id, _args));
    }

}