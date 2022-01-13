package com.miniSysY.md;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<String, String> externalFunc = new HashMap<>();
    public static HashMap<String, ArrayList<String>> externalFunc_para = new HashMap<>();
    public static ArrayList<String> funcUsed = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        CharStream inputStream = CharStreams.fromStream(System.in);
//        CharStream inputStream = CharStreams.fromString("");
        mdLexer lexer = new mdLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        mdParser parser = new mdParser(tokenStream);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });
        ParseTree tree = parser.compUnit();
        Visitor visitor = new Visitor();

        ArrayList<String>pType;
        externalFunc.put("getint", "i32");
        pType = new ArrayList<>();
        externalFunc_para.put("getint", pType);
        externalFunc.put("getch", "i32");
        pType = new ArrayList<>();
        externalFunc_para.put("getch", pType);
        externalFunc.put("getarray", "i32");
        pType = new ArrayList<>();
        pType.add("i32*");
        externalFunc_para.put("getarray", pType);
        externalFunc.put("putint", "void");
        pType = new ArrayList<>();
        pType.add("i32");
        externalFunc_para.put("putint", pType);
        externalFunc.put("putch", "void");
        pType = new ArrayList<>();
        pType.add("i32");
        externalFunc_para.put("putch", pType);
        externalFunc.put("putarray", "void");
        pType = new ArrayList<>();
        pType.add("i32");
        pType.add("i32*");
        externalFunc_para.put("putarray", pType);
        externalFunc.put("memset", "void");
        pType = new ArrayList<>();
        pType.add("i32*");
        pType.add("i32");
        pType.add("i32");
        externalFunc_para.put("memset", pType);

        visitor.visit(tree);
        Visitor.IR_List.add(0, "declare void @memset(i32*, i32, i32)\n");
        for (String s : Visitor.IR_List) {
            System.out.print(s);
        }
    }
}
