package com.miniSysY.P7;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Visitor extends P7BaseVisitor<Void> {
    Integer currentReg = 0;
    public static HashMap<RuleNode, HashMap<String, Object>> node_attr_Val = new HashMap<>(); // 保存树上结点的各种属性
    public static HashMap<RuleContext, HashMap<String, Object>> block_ident_Reg = new HashMap<>();
    public static HashMap<String, String> reg_Type = new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> arri_size = new HashMap<>();
    public static HashMap<String, ArrayList<String>> constArr_val = new HashMap<>();
    //    public static HashMap<String, HashMap<String, Object>> funcIdent_Attr = new HashMap<>();
    public static ArrayList<String> IR_List = new ArrayList<>();

    public boolean ident_Check_Reg_this_Block(RuleContext ctx, String Ident) {
        RuleContext parent = ctx;
        while (!(parent instanceof P7Parser.BlockContext || parent instanceof P7Parser.CompUnitContext)) {
            parent = parent.parent;
        }
        if (!block_ident_Reg.containsKey(parent))
            return false;
        return block_ident_Reg.get(parent).containsKey(Ident);
    }

    public boolean ident_Check_Reg(RuleContext ctx, String Ident) {
        RuleContext parent = ctx;
        while (!(parent instanceof P7Parser.CompUnitContext)) {
            if (parent instanceof P7Parser.BlockContext) {
                if (block_ident_Reg.containsKey(parent)) {
//                    HashMap<String, Integer> I_R = block_ident_Reg.get(parent);
                    if (block_ident_Reg.get(parent).containsKey(Ident)) {
                        return true;
                    }
                }
            }
            parent = parent.parent;
        }
        if (block_ident_Reg.containsKey(parent)) {
            return block_ident_Reg.get(parent).containsKey(Ident);
        }
        return false;
    }

//    public HashMap<String, Integer> get_Id_List(RuleContext ctx) {// 获取当前可用的符号表
//        RuleContext parent = ctx;
//        HashMap<String, Integer> res = new HashMap<>();
//        while (!(parent instanceof P7Parser.CompUnitContext)) {
//            if (parent instanceof P7Parser.BlockContext) {
//                HashMap<String, Integer> tmp = block_ident_Reg.get(parent);
//                for (String ident : tmp.keySet()) {
//                    if (!res.containsKey(ident)) {
//                        res.put(ident, tmp.get(ident));
//                    }
//                }
//            }
//            parent = parent.parent;
//        }
//        return res;
//    }

    public void ident_Put_Reg(RuleContext ctx, String Ident, Object Reg) {// 添加符号
        RuleContext parent = ctx;
        while (!(parent instanceof P7Parser.CompUnitContext)) {
            if (parent instanceof P7Parser.BlockContext) {
                HashMap<String, Object> I_R;
                if (block_ident_Reg.containsKey(parent)) {
                    I_R = block_ident_Reg.get(parent);
                } else {
                    I_R = new HashMap<>();
                }
                I_R.put(Ident, Reg);
                block_ident_Reg.put(parent, I_R);
                return;
            } else {
                parent = parent.parent;
            }
        }
        HashMap<String, Object> I_R;
        if (block_ident_Reg.containsKey(parent)) {
            I_R = block_ident_Reg.get(parent);
        } else {
            I_R = new HashMap<>();
        }
        I_R.put(Ident, Reg);
        block_ident_Reg.put(parent, I_R);
    }

    public Object ident_Get_Reg(RuleContext ctx, String Ident) {
        RuleContext parent = ctx;
        while (!(parent instanceof P7Parser.CompUnitContext)) {
            if (parent instanceof P7Parser.BlockContext) {
                if (block_ident_Reg.containsKey(parent)) {
                    if (block_ident_Reg.get(parent).containsKey(Ident)) {
                        return block_ident_Reg.get(parent).get(Ident);
                    }
                }
            }
            parent = parent.parent;
        }
        if (block_ident_Reg.containsKey(parent)) {
            if (block_ident_Reg.get(parent).containsKey(Ident)) {
                return block_ident_Reg.get(parent).get(Ident);
            }
        }
        return null;
    }

    @Override
    // blockItem:decl|stmt;
    public Void visitBlockItem(P7Parser.BlockItemContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.stmt() != null) {
            attr_Val.put("type", "stmt");
            visit(ctx.stmt());
        } else if (ctx.decl() != null) {
            attr_Val.put("type", "decl");
            visit(ctx.decl());
        }
        if (ctx.parent instanceof P7Parser.StmtContext) {
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    // lVal:Ident (LBracket exp RBracket)*;
    public Void visitLVal(P7Parser.LValContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        String Ident = ctx.Ident().getText();
        if (ctx.exp().size() != 0) {
            if (ident_Check_Reg(ctx, Ident)) {
                ArrayList<Integer> size = arri_size.get(Ident);
                if (ctx.exp().size() != size.size()) {
                    System.err.println("Array Type not Match!");
                    System.exit(-1);
                }
                //取出数组中的元素相关IR
                //获取维数，计算地址偏移量，取值
                if (size.size() == 2) {
                    String e0val = null, e1val = null;
                    visit(ctx.exp(0));
                    String baseptr = "%x" + (currentReg++);
                    String idptr = (String) ident_Get_Reg(ctx, Ident);
                    IR_List.add("\t" + baseptr + " = getelementptr [" + size.get(0) + " x [" + size.get(1) + " x i32]], [" + size.get(0) + " x [" + size.get(1) + " x i32]]* " + idptr + ", i32 0, i32 0\n");
                    if (node_attr_Val.get(ctx.exp(0)).containsKey("numberVal")) {
                        e0val = (String) node_attr_Val.get(ctx.exp(0)).get("numberVal");
                    } else if (node_attr_Val.get(ctx.exp(0)).containsKey("thisReg")) {
                        e0val = (String) node_attr_Val.get(ctx.exp(0)).get("thisReg");
                    }
                    visit(ctx.exp(1));
                    String rowReg = "%x" + currentReg++;
                    IR_List.add("\t" + rowReg + " = add i32 0, " + e0val + "\n");
                    if (node_attr_Val.get(ctx.exp(1)).containsKey("numberVal")) {
                        e1val = (String) node_attr_Val.get(ctx.exp(1)).get("numberVal");
                    } else if (node_attr_Val.get(ctx.exp(1)).containsKey("thisReg")) {
                        e1val = (String) node_attr_Val.get(ctx.exp(1)).get("thisReg");
                    }
                    String mulReg = "%x" + currentReg++;
                    IR_List.add("\t" + mulReg + " = mul i32 " + rowReg + ", " + size.get(1) + "\n");
                    String baselineptr = "%x" + (currentReg++);
                    IR_List.add("\t" + baselineptr + " = getelementptr [" + size.get(1) + " x i32], [" + size.get(1) + " x i32]* " + baseptr + ", i32 0, i32 0\n");
                    String colReg = "%x" + currentReg++;
                    IR_List.add("\t" + colReg + " = add i32 " + mulReg + ", " + e1val + "\n");
                    String valReg = "%x" + currentReg++;
                    attr_Val.put("arrReg", valReg);
                    reg_Type.put(valReg, "i32");
                    IR_List.add("\t" + valReg + " = getelementptr i32, i32* " + baselineptr + ", i32 " + colReg + "\n");
                    String thisReg = "%x" + currentReg++;
                    IR_List.add("\t" + thisReg + " = load i32, i32* " + valReg + "\n");
                    reg_Type.put(thisReg, "i32");
                    attr_Val.put("thisReg", thisReg);
                } else if (size.size() == 1) {
                    visit(ctx.exp(0));
                    String baseptr = "%x" + (currentReg++);
                    String idptr = (String) ident_Get_Reg(ctx, Ident);
                    IR_List.add("\t" + baseptr + " = getelementptr [" + size.get(0) + " x i32], [" + size.get(0) + " x i32]* " + idptr + ", i32 0, i32 0\n");
                    String e0val = null;
                    if (node_attr_Val.get(ctx.exp(0)).containsKey("numberVal")) {
                        e0val = (String) node_attr_Val.get(ctx.exp(0)).get("numberVal");
                    } else if (node_attr_Val.get(ctx.exp(0)).containsKey("thisReg")) {
                        e0val = (String) node_attr_Val.get(ctx.exp(0)).get("thisReg");
                    }
                    String colReg = "%x" + currentReg++;
                    IR_List.add("\t" + colReg + " = add i32 0, " + e0val + "\n");
                    String valReg = "%x" + currentReg++;
                    IR_List.add("\t" + valReg + " = getelementptr i32, i32* " + baseptr + ", i32 " + colReg + "\n");
                    attr_Val.put("arrReg", valReg);
                    reg_Type.put(valReg, "i32");
                    String thisReg = "%x" + currentReg++;
                    IR_List.add("\t" + thisReg + " = load i32, i32* " + valReg + "\n");
                    reg_Type.put(thisReg, "i32");
                    attr_Val.put("thisReg", thisReg);
                }

            } else {
                System.err.println("Undeclared Ident:" + Ident);
                System.exit(1);
            }
        } else {
            if (ident_Check_Reg(ctx, Ident)) {
                String identReg = (String) ident_Get_Reg(ctx, Ident);
                if (identReg.startsWith("%x") || identReg.startsWith("@")) {// local var or global var
                    String thisReg = "%x" + currentReg++;
                    reg_Type.put(thisReg, "i32");
                    IR_List.add("\t" + thisReg + " = load i32, i32* " + identReg + "\n");
                    attr_Val.put("thisReg", thisReg);
                } else {// const
                    attr_Val.put("nodeVal", identReg);
                }
            } else {
                System.err.println("Undeclared Ident:" + Ident);
                System.exit(1);
            }
        }
        return null;
    }

    @Override
    // decl:constDecl|varDecl;
    public Void visitDecl(P7Parser.DeclContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.parent instanceof P7Parser.CompUnitContext) {
            attr_Val.put("global", "global");
        }
        if (ctx.constDecl() != null) {
            visit(ctx.constDecl());
        } else if (ctx.varDecl() != null) {
            visit(ctx.varDecl());
        }
        return null;
    }

    @Override
    // constDecl:CONST_KW bType constDef (',' constDef)* Semicolon;
    public Void visitConstDecl(P7Parser.ConstDeclContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.bType());
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        for (P7Parser.ConstDefContext cdf : ctx.constDef()) {
            String Ident = cdf.Ident().getText();
            if (ident_Check_Reg_this_Block(cdf, Ident)) {
                System.err.println("Re-Declaration Ident:" + Ident);
                System.exit(1);
            }
            visit(cdf);
        }
        return null;
    }

    @Override
    // bType:INT_KW;
    public Void visitBType(P7Parser.BTypeContext ctx) {
        if (ctx.INT_KW() != null) {
            node_attr_Val.get(ctx.parent).put("bType", "i32");
        }
        return null;
    }

    @Override
    // Ident ( LBracket constExp RBracket )* ASSIGN constInitVal;
    public Void visitConstDef(P7Parser.ConstDefContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        String thisReg;
        String Ident = ctx.Ident().getText();
        if (ctx.constExp().size() != 0) {
            ArrayList<Integer> size = new ArrayList<>();
            attr_Val.put("size", size);
            arri_size.put(Ident, size);
            attr_Val.put("dim", size.size());
            for (P7Parser.ConstExpContext ce : ctx.constExp()) {
                visit(ce);
                size.add(Integer.parseInt((String) (node_attr_Val.get(ce).get("constExpVal"))));
            }
            if (node_attr_Val.get(ctx.parent).containsKey("global")) {
                attr_Val.put("global", "global");
                thisReg = "@" + Ident;
                reg_Type.put(thisReg, "i32");
                arri_size.put(thisReg, size);
                if (ctx.constInitVal() != null) {
                    StringBuilder sbIR = new StringBuilder();
                    sbIR.append(thisReg).append(" = dso_local constant ");
                    if (size.size() == 1) {
                        sbIR.append("[").append(size.get(0)).append(" x i32] ");
                    } else if (size.size() == 2) {
                        sbIR.append("[").append(size.get(0)).append(" x [").append(size.get(1)).append(" x i32]] ");
                    }
                    visit(ctx.constInitVal());//TODO:访问initval时候也要注意有没有IR输出（对于全局变量）
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.constInitVal()).get("arr_pos_val");
                    sbIR.append("[");
                    if (size.size() == 1) {
                        boolean zerorow = true;
                        for (int i = 0; i < size.get(0); i++) {
                            if (arr_pos_val.containsKey(String.valueOf(i))) {
                                zerorow = false;
                                break;
                            }
                        }
                        if (!zerorow) {
                            for (int i = 0; i < size.get(0); i++) {
                                if (arr_pos_val.containsKey(String.valueOf(i))) {
                                    sbIR.append("i32 ").append(arr_pos_val.get(String.valueOf(i)));
                                } else {
                                    sbIR.append("i32 0");
                                }
                                if (i < size.get(0) - 1) {
                                    sbIR.append(", ");
                                }
                            }
                        } else {
                            sbIR.append("zeroinitializer");
                        }
                    } else if (size.size() == 2) {
                        for (int i = 0; i < size.get(0); i++) {
                            sbIR.append("[").append(size.get(1)).append(" x i32] ");
                            boolean zerorow = true;
                            for (int j = 0; j < size.get(1); j++) {
                                int tmp = size.get(1) * i + j;
                                if (arr_pos_val.containsKey(String.valueOf(tmp))) {
                                    zerorow = false;
                                    break;
                                }
                            }
                            if (!zerorow) {
                                sbIR.append("[");
                                for (int j = 0; j < size.get(1); j++) {
                                    int tmp = size.get(1) * i + j;
                                    if (arr_pos_val.containsKey(String.valueOf(tmp))) {
                                        sbIR.append("i32 ").append(arr_pos_val.get(String.valueOf(tmp)));
                                    } else {
                                        sbIR.append("i32 0");
                                    }
                                    if (j < size.get(1) - 1) {
                                        sbIR.append(", ");
                                    }
                                }
                                sbIR.append("]");
                            } else {
                                sbIR.append("zeroinitializer");
                            }
                            if (i < size.get(0) - 1) {
                                sbIR.append(", ");
                            }
                        }
                    }
                    sbIR.append("]");
                    sbIR.append("\n");
                    IR_List.add(String.valueOf(sbIR));
                } else {
                    if (size.size() == 1) {
                        IR_List.add(thisReg + " = dso_local global [" + size.get(0) + " x i32] zeroinitializer\n");
                    } else if (size.size() == 2) {
                        IR_List.add(thisReg + " = dso_local global [" + size.get(0) + " x [" + size.get(1) + " x i32]] zeroinitializer\n");
                    }
                }
                ident_Put_Reg(ctx, Ident, thisReg);
            } else {
                thisReg = "%x" + currentReg++;
                ident_Put_Reg(ctx, Ident, thisReg);
                reg_Type.put(thisReg, "i32");
                String colptr = null;
                if (size.size() == 2) {
                    String baselineptr = "%x" + currentReg++;
                    colptr = "%x" + currentReg++;
                    IR_List.add("\t" + thisReg + " = alloca [" + size.get(0) + " x [" + size.get(1) + " x i32]]\n");
                    IR_List.add("\t" + baselineptr + " = getelementptr " + "[" + size.get(0) + " x [" + size.get(1) + " x i32]]" + ", " + "[" + size.get(0) + " x [" + size.get(1) + " x i32]]* " + thisReg + ", i32 0, i32 0\n");
                    IR_List.add("\t" + colptr + " = getelementptr [" + size.get(1) + " x i32], [" + size.get(1) + " x i32]* " + baselineptr + ", i32 0, i32 0\n");
                    IR_List.add("\tcall void @memset(i32* " + colptr + ", i32 0, i32 " + 4 * size.get(1) * size.get(0) + ")\n");
                } else if (size.size() == 1) {
                    colptr = "%x" + currentReg++;
                    IR_List.add("\t" + thisReg + " = alloca [" + size.get(0) + " x i32]\n");
                    IR_List.add("\t" + colptr + " = getelementptr [" + size.get(0) + " x i32], [" + size.get(0) + " x i32]* " + thisReg + ", i32 0, i32 0\n");
                    IR_List.add("\tcall void @memset(i32* " + colptr + ", i32 0, i32 " + 4 * size.get(0) + ")\n");
                }
                if (ctx.constInitVal() != null) {
                    visit(ctx.constInitVal());
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.constInitVal()).get("arr_pos_val");
                    for (String pos : arr_pos_val.keySet()) {
                        String tmpReg = "%x" + currentReg++;
                        IR_List.add("\t" + tmpReg + " = getelementptr i32, i32* " + colptr + ", i32 " + pos + "\n");
                        IR_List.add("\tstore i32 " + arr_pos_val.get(pos) + ", i32* " + tmpReg + "\n");
                    }
                }
            }
        } else {
            if (node_attr_Val.get(ctx.parent).containsKey("global")) {
                attr_Val.put("global", "global");
                long globalInitValue = 0;
                if (ctx.ASSIGN() != null) {
                    if (ctx.ASSIGN().getText().equals("=")) {
                        visit(ctx.constInitVal());
                        if (node_attr_Val.get(ctx.constInitVal()).containsKey("constExpVal")) {
                            globalInitValue = Long.parseLong((String) (node_attr_Val.get(ctx.constInitVal()).get("constExpVal")));
                        }
                    }
                }
                ident_Put_Reg(ctx, Ident, String.valueOf(globalInitValue));
            } else {
                if (ctx.ASSIGN() != null) {
                    if (ctx.ASSIGN().getText().equals("=")) {
                        visit(ctx.constInitVal());
                        Long constExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.constInitVal()).get("constExpVal")));
                        if (!ident_Check_Reg_this_Block(ctx, Ident)) {
                            ident_Put_Reg(ctx, Ident, String.valueOf(constExpVal));
                        } else {
                            System.err.println("Re-Declaration ident:" + Ident);
                            System.exit(1);
                        }
                    }
                }
            }
        }

        return null;
    }

    int pos = 0;
    HashMap<String, String> arr_pos_val = null;
    ArrayList<Integer> arrsize = null;

    @Override
    // constInitVal:constExp | LBrace ( constInitVal ( ',' constInitVal )* )? RBrace;
    public Void visitConstInitVal(P7Parser.ConstInitValContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.constExp() != null) {
            visit(ctx.constExp());
            attr_Val.put("constExpVal", node_attr_Val.get(ctx.constExp()).get("constExpVal"));
        } else if (ctx.constInitVal() != null) {
            // {{1}, {2, 3}}
            //TODO:分层解析赋值语句
            if (ctx.parent instanceof P7Parser.ConstDefContext) {
                arr_pos_val = new HashMap<>();
                arrsize = (ArrayList<Integer>) node_attr_Val.get(ctx.parent).get("size");
                attr_Val.put("arr_pos_val", arr_pos_val);
                pos = 0;
            }
            int cnt = pos;
            boolean bottom = false;
            for (P7Parser.ConstInitValContext ci : ctx.constInitVal()) {//一个括号内部
                visit(ci);
                if (ci.constExp() != null) {
                    bottom = true;
                    String expval = (String) node_attr_Val.get(ci.constExp()).get("constExpVal");
                    arr_pos_val.put(String.valueOf(cnt++), expval);
                }
            }
            if (bottom && (cnt - pos) < arrsize.get(arrsize.size() - 1)) {
                cnt = arrsize.get(arrsize.size() - 1);
            }
//            while (bottom && (cnt - pos) < arrsize.get(arrsize.size() - 1)) {
//                arrval.add(cnt++, "0");
//                cnt++;
//            }
            pos = cnt;
        }
        return null;
    }

    @Override
    // constExp:addExp;
    public Void visitConstExp(P7Parser.ConstExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.addExp());
        attr_Val.put("constExpVal", node_attr_Val.get(ctx.addExp()).get("numberVal"));
        return null;
    }

    @Override
    // varDecl:bType varDef (',' varDef)* Semicolon;
    public Void visitVarDecl(P7Parser.VarDeclContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.bType());
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        for (P7Parser.VarDefContext vdf : ctx.varDef()) {
            String Ident = vdf.Ident().getText();
//            if (ident_Reg.containsKey(Ident) || constIdent_Val.containsKey(Ident)) {
            if (ident_Check_Reg_this_Block(ctx, Ident)) {
                System.err.println("Re-Declaration ident:" + Ident);
                System.exit(1);
            }
            visit(vdf);
        }
//        node_attr_Val.put(ctx, attr_Val);
        return null;
    }

    @Override
    // varDef:Ident ( LBracket constExp RBracket )* | Ident ( LBracket constExp RBracket )* ASSIGN initVal;
    public Void visitVarDef(P7Parser.VarDefContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        String thisReg;
        String Ident = ctx.Ident().getText();
        if (ctx.constExp().size() != 0) {
            ArrayList<Integer> size = new ArrayList<>();
            attr_Val.put("size", size);
            arri_size.put(Ident, size);
            attr_Val.put("dim", size.size());
            for (P7Parser.ConstExpContext ce : ctx.constExp()) {
                visit(ce);
                size.add(Integer.parseInt((String) (node_attr_Val.get(ce).get("constExpVal"))));
            }
            if (node_attr_Val.get(ctx.parent).containsKey("global")) {
                attr_Val.put("global", "global");
                thisReg = "@" + Ident;
                arri_size.put(thisReg, size);
                reg_Type.put(thisReg, "i32");
                if (ctx.initVal() != null) {
                    StringBuilder sbIR = new StringBuilder();
                    sbIR.append(thisReg).append(" = dso_local global ");
                    if (size.size() == 1) {
                        sbIR.append("[").append(size.get(0)).append(" x i32] ");
                    } else if (size.size() == 2) {
                        sbIR.append("[").append(size.get(0)).append(" x [").append(size.get(1)).append(" x i32]] ");
                    }
                    visit(ctx.initVal());//TODO:访问initval时候也要注意有没有IR输出（对于全局变量）
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.initVal()).get("arr_pos_val");
                    sbIR.append("[");
                    if (size.size() == 1) {
                        boolean zerorow = true;
                        for (int i = 0; i < size.get(0); i++) {
                            if (arr_pos_val.containsKey(String.valueOf(i))) {
                                zerorow = false;
                                break;
                            }

                        }
                        if (!zerorow) {
                            for (int i = 0; i < size.get(0); i++) {
                                if (arr_pos_val.containsKey(String.valueOf(i))) {
                                    sbIR.append("i32 ").append(arr_pos_val.get(String.valueOf(i)));
                                } else {
                                    sbIR.append("i32 0");
                                }
                                if (i < size.get(0) - 1) {
                                    sbIR.append(", ");
                                }
                            }
                        } else {
                            sbIR.append("zeroinitializer");
                        }
                    } else if (size.size() == 2) {
                        for (int i = 0; i < size.get(0); i++) {
                            sbIR.append("[").append(size.get(1)).append(" x i32] ");
                            boolean zerorow = true;
                            for (int j = 0; j < size.get(1); j++) {
                                int tmp = size.get(1) * i + j;
                                if (arr_pos_val.containsKey(String.valueOf(tmp))) {
                                    zerorow = false;
                                    break;
                                }
                            }
                            if (!zerorow) {
                                sbIR.append("[");
                                for (int j = 0; j < size.get(1); j++) {
                                    int tmp = size.get(1) * i + j;
                                    if (arr_pos_val.containsKey(String.valueOf(tmp))) {
                                        sbIR.append("i32 ").append(arr_pos_val.get(String.valueOf(tmp)));
                                    } else {
                                        sbIR.append("i32 0");
                                    }
                                    if (j < size.get(1) - 1) {
                                        sbIR.append(", ");
                                    }
                                }
                                sbIR.append("]");
                            } else {
                                sbIR.append("zeroinitializer");
                            }
                            if (i < size.get(0) - 1) {
                                sbIR.append(", ");
                            }
                        }
                    }
                    sbIR.append("]");
                    sbIR.append("\n");
                    IR_List.add(String.valueOf(sbIR));
                } else {
                    if (size.size() == 1) {
                        IR_List.add(thisReg + " = dso_local global [" + size.get(0) + " x i32] zeroinitializer\n");
                    } else if (size.size() == 2) {
                        IR_List.add(thisReg + " = dso_local global [" + size.get(0) + " x [" + size.get(1) + " x i32]] zeroinitializer\n");
                    }
                }
                ident_Put_Reg(ctx, Ident, thisReg);
            } else {
                thisReg = "%x" + currentReg++;
                ident_Put_Reg(ctx, Ident, thisReg);
                reg_Type.put(thisReg, "i32");
                String colptr = null;
                if (size.size() == 2) {
                    String baselineptr = "%x" + currentReg++;
                    colptr = "%x" + currentReg++;
                    IR_List.add("\t" + thisReg + " = alloca [" + size.get(0) + " x [" + size.get(1) + " x i32]]\n");
                    IR_List.add("\t" + baselineptr + " = getelementptr " + "[" + size.get(0) + " x [" + size.get(1) + " x i32]]" + ", " + "[" + size.get(0) + " x [" + size.get(1) + " x i32]]* " + thisReg + ", i32 0, i32 0\n");
                    IR_List.add("\t" + colptr + " = getelementptr [" + size.get(1) + " x i32], [" + size.get(1) + " x i32]* " + baselineptr + ", i32 0, i32 0\n");
                    IR_List.add("\tcall void @memset(i32* " + colptr + ", i32 0, i32 " + 4 * size.get(1) * size.get(0) + ")\n");
                } else if (size.size() == 1) {
                    colptr = "%x" + currentReg++;
                    IR_List.add("\t" + thisReg + " = alloca [" + size.get(0) + " x i32]\n");
                    IR_List.add("\t" + colptr + " = getelementptr [" + size.get(0) + " x i32], [" + size.get(0) + " x i32]* " + thisReg + ", i32 0, i32 0\n");
                    IR_List.add("\tcall void @memset(i32* " + colptr + ", i32 0, i32 " + 4 * size.get(0) + ")\n");
                }
                if (ctx.initVal() != null) {
                    visit(ctx.initVal());
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.initVal()).get("arr_pos_val");

                    for (String pos : arr_pos_val.keySet()) {
                        String tmpReg = "%x" + currentReg++;
                        IR_List.add("\t" + tmpReg + " = getelementptr i32, i32* " + colptr + ", i32 " + pos + "\n");
                        IR_List.add("\tstore i32 " + arr_pos_val.get(pos) + ", i32* " + tmpReg + "\n");
                    }
                }
            }
        } else {
            if (node_attr_Val.get(ctx.parent).containsKey("global")) {
                attr_Val.put("global", "global");
                thisReg = "@" + Ident;
                String bType = (String) node_attr_Val.get(ctx.parent).get("bType");
                reg_Type.put(thisReg, bType);
                long globalInitValue = 0;
                if (ctx.ASSIGN() != null) {
                    if (ctx.ASSIGN().getText().equals("=")) {
                        visit(ctx.initVal());
                        if (node_attr_Val.get(ctx.initVal()).containsKey("numberVal")) {
                            globalInitValue = Long.parseLong((String) (node_attr_Val.get(ctx.initVal()).get("numberVal")));
                        }
                    }
                }
                ident_Put_Reg(ctx, Ident, thisReg);
                IR_List.add(thisReg + " = dso_local global " + bType + " " + globalInitValue + "\n");
            } else {
                thisReg = "%x" + currentReg++;
                String bType = (String) node_attr_Val.get(ctx.parent).get("bType");
                reg_Type.put(thisReg, bType);
                IR_List.add("\t" + thisReg + " = alloca " + bType + ", align 4" + "\n");
                ident_Put_Reg(ctx, Ident, thisReg);
                if (ctx.ASSIGN() != null) {
                    if (ctx.ASSIGN().getText().equals("=")) {
                        visit(ctx.initVal());
                        if (node_attr_Val.get(ctx.initVal()).containsKey("thisReg")) {
                            String initValReg = (String) node_attr_Val.get(ctx.initVal()).get("thisReg");
                            if (!bType.equals(reg_Type.get(initValReg))) {
                                System.out.println("Type dismatch!");
                                System.exit(-1);
                            }
                            IR_List.add("\tstore " + bType + " " + initValReg + ", " + bType + "* " + thisReg + "\n");
                        } else if (node_attr_Val.get(ctx.initVal()).containsKey("numberVal")) {
                            long numVal = Long.parseLong((String) (node_attr_Val.get(ctx.initVal()).get("numberVal")));
                            IR_List.add("\tstore i32 " + numVal + ", " + bType + "* " + thisReg + "\n");
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    // exp | LBrace ( initVal ( ',' initVal )* )? RBrace;
    public Void visitInitVal(P7Parser.InitValContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        if (ctx.exp() != null) {
            visit(ctx.exp());
            if (node_attr_Val.get(ctx.exp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.exp()).get("thisReg"));
            } else if (node_attr_Val.get(ctx.exp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.exp()).get("numberVal"));
            }
        } else if (ctx.initVal() != null) {
            // {{1}, {2, 3}}
            //TODO:分层解析赋值语句
            if (ctx.parent instanceof P7Parser.VarDefContext) {
                arr_pos_val = new HashMap<>();
                arrsize = (ArrayList<Integer>) node_attr_Val.get(ctx.parent).get("size");
                attr_Val.put("arr_pos_val", arr_pos_val);
                pos = 0;
            }
            int cnt = pos;
            boolean bottom = false;
            for (P7Parser.InitValContext i : ctx.initVal()) {//一个括号内部
                visit(i);
                if (i.exp() != null) {
                    bottom = true;
                    if (node_attr_Val.get(i).containsKey("numberVal")) {//直接就是一个数字
                        String expval = (String) node_attr_Val.get(i).get("numberVal");
                        arr_pos_val.put(String.valueOf(cnt++), expval);
                    } else if (node_attr_Val.get(i).containsKey("thisReg")) {//传进来Lval对应的东西
                        String expval = (String) node_attr_Val.get(i).get("thisReg");
                        arr_pos_val.put(String.valueOf(cnt++), expval);
                    }
                }
            }
            if (bottom && (cnt - pos) < arrsize.get(arrsize.size() - 1)) {
                cnt = arrsize.get(arrsize.size() - 1);
            }
            pos = cnt;
        }
        return null;
    }

    @Override
    // compUnit:(decl)* funcDef;
    public Void visitCompUnit(P7Parser.CompUnitContext ctx) {
        if (ctx.decl().size() > 0) {
            for (P7Parser.DeclContext dcx : ctx.decl()) {
                visit(dcx);
            }
        }
        visit(ctx.funcDef());
        return null;
    }

    @Override
    // funcType:INT_KW;
    public Void visitFuncType(P7Parser.FuncTypeContext ctx) {
        HashMap<String, Object> node_Attr = new HashMap<>();
        if (ctx.INT_KW().getText().equals("int"))
            node_Attr.put("funcType", "i32");
        node_attr_Val.put(ctx, node_Attr);
        return null;
    }

    @Override
    // funcIdent:FuncIdent;
    public Void visitFuncIdent(P7Parser.FuncIdentContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        attr_Val.put("funcIdent", ctx.FuncIdent().getText());
        node_attr_Val.put(ctx, attr_Val);
        return null;
    }

    @Override
    // funcDef:funcType funcIdent LParser RParser block;
    public Void visitFuncDef(P7Parser.FuncDefContext ctx) {
        visit(ctx.funcType());
        visit(ctx.funcIdent());
        IR_List.add("define dso_local " + node_attr_Val.get(ctx.funcType()).get("funcType") + " " + "@" + node_attr_Val.get(ctx.funcIdent()).get("funcIdent") + " ()" + "{\n");
        visit(ctx.block());
        IR_List.add("}");
        return null;
    }

    @Override
    // block:LBrace (blockItem)* RBrace;
    public Void visitBlock(P7Parser.BlockContext ctx) {
        for (P7Parser.BlockItemContext bi : ctx.blockItem()) {
            visit(bi);
        }
        return null;
    }

    @Override
    // stmt:lVal ASSIGN exp Semicolon|block|(exp)+ Semicolon|returnStmt|IF_KW LParser cond RParser stmt ( ELSE_KW stmt )* | WHILE_KW LParser cond RParser stmt;
    public Void visitStmt(P7Parser.StmtContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.returnStmt() != null) {
            visit(ctx.returnStmt());
        } else if (ctx.ASSIGN() != null) {
            if (ctx.ASSIGN().getText().equals("=")) {
                String Ident = ctx.lVal().Ident().getText();
                if (!ident_Check_Reg(ctx, Ident)) {
                    System.err.println("Undeclared Ident:" + Ident);
                    System.exit(1);
                }
                visit(ctx.lVal());
                String identReg = null;
                if (node_attr_Val.get(ctx.lVal()).containsKey("arrReg")) {
                    identReg = (String) node_attr_Val.get(ctx.lVal()).get("arrReg");
                } else {
                    identReg = (String) ident_Get_Reg(ctx, Ident);
                }
//                String identReg = (String) ident_Get_Reg(ctx, Ident);
                String bType = reg_Type.get(identReg);
                visit(ctx.exp());
                if (node_attr_Val.get(ctx.exp()).containsKey("thisReg")) {
                    String expReg = (String) node_attr_Val.get(ctx.exp()).get("thisReg");
                    if (!(reg_Type.get(identReg).equals(reg_Type.get(expReg)))) {
                        System.out.println("Type dismatch!");
                        System.exit(-1);
                    }
                    IR_List.add("\tstore " + bType + " " + expReg + ", " + bType + "* " + identReg + "\n");
                } else if (node_attr_Val.get(ctx.exp()).containsKey("numberVal")) {
                    IR_List.add("\tstore i32 " + node_attr_Val.get(ctx.exp()).get("numberVal") + ", i32* " + identReg + "\n");
                }
            }
        } else if (ctx.IF_KW() != null) {
            visit(ctx.cond());
            Integer TLabel = (Integer) node_attr_Val.get(ctx.cond()).get("TLabel");
            Integer FLabel = (Integer) node_attr_Val.get(ctx.cond()).get("FLabel");
            String PassLabel = String.valueOf(currentReg++);
            reg_Type.put(PassLabel, "i32");
            if (ctx.ELSE_KW() == null) {
                IR_List.add("\nx" + TLabel + ":\n");
                visit(ctx.stmt(0));
                IR_List.add("\tbr label %x" + PassLabel + "\n");

                IR_List.add("\nx" + PassLabel + ":\n");
                IR_List.add("\tbr label %x" + FLabel + "\n");
                IR_List.add("\nx" + FLabel + ":\n");
            } else {
                IR_List.add("\nx" + TLabel + ":\n");
                visit(ctx.stmt(0));
                IR_List.add("\tbr label %x" + PassLabel + "\n");

                IR_List.add("\nx" + FLabel + ":\n");
                if (ctx.stmt().size() == 2)
                    visit(ctx.stmt(1));
                IR_List.add("\tbr label %x" + PassLabel + "\n");

                IR_List.add("\nx" + PassLabel + ":\n");
            }
        } else if (ctx.block() != null) {
            visit(ctx.block());
        } else if (ctx.WHILE_KW() != null) {
            String StartLabel = String.valueOf(currentReg++);

            IR_List.add("\tbr label %x" + StartLabel + "\n");

            IR_List.add("\nx" + StartLabel + ":\n");
            visit(ctx.cond());

            Integer TLabel = (Integer) node_attr_Val.get(ctx.cond()).get("TLabel");
            Integer FLabel = (Integer) node_attr_Val.get(ctx.cond()).get("FLabel");

            attr_Val.put("StartLabel", StartLabel);
            attr_Val.put("FLabel", FLabel);
            attr_Val.put("TLabel", TLabel);

            IR_List.add("\nx" + TLabel + ":\n");
            visit(ctx.stmt(0));
            IR_List.add("\tbr label %x" + StartLabel + "\n");

            IR_List.add("\nx" + FLabel + ":\n");
        } else if (ctx.BREAK_KW() != null) {
            RuleContext parent = ctx;
            String StartLabel = null;
            Integer TLabel = null, FLabel = null;
            while (!(parent instanceof P7Parser.CompUnitContext)) {
                if (parent instanceof P7Parser.StmtContext) {
                    if (((P7Parser.StmtContext) parent).WHILE_KW() != null) {
                        StartLabel = (String) node_attr_Val.get(parent).get("StartLabel");
                        TLabel = (Integer) node_attr_Val.get(parent).get("TLabel");
                        FLabel = (Integer) node_attr_Val.get(parent).get("FLabel");
                        break;
                    }
                }
                parent = parent.parent;
            }
            IR_List.add("\tbr label %x" + FLabel + "\n");
            if (StartLabel == null || TLabel == null || FLabel == null) {
                System.err.println("Separate BREAK");
                System.exit(-1);
            }
        } else if (ctx.CONTINUE_KW() != null) {
            RuleContext parent = ctx;
            String StartLabel = null;
            Integer TLabel = null, FLabel = null;
            while (!(parent instanceof P7Parser.CompUnitContext)) {
                if (parent instanceof P7Parser.StmtContext) {
                    if (((P7Parser.StmtContext) parent).WHILE_KW() != null) {
                        StartLabel = (String) node_attr_Val.get(parent).get("StartLabel");
                        TLabel = (Integer) node_attr_Val.get(parent).get("TLabel");
                        FLabel = (Integer) node_attr_Val.get(parent).get("FLabel");
                        break;
                    }
                }
                parent = parent.parent;
            }
            IR_List.add("\tbr label %x" + StartLabel + "\n");
            if (StartLabel == null || TLabel == null || FLabel == null) {
                System.err.println("Separate CONTINUE");
                System.exit(-1);
            }
        } else {
            visit(ctx.exp());
        }
        node_attr_Val.put(ctx, attr_Val);
        return null;
    }

    @Override
    // number:intConst;
    public Void visitNumber(P7Parser.NumberContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        if (ctx.intConst() != null) {
            visit(ctx.intConst());
            attr_Val.put("nodeVal", node_attr_Val.get(ctx.intConst()).get("nodeVal"));
        }
        return null;
    }

    @Override
    // intConst:DecimalConst|OctalConst|HexadecimalConst;
    public Void visitIntConst(P7Parser.IntConstContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        long res = 0L;
        if (ctx.HexadecimalConst() != null) {
            String hex = ctx.HexadecimalConst().getText().toLowerCase().substring(2);
            res = Long.parseLong(hex, 16);
        } else if (ctx.OctalConst() != null) {
            String oct = ctx.OctalConst().getText();
            res = Long.parseLong(oct, 8);
        } else if (ctx.DecimalConst() != null) {
            String dec = ctx.DecimalConst().getText();
            res = Long.parseLong(dec, 10);
        }
        if (res <= 2147483647L && res >= 0L) {
            attr_Val.put("nodeVal", String.valueOf(res));
        }
        return null;
    }

    @Override
    // returnStmt:RETURN_KW exp Semicolon;
    public Void visitReturnStmt(P7Parser.ReturnStmtContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.exp());
        if (node_attr_Val.get(ctx.exp()).containsKey("thisReg")) {
            String expReg = (String) node_attr_Val.get(ctx.exp()).get("thisReg");
            String bType = reg_Type.get(expReg);
            IR_List.add("\tret " + bType + " " + expReg + "\n");
        } else if (node_attr_Val.get(ctx.exp()).containsKey("numberVal")) {
            IR_List.add("\tret i32 " + node_attr_Val.get(ctx.exp()).get("numberVal") + "\n");
        }
        return null;
    }

    @Override
    // exp:addExp;
    public Void visitExp(P7Parser.ExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        visit(ctx.addExp());
        if (node_attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
            attr_Val.put("thisReg", node_attr_Val.get(ctx.addExp()).get("thisReg"));
        } else if (node_attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
            attr_Val.put("numberVal", node_attr_Val.get(ctx.addExp()).get("numberVal"));
        }
        return null;
    }

    @Override
    // addExp:mulExp|addExp ( ADD | SUB ) mulExp;
    public Void visitAddExp(P7Parser.AddExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { // mulExp
            visit(ctx.mulExp());
            if (node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.mulExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.mulExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // addExp ( ADD | SUB ) mulExp;
            Long addExpVal = 0L, mulExpVal = 0L;
            String addExpReg = null, mulExpReg = null;
            visit(ctx.addExp());
            if (node_attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                addExpVal = Long.parseLong((String) node_attr_Val.get(ctx.addExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                addExpReg = (String) node_attr_Val.get(ctx.addExp()).get("thisReg");
            }

            visit(ctx.mulExp());
            if (node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                mulExpVal = Long.parseLong((String) node_attr_Val.get(ctx.mulExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                mulExpReg = (String) node_attr_Val.get(ctx.mulExp()).get("thisReg");
            }

            if (node_attr_Val.get(ctx.addExp()).containsKey("numberVal")
                    && node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                if (ctx.ADD() != null) {
                    attr_Val.put("numberVal", String.valueOf(addExpVal + mulExpVal));
                } else if (ctx.SUB() != null) {
                    attr_Val.put("numberVal", String.valueOf(addExpVal - mulExpVal));
                }
            } else {
                String thisReg = "%x" + currentReg++;
                reg_Type.put(thisReg, "i32");
                attr_Val.put("thisReg", thisReg);
                StringBuilder sb = new StringBuilder();
                sb.append("\t").append(thisReg).append(" = ");
                if (ctx.ADD() != null) {
                    sb.append("add i32 ");
                } else if (ctx.SUB() != null) {
                    sb.append("sub i32 ");
                }
                if (node_attr_Val.get(ctx.addExp()).containsKey("numberVal")
                        && node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                    sb.append(addExpVal).append(", ").append(mulExpReg);
                } else if (node_attr_Val.get(ctx.addExp()).containsKey("thisReg")
                        && node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                    sb.append(addExpReg).append(", ").append(mulExpVal);
                } else if (node_attr_Val.get(ctx.addExp()).containsKey("thisReg")
                        && node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                    sb.append(addExpReg).append(", ").append(mulExpReg);
                }
                IR_List.add(sb + "\n");
            }
        }
        return null;
    }

    @Override
    // mulExp:unaryExp|mulExp ( MUL | DIV | MOD ) unaryExp;
    public Void visitMulExp(P7Parser.MulExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        if (ctx.children.size() == 1) { // unaryExp
            visit(ctx.unaryExp());
            if (node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.unaryExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.unaryExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // mulExp ( MUL | DIV | MOD ) unaryExp;
            Long mulExpVal = 0L, unaryExpVal = 0L;
            String mulExpReg = null, unaryExpReg = null;

            visit(ctx.mulExp());
            String mulExpType = "i32";
            if (node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                mulExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.mulExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                mulExpReg = (String) node_attr_Val.get(ctx.mulExp()).get("thisReg");
            }

            visit(ctx.unaryExp());
            // String unaryExpType = "i32";
            if (node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                unaryExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.unaryExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                unaryExpReg = (String) node_attr_Val.get(ctx.unaryExp()).get("thisReg");
            }

            if (node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")
                    && node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                if (ctx.MUL() != null) {
                    attr_Val.put("numberVal", String.valueOf(mulExpVal * unaryExpVal));
                } else if (ctx.DIV() != null) {
                    attr_Val.put("numberVal", String.valueOf(mulExpVal / unaryExpVal));
                } else if (ctx.MOD() != null) {
                    attr_Val.put("numberVal", String.valueOf(mulExpVal % unaryExpVal));
                }
            } else {
                String thisReg = "%x" + currentReg++;
                attr_Val.put("thisReg", thisReg);
                reg_Type.put(thisReg, "i32");
                if (node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")
                        && node_attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                    if (ctx.MUL() != null) {
                        IR_List.add("\t" + thisReg + " = mul " + mulExpType + " " + mulExpVal + ", "
                                + unaryExpReg + "\n");
                    } else if (ctx.DIV() != null) {
                        IR_List.add("\t" + thisReg + " = sdiv " + mulExpType + " " + mulExpVal + ", " + unaryExpReg
                                + "\n");
                    } else if (ctx.MOD() != null) {
                        IR_List.add("\t" + thisReg + " = srem " + mulExpType + " " + mulExpVal + ", " + unaryExpReg
                                + "\n");
                    }
                } else if (node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")
                        && node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                    if (ctx.MUL() != null) {
                        IR_List.add("\t" + thisReg + " = mul " + mulExpType + " " + mulExpReg + ", "
                                + unaryExpVal + "\n");
                    } else if (ctx.DIV() != null) {
                        IR_List.add("\t" + thisReg + " = sdiv " + mulExpType + " " + mulExpReg + ", " + unaryExpVal
                                + "\n");
                    } else if (ctx.MOD() != null) {
                        IR_List.add("\t" + thisReg + " = srem " + mulExpType + " " + mulExpReg + ", " + unaryExpVal
                                + "\n");
                    }
                } else if (node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")
                        && node_attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                    if (ctx.MUL() != null) {
                        IR_List.add("\t" + thisReg + " = mul " + mulExpType + " " + mulExpReg + ", "
                                + unaryExpReg + "\n");
                    } else if (ctx.DIV() != null) {
                        IR_List.add("\t" + thisReg + " = sdiv " + mulExpType + " " + mulExpReg + ", "
                                + unaryExpReg + "\n");
                    } else if (ctx.MOD() != null) {
                        IR_List.add("\t" + thisReg + " = srem " + mulExpType + " " + mulExpReg + ", "
                                + unaryExpReg + "\n");
                    }
                }
            }
        }
        node_attr_Val.put(ctx, attr_Val);
        return null;
    }

    @Override
    // unaryExp:primaryExp|( ADD | SUB | NOT ) unaryExp | Ident LParser (exp ( ',' exp
    // )+)* RParser;
    public Void visitUnaryExp(P7Parser.UnaryExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        if (ctx.Ident() != null) { // Ident LParser (exp ( ',' exp )+)* RParser
            String Ident = ctx.Ident().getText();
            if (ident_Check_Reg_this_Block(ctx, Ident) || !Main.declaredFunc.containsKey(Ident)) {
                System.err.println("Undeclared Ident:" + Ident);
                System.exit(1);
            }
            String retType = Main.declaredFunc.get(Ident);
            StringBuilder sbIR = new StringBuilder();
            StringBuilder sbdecl = new StringBuilder();
            sbdecl.append("declare ").append(retType).append(" @").append(Ident).append("(");
            sbIR.append("\t");
            if (!retType.equals("void")) {
                String thisReg = "%x" + currentReg++;
                reg_Type.put(thisReg, retType);
                attr_Val.put("thisReg", thisReg);
                sbIR.append(thisReg).append(" = ");
            }
            sbIR.append("call ").append(retType).append(" @").append(Ident).append("(");
            int i = ctx.exp().size() - 1;
            for (P7Parser.ExpContext exp : ctx.exp()) {
                visit(exp);
                sbdecl.append("i32");
                if (node_attr_Val.get(exp).containsKey("thisReg")) {
                    sbIR.append("i32 ").append(node_attr_Val.get(exp).get("thisReg"));
                } else if (node_attr_Val.get(exp).containsKey("numberVal")) {
                    sbIR.append("i32 ").append(node_attr_Val.get(exp).get("numberVal"));
                }
                if (i-- > 0) {
                    sbIR.append(", ");
                    sbdecl.append(", ");
                }
            }
            sbIR.append(")\n");
            sbdecl.append(")\n");
            if (!Main.funcUsed.contains(Ident)) {
                IR_List.add(0, String.valueOf(sbdecl));
                Main.funcUsed.add(Ident);
            }
            IR_List.add(String.valueOf(sbIR));
            // funcIdent_Attr.put(Ident, func_attr);
        } else if (ctx.primaryExp() != null) { // primaryExp
            visit(ctx.primaryExp());
            if (node_attr_Val.get(ctx.primaryExp()).containsKey("lValReg")) {
                String lValReg = (String) node_attr_Val.get(ctx.primaryExp()).get("lValReg");
                attr_Val.put("thisReg", lValReg);
            } else if (node_attr_Val.get(ctx.primaryExp()).containsKey("expReg")) {
                String expReg = (String) node_attr_Val.get(ctx.primaryExp()).get("expReg");
                attr_Val.put("thisReg", expReg);
            } else if (node_attr_Val.get(ctx.primaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.primaryExp()).get("numberVal"));
            }
        } else if (ctx.ADD() != null) { // ADD unaryExp
            visit(ctx.unaryExp());
            if (node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.unaryExp()).get("numberVal"));
            } else {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.unaryExp()).get("thisReg"));
            }
        } else if (ctx.SUB() != null) { // SUB unaryExp
            visit(ctx.unaryExp());
            if (node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                long numberVal = Long.parseLong((String) (node_attr_Val.get(ctx.unaryExp()).get("numberVal")));
                attr_Val.put("numberVal", String.valueOf(numberVal * -1));
            } else {
                String unaryExpReg = (String) node_attr_Val.get(ctx.unaryExp()).get("thisReg");
                String unaryExpType = reg_Type.get(unaryExpReg);
                String thisReg = "%x" + currentReg++;
                reg_Type.put(thisReg, "i32");
                attr_Val.put("thisReg", thisReg);
                IR_List.add("\t" + thisReg + " = sub nsw " + unaryExpType + " 0" + ", " + unaryExpReg + "\n");
            }
        } else if (ctx.NOT() != null) {
            visit(ctx.unaryExp());
            if (node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                String numberVal = (String) node_attr_Val.get(ctx.unaryExp()).get("numberVal");
                attr_Val.put("numberVal", numberVal);
                String cmpReg = "%x" + currentReg++;
                reg_Type.put(cmpReg, "i1");
                IR_List.add("\t" + cmpReg + " = icmp eq i32 " + numberVal + ", 0\n");
            } else if (node_attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                String unaryExpReg = (String) node_attr_Val.get(ctx.unaryExp()).get("thisReg");
                String cmpReg = "%x" + currentReg++;
                reg_Type.put(cmpReg, "i1");
                if (reg_Type.get(unaryExpReg).equals("i32")) {
                    attr_Val.put("thisReg", unaryExpReg);
                    IR_List.add("\t" + cmpReg + " = icmp eq i32 " + unaryExpReg + ", 0\n");
                } else if (reg_Type.get(unaryExpReg).equals("i1")) {
                    IR_List.add("\t" + cmpReg + " = icmp eq i1 " + unaryExpReg + ", 0\n");
                }
                String thisReg = "%x" + currentReg++;
                reg_Type.put(thisReg, "i32");
                attr_Val.put("thisReg", thisReg);
                IR_List.add("\t" + thisReg + " = zext i1 " + cmpReg + " to i32\n");
            }
        }
        return null;
    }

    @Override
    // primaryExp:LParser exp RParser|lVal|number;
    public Void visitPrimaryExp(P7Parser.PrimaryExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        if (ctx.number() != null) { // number
            visit(ctx.number());
            attr_Val.put("numberVal", node_attr_Val.get(ctx.number()).get("nodeVal"));
            node_attr_Val.put(ctx, attr_Val);
        } else if (ctx.exp() != null) { // LParser exp RParser
            visit(ctx.exp());
            attr_Val.put("expReg", node_attr_Val.get(ctx.exp()).get("thisReg"));
        } else if (ctx.lVal() != null) {
            visit(ctx.lVal());
            if (node_attr_Val.get(ctx.lVal()).containsKey("thisReg")) {
                attr_Val.put("lValReg", node_attr_Val.get(ctx.lVal()).get("thisReg"));
            } else if (node_attr_Val.get(ctx.lVal()).containsKey("nodeVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.lVal()).get("nodeVal"));
            }
        }
        return null;
    }

    @Override
    // cond:lOrExp
    public Void visitCond(P7Parser.CondContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.lOrExp());
        String thisReg = "%x" + currentReg++;
        reg_Type.put(thisReg, "i1");
        int trueLabel = currentReg++;
        int falseLabel = currentReg++;
        if (node_attr_Val.get(ctx.lOrExp()).containsKey("numberVal")) {
            String numberVal = (String) node_attr_Val.get(ctx.lOrExp()).get("numberVal");
            IR_List.add("\t" + thisReg + " = icmp ne i32 " + numberVal + ", 0\n");
            IR_List.add("\tbr i1 " + thisReg + ", label %x" + trueLabel + ", label %x" + falseLabel + "\n");
        } else if (node_attr_Val.get(ctx.lOrExp()).containsKey("thisReg")) {
            String lOrExpReg = (String) node_attr_Val.get(ctx.lOrExp()).get("thisReg");
            if (reg_Type.get(lOrExpReg).equals("i32")) {
                IR_List.add("\t" + thisReg + " = icmp ne i32 " + lOrExpReg + ", 0\n");
                IR_List.add("\tbr i1 " + thisReg + ", label %x" + trueLabel + ", label %x" + falseLabel + "\n");
            } else if (reg_Type.get(lOrExpReg).equals("i1")) {
                IR_List.add("\tbr i1 " + lOrExpReg + ", label %x" + trueLabel + ", label %x" + falseLabel + "\n");
            }
        }

        attr_Val.put("TLabel", trueLabel);
        attr_Val.put("FLabel", falseLabel);
        return null;
    }

    @Override
    // relExp:addExp |relExp ( LT_KW | GT_KW | LE_KW | GE_KW ) addExp
    public Void visitRelExp(P7Parser.RelExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { // addExp
            visit(ctx.addExp());
            if (node_attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.addExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.addExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // relExp ( LT_KW | GT_KW | LE_KW | GE_KW ) addExp
            Long relExpVal = 0L, addExpVal = 0L;
            String relExpReg = null, addExpReg = null;

            visit(ctx.relExp());
            if (node_attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                relExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.relExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                relExpReg = (String) node_attr_Val.get(ctx.relExp()).get("thisReg");
            }
            visit(ctx.addExp());
            if (node_attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                addExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.addExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                addExpReg = (String) node_attr_Val.get(ctx.addExp()).get("thisReg");
            }

            String thisReg = "%x" + currentReg++;
            reg_Type.put(thisReg, "i1");
            attr_Val.put("thisReg", thisReg);
            StringBuilder sb = new StringBuilder();
            sb.append("\t").append(thisReg).append(" = icmp ");
            if (ctx.LT_KW() != null) {
                sb.append("slt i32 ");
            } else if (ctx.GT_KW() != null) {
                sb.append("sgt i32 ");
            } else if (ctx.LE_KW() != null) {
                sb.append("sle i32 ");
            } else if (ctx.GE_KW() != null) {
                sb.append("sge i32 ");
            }
            if (node_attr_Val.get(ctx.relExp()).containsKey("numberVal")
                    && node_attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                sb.append(relExpVal);
                sb.append(", ");
                sb.append(addExpVal);
            } else if (node_attr_Val.get(ctx.relExp()).containsKey("numberVal")
                    && node_attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                sb.append(relExpVal);
                sb.append(", ").append(addExpReg);
            } else if (node_attr_Val.get(ctx.relExp()).containsKey("thisReg")
                    && node_attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                sb.append(relExpReg);
                sb.append(", ").append(addExpVal);
            } else if (node_attr_Val.get(ctx.relExp()).containsKey("thisReg")
                    && node_attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                sb.append(relExpReg);
                sb.append(", ").append(addExpReg);
            }
            sb.append("\n");
            IR_List.add(String.valueOf(sb));
        }
        return null;
    }

    @Override
    // eqExp:relExp | eqExp (EQ_KW | NEQ_KW) relExp
    public Void visitEqExp(P7Parser.EqExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { // relExp
            visit(ctx.relExp());
            if (node_attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.relExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.relExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // eqExp (EQ_KW | NEQ_KW) relExp
            Long eqExpVal = 0L, relExpVal = 0L;
            String eqExpReg = null, relExpReg = null;

            visit(ctx.eqExp());
            if (node_attr_Val.get(ctx.eqExp()).containsKey("numberVal")) {
                eqExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.eqExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.eqExp()).containsKey("thisReg")) {
                eqExpReg = (String) node_attr_Val.get(ctx.eqExp()).get("thisReg");
            }
            visit(ctx.relExp());
            if (node_attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                relExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.relExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                relExpReg = (String) node_attr_Val.get(ctx.relExp()).get("thisReg");
            }

            String thisReg = "%x" + currentReg++;
            reg_Type.put(thisReg, "i1");
            attr_Val.put("thisReg", thisReg);
            StringBuilder sb = new StringBuilder();
            sb.append("\t").append(thisReg).append(" = icmp ");
            if (ctx.EQ_KW() != null) {
                sb.append("eq i32 ");
            } else if (ctx.NEQ_KW() != null) {
                sb.append("ne i32 ");
            }
            if (node_attr_Val.get(ctx.eqExp()).containsKey("numberVal")
                    && node_attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                sb.append(eqExpVal);
                sb.append(", ");
                sb.append(relExpVal);
            } else if (node_attr_Val.get(ctx.eqExp()).containsKey("numberVal")
                    && node_attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                sb.append(eqExpVal);
                sb.append(", ").append(relExpReg);
            } else if (node_attr_Val.get(ctx.eqExp()).containsKey("thisReg")
                    && node_attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                sb.append(eqExpReg);
                sb.append(", ").append(relExpVal);
            } else if (node_attr_Val.get(ctx.eqExp()).containsKey("thisReg")
                    && node_attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                sb.append(eqExpReg);
                sb.append(", ").append(relExpReg);
            }
            sb.append("\n");
            IR_List.add(String.valueOf(sb));
        }
        return null;
    }

    @Override
    // lAndExp:eqExp | lAndExp LAND_KW eqExp
    public Void visitLAndExp(P7Parser.LAndExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.LAND_KW() == null) { // eqExp
            visit(ctx.eqExp());
            if (node_attr_Val.get(ctx.eqExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.eqExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.eqExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.eqExp()).get("thisReg"));
            }
        } else { // lAndExp LAND_KW eqExp
            visit(ctx.lAndExp());
            String lAndExpReg, eqExpReg, reg1 = null, reg2 = null;
            if (node_attr_Val.get(ctx.lAndExp()).containsKey("thisReg")) {
                lAndExpReg = (String) node_attr_Val.get(ctx.lAndExp()).get("thisReg");
                if (reg_Type.get(lAndExpReg).equals("i1")) {
                    reg1 = lAndExpReg;
                } else if (reg_Type.get(lAndExpReg).equals("i32")) {
                    reg1 = "%x" + currentReg++;
                    reg_Type.put(reg1, "i1");
                    IR_List.add("\t" + reg1 + " = icmp ne i32 " + lAndExpReg + ", 0" + "\n");
                }
            }
            visit(ctx.eqExp());
            if (node_attr_Val.get(ctx.eqExp()).containsKey("thisReg")) {
                eqExpReg = (String) node_attr_Val.get(ctx.eqExp()).get("thisReg");
                if (reg_Type.get(eqExpReg).equals("i1")) {
                    reg2 = eqExpReg;
                } else if (reg_Type.get(eqExpReg).equals("i32")) {
                    reg2 = "%x" + currentReg++;
                    reg_Type.put(reg2, "i1");
                    IR_List.add("\t" + reg2 + " = icmp ne i32 " + eqExpReg + ", 0" + "\n");
                }
            }
            String thisReg = "%x" + currentReg++;
            reg_Type.put(thisReg, "i1");
            attr_Val.put("thisReg", thisReg);
            IR_List.add("\t" + thisReg + " = and i1 " + reg1 + ", " + reg2 + "\n");
        }
        return null;
    }

    @Override
    // lOrExp:lAndExp | lOrExp LOR_KW lAndExp
    public Void visitLOrExp(P7Parser.LOrExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.LOR_KW() == null) { // lAndExp
            visit(ctx.lAndExp());
            if (node_attr_Val.get(ctx.lAndExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.lAndExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.lAndExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_attr_Val.get(ctx.lAndExp()).get("thisReg"));
            }
        } else { // lOrExp LOR_KW lAndExp
            visit(ctx.lOrExp());
            String lOrExpReg, lAndExpReg, reg1 = null, reg2 = null;
            if (node_attr_Val.get(ctx.lOrExp()).containsKey("thisReg")) {
                lOrExpReg = (String) node_attr_Val.get(ctx.lOrExp()).get("thisReg");
                if (reg_Type.get(lOrExpReg).equals("i1")) {
                    reg1 = lOrExpReg;
                } else if (reg_Type.get(lOrExpReg).equals("i32")) {
                    reg1 = "%x" + currentReg++;
                    reg_Type.put(reg1, "i1");
                    IR_List.add("\t" + reg1 + " = icmp ne i32 " + lOrExpReg + ", 0" + "\n");
                }
            }
            visit(ctx.lAndExp());
            if (node_attr_Val.get(ctx.lAndExp()).containsKey("thisReg")) {
                lAndExpReg = (String) node_attr_Val.get(ctx.lAndExp()).get("thisReg");
                if (reg_Type.get(lAndExpReg).equals("i1")) {
                    reg2 = lAndExpReg;
                } else if (reg_Type.get(lAndExpReg).equals("i32")) {
                    reg2 = "%x" + currentReg++;
                    reg_Type.put(reg2, "i1");
                    IR_List.add("\t" + reg2 + " = icmp ne i32 " + lAndExpReg + ", 0" + "\n");
                }
            }
            String thisReg = "%x" + currentReg++;
            reg_Type.put(thisReg, "i1");
            attr_Val.put("thisReg", thisReg);
            IR_List.add("\t" + thisReg + " = or i1 " + reg1 + ", " + reg2 + "\n");
        }
        return null;
    }
}