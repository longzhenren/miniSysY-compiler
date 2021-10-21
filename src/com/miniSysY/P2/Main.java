package com.miniSysY.P2;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        CharStream inputStream = CharStreams.fromStream(System.in);
//        CharStream inputStream = CharStreams.fromString("int main() {\n" +
//                "    return 1 + (-2) * (3 / (4 - 5));\n" +
//                "}");
        P2Lexer lexer = new P2Lexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        P2Parser parser = new P2Parser(tokenStream);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });
        ParseTree tree = parser.compUnit();
        Visitor visitor = new Visitor();
        visitor.visit(tree);
    }
}
