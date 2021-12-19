package com.miniSysY.P7;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, String> declaredFunc = new HashMap<>();
    public static ArrayList<String> funcUsed = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()){
            System.err.println(s.nextLine());
        }
        CharStream inputStream = CharStreams.fromStream(System.in);

//        CharStream inputStream = CharStreams.fromString("");
        P7Lexer lexer = new P7Lexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        P7Parser parser = new P7Parser(tokenStream);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });
        ParseTree tree = parser.compUnit();
        com.miniSysY.P7.Visitor visitor = new com.miniSysY.P7.Visitor();
        declaredFunc.put("getint", "i32");
        declaredFunc.put("getch", "i32");
        declaredFunc.put("getarray", "i32");
        declaredFunc.put("putint", "void");
        declaredFunc.put("putch", "void");
        declaredFunc.put("putarray", "void");
        declaredFunc.put("memset", "void");

        visitor.visit(tree);
        Visitor.IR_List.add(0, "declare void @memset(i32*, i32, i32)\n");
        for (String s : Visitor.IR_List) {
            System.out.print(s);
        }
    }
}
