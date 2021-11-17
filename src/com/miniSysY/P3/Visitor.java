package com.miniSysY.P3;

import org.antlr.v4.runtime.tree.RuleNode;

import java.util.HashMap;

public class Visitor extends P3BaseVisitor<Void> {
    Integer currentReg = 0;
    HashMap<RuleNode, HashMap<String, Object>> node_Attr_Val = new HashMap<>(); //保存树上结点的各种属性
    HashMap<String, Integer> ident_Reg = new HashMap<>();    //变量名到寄存器的映射
    HashMap<Integer, String> identReg_Type = new HashMap<>();    //变量名到寄存器的映射
    HashMap<Integer, Integer> constReg_Val = new HashMap<>();//常量寄存器值表

    @Override
//    blockItem:decl|stmt;
    public Void visitBlockItem(P3Parser.BlockItemContext ctx) {
        //System.out.println(";visitBlockItem");
        HashMap<String, Object> attr_val = new HashMap<>();
        if (ctx.stmt() != null) {
            attr_val.put("type", "stmt");
            visit(ctx.stmt());
        } else if (ctx.decl() != null) {
            attr_val.put("type", "decl");
            visit(ctx.decl());
        }
        node_Attr_Val.put(ctx, attr_val);
        //System.out.println(";visitBlockItem" + " Fin");
        return null;
    }

    @Override
//    lVal:Ident;
    public Void visitLVal(P3Parser.LValContext ctx) {
        //System.out.println(";visitLVal");
        HashMap<String, Object> attr_val = new HashMap<>();
        if (ident_Reg.containsKey(ctx.Ident().getText())) {
            Integer thisReg = ident_Reg.get(ctx.Ident().getText());
            attr_val.put("thisReg", thisReg);
        } else {
            System.exit(1);
        }
        node_Attr_Val.put(ctx, attr_val);
        //System.out.println(";visitLVal" + " Fin");
        return null;
    }

    @Override
//    decl:constDecl|varDecl;
    public Void visitDecl(P3Parser.DeclContext ctx) {
        //System.out.println(";visitDecl");
        //System.out.println(";visitDecl" + " Fin");
        return super.visitDecl(ctx);
    }

    @Override
//    constDecl:CONST_KW bType constDef (',' constDef)* Semicolumn;
    public Void visitConstDecl(P3Parser.ConstDeclContext ctx) {
        //System.out.println(";visitVarDecl");
        HashMap<String, Object> attr_val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_val);
        visit(ctx.bType());
        String constInitValType = (String) attr_val.get("bType");
        for (P3Parser.ConstDefContext cdf : ctx.constDef()) {
            if (ident_Reg.containsKey(cdf.Ident().getText())) {
                System.exit(1);
            }
            if (cdf.ASSIGN().getText().equals("=")) {
                visit(cdf);
                int thisReg = currentReg++;
                identReg_Type.put(thisReg, constInitValType);
                ident_Reg.put(cdf.Ident().getText(), thisReg);
                System.out.println("\t%x" + thisReg + " = alloca " + constInitValType + ", align 4");
                Integer constInitValReg = (Integer) node_Attr_Val.get(cdf).get("constInitValReg");
                System.out.println("\tstore " + constInitValType + " %x" + constInitValReg + ", " + constInitValType + "* %x" + thisReg + ", align 4");
            }
        }

        node_Attr_Val.put(ctx, attr_val);
        //System.out.println(";visitVarDecl" + " Fin");
        return null;
    }

    @Override
//    bType:INT_KW;
    public Void visitBType(P3Parser.BTypeContext ctx) {
        //System.out.println(";visitBType");
        if (ctx.INT_KW() != null) {
            node_Attr_Val.get(ctx.parent).put("bType", "i32");
        }
        //System.out.println(";visitBType" + " Fin");
        return null;
    }

    @Override
//    constDef:Ident ASSIGN constInitVal;
    public Void visitConstDef(P3Parser.ConstDefContext ctx) {
        //System.out.println(";visitConstDef");
        HashMap<String, Object> attr_val = new HashMap<>();
        if (ctx.ASSIGN() != null) {
            if (ctx.ASSIGN().getText().equals("=")) {
                visit(ctx.constInitVal());
                attr_val.put("constInitValReg", node_Attr_Val.get(ctx.constInitVal()).get("thisReg"));
            }
        }
        node_Attr_Val.put(ctx, attr_val);
        //System.out.println(";visitConstDef" + " Fin");
        return null;
    }

    @Override
//    constInitVal:constExp;
    public Void visitConstInitVal(P3Parser.ConstInitValContext ctx) {
        //System.out.println(";visitConstInitVal");
        HashMap<String, Object> attr_val = new HashMap<>();
        visit(ctx.constExp());
        attr_val.put("thisReg", node_Attr_Val.get(ctx.constExp()).get("thisReg"));
        node_Attr_Val.put(ctx, attr_val);
        return null;
        //System.out.println(";visitConstInitVal" + " Fin");
    }

    @Override
//    constExp:addExp;
    public Void visitConstExp(P3Parser.ConstExpContext ctx) {
        //System.out.println(";visitConstExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
//        attr_Val.put("bType", node_Attr_Val.get(ctx.parent).get("bType"));
        visit(ctx.addExp());
        attr_Val.put("thisReg", node_Attr_Val.get(ctx.addExp()).get("thisReg"));
        node_Attr_Val.put(ctx, attr_Val);
        return null;
        //System.out.println(";visitConstExp" + " Fin");
    }

    @Override
//    varDecl:bType varDef (',' varDef)* Semicolumn;
    public Void visitVarDecl(P3Parser.VarDeclContext ctx) {
        //System.out.println(";visitVarDecl");
        HashMap<String, Object> attr_val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_val);
        visit(ctx.bType());
        String initValType = (String) attr_val.get("bType");
        for (P3Parser.VarDefContext vdf : ctx.varDef()) {
            int thisReg = currentReg++;
            if (ident_Reg.containsKey(vdf.Ident().getText())) {
                System.exit(1);
            }
            identReg_Type.put(thisReg, initValType);
            System.out.println("\t%x" + thisReg + " = alloca " + initValType + ", align 4");
            ident_Reg.put(vdf.Ident().getText(), thisReg);
            if (vdf.ASSIGN() != null) {
                if (vdf.ASSIGN().getText().equals("=")) {
                    visit(vdf);
                    Integer initValReg = (Integer) node_Attr_Val.get(vdf).get("initValReg");
                    System.out.println("\tstore " + initValType + " %x" + initValReg + ", " + initValType + "* %x" + thisReg + ", align 4");
                }
            }
        }
        node_Attr_Val.put(ctx, attr_val);
        //System.out.println(";visitVarDecl" + " Fin");
        return null;
    }

    @Override
//    varDef:Ident|Ident ASSIGN initVal;
    public Void visitVarDef(P3Parser.VarDefContext ctx) {
        //System.out.println(";visitVarDef");
        HashMap<String, Object> attr_val = new HashMap<>();
//        int thisReg = currentReg++;
        if (ctx.ASSIGN() != null) {
            if (ctx.ASSIGN().getText().equals("=")) {
                visit(ctx.initVal());
                attr_val.put("initValReg", node_Attr_Val.get(ctx.initVal()).get("thisReg"));
            }
        }
        node_Attr_Val.put(ctx, attr_val);
        //System.out.println(";visitVarDef" + " Fin");
        return null;
    }

    @Override
//    initVal:exp;
    public Void visitInitVal(P3Parser.InitValContext ctx) {
        //System.out.println(";visitInitVal");
        HashMap<String, Object> attr_val = new HashMap<>();
        visit(ctx.exp());
        attr_val.put("thisReg", node_Attr_Val.get(ctx.exp()).get("thisReg"));
        node_Attr_Val.put(ctx, attr_val);
        //System.out.println(";visitInitVal" + " Fin");
        return null;
    }

    @Override
//    compUnit:funcDef;
    public Void visitCompUnit(P3Parser.CompUnitContext ctx) {
        //System.out.println(";visitCompUnit");
        visit(ctx.funcDef());
        //System.out.println(";visitCompUnit" + " Fin");
        return null;
    }

    @Override
//    funcType:INT_KW;
    public Void visitFuncType(P3Parser.FuncTypeContext ctx) {
        //System.out.println(";visitFuncType");
        HashMap<String, Object> node_Attr = new HashMap<>();
        if (ctx.INT_KW().getText().equals("int"))
            node_Attr.put("funcType", "i32");
        node_Attr_Val.put(ctx, node_Attr);
        //System.out.println(";visitFuncType" + " Fin");
        return null;
    }

    @Override
//    funcIdent:FuncIdent;
    public Void visitFuncIdent(P3Parser.FuncIdentContext ctx) {
        //System.out.println(";visitFuncIdent");
        HashMap<String, Object> attr_val = new HashMap<>();
        attr_val.put("funcIdent", ctx.FuncIdent().getText());
        node_Attr_Val.put(ctx, attr_val);
//        System.out.print('@' + ctx.FuncIdent().getText());
        //System.out.println(";visitFuncIdent" + " Fin");
        return null;
    }

    @Override
//    funcDef:funcType funcIdent LParser RParser block;
    public Void visitFuncDef(P3Parser.FuncDefContext ctx) {
        //System.out.println(";visitFuncDef");
        System.out.print("define dso_local ");
        visit(ctx.funcType());
        System.out.print(node_Attr_Val.get(ctx.funcType()).get("funcType") + " ");
        visit(ctx.funcIdent());
        System.out.print("@" + node_Attr_Val.get(ctx.funcIdent()).get("funcIdent") + " ");
        System.out.print("()");
        visit(ctx.block());
        //System.out.println(";visitFuncDef" + " Fin");
        return null;
    }

    @Override
//    block:LBrace (blockItem)* RBrace;
    public Void visitBlock(P3Parser.BlockContext ctx) {
        //System.out.println(";visitBlock");
        System.out.println("{");
        for (P3Parser.BlockItemContext bi : ctx.blockItem()) {
            visit(bi);
        }
        System.out.println("}");
        //System.out.println(";visitBlock" + " Fin");
        return null;
    }

    @Override
//    stmt:lVal ASSIGN exp Semicolumn|(exp)+ Semicolumn|reteurnStmt;
    public Void visitStmt(P3Parser.StmtContext ctx) {
        //System.out.println(";visitStmt");
        if (ctx.reteurnStmt() != null) {
            visit(ctx.reteurnStmt());
        } else if (ctx.ASSIGN() != null) {
            if (ctx.ASSIGN().getText().equals("=")) {
                if (ident_Reg.get(ctx.lVal().Ident().getText()) == null) {
                    System.exit(1);
                }
                Integer identReg = ident_Reg.get(ctx.lVal().Ident().getText());
                String identType = identReg_Type.get(identReg);
//                String identType = "i32";
                visit(ctx.exp(0));
                Integer expReg = (Integer) node_Attr_Val.get(ctx.exp(0)).get("thisReg");
                System.out.println("\tstore " + identType + " %x" + expReg + ", " + identType + "* %x" + identReg + ", align 4");
            }
        }
        //System.out.println(";visitStmt" + " Fin");
        return null;
    }

    @Override
//    number:intConst;
    public Void visitNumber(P3Parser.NumberContext ctx) {
        //System.out.println(";visitNumber");
        HashMap<String, Object> attr_Val = new HashMap<>();
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.intConst() != null) {
            visit(ctx.intConst());
            attr_Val.put("nodeVal", node_Attr_Val.get(ctx.intConst()).get("nodeVal"));
            node_Attr_Val.put(ctx, attr_Val);
        }
        //System.out.println(";visitNumber" + " Fin");
        return null;
    }

    @Override
//    intConst:DecimalConst|OctalConst|HexadecimalConst;
    public Void visitIntConst(P3Parser.IntConstContext ctx) {
        //System.out.println(";visitIntConst");
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
//        System.out.println("RES:"+res);
        if (res <= 2147483647L && res >= 0L) {
//            System.out.print(" "+res);
            attr_Val.put("nodeVal", res);
        }
        //TODO: else?
        node_Attr_Val.put(ctx, attr_Val);
        //System.out.println(";visitIntConst" + " Fin");
        return null;
    }

    @Override
//    reteurnStmt:RETURN_KW exp Semicolumn;
    public Void visitReteurnStmt(P3Parser.ReteurnStmtContext ctx) {
        //System.out.println(";visitReteurnStmt");
        visit(ctx.exp());
        Integer expReg = (Integer) node_Attr_Val.get(ctx.exp()).get("thisReg");
        String expType = "i32";
        Integer thisReg = currentReg++;
        System.out.println("\t%x" + thisReg + " = load " + expType + ", " + expType + "* %x" + expReg + ", align 4");
        System.out.println("\tret i32 %x" + thisReg);
        //System.out.println(";visitReteurnStmt" + " Fin");
        return null;
    }

    @Override
//    exp:addExp;
    public Void visitExp(P3Parser.ExpContext ctx) {
        //System.out.println(";visitExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
//        attr_Val.put("bType", node_Attr_Val.get(ctx.parent).get("bType"));
        visit(ctx.addExp());
        String expType = "i32";
        if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
            attr_Val.put("thisReg", node_Attr_Val.get(ctx.addExp()).get("thisReg"));
        } else if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
            Integer thisReg = currentReg++;
            System.out.println("\tstore " + expType +" "+ node_Attr_Val.get(ctx.addExp()).get("numberVal") + ", " + expType + "* %x" + thisReg + ", align 4");
            attr_Val.put("thisReg", thisReg);
        }
        node_Attr_Val.put(ctx, attr_Val);
        //System.out.println(";visitExp" + " Fin");
        return null;
    }

    @Override
//    addExp:mulExp|addExp ( ADD | SUB ) mulExp;
    public Void visitAddExp(P3Parser.AddExpContext ctx) {
        //System.out.println(";visitAddExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        String bType = "i32";
        attr_Val.put("bType", bType);
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { //mulExp
            visit(ctx.mulExp());
            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.mulExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.mulExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { //addExp ( ADD | SUB ) mulExp;
            Long addExpVal = 0L, mulExpVal = 0L;
            Integer addExpReg = 0, mulExpReg = 0;
            int tmpMulExpReg = 0, tmpAddExpReg = 0;

            visit(ctx.addExp());
            String addExpType = "i32";
            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
                addExpVal = (Long) node_Attr_Val.get(ctx.addExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
                addExpReg = (Integer) node_Attr_Val.get(ctx.addExp()).get("thisReg");
                tmpAddExpReg = currentReg++;
                System.out.println("\t%x" + tmpAddExpReg + " = load " + addExpType + ", " + addExpType + "* %x" + addExpReg + ", align 4");
            }

            visit(ctx.mulExp());
            String mulExpType = "i32";
            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                mulExpVal = (Long) node_Attr_Val.get(ctx.mulExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                mulExpReg = (Integer) node_Attr_Val.get(ctx.mulExp()).get("thisReg");
                tmpMulExpReg = currentReg++;
                System.out.println("\t%x" + tmpMulExpReg + " = load " + mulExpType + ", " + mulExpType + "* %x" + mulExpReg + ", align 4");
            }

            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                if (ctx.ADD() != null) {
                    attr_Val.put("numberVal", addExpVal + mulExpVal);
                } else if (ctx.SUB() != null) {
                    attr_Val.put("numberVal", addExpVal - mulExpVal);
                }
            } else {
                Integer thisReg = currentReg++;
                attr_Val.put("thisReg", thisReg);
                if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                    if (ctx.ADD() != null) {
                        System.out.println("\t%x" + thisReg + " = add nsw " + addExpType + addExpVal + ", %x" + tmpMulExpReg);
                    } else if (ctx.SUB() != null) {
                        System.out.println("\t%x" + thisReg + " = sub nsw " + addExpType + addExpVal + ", %x" + tmpMulExpReg);
                    }
                } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                    if (ctx.ADD() != null) {
                        System.out.println("\t%x" + thisReg + " = add nsw " + addExpType + " %x" + tmpAddExpReg + ", " + mulExpVal);
                    } else if (ctx.SUB() != null) {
                        System.out.println("\t%x" + thisReg + " = sub nsw " + addExpType + " %x" + tmpAddExpReg + ", " + mulExpVal);
                    }
                } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                    if (ctx.ADD() != null) {
                        System.out.println("\t%x" + thisReg + " = add nsw " + addExpType + " %x" + tmpAddExpReg + ", %x" + tmpMulExpReg);
                    } else if (ctx.SUB() != null) {
                        System.out.println("\t%x" + thisReg + " = sub nsw " + addExpType + " %x" + tmpAddExpReg + ", %x" + tmpMulExpReg);
                    }
                }
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        //System.out.println(";visitAddExp" + " Fin");
        return null;
    }

    @Override
//    mulExp:unaryExp|mulExp ( MUL | DIV | MOD ) unaryExp;
    public Void visitMulExp(P3Parser.MulExpContext ctx) {
        //System.out.println(";visitMulExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        String bType = "i32";
        attr_Val.put("bType", bType);
        node_Attr_Val.put(ctx, attr_Val);
        if (ctx.children.size() == 1) { //unaryExp
            visit(ctx.unaryExp());
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                attr_Val.put("numberVal", node_Attr_Val.get(ctx.unaryExp()).get("numberVal"));
            } else if (node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                attr_Val.put("thisReg", node_Attr_Val.get(ctx.unaryExp()).get("thisReg"));
            }
        } else if (ctx.children.size() == 3) { //mulExp ( MUL | DIV | MOD ) unaryExp;
            Long mulExpVal = 0L, unaryExpVal = 0L;
            Integer mulExpReg = 0, unaryExpReg = 0;
            int tmpUnaryExpReg = 0, tmpMulExpReg = 0;

            visit(ctx.mulExp());
            String mulExpType = "i32";
            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
                mulExpVal = (Long) node_Attr_Val.get(ctx.mulExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
                mulExpReg = (Integer) node_Attr_Val.get(ctx.mulExp()).get("thisReg");
                tmpMulExpReg = currentReg++;
                System.out.println("\t%x" + tmpMulExpReg + " = load " + mulExpType + ", " + mulExpType + "* %x" + mulExpReg + ", align 4");
            }

            visit(ctx.unaryExp());
            String unaryExpType = "i32";
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                unaryExpVal = (Long) node_Attr_Val.get(ctx.unaryExp()).get("numberVal");
            } else if (node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                unaryExpReg = (Integer) node_Attr_Val.get(ctx.unaryExp()).get("thisReg");
                tmpUnaryExpReg = currentReg++;
                System.out.println("\t%x" + tmpUnaryExpReg + " = load " + unaryExpType + ", " + unaryExpType + "* %x" + unaryExpReg + ", align 4");
            }

            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
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
                if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                    if (ctx.MUL() != null) {
                        System.out.println("\t%x" + thisReg + " = mul nsw " + mulExpType + mulExpVal + ", %x" + tmpUnaryExpReg);
                    } else if (ctx.DIV() != null) {
                        System.out.println("\t%x" + thisReg + " = div nsw " + mulExpType + mulExpVal + ", %x" + tmpUnaryExpReg);
                    } else if (ctx.MOD() != null) {
                        System.out.println("\t%x" + thisReg + " = srem " + mulExpType + mulExpVal + ", %x" + tmpUnaryExpReg);
                    }
                } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                    if (ctx.MUL() != null) {
                        System.out.println("\t%x" + thisReg + " = mul nsw " + mulExpType + " %x" + tmpMulExpReg + ", " + unaryExpVal);
                    } else if (ctx.DIV() != null) {
                        System.out.println("\t%x" + thisReg + " = div nsw " + mulExpType + " %x" + tmpMulExpReg + ", " + unaryExpVal);
                    } else if (ctx.MOD() != null) {
                        System.out.println("\t%x" + thisReg + " = srem " + mulExpType + " %x" + tmpMulExpReg + ", " + unaryExpVal);
                    }
                } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
                    if (ctx.MUL() != null) {
                        System.out.println("\t%x" + thisReg + " = mul nsw " + mulExpType + " %x" + tmpMulExpReg + ", %x" + tmpUnaryExpReg);
                    } else if (ctx.DIV() != null) {
                        System.out.println("\t%x" + thisReg + " = div nsw " + mulExpType + " %x" + tmpMulExpReg + ", %x" + tmpUnaryExpReg);
                    } else if (ctx.MOD() != null) {
                        System.out.println("\t%x" + thisReg + " = srem " + mulExpType + " %x" + tmpMulExpReg + ", %x" + tmpUnaryExpReg);
                    }
                }
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        //System.out.println(";visitMulExp" + " Fin");
        return null;
    }

    @Override
//    unaryExp:primaryExp|( ADD | SUB ) unaryExp;
    public Void visitUnaryExp(P3Parser.UnaryExpContext ctx) {
        //System.out.println(";visitUnaryExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        if (ctx.SUB() == null) { // primaryExp | ADD unaryExp
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
        } else { // SUB unaryExp
            visit(ctx.unaryExp());
            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
                Long numberVal = (Long) node_Attr_Val.get(ctx.unaryExp()).get("numberVal");
                attr_Val.put("numberVal", numberVal * -1);
            } else {
                String unaryExpType = "i32";
                Integer unaryExpReg = (Integer) node_Attr_Val.get(ctx.unaryExp()).get("thisReg");
                int tmpUnaryexpReg = currentReg++;
                int thisReg = currentReg++;
                attr_Val.put("thisReg", thisReg);
                System.out.println("\t%x" + tmpUnaryexpReg + " = load " + unaryExpType + ", " + unaryExpType + "* %x" + unaryExpReg + ", align 4");
                System.out.println("\t%x" + thisReg + " = sub nsw " + unaryExpType + "0" + ", %x" + tmpUnaryexpReg);
            }
        }
        node_Attr_Val.put(ctx, attr_Val);
        //System.out.println(";visitUnaryExp" + " Fin");
        return null;
    }

    @Override
//    primaryExp:LParser exp RParser|lVal|number;
    public Void visitPrimaryExp(P3Parser.PrimaryExpContext ctx) {
        //System.out.println(";visitPrimaryExp");
        HashMap<String, Object> attr_Val = new HashMap<>();
        if (ctx.number() != null) { //number
//            Integer thisReg = currentReg++;
            visit(ctx.number());
            attr_Val.put("numberVal", node_Attr_Val.get(ctx.number()).get("nodeVal"));
            node_Attr_Val.put(ctx, attr_Val);
        } else if (ctx.exp() != null) { //LParser exp RParser
            visit(ctx.exp());
            attr_Val.put("expReg", node_Attr_Val.get(ctx.exp()).get("thisReg"));
        } else if (ctx.lVal() != null) {
            visit(ctx.lVal());
            attr_Val.put("lValReg", node_Attr_Val.get(ctx.lVal()).get("thisReg"));
        }
        node_Attr_Val.put(ctx, attr_Val);
        //System.out.println(";visitPrimaryExp" + " Fin");
        return null;
    }
}
