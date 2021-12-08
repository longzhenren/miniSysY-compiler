package com.miniSysY.P6;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<String, String> declaredFunc = new HashMap<>();
    public static ArrayList<String> funcUsed = new ArrayList<>();

    public static void main(String[] args) throws IOException {

//        CharStream inputStream = CharStreams.fromStream(System.in);
        CharStream inputStream = CharStreams.fromString("int main() {\n" +
                "    int n = getint();\n" +
                "    int i = 0, sum = 0;\n" +
                "    while (i < n) {\n" +
                "        if (i % 2 == 0) {\n" +
                "            i = i + 1;\n" +
                "            continue;\n" +
                "        }\n" +
                "        i = i + 1;\n" +
                "        sum = sum + i;\n" +
                "        putint(sum);\n" +
                "        putch(10);\n" +
                "    }\n" +
                "    return 0;\n" +
                "}");
        P6Lexer lexer = new P6Lexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        P6Parser parser = new P6Parser(tokenStream);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });
        ParseTree tree = parser.compUnit();
        Visitor visitor = new Visitor();
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
