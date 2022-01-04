package com.miniSysY.P8;

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

//        CharStream inputStream = CharStreams.fromStream(System.in);
        CharStream inputStream = CharStreams.fromString("int n; \n" +
                "int QuickSort(int arr[], int low, int high) { \n" +
                "    if (low < high) { \n" +
                "        int i; \n" +
                "        i = low; \n" +
                "        int j; \n" +
                "        j = high; \n" +
                "        int k; \n" +
                "        k = arr[low]; \n" +
                "        while (i < j) { \n" +
                "            while (i < j && arr[j] > k - 1) { \n" +
                "                j = j - 1; \n" +
                "            } \n" +
                " \n" +
                "            if (i < j) { \n" +
                "                arr[i] = arr[j]; \n" +
                "                i      = i + 1; \n" +
                "            } \n" +
                " \n" +
                "            while (i < j && arr[i] < k) { \n" +
                "                i = i + 1; \n" +
                "            } \n" +
                " \n" +
                "            if (i < j) { \n" +
                "                arr[j] = arr[i]; \n" +
                "                j      = j - 1; \n" +
                "            } \n" +
                "        } \n" +
                " \n" +
                "        arr[i] = k; \n" +
                "        int tmp; \n" +
                "        tmp = i - 1; \n" +
                "        tmp = QuickSort(arr, low, tmp); \n" +
                "        tmp = i + 1; \n" +
                "        tmp = QuickSort(arr, tmp, high); \n" +
                "    } \n" +
                "    return 0; \n" +
                "} \n" +
                " \n" +
                "int main() { \n" +
                " \n" +
                "    int a[10]; \n" +
                "    n = getarray(a); \n" +
                "    int i; \n" +
                "    i = 0; \n" +
                "    int tmp; \n" +
                "    tmp = 9; \n" +
                "    i   = QuickSort(a, i, tmp); \n" +
                "    putarray(10, a); \n" +
                "    return 0; \n" +
                "} ");
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

//        HashMap<String ,Object> tmp;
//        tmp = new HashMap<>();
//        Visitor.funcIdent_Attr.put("getint",tmp);
//        tmp.put("retType","i32");
//        ArrayList<String> pTypes = new ArrayList<>();
//        HashMap<String, HashMap<String, String>> funcFParams = new HashMap<>();
//        tmp.put("pTypes",pTypes);


        ArrayList<String>pType;
        externalFunc.put("getint", "i32");
        externalFunc.put("getch", "i32");
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
