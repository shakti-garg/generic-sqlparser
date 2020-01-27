package org.shaktig.incrementalsql;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.shaktig.sqlparser.mysql.MySqlLexer;
import org.shaktig.sqlparser.mysql.MySqlParser;
import org.shaktig.sqlparser.mysql.MySqlParserBaseListener;

public class Main {

    public static void main(String[] args) {
        String input = "select a.*, b.sal from emp a join sal b on (a.id = b.id)";

        CharStream inStream = CharStreams.fromString(input.toUpperCase());
        Lexer lexer = new MySqlLexer(inStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MySqlParser parser = new MySqlParser(tokens);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MySqlParserBaseListener(), parser.root());
    }
}
