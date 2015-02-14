package astron.dc.parser;

import astron.dc.DType;
import astron.dc.FundamentalType;

/**
 * @author chandler14362
 */
public class KeywordData extends ParserData {

    public class Keyword extends DType {

        public Keyword(final String alias) {
            _alias = alias;
        }

        public FundamentalType getFundamentalType() {
            return null;
        }

    }

    private String _alias;

    public KeywordData(final String alias) {
        _alias = alias;
    }

    public DType construct() {
        return new Keyword(_alias);
    }

}
