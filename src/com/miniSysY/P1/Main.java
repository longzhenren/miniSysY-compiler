package com.miniSysY.P1;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream inputStream = CharStreams.fromStream(System.in);
        P1Lexer lexer = new P1Lexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        P1Parser parser = new P1Parser(tokenStream);
        parser.addErrorListener(new BaseErrorListener(){
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
