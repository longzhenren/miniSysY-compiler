package com.miniSysY.P4;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Visitor extends P4BaseVisitor<Void> {
    Integer currentReg = 0;
    HashMap<RuleNode, HashMap<String, Object>> node_Attr_Val = new HashMap<>(); // 保存树上结点的各种属性
    HashMap<String, Integer> ident_Reg = new HashMap<>(); // 变量名到寄存器的映射
    HashMap<RuleContext, HashMap<String, Integer>> block_ident_Reg = new HashMap<>();
    HashMap<Integer, String> reg_Type = new HashMap<>();
    HashMap<String, Long> constIdent_Val = new HashMap<>();// 常量值表
    HashMap<String, HashMap<String, Object>> funcIdent_Attr = new HashMap<>();
    public static HashMap<Integer, ArrayList<String>> block_IR = new HashMap<>();
    public static ArrayList<String> IR_List = new ArrayList<>();

//    public boolean ident_check_Reg(RuleContext ctx, String Ident) {
//        RuleContext parent = ctx;
//        while (!(parent instanceof P4Parser.CompUnitContext)) {
//            if (parent instanceof P4Parser.BlockContext) {
//                if (block_ident_Reg.get(parent).containsKey(Ident))
//                    return true;
//            } else {
//                parent = parent.parent;
//            }
//        }
//        return false;
//    }
//
//    public void ident_Put_Reg(RuleContext ctx, String Ident, Integer Reg) {
//        RuleContext parent = ctx;
//        while (!(parent instanceof P4Parser.BlockContext)) {
//            parent = parent.parent;
//        }
//        HashMap<String, Integer> I_R = new HashMap<>();
//        I_R.put(Ident, Reg);
//        ident_Reg.put(Ident, Reg);
//        block_ident_Reg.put(parent, I_R);
//    }

    @Override
    // blockItem:decl|stmt;
    public Void visitBlockItem(P4Parser.BlockItemContext ctx) {
        // System.out.println(";visitBlockItem");
        HashMap<String, Object> attr_val = new HashMap<>();
        if (ctx.stmt() != null) {
            attr_val.put("type", "stmt");
            visit(ctx.stmt());
        } else if (ctx.decl() != null) {
            attr_val.put("type", "decl");
            visit(ctx.decl());
        }
        if (ctx.parent instanceof P4Parser.StmtContext) {
            Integer blockID = (Integer) node_Attr_Val.get(ctx.parent).get("blockID");
            attr_val.put("blockID", blockID);
            visit(ctx.stmt());
        }
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitBlockItem" + " Fin");
        return null;
    }

    @Override
    // lVal:Ident;
    public Void visitLVal(P4Parser.LValContext ctx) {
        // System.out.println(";visitLVal");
        HashMap<String, Object> attr_val = new HashMap<>();
        if (ident_Reg.containsKey(ctx.Ident().getText())) {
            Integer identReg = ident_Reg.get(ctx.Ident().getText());
            int thisReg = currentReg++;
            reg_Type.put(thisReg,"i32");
            IR_List.add("\t%x" + thisReg + " = load i32, i32* %x" + identReg + "\n");
            attr_val.put("thisReg", thisReg);
        } else if (constIdent_Val.containsKey(ctx.Ident().getText())) {
            attr_val.put("nodeVal", constIdent_Val.get(ctx.Ident().getText()));
        } else {
            System.exit(1);
        }
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitLVal" + " Fin");
        return null;
    }

    @Override
    // decl:constDecl|varDecl;
    public Void visitDecl(P4Parser.DeclContext ctx) {
        // System.out.println(";visitDecl");
        // System.out.println(";visitDecl" + " Fin");
        return super.visitDecl(ctx);
    }

    @Override
    // constDecl:CONST_KW bType constDef (',' constDef)* Semicolon;
    public Void visitConstDecl(P4Parser.ConstDeclContext ctx) {
        // System.out.println(";visitConstDecl");
        HashMap<String, Object> attr_val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_val);
        visit(ctx.bType());
        for (P4Parser.ConstDefContext cdf : ctx.constDef()) {
            if (constIdent_Val.containsKey(cdf.Ident().getText()) || ident_Reg.containsKey(cdf.Ident().getText())) {
                System.exit(1);
            }
            visit(cdf);
        }
        // System.out.println(";visitConstDecl" + " Fin");
        return null;
    }

    @Override
    // bType:INT_KW;
    public Void visitBType(P4Parser.BTypeContext ctx) {
        // System.out.println(";visitBType");
        if (ctx.INT_KW() != null) {
            node_Attr_Val.get(ctx.parent).put("bType", "i32");
        }
        // System.out.println(";visitBType" + " Fin");
        return null;
    }

    @Override
    // constDef:Ident ASSIGN constInitVal;
    public Void visitConstDef(P4Parser.ConstDefContext ctx) {
        // System.out.println(";visitConstDef");
        // String bType = node_Attr_Val.get(ctx.parent).get("bType");
        HashMap<String, Object> attr_val = new HashMap<>();
        if (ctx.ASSIGN() != null) {
            if (ctx.ASSIGN().getText().equals("=")) {
                visit(ctx.constInitVal());
                Long constExpVal = (Long) node_Attr_Val.get(ctx.constInitVal()).get("constExpVal");
                constIdent_Val.put(ctx.Ident().getText(), constExpVal);
            }
        }
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitConstDef" + " Fin");
        return null;
    }

    @Override
    // constInitVal:constExp;
    public Void visitConstInitVal(P4Parser.ConstInitValContext ctx) {
        // System.out.println(";visitConstInitVal");
        HashMap<String, Object> attr_val = new HashMap<>();
        visit(ctx.constExp());
        attr_val.put("constExpVal", node_Attr_Val.get(ctx.constExp()).get("constExpVal"));
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitConstInitVal" + " Fin");
        return null;
    }

    @Override
    // constExp:addExp;
    public Void visitConstExp(P4Parser.ConstExpContext ctx) {
        // System.out.println(";visitConstExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        // attr_Val.put("bType", node_Attr_Val.get(ctx.parent).get("bType"));
        visit(ctx.addExp());
        attr_Val.put("constExpVal", node_Attr_Val.get(ctx.addExp()).get("numberVal"));
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitConstExp" + " Fin");
        return null;
    }

    @Override
    // varDecl:bType varDef (',' varDef)* Semicolon;
    public Void visitVarDecl(P4Parser.VarDeclContext ctx) {
        // System.out.println(";visitVarDecl");
        HashMap<String, Object> attr_val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_val);
        visit(ctx.bType());
        for (P4Parser.VarDefContext vdf : ctx.varDef()) {
            String Ident = vdf.Ident().getText();
            if (ident_Reg.containsKey(Ident) || constIdent_Val.containsKey(Ident)) {
                System.exit(1);
            }
            visit(vdf);
        }
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitVarDecl" + " Fin");
        return null;
    }

    @Override
    // varDef:Ident|Ident ASSIGN initVal;
    public Void visitVarDef(P4Parser.VarDefContext ctx) {
        // System.out.println(";visitVarDef");
        HashMap<String, Object> attr_val = new HashMap<>();
        int thisReg = currentReg++;
        reg_Type.put(thisReg,"i32");
        String bType = (String) node_Attr_Val.get(ctx.parent).get("bType");
        reg_Type.put(thisReg, bType);
        IR_List.add("\t%x" + thisReg + " = alloca " + bType + " , align 4" + "\n");
        ident_Reg.put(ctx.Ident().getText(), thisReg);
//        ident_Put_Reg(ctx, ctx.Ident().getText(), thisReg);
        if (ctx.ASSIGN() != null) {
            if (ctx.ASSIGN().getText().equals("=")) {
                visit(ctx.initVal());
                if (node_Attr_Val.get(ctx.initVal()).containsKey("thisReg")) {
                    Integer initValReg = (Integer) node_Attr_Val.get(ctx.initVal()).get("thisReg");
                    if (!bType.equals(reg_Type.get(initValReg))) {
                        System.out.println("Type dismatch!");
                        System.exit(-1);
                    }
                    IR_List.add("\tstore " + bType + " %x" + initValReg + ", " + bType + "* %x" + thisReg + "\n");
                } else if (node_Attr_Val.get(ctx.initVal()).containsKey("numberVal")) {
                    Long numVal = (Long) node_Attr_Val.get(ctx.initVal()).get("numberVal");
                    IR_List.add("\tstore " + bType + numVal + ", " + bType + "* %x" + thisReg + "\n");
                }
            }
        }
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitVarDef" + " Fin");
        return null;
    }

    @Override
    // initVal:exp;
    public Void visitInitVal(P4Parser.InitValContext ctx) {
        // System.out.println(";visitInitVal");
        HashMap<String, Object> attr_val = new HashMap<>();
        visit(ctx.exp());
        if (node_Attr_Val.get(ctx.exp()).containsKey("thisReg")) {
            attr_val.put("thisReg", node_Attr_Val.get(ctx.exp()).get("thisReg"));
        } else if (node_Attr_Val.get(ctx.exp()).containsKey("numberVal")) {
            attr_val.put("numberVal", node_Attr_Val.get(ctx.exp()).get("numberVal"));
        }
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitInitVal" + " Fin");
        return null;
    }

    @Override
    // compUnit:funcDef;
    public Void visitCompUnit(P4Parser.CompUnitContext ctx) {
        // System.out.println(";visitCompUnit");
        visit(ctx.funcDef());
        // System.out.println(";visitCompUnit" + " Fin");
        return null;
    }

    @Override
    // funcType:INT_KW;
    public Void visitFuncType(P4Parser.FuncTypeContext ctx) {
        // System.out.println(";visitFuncType");
        HashMap<String, Object> node_Attr = new HashMap<>();
        if (ctx.INT_KW().getText().equals("int"))
            node_Attr.put("funcType", "i32");
        node_Attr_Val.put(ctx, node_Attr);
        // System.out.println(";visitFuncType" + " Fin");
        return null;
    }

    @Override
    // funcIdent:FuncIdent;
    public Void visitFuncIdent(P4Parser.FuncIdentContext ctx) {
        // System.out.println(";visitFuncIdent");
        HashMap<String, Object> attr_val = new HashMap<>();
        attr_val.put("funcIdent", ctx.FuncIdent().getText());
        node_Attr_Val.put(ctx, attr_val);
        // System.out.println(";visitFuncIdent" + " Fin");
        return null;
    }

    @Override
    // funcDef:funcType funcIdent LParser RParser block;
    public Void visitFuncDef(P4Parser.FuncDefContext ctx) {
        // System.out.println(";visitFuncDef");
        visit(ctx.funcType());
        visit(ctx.funcIdent());
        IR_List.add("define dso_local " + node_Attr_Val.get(ctx.funcType()).get("funcType") + " " + "@" + node_Attr_Val.get(ctx.funcIdent()).get("funcIdent") + " ()" + "{\n");
        visit(ctx.block());
        IR_List.add("}");
        // System.out.println(";visitFuncDef" + " Fin");
        return null;
    }

    @Override
    // block:LBrace (blockItem)* RBrace;
    public Void visitBlock(P4Parser.BlockContext ctx) {
        // System.out.println(";visitBlock");
        for (P4Parser.BlockItemContext bi : ctx.blockItem()) {
            visit(bi);
        }
        // System.out.println(";visitBlock" + " Fin");
        return null;
    }

    @Override
    // stmt:lVal ASSIGN exp Semicolon|block|(exp)+ Semicolon|returnStmt|IF_KW
    // LParser cond RParser stmt ( ELSE_KW stmt )*;
    public Void visitStmt(P4Parser.StmtContext ctx) {
        // System.out.println(";visitStmt");
        HashMap<String, Object> attr_Val = new HashMap<>();
        if (ctx.returnStmt() != null) {
            visit(ctx.returnStmt());
        } else if (ctx.ASSIGN() != null) {
            if (ctx.ASSIGN().getText().equals("=")) {
                String Ident = ctx.lVal().Ident().getText();
                if (!ident_Reg.containsKey(Ident) || constIdent_Val.containsKey(Ident)) {
                    System.exit(1);
                }
                Integer identReg = ident_Reg.get(Ident);
                String bType = reg_Type.get(identReg);
                visit(ctx.exp(0));
                if (node_Attr_Val.get(ctx.exp(0)).containsKey("thisReg")) {
                    Integer expReg = (Integer) node_Attr_Val.get(ctx.exp(0)).get("thisReg");
                    if (!reg_Type.get(expReg).equals(bType)) {
                        System.exit(-1);
                    }
                    IR_List.add("\tstore " + bType + " %x" + expReg + ", " + bType + "* %x" + identReg + "\n");
                } else if (node_Attr_Val.get(ctx.exp(0)).containsKey("numberVal")) {
                    IR_List.add("\tstore i32 " + node_Attr_Val.get(ctx.exp(0)).get("numberVal") + ", i32* %x" + identReg + "\n");
                }
            }
        } else if (ctx.IF_KW() != null) {
            visit(ctx.cond());
            Integer TLabel = (Integer) node_Attr_Val.get(ctx.cond()).get("TLabel");
            Integer FLabel = (Integer) node_Attr_Val.get(ctx.cond()).get("FLabel");
            Integer PassLabel = currentReg++;
            reg_Type.put(PassLabel,"i32");
            if (ctx.ELSE_KW() == null) {
                IR_List.add("\nx" + TLabel + ":\n");
                visit(ctx.stmt(0));
                IR_List.add("\tbr label %x" + PassLabel + "\n");
                IR_List.add("\nx" + PassLabel + ":\n");
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
        } else {
            for (P4Parser.ExpContext exp : ctx.exp()) {
                visit(exp);
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitStmt" + " Fin");
        return null;
    }

    @Override
    // number:intConst;
    public Void visitNumber(P4Parser.NumberContext ctx) {
        // System.out.println(";visitNumber");
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.intConst() != null) {
            visit(ctx.intConst());
            attr_Val.put("nodeVal", node_Attr_Val.get(ctx.intConst()).get("nodeVal"));
            node_Attr_Val.put(ctx, attr_Val);
        }
        // System.out.println(";visitNumber" + " Fin");
        return null;
    }

    @Override
    // intConst:DecimalConst|OctalConst|HexadecimalConst;
    public Void visitIntConst(P4Parser.IntConstContext ctx) {
        // System.out.println(";visitIntConst");
        HashMap<String, Object> attr_Val = new HashMap<>();
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
            attr_Val.put("nodeVal", res);
        }
        // TODO: else?
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitIntConst" + " Fin");
        return null;
    }

    @Override
    // returnStmt:RETURN_KW exp Semicolon;
    public Void visitReturnStmt(P4Parser.ReturnStmtContext ctx) {
        // System.out.println(";visitReturnStmt");
        visit(ctx.exp());
        if (node_Attr_Val.get(ctx.exp()).containsKey("thisReg")) {
            Integer expReg = (Integer) node_Attr_Val.get(ctx.exp()).get("thisReg");
            String bType = reg_Type.get(expReg);
            IR_List.add("\tret " + bType + " %x" + expReg + "\n");
        } else if (node_Attr_Val.get(ctx.exp()).containsKey("numberVal")) {
            IR_List.add("\tret i32 " + node_Attr_Val.get(ctx.exp()).get("numberVal") + "\n");
        }
        // System.out.println(";visitReturnStmt" + " Fin");
        return null;
    }

    @Override
    // exp:addExp;
    public Void visitExp(P4Parser.ExpContext ctx) {
        // System.out.println(";visitExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        // attr_Val.put("bType", node_Attr_Val.get(ctx.parent).get("bType"));
        visit(ctx.addExp());
        // String expType = "i32";
        if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
            attr_Val.put("thisReg", node_Attr_Val.get(ctx.addExp()).get("thisReg"));
        } else if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
            attr_Val.put("numberVal", node_Attr_Val.get(ctx.addExp()).get("numberVal"));
        }
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitExp" + " Fin");
        return null;
    }

    @Override
    // addExp:mulExp|addExp ( ADD | SUB ) mulExp;
    public Void visitAddExp(P4Parser.AddExpContext ctx) {
        // System.out.println(";visitAddExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { // mulExp
            visit(ctx.mulExp());
            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.mulExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.mulExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // addExp ( ADD | SUB ) mulExp;
            Long addExpVal = 0L, mulExpVal = 0L;
            Integer addExpReg = 0, mulExpReg = 0;
            visit(ctx.addExp());
            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                addExpVal = (Long) node_Attr_Val.get(ctx.addExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                addExpReg = (Integer) node_Attr_Val.get(ctx.addExp()).get("thisReg");
            }

            visit(ctx.mulExp());
            // String mulExpType = "i32";
            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                mulExpVal = (Long) node_Attr_Val.get(ctx.mulExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                mulExpReg = (Integer) node_Attr_Val.get(ctx.mulExp()).get("thisReg");
            }

            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")
                    && node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                if (ctx.ADD() != null) {
                    attr_Val.put("numberVal", addExpVal + mulExpVal);
                } else if (ctx.SUB() != null) {
                    attr_Val.put("numberVal", addExpVal - mulExpVal);
                }
            } else {
                Integer thisReg = currentReg++;
                reg_Type.put(thisReg, "i32");
                attr_Val.put("thisReg", thisReg);
                StringBuilder sb = new StringBuilder();
                sb.append("\t%x").append(thisReg).append(" = ");
                if (ctx.ADD() != null) {
                    sb.append("add nsw i32 ");
                } else if (ctx.SUB() != null) {
                    sb.append("sub nsw i32 ");
                }
                if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")
                        && node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                    sb.append(addExpVal).append(", %x").append(mulExpReg);
                } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")
                        && node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                    sb.append("%x").append(addExpReg).append(", ").append(mulExpVal);
                } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")
                        && node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                    sb.append("%x").append(addExpReg).append(", %x").append(mulExpReg);
                }
                IR_List.add(sb + "\n");
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitAddExp" + " Fin");
        return null;
    }

    @Override
    // mulExp:unaryExp|mulExp ( MUL | DIV | MOD ) unaryExp;
    public Void visitMulExp(P4Parser.MulExpContext ctx) {
        // System.out.println(";visitMulExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { // unaryExp
            visit(ctx.unaryExp());
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.unaryExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.unaryExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // mulExp ( MUL | DIV | MOD ) unaryExp;
            Long mulExpVal = 0L, unaryExpVal = 0L;
            Integer mulExpReg = 0, unaryExpReg = 0;

            visit(ctx.mulExp());
            String mulExpType = "i32";
            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                mulExpVal = (Long) node_Attr_Val.get(ctx.mulExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                mulExpReg = (Integer) node_Attr_Val.get(ctx.mulExp()).get("thisReg");
            }

            visit(ctx.unaryExp());
            // String unaryExpType = "i32";
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                unaryExpVal = (Long) node_Attr_Val.get(ctx.unaryExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                unaryExpReg = (Integer) node_Attr_Val.get(ctx.unaryExp()).get("thisReg");
            }

            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")
                    && node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                if (ctx.MUL() != null) {
                    attr_Val.put("numberVal", mulExpVal * unaryExpVal);
                } else if (ctx.DIV() != null) {
                    attr_Val.put("numberVal", mulExpVal / unaryExpVal);
                } else if (ctx.MOD() != null) {
                    attr_Val.put("numberVal", mulExpVal % unaryExpVal);
                }
            } else {
                Integer thisReg = currentReg++;
                attr_Val.put("thisReg", thisReg);
                reg_Type.put(thisReg, "i32");
                if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")
                        && node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                    if (ctx.MUL() != null) {
                        IR_List.add("\t%x" + thisReg + " = mul nsw " + mulExpType + " " + mulExpVal + ", %x"
                                + unaryExpReg + "\n");
                    } else if (ctx.DIV() != null) {
                        IR_List.add("\t%x" + thisReg + " = sdiv " + mulExpType + " " + mulExpVal + ", %x" + unaryExpReg
                                + "\n");
                    } else if (ctx.MOD() != null) {
                        IR_List.add("\t%x" + thisReg + " = srem " + mulExpType + " " + mulExpVal + ", %x" + unaryExpReg
                                + "\n");
                    }
                } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")
                        && node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                    if (ctx.MUL() != null) {
                        IR_List.add("\t%x" + thisReg + " = mul nsw " + mulExpType + " %x" + mulExpReg + ", "
                                + unaryExpVal + "\n");
                    } else if (ctx.DIV() != null) {
                        IR_List.add("\t%x" + thisReg + " = sdiv " + mulExpType + " %x" + mulExpReg + ", " + unaryExpVal
                                + "\n");
                    } else if (ctx.MOD() != null) {
                        IR_List.add("\t%x" + thisReg + " = srem " + mulExpType + " %x" + mulExpReg + ", " + unaryExpVal
                                + "\n");
                    }
                } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")
                        && node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                    if (ctx.MUL() != null) {
                        IR_List.add("\t%x" + thisReg + " = mul nsw " + mulExpType + " %x" + mulExpReg + ", %x"
                                + unaryExpReg + "\n");
                    } else if (ctx.DIV() != null) {
                        IR_List.add("\t%x" + thisReg + " = sdiv " + mulExpType + " %x" + mulExpReg + ", %x"
                                + unaryExpReg + "\n");
                    } else if (ctx.MOD() != null) {
                        IR_List.add("\t%x" + thisReg + " = srem " + mulExpType + " %x" + mulExpReg + ", %x"
                                + unaryExpReg + "\n");
                    }
                }
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitMulExp" + " Fin");
        return null;
    }

    @Override
    // unaryExp:primaryExp|( ADD | SUB | NOT ) unaryExp | Ident LParser (exp ( ',' exp
    // )+)* RParser;
    public Void visitUnaryExp(P4Parser.UnaryExpContext ctx) {
        // System.out.println(";visitUnaryExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        if (ctx.Ident() != null) { // Ident LParser (exp ( ',' exp )+)* RParser
            // attr_Val.put("paraExpList",ctx.exp());
            String Ident = ctx.Ident().getText();
            if (ident_Reg.containsKey(Ident) || constIdent_Val.containsKey(Ident)
                    || !Main.declaredFunc.containsKey(Ident))
                System.exit(1);
            String retType = Main.declaredFunc.get(Ident);
            StringBuilder sbIR = new StringBuilder();
            StringBuilder sbdecl = new StringBuilder();
            sbdecl.append("declare ").append(retType).append(" @").append(Ident).append("(");
            sbIR.append("\t");
            if (!retType.equals("void")) {
                int thisReg = currentReg++;
                reg_Type.put(thisReg, retType);
                attr_Val.put("thisReg", thisReg);
                sbIR.append("%x").append(thisReg).append(" = ");
            }
            sbIR.append("call ").append(retType).append(" @").append(Ident).append("(");
            int i = ctx.exp().size() - 1;
            for (P4Parser.ExpContext exp : ctx.exp()) {
                visit(exp);
                sbdecl.append("i32");
                if (node_Attr_Val.get(exp).containsKey("thisReg")) {
                    sbIR.append("i32 %x").append(node_Attr_Val.get(exp).get("thisReg"));
                } else if (node_Attr_Val.get(exp).containsKey("numberVal")) {
                    sbIR.append("i32 ").append(node_Attr_Val.get(exp).get("numberVal"));
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
        } else if (ctx.primaryExp() != null) { // primaryExp | ADD unaryExp
            visit(ctx.primaryExp());
            if (node_Attr_Val.get(ctx.primaryExp()).containsKey("lValReg")) {
                Integer lValReg = (Integer) node_Attr_Val.get(ctx.primaryExp()).get("lValReg");
                attr_Val.put("thisReg", lValReg);
            } else if (node_Attr_Val.get(ctx.primaryExp()).containsKey("expReg")) {
                Integer expReg = (Integer) node_Attr_Val.get(ctx.primaryExp()).get("expReg");
                attr_Val.put("thisReg", expReg);
            } else if (node_Attr_Val.get(ctx.primaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.primaryExp()).get("numberVal"));
            }
        } else if (ctx.ADD() != null) { // ADD unaryExp
            visit(ctx.unaryExp());
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.unaryExp()).get("numberVal"));
            } else {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.unaryExp()).get("thisReg"));
            }
        } else if (ctx.SUB() != null) { // SUB unaryExp
            visit(ctx.unaryExp());
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                Long numberVal = (Long) node_Attr_Val.get(ctx.unaryExp()).get("numberVal");
                attr_Val.put("numberVal", numberVal * -1);
            } else {
                Integer unaryExpReg = (Integer) node_Attr_Val.get(ctx.unaryExp()).get("thisReg");
                String unaryExpType = reg_Type.get(unaryExpReg);
                int thisReg = currentReg++;
                reg_Type.put(thisReg, "i32");
                attr_Val.put("thisReg", thisReg);
                IR_List.add("\t%x" + thisReg + " = sub nsw " + unaryExpType + " 0" + ", %x" + unaryExpReg + "\n");
            }
        } else if (ctx.NOT() != null) {
            visit(ctx.unaryExp());
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.unaryExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                // TODO: Type i1 and i32
                int cmpReg = currentReg++;
                reg_Type.put(cmpReg, "i1");
                Integer unaryExpReg = (Integer) node_Attr_Val.get(ctx.unaryExp()).get("thisReg");
                IR_List.add("\t%x" + cmpReg + " = icmp eq i1 %x" + unaryExpReg + ", 0\n");
                int thisReg = currentReg++;
                reg_Type.put(thisReg, "i32");
                attr_Val.put("thisReg", thisReg);
                IR_List.add("\t%x" + thisReg + " = zext i1 %x" + cmpReg + " to i32\n");
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitUnaryExp" + " Fin");
        return null;
    }

    @Override
    // primaryExp:LParser exp RParser|lVal|number;
    public Void visitPrimaryExp(P4Parser.PrimaryExpContext ctx) {
        // System.out.println(";visitPrimaryExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        if (ctx.number() != null) { // number
            visit(ctx.number());
            attr_Val.put("numberVal", node_Attr_Val.get(ctx.number()).get("nodeVal"));
            node_Attr_Val.put(ctx, attr_Val);
        } else if (ctx.exp() != null) { // LParser exp RParser
            visit(ctx.exp());
            attr_Val.put("expReg", node_Attr_Val.get(ctx.exp()).get("thisReg"));
        } else if (ctx.lVal() != null) {
            visit(ctx.lVal());
            if (node_Attr_Val.get(ctx.lVal()).containsKey("thisReg")) {
                attr_Val.put("lValReg", node_Attr_Val.get(ctx.lVal()).get("thisReg"));
            } else if (node_Attr_Val.get(ctx.lVal()).containsKey("nodeVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.lVal()).get("nodeVal"));
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitPrimaryExp" + " Fin");
        return null;
    }

    @Override
    // cond:lOrExp
    public Void visitCond(P4Parser.CondContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        visit(ctx.lOrExp());
        if (node_Attr_Val.get(ctx.lOrExp()).containsKey("numberVal")) {
            Integer numberVal = (Integer) node_Attr_Val.get(ctx.lOrExp()).get("numberVal");
        } else if (node_Attr_Val.get(ctx.lOrExp()).containsKey("thisReg")) {
            Integer lOrExpReg = (Integer) node_Attr_Val.get(ctx.lOrExp()).get("thisReg");
            if(reg_Type.get(lOrExpReg).equals("i32")){
                int thisReg = currentReg++;
                reg_Type.put(thisReg, "i1");
                int trueLabel = currentReg++;
                reg_Type.put(trueLabel, "i32");
                int falseLabel = currentReg++;
                reg_Type.put(falseLabel, "i32");
                IR_List.add("\t%x" + thisReg + " = icmp ne i1 %x" + lOrExpReg + ", 0\n");
                IR_List.add("\tbr i1 %x" + thisReg + ", label %x" + trueLabel + ", label %x" + falseLabel + "\n");
                attr_Val.put("TLabel", trueLabel);
                attr_Val.put("FLabel", falseLabel);
            }else if(reg_Type.get(lOrExpReg).equals("i1")){
                int trueLabel = currentReg++;
                reg_Type.put(trueLabel, "i32");
                int falseLabel = currentReg++;
                reg_Type.put(falseLabel, "i32");
                IR_List.add("\tbr i1 %x" + lOrExpReg + ", label %x" + trueLabel + ", label %x" + falseLabel + "\n");
                attr_Val.put("TLabel", trueLabel);
                attr_Val.put("FLabel", falseLabel);
            }
        } else if (node_Attr_Val.get(ctx.lOrExp()).containsKey("TLabel") && node_Attr_Val.get(ctx.lOrExp()).containsKey("FLabel")) {
            attr_Val.put("TLabel", node_Attr_Val.get(ctx.lOrExp()).get("TLabel"));
            attr_Val.put("FLabel", node_Attr_Val.get(ctx.lOrExp()).get("FLabel"));
        }
        node_Attr_Val.put(ctx, attr_Val);
        return null;
    }

    @Override
    // relExp:addExp |relExp ( LT_KW | GT_KW | LE_KW | GE_KW ) addExp
    public Void visitRelExp(P4Parser.RelExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        String bType = "i32";
        attr_Val.put("bType", bType);
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { // addExp
            visit(ctx.addExp());
            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.addExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.addExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // relExp ( LT_KW | GT_KW | LE_KW | GE_KW ) addExp
            Long relExpVal = 0L, addExpVal = 0L;
            Integer relExpReg = 0, addExpReg = 0;

            visit(ctx.relExp());
            if (node_Attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                relExpVal = (Long) node_Attr_Val.get(ctx.relExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                relExpReg = (Integer) node_Attr_Val.get(ctx.relExp()).get("thisReg");
            }
            visit(ctx.addExp());
            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                addExpVal = (Long) node_Attr_Val.get(ctx.addExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                addExpReg = (Integer) node_Attr_Val.get(ctx.addExp()).get("thisReg");
            }

            Integer thisReg = currentReg++;
            reg_Type.put(thisReg, "i32");
            attr_Val.put("thisReg", thisReg);
            StringBuilder sb = new StringBuilder();
            sb.append("\t%x").append(thisReg).append(" = icmp ");
            if (ctx.LT_KW() != null) {
                sb.append("slt i32 ");
            } else if (ctx.GT_KW() != null) {
                sb.append("sgt i32 ");
            } else if (ctx.LE_KW() != null) {
                sb.append("sle i32 ");
            } else if (ctx.GE_KW() != null) {
                sb.append("sge i32 ");
            }
            if (node_Attr_Val.get(ctx.relExp()).containsKey("numberVal")
                    && node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                sb.append(relExpVal);
                sb.append(", ");
                sb.append(addExpVal);
            } else if (node_Attr_Val.get(ctx.relExp()).containsKey("numberVal")
                    && node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                sb.append(relExpVal);
                sb.append(", %x").append(addExpReg);
            } else if (node_Attr_Val.get(ctx.relExp()).containsKey("thisReg")
                    && node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                sb.append("%x").append(relExpReg);
                sb.append(", ").append(addExpVal);
            } else if (node_Attr_Val.get(ctx.relExp()).containsKey("thisReg")
                    && node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                sb.append("%x").append(relExpReg);
                sb.append(", %x").append(addExpReg);
            }
            sb.append("\n");
            IR_List.add(String.valueOf(sb));
        }
        node_Attr_Val.put(ctx, attr_Val);
        // System.out.println(";visitRelExp" + " Fin");
        return null;
    }

    @Override
    // eqExp:relExp | eqExp (EQ_KW | NEQ_KW) relExp
    public Void visitEqExp(P4Parser.EqExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        String bType = "i32";
        attr_Val.put("bType", bType);
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { // relExp
            visit(ctx.relExp());
            if (node_Attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.relExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.relExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { // eqExp (EQ_KW | NEQ_KW) relExp
            Long eqExpVal = 0L, relExpVal = 0L;
            Integer eqExpReg = 0, relExpReg = 0;

            visit(ctx.eqExp());
            if (node_Attr_Val.get(ctx.eqExp()).containsKey("numberVal")) {
                eqExpVal = (Long) node_Attr_Val.get(ctx.eqExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.eqExp()).containsKey("thisReg")) {
                eqExpReg = (Integer) node_Attr_Val.get(ctx.eqExp()).get("thisReg");
            }
            visit(ctx.relExp());
            // String unaryExpType = "i32";
            if (node_Attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                relExpVal = (Long) node_Attr_Val.get(ctx.relExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                relExpReg = (Integer) node_Attr_Val.get(ctx.relExp()).get("thisReg");
            }

            Integer thisReg = currentReg++;
            reg_Type.put(thisReg, "i32");
            attr_Val.put("thisReg", thisReg);
            StringBuilder sb = new StringBuilder();
            sb.append("\t%x").append(thisReg).append(" = icmp ");
            if (ctx.EQ_KW() != null) {
                sb.append("eq i32 ");
            } else if (ctx.NEQ_KW() != null) {
                sb.append("neq i32 ");
            }
            if (node_Attr_Val.get(ctx.eqExp()).containsKey("numberVal")
                    && node_Attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                sb.append(eqExpVal);
                sb.append(", ");
                sb.append(relExpVal);
            } else if (node_Attr_Val.get(ctx.eqExp()).containsKey("numberVal")
                    && node_Attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                sb.append(eqExpVal);
                sb.append(", %x").append(relExpReg);
            } else if (node_Attr_Val.get(ctx.eqExp()).containsKey("thisReg")
                    && node_Attr_Val.get(ctx.relExp()).containsKey("numberVal")) {
                sb.append("%x").append(eqExpReg);
                sb.append(", ").append(relExpVal);
            } else if (node_Attr_Val.get(ctx.eqExp()).containsKey("thisReg")
                    && node_Attr_Val.get(ctx.relExp()).containsKey("thisReg")) {
                sb.append("%x").append(eqExpReg);
                sb.append(", %x").append(relExpReg);
            }
            sb.append("\n");
            IR_List.add(String.valueOf(sb));
        }
        node_Attr_Val.put(ctx, attr_Val);
        return null;
    }

    @Override
    // lAndExp:eqExp | lAndExp LAND_KW eqExp
    public Void visitLAndExp(P4Parser.LAndExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        String bType = "i32";
        attr_Val.put("bType", bType);
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.LAND_KW() == null) { // eqExp
            visit(ctx.eqExp());
            if (node_Attr_Val.get(ctx.eqExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.eqExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.eqExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.eqExp()).get("thisReg"));
            }
        } else { // lAndExp LAND_KW eqExp
            int lAndTrueLabel = 0, falseLabel = 0, trueLabel = 0;
            Integer lAndExpReg = null, eqExpReg = null;
            visit(ctx.lAndExp());
            if (node_Attr_Val.get(ctx.lAndExp()).containsKey("thisReg")) {
                lAndTrueLabel = currentReg++;
                reg_Type.put(lAndTrueLabel, "i32");
                lAndExpReg = (Integer) node_Attr_Val.get(ctx.lAndExp()).get("thisReg");
            }
            visit(ctx.eqExp());
            if (node_Attr_Val.get(ctx.eqExp()).containsKey("thisReg")) {
                trueLabel = currentReg++;
                reg_Type.put(trueLabel, "i32");
                eqExpReg = (Integer) node_Attr_Val.get(ctx.lAndExp()).get("thisReg");
                falseLabel = currentReg++;
                reg_Type.put(falseLabel, "i32");
            }
            // TODO:??
            IR_List.add("\tbr i1 %x" + lAndExpReg + ", label %x" + lAndTrueLabel + ", label %x" + falseLabel + "\n");
            IR_List.add("\nx" + lAndTrueLabel + ":\n");
            IR_List.add("\tbr i1 %x" + eqExpReg + ", label %x" + trueLabel + ", label %x" + falseLabel + "\n");
            attr_Val.put("TLabel", trueLabel);
            attr_Val.put("FLabel", falseLabel);
        }
        node_Attr_Val.put(ctx, attr_Val);
        return null;
    }

    @Override
    // lOrExp:lAndExp | lOrExp LOR_KW lAndExp
    public Void visitLOrExp(P4Parser.LOrExpContext ctx) {
        HashMap<String, Object> attr_Val = new HashMap<>();
        String bType = "i32";
        attr_Val.put("bType", bType);
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.LOR_KW() == null) { // lAndExp
            visit(ctx.lAndExp());
            if (node_Attr_Val.get(ctx.lAndExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.lAndExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.lAndExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.lAndExp()).get("thisReg"));
            } else if (node_Attr_Val.get(ctx.lAndExp()).containsKey("TLabel") && node_Attr_Val.get(ctx.lAndExp()).containsKey("FLabel")) {
                attr_Val.put("TLabel", node_Attr_Val.get(ctx.lAndExp()).get("TLabel"));
                attr_Val.put("FLabel", node_Attr_Val.get(ctx.lAndExp()).get("FLabel"));
            }
        } else { // lOrExp LAND_KW lAndExp
            int lOrFalseLabel = 0, trueLabel = 0, falseLabel = 0;
            Integer lOrExpReg = null, lAndExpReg = null;
            visit(ctx.lOrExp());
            if (node_Attr_Val.get(ctx.lOrExp()).containsKey("thisReg")) {
                trueLabel = currentReg++;
                reg_Type.put(trueLabel, "i32");
                lOrExpReg = (Integer) node_Attr_Val.get(ctx.lOrExp()).get("thisReg");
                lOrFalseLabel = currentReg++;
                reg_Type.put(lOrFalseLabel, "i32");
            }
            visit(ctx.lAndExp());
            if (node_Attr_Val.get(ctx.lAndExp()).containsKey("thisReg")) {
                lAndExpReg = (Integer) node_Attr_Val.get(ctx.lOrExp()).get("thisReg");
                falseLabel = currentReg++;
                reg_Type.put(falseLabel, "i32");
            }
            IR_List.add("\tbr i1 %x" + lOrExpReg + ", label %x" + trueLabel + ", label %x" + lOrFalseLabel + "\n");
            IR_List.add("\nx" + lOrFalseLabel + ":\n");
            IR_List.add("\tbr i1 %x" + lAndExpReg + ", label %x" + trueLabel + ", label %x" + falseLabel + "\n");
            attr_Val.put("TLabel", trueLabel);
            attr_Val.put("FLabel", falseLabel);
        }
        node_Attr_Val.put(ctx, attr_Val);
        return null;
    }
}