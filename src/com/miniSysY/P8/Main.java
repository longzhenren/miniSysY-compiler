package com.miniSysY.P8;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<String, String> externalFunc = new HashMap<>();
    public static ArrayList<String> funcUsed = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        CharStream inputStream = CharStreams.fromStream(System.in);
//        CharStream inputStream = CharStreams.fromString("");
        P8Lexer lexer = new P8Lexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        P8Parser parser = new P8Parser(tokenStream);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });
        ParseTree tree = parser.compUnit();
        Visitor visitor = new Visitor();
        externalFunc.put("getint", "i32");
        externalFunc.put("getch", "i32");
        externalFunc.put("getarray", "i32");
        externalFunc.put("putint", "void");
        externalFunc.put("putch", "void");
        externalFunc.put("putarray", "void");
        externalFunc.put("memset", "void");

        visitor.visit(tree);
        Visitor.IR_List.add(0, "declare void @memset(i32*, i32, i32)\n");
        for (String s : Visitor.IR_List) {
            System.out.print(s);
        }
    }
}
