package astron.dc.parser;

import astron.dc.File;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link astron.dc.parser.DCParser}
 *
 * @author chandler14362
 */
public class DCParserTest {

    @Test
    public void testDCParser() throws Exception {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(getClass().getResourceAsStream("test_dc.dc"));
        DCLexer lexer = new DCLexer(antlrInputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DCParser parser = new DCParser(tokens);
        ParserRuleContext tree = parser.init();
        ParseTreeWalker walker = new ParseTreeWalker();

        File file = new File();

        DCLoader loader = new DCLoader(file);
        walker.walk(loader, tree);

        file.printInfo();
        System.out.println(String.format("DC Hash: %s", file.getHash()));

        assertEquals(4, file.getImportCount());
        assertEquals(2, file.getKeywordCount());
    }

}
