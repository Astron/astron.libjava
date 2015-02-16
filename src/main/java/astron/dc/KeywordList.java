package astron.dc;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public class KeywordList {

    private ArrayList<String> _keywords = new ArrayList<String>();

    public KeywordList() {}

    public boolean hasKeyword(final String name) {
        return _keywords.contains(name);
    }

    public int getKeywordCount() {
        return _keywords.size();
    }

    public String getKeyword(final int index) {
        return _keywords.get(index);
    }

    public void addKeyword(final String keyword) {
        _keywords.add(keyword);
    }

    public String toString() {
        return String.format("---KeywordList---\n Keywords: %s", _keywords);
    }

    protected void generateHash(HashGenerator hashgen) {
        hashgen.addInt(_keywords.size());
        for (String keyword: _keywords) {
            hashgen.addString(keyword);
        }
    }

}
