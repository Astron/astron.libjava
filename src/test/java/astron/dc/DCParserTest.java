package astron.dc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.FileInputStream;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link astron.dc.DCParser}
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
        DCLoader loader = new DCLoader();
        walker.walk(loader, tree);

        DCFile dcFile = loader.getDcFile();
        dcFile.printInfo();

        assertEquals(5, dcFile.getImportCount());
        assertEquals(2, dcFile.getKeywordCount());
    }

}
