package com.miniSysY.P8;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Visitor extends P8BaseVisitor<Void> {
    Integer currentReg = 0;
    int pos = 0, sid = 0;
    HashMap<String, String> arr_pos_val = null;
    ArrayList<Integer> arrsize = null;
    public static HashMap<RuleNode, HashMap<String, Object>> node_attr_Val = new HashMap<>(); // 保存树上结点的各种属性
    public static HashMap<RuleContext, HashMap<String, Object>> block_ident_Reg = new HashMap<>();
    public static HashMap<String, String> reg_Type = new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> arri_size = new HashMap<>();
    //    public static HashMap<String, ArrayList<String>> constArr_val = new HashMap<>();
    public static HashMap<String, HashMap<String, Object>> funcIdent_Attr = new HashMap<>();
    public static ArrayList<String> IR_List = new ArrayList<>();

    public boolean ident_Check_Reg_this_Block(RuleContext ctx, String Ident) {
        RuleContext parent = ctx;
        while (!(parent instanceof P8Parser.BlockContext || parent instanceof P8Parser.CompUnitContext)) {
            parent = parent.parent;
        }
        if (!block_ident_Reg.containsKey(parent))
            return false;
        return block_ident_Reg.get(parent).containsKey(Ident);
    }

    public boolean ident_Check_Reg(RuleContext ctx, String Ident) {
        RuleContext parent = ctx;
        while (!(parent instanceof P8Parser.CompUnitContext)) {
            if (parent instanceof P8Parser.BlockContext) {
                if (block_ident_Reg.containsKey(parent)) {
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

    public void ident_Put_Reg(RuleContext ctx, String Ident, Object Reg) {// 添加符号
        RuleContext parent = ctx;
        while (!(parent instanceof P8Parser.CompUnitContext)) {
            if (parent instanceof P8Parser.BlockContext) {
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

    public void clear_Ident_Reg(RuleContext ctx) {
        RuleContext parent = ctx;
        while (!(parent instanceof P8Parser.CompUnitContext)) {
            parent = parent.parent;
        }
        HashMap<String, Object> globalIdent = block_ident_Reg.get(parent);
        HashMap<String, String> globalReg = new HashMap<>();
        block_ident_Reg = new HashMap<>();
        block_ident_Reg.put(parent, globalIdent);
        if (globalIdent != null) {
            for (Object o : globalIdent.values()) {
                if (o instanceof String) {
                    String s = (String) o;
                    if (reg_Type.containsKey(s)) {
                        globalReg.put(s, reg_Type.get(s));
                    }
                }
            }
            reg_Type = globalReg;
        } else {
            reg_Type = new HashMap<>();
        }
    }

    public Object ident_Get_Reg(RuleContext ctx, String Ident) {
        RuleContext parent = ctx;
        while (!(parent instanceof P8Parser.CompUnitContext)) {
            if (parent instanceof P8Parser.BlockContext) {
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
    // compUnit:(decl|funcDef)*(decl|funcDef);
    public Void visitCompUnit(P8Parser.CompUnitContext ctx) {
        for (ParseTree child : ctx.children) {
            visit(child);
        }
        return null;
    }

    @Override
    // bType:INT_KW;
    public Void visitBType(P8Parser.BTypeContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        attr_Val.put("bType", "i32");
        return null;
    }

    @Override
    // decl:constDecl|varDecl;
    public Void visitDecl(P8Parser.DeclContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.parent instanceof P8Parser.CompUnitContext) {
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
    public Void visitConstDecl(P8Parser.ConstDeclContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.bType());
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        for (P8Parser.ConstDefContext cdf : ctx.constDef()) {
            String Ident = cdf.Ident().getText();
            if (ident_Check_Reg_this_Block(cdf, Ident)) {
                System.err.println("Re-Declaration Ident:" + Ident);
                System.exit(1);
            }
            visit(cdf);
        }
        return null;
    }

    public static String getArrSizeString(ArrayList<Integer> size) {
        StringBuilder sb = new StringBuilder();
        int dim = size.size();
        if (dim == 0 || size.get(0) == 0) {
            return "i32";
        }
        for (Integer integer : size) {
            sb.append("[").append(integer).append(" x ");
        }
        sb.append("i32").append("]".repeat(dim));
        return String.valueOf(sb);
    }

    public static String getGlobalArrVal(ArrayList<Integer> size, HashMap<String, String> arr_pos_val, int pos) {
        StringBuilder sb = new StringBuilder();
        int dim = size.size();

        if (dim == 1) {
            boolean allzero = true;
            for (int i = pos; i < pos + size.get(0); i++) {
                if (arr_pos_val.containsKey(String.valueOf(i))) {
                    allzero = false;
                    break;
                }
            }
            if (allzero) {
                sb.append("zeroinitializer");
            } else {
                sb.append("[");
                for (int i = pos; i < pos + size.get(0); i++) {
                    if (arr_pos_val.containsKey(String.valueOf(i))) {
                        sb.append("i32 ").append(arr_pos_val.get(String.valueOf(i)));
                    } else {
                        sb.append("i32 0");
                    }
                    if (i < pos + size.get(0) - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");
            }
        } else {
            sb.append("[");
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < dim; i++) {
                tmp.add(size.get(i));
            }
            for (int i = 0; i < size.get(0); i++) {
                sb.append(getArrSizeString(tmp)).append(" ");
                sb.append(getGlobalArrVal(tmp, arr_pos_val, pos));
                if (i < size.get(0) - 1) {
                    sb.append(", ");
                }
                pos += size.get(1);
            }
            sb.append("]");
        }
        return String.valueOf(sb);
    }

    @Override
    // Ident ( LBracket constExp RBracket )* ASSIGN constInitVal;
    public Void visitConstDef(P8Parser.ConstDefContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        String thisReg;
        String Ident = ctx.Ident().getText();
        if (ctx.constExp().size() != 0) {
            ArrayList<Integer> size = new ArrayList<>();
            attr_Val.put("size", size);
            arri_size.put(Ident, size);
            attr_Val.put("dim", size.size());
            for (P8Parser.ConstExpContext ce : ctx.constExp()) {
                visit(ce);
                size.add(Integer.parseInt((String) (node_attr_Val.get(ce).get("constExpVal"))));
            }
//            reg_Type.put(Ident, getArrSizeString(size) + "*");
            if (node_attr_Val.get(ctx.parent).containsKey("global")) {
                attr_Val.put("global", "global");
                thisReg = "@" + Ident;
                reg_Type.put(thisReg, getArrSizeString(size) + "*");
                arri_size.put(thisReg, size);
                if (ctx.constInitVal() != null) {
                    StringBuilder sbIR = new StringBuilder();
                    sbIR.append(thisReg).append(" = dso_local constant ");
                    if (size.size() != 0) {
                        sbIR.append(getArrSizeString(size)).append(" ");
                    }
                    visit(ctx.constInitVal());//TODO:访问initval时候也要注意有没有IR输出（对于全局变量）
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.constInitVal()).get("arr_pos_val");
                    sbIR.append(getGlobalArrVal(size, arr_pos_val, 0));
                    sbIR.append("\n");
                    IR_List.add(String.valueOf(sbIR));
                } else {
                    if (size.size() != 0) {
                        IR_List.add(thisReg + " = dso_local global " + getArrSizeString(size) + " zeroinitializer\n");
                    }
                }
                ident_Put_Reg(ctx, Ident, thisReg);
            } else {
                thisReg = "%x" + currentReg++;
                ident_Put_Reg(ctx, Ident, thisReg);
                reg_Type.put(thisReg, getArrSizeString(size) + "*");
                arri_size.put(Ident, size);
                int dim = size.size();
                IR_List.add("\t" + thisReg + " = alloca" + getArrSizeString(size) + "\n");
                if (dim != 0) {
                    int memsize = 1;
                    StringBuilder sb = new StringBuilder();
                    String tmpReg = "%x" + currentReg++;
                    sb.append("\t").append(tmpReg).append(" = getelementptr ").append(getArrSizeString(size)).append(", ").append(getArrSizeString(size)).append("* ").append(thisReg).append(", i32 0");
                    for (Integer integer : size) {
                        sb.append(", i32 0");
                        memsize *= integer;
                    }
                    reg_Type.put(tmpReg, "i32*");
                    IR_List.add(sb + "\n");
                    IR_List.add("\tcall void @memset(i32* " + tmpReg + ", i32 0, i32 " + 4 * memsize + ")\n");
                }
                if (ctx.constInitVal() != null) {
                    visit(ctx.constInitVal());
                    StringBuilder sb = new StringBuilder();
                    String curptr = "%x" + currentReg++;
                    reg_Type.put(curptr, "i32*");
                    sb.append("\t").append(curptr).append(" = getelementptr ").append(getArrSizeString(size)).append(", ").append(getArrSizeString(size)).append("* ").append(thisReg);
                    sb.append(", i32 0".repeat(Math.max(0, dim - 1)));
                    IR_List.add(sb + "\n");
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.constInitVal()).get("arr_pos_val");
                    for (String pos : arr_pos_val.keySet()) {
                        String tmpReg = "%x" + currentReg++;
                        IR_List.add("\t" + tmpReg + " = getelementptr i32, i32* " + curptr + ", i32 " + pos + "\n");
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

    @Override
    // constInitVal:constExp | LBrace ( constInitVal ( ',' constInitVal )* )? RBrace;
    public Void visitConstInitVal(P8Parser.ConstInitValContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.constExp() != null) {
            visit(ctx.constExp());
            attr_Val.put("constExpVal", node_attr_Val.get(ctx.constExp()).get("constExpVal"));
        } else if (ctx.constInitVal() != null) {
            if (ctx.parent instanceof P8Parser.ConstDefContext) {
                arr_pos_val = new HashMap<>();
                arrsize = (ArrayList<Integer>) node_attr_Val.get(ctx.parent).get("size");
                attr_Val.put("arr_pos_val", arr_pos_val);
                pos = 0;
                sid = 1;
            }
            for (P8Parser.ConstInitValContext ci : ctx.constInitVal()) {//一个括号内部
                visit(ci);
                if (ci.constExp() != null) {
                    String expval = (String) node_attr_Val.get(ci.constExp()).get("constExpVal");
                    arr_pos_val.put(String.valueOf(pos++), expval);
                } else {
                    sid++;
                }
            }
            pos = arrsize.get(arrsize.size() - 1) * sid;
        }
        return null;
    }

    @Override
    // varDecl:bType varDef (',' varDef)* Semicolon;
    public Void visitVarDecl(P8Parser.VarDeclContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.bType());
        attr_Val.put("bType", node_attr_Val.get(ctx.bType()).get("bType"));
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        for (P8Parser.VarDefContext vdf : ctx.varDef()) {
            String Ident = vdf.Ident().getText();
//            if (ident_Reg.containsKey(Ident) || constIdent_Val.containsKey(Ident)) {
            if (ident_Check_Reg_this_Block(ctx, Ident)) {
                System.err.println("Re-Declaration ident:" + Ident);
                System.exit(1);
            }
            visit(vdf);
        }
        return null;
    }

    @Override
    // varDef:Ident ( LBracket constExp RBracket )* | Ident ( LBracket constExp RBracket )* ASSIGN initVal;
    public Void visitVarDef(P8Parser.VarDefContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        String thisReg;
        String Ident = ctx.Ident().getText();
        if (ctx.constExp().size() != 0) {//是数组
            ArrayList<Integer> size = new ArrayList<>();
            attr_Val.put("size", size);
            arri_size.put(Ident, size);
            attr_Val.put("dim", size.size());
            for (P8Parser.ConstExpContext ce : ctx.constExp()) {
                visit(ce);
                size.add(Integer.parseInt((String) (node_attr_Val.get(ce).get("constExpVal"))));
            }
            if (node_attr_Val.get(ctx.parent).containsKey("global")) {
                attr_Val.put("global", "global");
                thisReg = "@" + Ident;
                //全局变量 全都要加*
                reg_Type.put(thisReg, getArrSizeString(size) + "*");
                System.err.println("visitVarDef,globalArr:"+Ident+" Reg:"+thisReg+" Type:"+reg_Type.get(thisReg));
                if (ctx.initVal() != null) {
                    StringBuilder sbIR = new StringBuilder();
                    sbIR.append(thisReg).append(" = dso_local global ").append(getArrSizeString(size)).append(" ");
                    visit(ctx.initVal());//TODO:访问initval时候也要注意有没有IR输出（对于全局变量）
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.initVal()).get("arr_pos_val");
                    sbIR.append(getGlobalArrVal(size, arr_pos_val, 0));
                    sbIR.append("\n");
                    IR_List.add(String.valueOf(sbIR));
                } else {
                    IR_List.add(thisReg + " = dso_local global " + getArrSizeString(size) + " zeroinitializer\n");
                }
                ident_Put_Reg(ctx, Ident, thisReg);
            } else {
                thisReg = "%x" + currentReg++;
                ident_Put_Reg(ctx, Ident, thisReg);
                int dim = size.size();
                IR_List.add("\t" + thisReg + " = alloca " + getArrSizeString(size) + "\n");
                reg_Type.put(thisReg, getArrSizeString(size) + "*");
                System.err.println("visitVarDef,arr:"+Ident+" Reg:"+thisReg+" Type:"+reg_Type.get(thisReg));
                if (dim != 0) {
                    int memsize = 1;
                    StringBuilder sb = new StringBuilder();
                    String tmpReg = "%x" + currentReg++;
                    reg_Type.put(tmpReg, "i32*");
                    sb.append("\t").append(tmpReg).append(" = getelementptr ").append(getArrSizeString(size)).append(", ").append(getArrSizeString(size)).append("* ").append(thisReg).append(", i32 0");
                    for (Integer integer : size) {
                        sb.append(", i32 0");
                        memsize *= integer;
                    }
                    IR_List.add(sb + "\n");
                    IR_List.add("\tcall void @memset(i32* " + tmpReg + ", i32 0, i32 " + 4 * memsize + ")\n");
                }
                if (ctx.initVal() != null) {
                    visit(ctx.initVal());
                    //拆到i32*进行存值
                    StringBuilder sb = new StringBuilder();
                    String curptr = "%x" + currentReg++;
                    reg_Type.put(curptr, "i32*");
                    sb.append("\t").append(curptr).append(" = getelementptr ").append(getArrSizeString(size)).append(", ").append(getArrSizeString(size)).append("* ").append(thisReg).append(", i32 0");
                    sb.append(", i32 0".repeat(dim));
                    IR_List.add(sb + "\n");
                    HashMap<String, String> arr_pos_val = (HashMap<String, String>) node_attr_Val.get(ctx.initVal()).get("arr_pos_val");
                    for (String pos : arr_pos_val.keySet()) {
                        String tmpReg = "%x" + currentReg++;
                        IR_List.add("\t" + tmpReg + " = getelementptr i32, i32* " + curptr + ", i32 " + pos + "\n");
                        IR_List.add("\tstore i32 " + arr_pos_val.get(pos) + ", i32* " + tmpReg + "\n");
                    }
                }
            }
        } else {
            if (node_attr_Val.get(ctx.parent).containsKey("global")) {
                attr_Val.put("global", "global");
                thisReg = "@" + Ident;
                String bType = (String) node_attr_Val.get(ctx.parent).get("bType");
                reg_Type.put(thisReg, bType + "*");
                System.err.println("visitVarDef,global:"+Ident+" Reg:"+thisReg+" Type:"+reg_Type.get(thisReg));
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
                reg_Type.put(thisReg, bType + "*");
                IR_List.add("\t" + thisReg + " = alloca " + bType + "\n");
                System.err.println("visitVarDef:"+Ident+" Reg:"+thisReg+" Type:"+reg_Type.get(thisReg));
                ident_Put_Reg(ctx, Ident, thisReg);
                if (ctx.ASSIGN() != null) {
                    if (ctx.ASSIGN().getText().equals("=")) {
                        visit(ctx.initVal());
                        if (node_attr_Val.get(ctx.initVal()).containsKey("thisReg")) {
                            String initValReg = (String) node_attr_Val.get(ctx.initVal()).get("thisReg");
                            String initType = reg_Type.get(initValReg);
                            if(initType.equals("i32*")){
                                String tmpReg = "%x"+currentReg++;
                                IR_List.add("\t"+tmpReg+" = load i32, i32* "+initValReg+"\n");
                                reg_Type.put(tmpReg,"i32");
                                initValReg = tmpReg;
                            }
                            if (!bType.equals(reg_Type.get(initValReg))) {
                                System.err.println("Type dismatch!");
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
    public Void visitInitVal(P8Parser.InitValContext ctx) {
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
            if (ctx.parent instanceof P8Parser.VarDefContext) {
                arr_pos_val = new HashMap<>();
                arrsize = (ArrayList<Integer>) node_attr_Val.get(ctx.parent).get("size");
                attr_Val.put("arr_pos_val", arr_pos_val);
                pos = 0;
                sid = 1;
            }
            for (P8Parser.InitValContext i : ctx.initVal()) {//一个括号内部
                visit(i);
                if (i.exp() != null) {
                    if (node_attr_Val.get(i).containsKey("numberVal")) {//直接就是一个数字
                        String expval = (String) node_attr_Val.get(i).get("numberVal");
                        arr_pos_val.put(String.valueOf(pos++), expval);
                    } else if (node_attr_Val.get(i).containsKey("thisReg")) {
                        String expval = (String) node_attr_Val.get(i).get("thisReg");
                        String exptype = reg_Type.get(expval);
                        //TODO:Need?
                        if (exptype.startsWith("i32") && exptype.endsWith("*")) {
                            String tmpReg = "%x" + currentReg++;
                            String tmptype = exptype.substring(0, exptype.length() - 1);
                            reg_Type.put(tmpReg, tmptype);
                            IR_List.add("\t" + tmpReg + " = load " + tmptype + ", " + exptype + " " + expval + "\n");
                            expval = tmpReg;
                        }
                        arr_pos_val.put(String.valueOf(pos++), expval);
                    }
                } else {
                    sid++;
                }
            }
            pos = arrsize.get(arrsize.size() - 1) * sid;
        }
        return null;
    }

    @Override
    // funcType: INT_KW | VOID_KW;
    public Void visitFuncType(P8Parser.FuncTypeContext ctx) {
        HashMap<String, Object> attr_val = new HashMap<>();
        node_attr_Val.put(ctx, attr_val);
        if (ctx.INT_KW() != null)
            attr_val.put("funcType", "i32");
        else if (ctx.VOID_KW() != null)
            attr_val.put("funcType", "void");

        return null;
    }

    @Override
    // funcDef: funcType Ident LParser (funcFParams)? RParser block;
    public Void visitFuncDef(P8Parser.FuncDefContext ctx) {
        HashMap<String, Object> attr_val = new HashMap<>();
        node_attr_Val.put(ctx, attr_val);
        visit(ctx.funcType());
        String Ident = ctx.Ident().getText();
        String funcType = (String) node_attr_Val.get(ctx.funcType()).get("funcType");
        attr_val.put("retType", funcType);
        StringBuilder sb = new StringBuilder();
        sb.append("define dso_local ").append(node_attr_Val.get(ctx.funcType()).get("funcType")).append(" ").append("@").append(Ident).append(" (");
        ArrayList<String> tmpIR = null;
        if (ctx.funcFParams() != null) {
            visit(ctx.funcFParams());
            attr_val.put("funcFParams", node_attr_Val.get(ctx.funcFParams()).get("funcFParams"));
            attr_val.put("pTypes", node_attr_Val.get(ctx.funcFParams()).get("pTypes"));
            sb.append(node_attr_Val.get(ctx.funcFParams()).get("pStr"));
            tmpIR = (ArrayList<String>) node_attr_Val.get(ctx.funcFParams()).get("tmpIR");
        }
        funcIdent_Attr.put(Ident, attr_val);
        sb.append(")" + "{\n");
        IR_List.add(String.valueOf(sb));
        if (tmpIR != null)
            IR_List.addAll(tmpIR);
        visit(ctx.block());
        if (funcType.equals("void")) {
            IR_List.add("\tret void\n");
        }
        IR_List.add("}\n");
        currentReg = 0;
        clear_Ident_Reg(ctx);
        return null;
    }

    @Override
//    funcFParams: funcFParam ( ',' funcFParam )*;
    public Void visitFuncFParams(P8Parser.FuncFParamsContext ctx) {
        HashMap<String, Object> attr_val = new HashMap<>();
        node_attr_Val.put(ctx, attr_val);
        HashMap<String, HashMap<String, String>> funcFParams = new HashMap<>();
        ArrayList<String> pTypes = new ArrayList<>();
        attr_val.put("funcFParams", funcFParams);
        attr_val.put("pTypes", pTypes);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> tmpIR = new ArrayList<>();
        int tmpreg = currentReg;
        currentReg += ctx.funcFParam().size();
        for (P8Parser.FuncFParamContext fpc : ctx.funcFParam()) {
            visit(fpc);
            String pType = (String) node_attr_Val.get(fpc).get("pType");
            String Ident = (String) node_attr_Val.get(fpc).get("Ident");
            String pReg = "%x" + tmpreg++;
            sb.append(pType).append(" ").append(pReg).append(", ");
            HashMap<String, String> tmp = new HashMap<>();
            tmp.put("Ident", Ident);
            tmp.put("pType", pType);
            pTypes.add(pType);
            String saveReg = "%x" + currentReg++;
            tmpIR.add("\t" + saveReg + " = alloca " + pType + "\n");
            tmpIR.add("\tstore " + pType + " " + pReg + ", " + pType + "* " + saveReg + "\n");
            String thisReg = "%x" + currentReg++;
            tmpIR.add("\t" + thisReg + " = load " + pType + ", "+pType+"* " + saveReg + "\n");
            reg_Type.put(saveReg, pType+"*");
            reg_Type.put(thisReg, pType);
            reg_Type.put(pReg, pType);
//            funcFParams.put(thisReg, tmp);
            funcFParams.put(saveReg, tmp);
        }
        sb.setLength(sb.length() - 2);
        attr_val.put("tmpIR", tmpIR);
        attr_val.put("pStr", String.valueOf(sb));
        return null;
    }

    @Override
//    funcFParam : bType Ident (LBracket RBracket ( LBracket exp RBracket )*)?;
    public Void visitFuncFParam(P8Parser.FuncFParamContext ctx) {
        HashMap<String, Object> attr_val = new HashMap<>();
        node_attr_Val.put(ctx, attr_val);
        String Ident = ctx.Ident().getText();
        attr_val.put("Ident", Ident);
        visit(ctx.bType());
        String bType = (String) node_attr_Val.get(ctx.bType()).get("bType");
        if (ctx.LBracket().size() == 0) {
            attr_val.put("pType", bType);
        } else {
            ArrayList<Integer> size = new ArrayList<>();
            size.add(0);
            for (int i = 0; i < ctx.exp().size(); i++) {
                visit(ctx.exp(i));
                if (node_attr_Val.get(ctx.exp(i)).containsKey("numberVal")) {
                    Integer nodeval = Integer.parseInt((String) node_attr_Val.get(ctx.exp(i)).get("numberVal"));
                    size.add(nodeval);
                }
            }
            attr_val.put("pType", getArrSizeString(size) + "*");
            arri_size.put(Ident, size);
        }
        return null;
    }

    @Override
    // block:LBrace (blockItem)* RBrace;
    public Void visitBlock(P8Parser.BlockContext ctx) {
        if (node_attr_Val.get(ctx.parent).containsKey("funcFParams")) {
            HashMap<String, HashMap<String, String>> Ident_pReg_Type = (HashMap<String, HashMap<String, String>>) node_attr_Val.get(ctx.parent).get("funcFParams");
            for (String pReg : Ident_pReg_Type.keySet()) {
                HashMap<String, String> pattr_val = Ident_pReg_Type.get(pReg);
                String Ident = pattr_val.get("Ident");
//                String pType = pattr_val.get("pType");
                //TODO:???
                ident_Put_Reg(ctx, Ident, pReg);
//                reg_Type.put(pReg, pType);
            }
        }
        for (P8Parser.BlockItemContext bi : ctx.blockItem()) {
            visit(bi);
        }
        return null;
    }

    @Override
    // blockItem:decl|stmt;
    public Void visitBlockItem(P8Parser.BlockItemContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (ctx.stmt() != null) {
            attr_Val.put("type", "stmt");
            visit(ctx.stmt());
        } else if (ctx.decl() != null) {
            attr_Val.put("type", "decl");
            visit(ctx.decl());
        }
        if (ctx.parent instanceof P8Parser.StmtContext) {
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    // stmt:lVal ASSIGN exp Semicolon|block|(exp)+ Semicolon|returnStmt|IF_KW LParser cond RParser stmt ( ELSE_KW stmt )* | WHILE_KW LParser cond RParser stmt;
    public Void visitStmt(P8Parser.StmtContext ctx) {
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
                String lvalReg = (String) node_attr_Val.get(ctx.lVal()).get("thisReg");
//                String lvalReg = (String) ident_Get_Reg(ctx, Ident);
                String identType = reg_Type.get(lvalReg);
//                System.err.println(Ident + " " + identType);
                visit(ctx.exp());
                if (node_attr_Val.get(ctx.exp()).containsKey("thisReg")) {
                    String expReg = (String) node_attr_Val.get(ctx.exp()).get("thisReg");
                    String bType = reg_Type.get(expReg);
                    if (!identType.startsWith(bType)) {
                        System.err.println("Not Match Lval and new Value!");
                        System.exit(-1);
                    }
                    if(bType.equals("i32*")){
                        String tmpReg = "%x"+currentReg++;
                        IR_List.add("\t"+tmpReg+" = load i32, i32* "+expReg+"\n");
                        reg_Type.put(tmpReg,"i32");
                        IR_List.add("\tstore i32 "+ tmpReg + ", i32* " + lvalReg + "\n");
                    }else {
                        IR_List.add("\tstore " + bType + " " + expReg + ", " + bType + "* " + lvalReg + "\n");
                    }
                } else if (node_attr_Val.get(ctx.exp()).containsKey("numberVal")) {
                    IR_List.add("\tstore i32 " + node_attr_Val.get(ctx.exp()).get("numberVal") + ", i32* " + lvalReg + "\n");
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
                if(!IR_List.get(IR_List.size()-1).contains("ret")){
                    IR_List.add("\tbr label %x" + PassLabel + "\n");
                }
                IR_List.add("\nx" + FLabel + ":\n");
                if (ctx.stmt().size() == 2)
                    visit(ctx.stmt(1));

                if(!IR_List.get(IR_List.size()-1).contains("ret")){
                    IR_List.add("\tbr label %x" + PassLabel + "\n");

                    IR_List.add("\nx" + PassLabel + ":\n");
                }else {
                    IR_List.add("\n");
                }
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
            while (!(parent instanceof P8Parser.CompUnitContext)) {
                if (parent instanceof P8Parser.StmtContext) {
                    if (((P8Parser.StmtContext) parent).WHILE_KW() != null) {
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
            while (!(parent instanceof P8Parser.CompUnitContext)) {
                if (parent instanceof P8Parser.StmtContext) {
                    if (((P8Parser.StmtContext) parent).WHILE_KW() != null) {
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
    // lVal:Ident (LBracket exp RBracket)*;
    public Void visitLVal(P8Parser.LValContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        String Ident = ctx.Ident().getText();
        if (ident_Check_Reg(ctx, Ident) && arri_size.containsKey(Ident)) {//Array
            ArrayList<Integer> size = arri_size.get(Ident);
            //TODO:Type here
            String idptr = (String) ident_Get_Reg(ctx, Ident);
            String idtype = reg_Type.get(idptr);
            System.err.println("visitLVal,Arr Ident:"+Ident+" Reg:"+idptr+" Type:"+idtype);
            if (idtype.equals("i32**")) {
                String tmpReg = "%x" + currentReg++;
//                String tmptype = idtype.substring(0, idtype.length() - 1);
                reg_Type.put(tmpReg, "i32*");
                IR_List.add("\t" + tmpReg + " = load i32*, i32** " + idptr + "\n");
                idptr = tmpReg;
            }
            int dim = size.size();
            int lvaldim = ctx.exp().size();
            ArrayList<String> lvalList = new ArrayList<>();
            for (int i = 0; i < lvaldim; i++) {
                visit(ctx.exp(i));
                if (node_attr_Val.get(ctx.exp(i)).containsKey("numberVal")) {
                    lvalList.add(i, (String) node_attr_Val.get(ctx.exp(i)).get("numberVal"));
                } else if (node_attr_Val.get(ctx.exp(i)).containsKey("thisReg")) {
                    String thisReg = (String) node_attr_Val.get(ctx.exp(i)).get("thisReg");
                    if(reg_Type.get(thisReg).equals("i32*")){
                        String tmpReg = "%x" + currentReg++;
                        IR_List.add("\t"+tmpReg+" = load i32, i32* "+thisReg+"\n");
                        reg_Type.put(tmpReg,"i32");
                        thisReg = tmpReg;
                    }
                    lvalList.add(i, thisReg);
                }
            }
            ArrayList<Integer> tmpsize = new ArrayList<>();
            for (int i = lvaldim; i < dim; i++) {
                tmpsize.add(size.get(i));
            }
            String thisReg = "%x" + currentReg++;
            attr_Val.put("thisReg", thisReg);
            reg_Type.put(thisReg, getArrSizeString(tmpsize) + "*");
            attr_Val.put("remainSize", tmpsize);
            StringBuilder sb = new StringBuilder();
            sb.append("\t").append(thisReg).append(" = getelementptr ").append(getArrSizeString(size)).append(", ").append(getArrSizeString(size)).append("* ").append(idptr);
            if (size.get(0) != 0) {
                sb.append(", i32 0");
            }
            for (int i = 0; i < lvaldim; i++) {
                sb.append(", i32 ").append(lvalList.get(i));
            }

            sb.append("\n");
            IR_List.add(String.valueOf(sb));
        } else {
            if (ident_Check_Reg(ctx, Ident)) {
                String identReg = (String) ident_Get_Reg(ctx, Ident);
                if (identReg.startsWith("%x") || identReg.startsWith("@")) {// local var or global var
                    System.err.println("visitLVal Ident:"+Ident+" Reg:"+identReg+" Type:"+reg_Type.get(identReg));
//                    String type = reg_Type.get(identReg);
//                    if(type.equals("i32*")){
//                        String thisReg = "%x" + currentReg++;
//                        IR_List.add("      \t" + thisReg + " = load i32, i32* " + identReg + "\n");
//                    }
                    attr_Val.put("thisReg", identReg);
//                    if (type.startsWith("i32") && type.endsWith("*")) {
//                        String thisReg = "%x" + currentReg++;
//                        String tmptype = type.substring(0, type.length() - 1);
//                        reg_Type.put(thisReg, tmptype);
//                        IR_List.add("\t" + thisReg + " = load " + tmptype + ", " + type + " " + identReg + "\n");
//                        attr_Val.put("thisReg", thisReg);
//                    } else {
//                        attr_Val.put("thisReg", identReg);
//                    }
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
    // cond:lOrExp
    public Void visitCond(P8Parser.CondContext ctx) {
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
    // returnStmt:RETURN_KW exp Semicolon;
    public Void visitReturnStmt(P8Parser.ReturnStmtContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.exp());
        if (node_attr_Val.get(ctx.exp()).containsKey("thisReg")) {
            String expReg = (String) node_attr_Val.get(ctx.exp()).get("thisReg");
//            String bType = reg_Type.get(expReg);
            String thisReg = (String) node_attr_Val.get(ctx.exp()).get("thisReg");
            if(reg_Type.get(thisReg).equals("i32*")){
                String tmpReg = "%x" + currentReg++;
                IR_List.add("\t"+tmpReg+" = load i32, i32* "+thisReg+"\n");
                reg_Type.put(tmpReg,"i32");
                thisReg = tmpReg;
            }
            IR_List.add("\tret i32 " + thisReg + "\n");
        } else if (node_attr_Val.get(ctx.exp()).containsKey("numberVal")) {
            IR_List.add("\tret i32 " + node_attr_Val.get(ctx.exp()).get("numberVal") + "\n");
        }
        return null;
    }

    @Override
    // constExp:addExp;
    public Void visitConstExp(P8Parser.ConstExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        visit(ctx.addExp());
        attr_Val.put("constExpVal", node_attr_Val.get(ctx.addExp()).get("numberVal"));
        return null;
    }

    @Override
    // exp:addExp;
    public Void visitExp(P8Parser.ExpContext ctx) {
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
    public Void visitAddExp(P8Parser.AddExpContext ctx) {
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
                if(reg_Type.get(addExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+addExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    addExpReg = tmpReg;
                }
            }

            visit(ctx.mulExp());
            if (node_attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                mulExpVal = Long.parseLong((String) node_attr_Val.get(ctx.mulExp()).get("numberVal"));
            } else if (node_attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                mulExpReg = (String) node_attr_Val.get(ctx.mulExp()).get("thisReg");
                if(reg_Type.get(mulExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+mulExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    mulExpReg = tmpReg;
                }
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
    public Void visitMulExp(P8Parser.MulExpContext ctx) {
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
                if(reg_Type.get(mulExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+mulExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    mulExpReg = tmpReg;
                }
            }

            visit(ctx.unaryExp());
            // String unaryExpType = "i32";
            if (node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                unaryExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.unaryExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                unaryExpReg = (String) node_attr_Val.get(ctx.unaryExp()).get("thisReg");
                if(reg_Type.get(unaryExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+unaryExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    unaryExpReg = tmpReg;
                }
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
//    unaryExp: Ident LParser (exp ( ',' exp)*)? RParser | ( ADD | SUB | NOT ) unaryExp | primaryExp;
    public Void visitUnaryExp(P8Parser.UnaryExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_attr_Val.put(ctx, attr_Val);
        if (node_attr_Val.get(ctx.parent).containsKey("global")) {
            attr_Val.put("global", "global");
        }
        if (ctx.Ident() != null) { // Ident LParser (exp ( ',' exp)*)? RParser
            String Ident = ctx.Ident().getText();
            if (!ident_Check_Reg_this_Block(ctx, Ident) && !Main.externalFunc.containsKey(Ident) && !funcIdent_Attr.containsKey(Ident)) {
                System.err.println("Undeclared Ident:" + Ident);
                System.exit(1);
            }
            StringBuilder sbIR = new StringBuilder();
            if (Main.externalFunc.containsKey(Ident)) {
                String retType = Main.externalFunc.get(Ident);
                ArrayList<String> pTypes = Main.externalFunc_para.get(Ident);
                sbIR.append("call ").append(retType).append(" @").append(Ident).append("(");
                for (int i=0;i<ctx.exp().size();i++) {
                    visit(ctx.exp(i));
                    if (node_attr_Val.get(ctx.exp(i)).containsKey("thisReg")) {
                        String thisReg = (String) node_attr_Val.get(ctx.exp(i)).get("thisReg");
                        String bType = reg_Type.get(thisReg);
                        if(bType.equals("i32*")&&pTypes.get(i).equals("i32")){
                            String tmpReg = "%x" + currentReg++;
                            IR_List.add("\t"+tmpReg+" = load i32, i32* "+thisReg+"\n");
                            reg_Type.put(tmpReg,"i32");
                            bType = "i32";
                            thisReg = tmpReg;
                        }
                        sbIR.append(bType).append(" ").append(thisReg);
                    } else if (node_attr_Val.get(ctx.exp(i)).containsKey("numberVal")) {
                        sbIR.append("i32 ").append(node_attr_Val.get(ctx.exp(i)).get("numberVal"));
                    }
                    if(i!=ctx.exp().size()-1){
                        sbIR.append(", ");
                    }
                }
                StringBuilder psb = new StringBuilder();
                for(String s:pTypes){
                    psb.append(s).append(", ");
                }
                psb.delete(psb.length()-2,psb.length());
                String para = String.valueOf(psb);
                sbIR.append(")\n");
                if (!Main.funcUsed.contains(Ident)) {
                    if (para != null)
                        IR_List.add(0, "declare " + retType + " @" + Ident + "(" + para + ")\n");
                    else
                        IR_List.add(0, "declare " + retType + " @" + Ident + "()\n");
                    Main.funcUsed.add(Ident);
                }
                if (!retType.equals("void")) {
                    String thisReg = "%x" + currentReg++;
                    reg_Type.put(thisReg, retType);
                    attr_Val.put("thisReg", thisReg);
                    IR_List.add("\t" + thisReg + " = " + sbIR);
                } else {
                    IR_List.add("\t" + sbIR);
                }
            } else if (funcIdent_Attr.containsKey(Ident)) {
                String retType = (String) funcIdent_Attr.get(Ident).get("retType");
                ArrayList<String> pTypes = (ArrayList<String>) funcIdent_Attr.get(Ident).get("pTypes");
                sbIR.append("call ").append(retType).append(" @").append(Ident).append("(");
                for (int i=0;i<ctx.exp().size();i++) {
                    visit(ctx.exp(i));
                    if (node_attr_Val.get(ctx.exp(i)).containsKey("thisReg")) {
                        String thisReg = (String) node_attr_Val.get(ctx.exp(i)).get("thisReg");
                        String bType = reg_Type.get(thisReg);
                        if(bType.equals("i32*")&&pTypes.get(i).equals("i32")){
                            String tmpReg = "%x" + currentReg++;
                            IR_List.add("\t"+tmpReg+" = load i32, i32* "+thisReg+"\n");
                            reg_Type.put(tmpReg,"i32");
                            thisReg = tmpReg;
                            bType = "i32";
                        }
                        sbIR.append(bType).append(" ").append(thisReg);
                    } else if (node_attr_Val.get(ctx.exp(i)).containsKey("numberVal")) {
                        sbIR.append("i32 ").append(node_attr_Val.get(ctx.exp(i)).get("numberVal"));
                    }
                    if(i!=ctx.exp().size()-1){
                        sbIR.append(", ");
                    }
                }
                sbIR.append(")\n");
                if (!retType.equals("void")) {
                    String thisReg = "%x" + currentReg++;
                    reg_Type.put(thisReg, retType);
                    attr_Val.put("thisReg", thisReg);
                    IR_List.add("\t" + thisReg + " = " + sbIR);
                } else {
                    IR_List.add("\t" + sbIR);
                }

            }
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
                String unaryExpReg = (String) node_attr_Val.get(ctx.unaryExp()).get("thisReg");
                if(reg_Type.get(unaryExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+unaryExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    unaryExpReg = tmpReg;
                }
                attr_Val.put("thisReg", unaryExpReg);
            }
        } else if (ctx.SUB() != null) { // SUB unaryExp
            visit(ctx.unaryExp());
            if (node_attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                long numberVal = Long.parseLong((String) (node_attr_Val.get(ctx.unaryExp()).get("numberVal")));
                attr_Val.put("numberVal", String.valueOf(numberVal * -1));
            } else {
                String unaryExpReg = (String) node_attr_Val.get(ctx.unaryExp()).get("thisReg");
                if(reg_Type.get(unaryExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+unaryExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    unaryExpReg = tmpReg;
                }
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
                if(reg_Type.get(unaryExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+unaryExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    unaryExpReg = tmpReg;
                }
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
    public Void visitPrimaryExp(P8Parser.PrimaryExpContext ctx) {
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
            //TODO:留不留？
            String thisReg = (String) node_attr_Val.get(ctx.exp()).get("thisReg");
            if(reg_Type.get(thisReg).equals("i32*")){
                String tmpReg = "%x" + currentReg++;
                IR_List.add("\t"+tmpReg+" = load i32, i32* "+thisReg+"\n");
                reg_Type.put(tmpReg,"i32");
                thisReg = tmpReg;
            }
            attr_Val.put("expReg", thisReg);
        } else if (ctx.lVal() != null) {
            visit(ctx.lVal());
            if(node_attr_Val.get(ctx.lVal()).containsKey("remainSize")){//Array
                if(node_attr_Val.get(ctx.lVal()).containsKey("thisReg")){
                    ArrayList<Integer> size = (ArrayList<Integer>) node_attr_Val.get(ctx.lVal()).get("remainSize");
                    String type = getArrSizeString(size);
                    String lvalReg = (String) node_attr_Val.get(ctx.lVal()).get("thisReg");
                    if(type.equals("i32")){
                        attr_Val.put("lValReg", lvalReg);
                    }else{
                        StringBuilder sb = new StringBuilder();
                        String thisReg = "%x" + currentReg++;
                        sb.append("\t").append(thisReg).append(" = getelementptr ").append(getArrSizeString(size)).append(", ").append(getArrSizeString(size)).append("* ").append(lvalReg);
                        sb.append(", i32 0".repeat(size.size() + 1));
                        sb.append("\n");
                        IR_List.add(String.valueOf(sb));
                        attr_Val.put("lValReg", thisReg);
                        reg_Type.put(thisReg, "i32*");
                    }
                }
            }
            else if(node_attr_Val.get(ctx.lVal()).containsKey("thisReg")){
                String lValReg = (String) node_attr_Val.get(ctx.lVal()).get("thisReg");
                attr_Val.put("lValReg", lValReg);
            } else if (node_attr_Val.get(ctx.lVal()).containsKey("nodeVal")) {
                attr_Val.put("numberVal", node_attr_Val.get(ctx.lVal()).get("nodeVal"));
            }
        }
        return null;
    }

    @Override
    // relExp:addExp |relExp ( LT_KW | GT_KW | LE_KW | GE_KW ) addExp
    public Void visitRelExp(P8Parser.RelExpContext ctx) {
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
                if(reg_Type.get(relExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+relExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    relExpReg = tmpReg;
                }
            }
            visit(ctx.addExp());
            if (node_attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                addExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.addExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                addExpReg = (String) node_attr_Val.get(ctx.addExp()).get("thisReg");
                if(reg_Type.get(addExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+addExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    addExpReg = tmpReg;
                }
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
    public Void visitEqExp(P8Parser.EqExpContext ctx) {
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
                if(reg_Type.get(eqExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+eqExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    eqExpReg = tmpReg;
                }
            }
            visit(ctx.relExp());
            if (node_attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                relExpVal = Long.parseLong((String) (node_attr_Val.get(ctx.relExp()).get("numberVal")));
            } else if (node_attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                relExpReg = (String) node_attr_Val.get(ctx.relExp()).get("thisReg");
                if(reg_Type.get(relExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+relExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    relExpReg = tmpReg;
                }
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
    public Void visitLAndExp(P8Parser.LAndExpContext ctx) {
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
    public Void visitLOrExp(P8Parser.LOrExpContext ctx) {
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
                if(reg_Type.get(lOrExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+lOrExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    lOrExpReg = tmpReg;
                }
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
                if(reg_Type.get(lAndExpReg).equals("i32*")){
                    String tmpReg = "%x" + currentReg++;
                    IR_List.add("\t"+tmpReg+" = load i32, i32* "+lAndExpReg+"\n");
                    reg_Type.put(tmpReg,"i32");
                    lAndExpReg = tmpReg;
                }
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

    @Override
    // number:intConst;
    public Void visitNumber(P8Parser.NumberContext ctx) {
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
    public Void visitIntConst(P8Parser.IntConstContext ctx) {
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

}