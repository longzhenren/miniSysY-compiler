package com.miniSysY.P8;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<String, String> externalFunc = new HashMap<>();
    public static HashMap<String, String> externalFunc_para = new HashMap<>();
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
        externalFunc_para.put("getarray", "i32*");
        externalFunc.put("putint", "void");
        externalFunc_para.put("putint", "i32");
        externalFunc.put("putch", "void");
        externalFunc_para.put("putch", "i32");
        externalFunc.put("putarray", "void");
        externalFunc_para.put("putarray", "i32, i32*");
        externalFunc.put("memset", "void");
        externalFunc_para.put("memset", "i32*, i32, i32");

        visitor.visit(tree);
        Visitor.IR_List.add(0, "declare void @memset(i32*, i32, i32)\n");
        for (String s : Visitor.IR_List) {
            System.out.print(s);
        }
    }
}