package com.miniSysY.P5;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<String, String> declaredFunc = new HashMap<>();
    public static ArrayList<String> funcUsed = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        CharStream inputStream = CharStreams.fromStream(System.in);
//        CharStream inputStream = CharStreams.fromString("");
        P5Lexer lexer = new P5Lexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        P5Parser parser = new P5Parser(tokenStream);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });
        ParseTree tree = parser.compUnit();
        com.miniSysY.P5.Visitor visitor = new com.miniSysY.P5.Visitor();
        declaredFunc.put("getint", "i32");
        declaredFunc.put("getch", "i32");
        declaredFunc.put("getarray", "i32");
        declaredFunc.put("putint", "void");
        declaredFunc.put("putch", "void");
        declaredFunc.put("putarray", "void");

        visitor.visit(tree);
        for (String s : Visitor.IR_List) {
            System.out.print(s);
        }
    }
}
