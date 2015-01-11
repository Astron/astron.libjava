package astron.dc;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.FileInputStream;


/**
 * @author chandler14362
 */
public class DCParserTest {

    @Test
    public void testDCParser() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/astron/dc/test_dc.dc");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(fileInputStream);
        DCLexer lexer = new DCLexer(antlrInputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DCParser parser = new DCParser(tokens);
        ParserRuleContext tree = parser.init();
        ParseTreeWalker walker = new ParseTreeWalker();
        DCLoader loader = new DCLoader();
        walker.walk(loader, tree);

        DCFile dcFile = loader.getDcFile();
        dcFile.printInfo();
    }

}
