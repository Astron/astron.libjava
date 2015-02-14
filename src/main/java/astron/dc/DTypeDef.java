package astron.dc;

/**
 * @author chandler14362
 */
public class DTypeDef extends DType {

    private final FundamentalType _type;

    public DTypeDef(String alias, FundamentalType type) {
        _alias = alias;
        _type = type;
    }

    public FundamentalType getFundamentalType() {
        return _type;
    }

    public String toString() {
        return String.format("---DTypeDef---\n Alias: %s\n Type: %s", _alias, _type);
    }

}
