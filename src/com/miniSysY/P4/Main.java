package com.miniSysY.P4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, String> declaredFunc = new HashMap<>();
    public static ArrayList<String> funcUsed = new ArrayList<>();

    public static void main(String[] args) throws IOException {

//        CharStream inputStream = CharStreams.fromStream(System.in);
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            System.err.println(sc.next());
        }
//        CharStream inputStream = CharStreams.fromString("");
//        P4Lexer lexer = new P4Lexer(inputStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//        P4Parser parser = new P4Parser(tokenStream);
//        parser.addErrorListener(new BaseErrorListener() {
//            @Override
//            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        ParseTree tree = parser.compUnit();
//        Visitor visitor = new Visitor();
//        declaredFunc.put("getint", "i32");
//        declaredFunc.put("getch", "i32");
//        declaredFunc.put("getarray", "i32");
//        declaredFunc.put("putint", "void");
//        declaredFunc.put("putch", "void");
//        declaredFunc.put("putarray", "void");
//
//        visitor.visit(tree);
//        for (String s : Visitor.IR_List) {
//            System.out.print(s);
//        }
    }
}
