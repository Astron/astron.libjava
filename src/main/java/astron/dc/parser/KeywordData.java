package astron.dc.parser;

import astron.dc.File;

/**
 * @author chandler14362
 */
public class KeywordData extends ParserData {

    private final String _alias;

    public KeywordData(final String alias) {
        _alias = alias;
    }

    public void construct(final File file) {
        file.addKeyword(_alias);
    }

}
