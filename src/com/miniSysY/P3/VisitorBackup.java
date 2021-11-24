//package com.miniSysY.P3;
//
//import org.antlr.v4.runtime.tree.RuleNode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Visitor extends P3BaseVisitor<Void> {
//    Integer currentReg = 0;
//    HashMap<RuleNode, HashMap<String, Object>> node_Attr_Val = new HashMap<>(); //保存树上结点的各种属性
//    HashMap<String, Integer> ident_Reg = new HashMap<>();    //变量名到寄存器的映射
//    //    HashMap<Integer, String> identReg_Type = new HashMap<>();
//    HashMap<String, Long> constIdent_Val = new HashMap<>();//常量值表
//    ArrayList<String> functionCallList = new ArrayList<>();
//    public static ArrayList<String> IR_List = new ArrayList<>();
//
//    @Override
////    blockItem:decl|stmt;
//    public Void visitBlockItem(P3Parser.BlockItemContext ctx) {
//        //System.out.println(";visitBlockItem");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        if (ctx.stmt() != null) {
//            attr_val.put("type", "stmt");
//            visit(ctx.stmt());
//        } else if (ctx.decl() != null) {
//            attr_val.put("type", "decl");
//            visit(ctx.decl());
//        }
//        node_Attr_Val.put(ctx, attr_val);
//        //System.out.println(";visitBlockItem" + " Fin");
//        return null;
//    }
//
//    @Override
////    lVal:Ident;
//    public Void visitLVal(P3Parser.LValContext ctx) {
//        //System.out.println(";visitLVal");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        if (ident_Reg.containsKey(ctx.Ident().getText())) {
//            Integer identReg = ident_Reg.get(ctx.Ident().getText());
////            if (identReg == -1) {
////                System.out.println("使用了未赋值的变量");
////                System.exit(1);
////            } else {
//            int thisReg = currentReg++;
//            IR_List.add("\t%x" + thisReg + " = load i32, i32* %x" + identReg + "\n");
////            System.out.println("\t%x" + thisReg + " = load i32, i32* %x" + identReg);
//            attr_val.put("thisReg", thisReg);
////            }
//        } else if (constIdent_Val.containsKey(ctx.Ident().getText())) {
//            attr_val.put("nodeVal", constIdent_Val.get(ctx.Ident().getText()));
//        } else {
//            System.exit(1);
//        }
//        node_Attr_Val.put(ctx, attr_val);
//        //System.out.println(";visitLVal" + " Fin");
//        return null;
//    }
//
//    @Override
////    decl:constDecl|varDecl;
//    public Void visitDecl(P3Parser.DeclContext ctx) {
//        //System.out.println(";visitDecl");
//        //System.out.println(";visitDecl" + " Fin");
//        return super.visitDecl(ctx);
//    }
//
//    @Override
////    constDecl:CONST_KW bType constDef (',' constDef)* Semicolon;
//    public Void visitConstDecl(P3Parser.ConstDeclContext ctx) {
//        //System.out.println(";visitConstDecl");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        node_Attr_Val.put(ctx, attr_val);
//        visit(ctx.bType());
//        for (P3Parser.ConstDefContext cdf : ctx.constDef()) {
//            if (constIdent_Val.containsKey(cdf.Ident().getText()) || ident_Reg.containsKey(cdf.Ident().getText())) {
//                System.exit(1);
//            }
//            visit(cdf);
//        }
//        //System.out.println(";visitConstDecl" + " Fin");
//        return null;
//    }
//
//    @Override
////    bType:INT_KW;
//    public Void visitBType(P3Parser.BTypeContext ctx) {
//        //System.out.println(";visitBType");
//        if (ctx.INT_KW() != null) {
//            node_Attr_Val.get(ctx.parent).put("bType", "i32");
//        }
//        //System.out.println(";visitBType" + " Fin");
//        return null;
//    }
//
//    @Override
////    constDef:Ident ASSIGN constInitVal;
//    public Void visitConstDef(P3Parser.ConstDefContext ctx) {
//        //System.out.println(";visitConstDef");
////        String bType = node_Attr_Val.get(ctx.parent).get("bType");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        if (ctx.ASSIGN() != null) {
//            if (ctx.ASSIGN().getText().equals("=")) {
//                visit(ctx.constInitVal());
//                Long constExpVal = (Long) node_Attr_Val.get(ctx.constInitVal()).get("constExpVal");
//                constIdent_Val.put(ctx.Ident().getText(), constExpVal);
//            }
//        }
//        node_Attr_Val.put(ctx, attr_val);
//        //System.out.println(";visitConstDef" + " Fin");
//        return null;
//    }
//
//    @Override
////    constInitVal:constExp;
//    public Void visitConstInitVal(P3Parser.ConstInitValContext ctx) {
//        //System.out.println(";visitConstInitVal");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        visit(ctx.constExp());
//        attr_val.put("constExpVal", node_Attr_Val.get(ctx.constExp()).get("constExpVal"));
//        node_Attr_Val.put(ctx, attr_val);
//        //System.out.println(";visitConstInitVal" + " Fin");
//        return null;
//    }
//
//    @Override
////    constExp:addExp;
//    public Void visitConstExp(P3Parser.ConstExpContext ctx) {
//        //System.out.println(";visitConstExp");
//        HashMap<String, Object> attr_Val = new HashMap<>();
////        attr_Val.put("bType", node_Attr_Val.get(ctx.parent).get("bType"));
//        visit(ctx.addExp());
//        attr_Val.put("constExpVal", node_Attr_Val.get(ctx.addExp()).get("numberVal"));
//        node_Attr_Val.put(ctx, attr_Val);
//        //System.out.println(";visitConstExp" + " Fin");
//        return null;
//    }
//
//    @Override
////    varDecl:bType varDef (',' varDef)* Semicolon;
//    public Void visitVarDecl(P3Parser.VarDeclContext ctx) {
//        //System.out.println(";visitVarDecl");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        node_Attr_Val.put(ctx, attr_val);
//        visit(ctx.bType());
////        String initValType = (String) attr_val.get("bType");
//        for (P3Parser.VarDefContext vdf : ctx.varDef()) {
//            String Ident = vdf.Ident().getText();
//            if (ident_Reg.containsKey(Ident) || constIdent_Val.containsKey(Ident)) {
//                System.exit(1);
//            }
//            visit(vdf);
//        }
//        node_Attr_Val.put(ctx, attr_val);
//        //System.out.println(";visitVarDecl" + " Fin");
//        return null;
//    }
//
//    @Override
////    varDef:Ident|Ident ASSIGN initVal;
//    public Void visitVarDef(P3Parser.VarDefContext ctx) {
//        //System.out.println(";visitVarDef");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        int thisReg = currentReg++;
//        IR_List.add("\t%x" + thisReg + " = alloca i32, align 4" + "\n");
//        ident_Reg.put(ctx.Ident().getText(), thisReg);
//        if (ctx.ASSIGN() != null) {
//            if (ctx.ASSIGN().getText().equals("=")) {
//                visit(ctx.initVal());
//                if (node_Attr_Val.get(ctx.initVal()).containsKey("thisReg")) {
//                    Integer initValReg = (Integer) node_Attr_Val.get(ctx.initVal()).get("thisReg");
////                    ident_Reg.put(ctx.Ident().getText(), initValReg);
//                    IR_List.add("\tstore i32 %x" + initValReg + ", i32* %x" + thisReg + "\n");
//                } else if (node_Attr_Val.get(ctx.initVal()).containsKey("numberVal")) {
//                    Long numVal = (Long) node_Attr_Val.get(ctx.initVal()).get("numberVal");
//                    IR_List.add("\tstore i32 " + numVal + ", i32* %x" + thisReg + "\n");
//                }
////                attr_val.put("initValReg", node_Attr_Val.get(ctx.initVal()).get("thisReg"));
//            }
//        }
//        node_Attr_Val.put(ctx, attr_val);
//        //System.out.println(";visitVarDef" + " Fin");
//        return null;
//    }
//
//    @Override
////    initVal:exp;
//    public Void visitInitVal(P3Parser.InitValContext ctx) {
//        //System.out.println(";visitInitVal");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        visit(ctx.exp());
//        if (node_Attr_Val.get(ctx.exp()).containsKey("thisReg")) {
//            attr_val.put("thisReg", node_Attr_Val.get(ctx.exp()).get("thisReg"));
//        } else if (node_Attr_Val.get(ctx.exp()).containsKey("numberVal")) {
//            attr_val.put("numberVal", node_Attr_Val.get(ctx.exp()).get("numberVal"));
//        }
//        node_Attr_Val.put(ctx, attr_val);
//        //System.out.println(";visitInitVal" + " Fin");
//        return null;
//    }
//
//    @Override
////    compUnit:funcDef;
//    public Void visitCompUnit(P3Parser.CompUnitContext ctx) {
//        //System.out.println(";visitCompUnit");
//        visit(ctx.funcDef());
//        //System.out.println(";visitCompUnit" + " Fin");
//        return null;
//    }
//
//    @Override
////    funcType:INT_KW;
//    public Void visitFuncType(P3Parser.FuncTypeContext ctx) {
//        //System.out.println(";visitFuncType");
//        HashMap<String, Object> node_Attr = new HashMap<>();
//        if (ctx.INT_KW().getText().equals("int"))
//            node_Attr.put("funcType", "i32");
//        node_Attr_Val.put(ctx, node_Attr);
//        //System.out.println(";visitFuncType" + " Fin");
//        return null;
//    }
//
//    @Override
////    funcIdent:FuncIdent;
//    public Void visitFuncIdent(P3Parser.FuncIdentContext ctx) {
//        //System.out.println(";visitFuncIdent");
//        HashMap<String, Object> attr_val = new HashMap<>();
//        attr_val.put("funcIdent", ctx.FuncIdent().getText());
//        node_Attr_Val.put(ctx, attr_val);
////        System.out.print('@' + ctx.FuncIdent().getText());
//        //System.out.println(";visitFuncIdent" + " Fin");
//        return null;
//    }
//
//    @Override
////    funcDef:funcType funcIdent LParser RParser block;
//    public Void visitFuncDef(P3Parser.FuncDefContext ctx) {
//        //System.out.println(";visitFuncDef");
//        visit(ctx.funcType());
//        visit(ctx.funcIdent());
//        IR_List.add("define dso_local " + node_Attr_Val.get(ctx.funcType()).get("funcType") + " " + "@" + node_Attr_Val.get(ctx.funcIdent()).get("funcIdent") + " ()");
//        visit(ctx.block());
//        //System.out.println(";visitFuncDef" + " Fin");
//        return null;
//    }
//
//    @Override
////    block:LBrace (blockItem)* RBrace;
//    public Void visitBlock(P3Parser.BlockContext ctx) {
//        //System.out.println(";visitBlock");
//        IR_List.add("{" + "\n");
//        for (P3Parser.BlockItemContext bi : ctx.blockItem()) {
//            visit(bi);
//        }
//        IR_List.add("}");
//        //System.out.println(";visitBlock" + " Fin");
//        return null;
//    }
//
//    @Override
////    stmt:lVal ASSIGN exp Semicolon|(exp)+ Semicolon|returnStmt;
//    public Void visitStmt(P3Parser.StmtContext ctx) {
//        //System.out.println(";visitStmt");
//        if (ctx.returnStmt() != null) {
//            visit(ctx.returnStmt());
//        } else if (ctx.ASSIGN() != null) {
//            if (ctx.ASSIGN().getText().equals("=")) {
//                String Ident = ctx.lVal().Ident().getText();
//                Integer identReg = ident_Reg.get(Ident);
//                if (!ident_Reg.containsKey(Ident) || constIdent_Val.containsKey(Ident)) {
//                    System.exit(1);
//                }
//                visit(ctx.exp(0));
//                if (node_Attr_Val.get(ctx.exp(0)).containsKey("thisReg")) {
//                    Integer expReg = (Integer) node_Attr_Val.get(ctx.exp(0)).get("thisReg");
//                    IR_List.add("\tstore i32 %x" + expReg + ", i32* %x" + identReg + "\n");
//                } else if (node_Attr_Val.get(ctx.exp(0)).containsKey("numberVal")) {
//                    IR_List.add("\tstore i32 " + node_Attr_Val.get(ctx.exp(0)).get("numberVal") + ", i32* %x" + identReg + "\n");
//                }
//            }
//        }
//        //System.out.println(";visitStmt" + " Fin");
//        return null;
//    }
//
//    @Override
////    number:intConst;
//    public Void visitNumber(P3Parser.NumberContext ctx) {
//        //System.out.println(";visitNumber");
//        HashMap<String, Object> attr_Val = new HashMap<>();
//        node_Attr_Val.put(ctx, attr_Val);
//        if (ctx.intConst() != null) {
//            visit(ctx.intConst());
//            attr_Val.put("nodeVal", node_Attr_Val.get(ctx.intConst()).get("nodeVal"));
//            node_Attr_Val.put(ctx, attr_Val);
//        }
//        //System.out.println(";visitNumber" + " Fin");
//        return null;
//    }
//
//    @Override
////    intConst:DecimalConst|OctalConst|HexadecimalConst;
//    public Void visitIntConst(P3Parser.IntConstContext ctx) {
//        //System.out.println(";visitIntConst");
//        HashMap<String, Object> attr_Val = new HashMap<>();
//        long res = 0L;
//        if (ctx.HexadecimalConst() != null) {
//            String hex = ctx.HexadecimalConst().getText().toLowerCase().substring(2);
//            res = Long.parseLong(hex, 16);
//        } else if (ctx.OctalConst() != null) {
//            String oct = ctx.OctalConst().getText();
//            res = Long.parseLong(oct, 8);
//        } else if (ctx.DecimalConst() != null) {
//            String dec = ctx.DecimalConst().getText();
//            res = Long.parseLong(dec, 10);
//        }
//        if (res <= 2147483647L && res >= 0L) {
//            attr_Val.put("nodeVal", res);
//        }
//        //TODO: else?
//        node_Attr_Val.put(ctx, attr_Val);
//        //System.out.println(";visitIntConst" + " Fin");
//        return null;
//    }
//
//    @Override
////    returnStmt:RETURN_KW exp Semicolon;
//    public Void visitReturnStmt(P3Parser.ReturnStmtContext ctx) {
//        //System.out.println(";visitReturnStmt");
//        visit(ctx.exp());
//        if (node_Attr_Val.get(ctx.exp()).containsKey("thisReg")) {
//            Integer expReg = (Integer) node_Attr_Val.get(ctx.exp()).get("thisReg");
//            IR_List.add("\tret i32 %x" + expReg + "\n");
//        } else if (node_Attr_Val.get(ctx.exp()).containsKey("numberVal")) {
//            IR_List.add("\tret i32 " + node_Attr_Val.get(ctx.exp()).get("numberVal") + "\n");
//        }
//        //System.out.println(";visitReturnStmt" + " Fin");
//        return null;
//    }
//
//    @Override
////    exp:addExp;
//    public Void visitExp(P3Parser.ExpContext ctx) {
//        //System.out.println(";visitExp");
//        HashMap<String, Object> attr_Val = new HashMap<>();
////        attr_Val.put("bType", node_Attr_Val.get(ctx.parent).get("bType"));
//        visit(ctx.addExp());
////        String expType = "i32";
//        if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
//            attr_Val.put("thisReg", node_Attr_Val.get(ctx.addExp()).get("thisReg"));
//        } else if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
//            attr_Val.put("numberVal", node_Attr_Val.get(ctx.addExp()).get("numberVal"));
//        }
//        node_Attr_Val.put(ctx, attr_Val);
//        //System.out.println(";visitExp" + " Fin");
//        return null;
//    }
//
//    @Override
////    addExp:mulExp|addExp ( ADD | SUB ) mulExp;
//    public Void visitAddExp(P3Parser.AddExpContext ctx) {
//        //System.out.println(";visitAddExp");
//        HashMap<String, Object> attr_Val = new HashMap<>();
//        String bType = "i32";
//        attr_Val.put("bType", bType);
//        node_Attr_Val.put(ctx, attr_Val);
//        if (ctx.children.size() == 1) { //mulExp
//            visit(ctx.mulExp());
//            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
//                attr_Val.put("numberVal", node_Attr_Val.get(ctx.mulExp()).get("numberVal"));
//            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
//                attr_Val.put("thisReg", node_Attr_Val.get(ctx.mulExp()).get("thisReg"));
//            }
//        } else if (ctx.children.size() == 3) { //addExp ( ADD | SUB ) mulExp;
//            Long addExpVal = 0L, mulExpVal = 0L;
//            Integer addExpReg = 0, mulExpReg = 0;
//
//            visit(ctx.addExp());
//            String addExpType = "i32";
//            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal")) {
//                addExpVal = (Long) node_Attr_Val.get(ctx.addExp()).get("numberVal");
//            } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg")) {
//                addExpReg = (Integer) node_Attr_Val.get(ctx.addExp()).get("thisReg");
//            }
//
//            visit(ctx.mulExp());
////            String mulExpType = "i32";
//            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
//                mulExpVal = (Long) node_Attr_Val.get(ctx.mulExp()).get("numberVal");
//            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
//                mulExpReg = (Integer) node_Attr_Val.get(ctx.mulExp()).get("thisReg");
//            }
//
//            if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
//                if (ctx.ADD() != null) {
//                    attr_Val.put("numberVal", addExpVal + mulExpVal);
//                } else if (ctx.SUB() != null) {
//                    attr_Val.put("numberVal", addExpVal - mulExpVal);
//                }
//            } else {
//                Integer thisReg = currentReg++;
//                attr_Val.put("thisReg", thisReg);
//                if (node_Attr_Val.get(ctx.addExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
//                    if (ctx.ADD() != null) {
//                        IR_List.add("\t%x" + thisReg + " = add nsw " + addExpType + " " + addExpVal + ", %x" + mulExpReg + "\n");
//                    } else if (ctx.SUB() != null) {
//                        IR_List.add("\t%x" + thisReg + " = sub nsw " + addExpType + " " + addExpVal + ", %x" + mulExpReg + "\n");
//                    }
//                } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
//                    if (ctx.ADD() != null) {
//                        IR_List.add("\t%x" + thisReg + " = add nsw " + addExpType + " %x" + addExpReg + ", " + mulExpVal + "\n");
//                    } else if (ctx.SUB() != null) {
//                        IR_List.add("\t%x" + thisReg + " = sub nsw " + addExpType + " %x" + addExpReg + ", " + mulExpVal + "\n");
//                    }
//                } else if (node_Attr_Val.get(ctx.addExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
//                    if (ctx.ADD() != null) {
//                        IR_List.add("\t%x" + thisReg + " = add nsw " + addExpType + " %x" + addExpReg + ", %x" + mulExpReg + "\n");
//                    } else if (ctx.SUB() != null) {
//                        IR_List.add("\t%x" + thisReg + " = sub nsw " + addExpType + " %x" + addExpReg + ", %x" + mulExpReg + "\n");
//                    }
//                }
//            }
//        }
//        node_Attr_Val.put(ctx, attr_Val);
//        //System.out.println(";visitAddExp" + " Fin");
//        return null;
//    }
//
//    @Override
////    mulExp:unaryExp|mulExp ( MUL | DIV | MOD ) unaryExp;
//    public Void visitMulExp(P3Parser.MulExpContext ctx) {
//        //System.out.println(";visitMulExp");
//        HashMap<String, Object> attr_Val = new HashMap<>();
//        String bType = "i32";
//        attr_Val.put("bType", bType);
//        node_Attr_Val.put(ctx, attr_Val);
//        if (ctx.children.size() == 1) { //unaryExp
//            visit(ctx.unaryExp());
//            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
//                attr_Val.put("numberVal", node_Attr_Val.get(ctx.unaryExp()).get("numberVal"));
//            } else if (node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
//                attr_Val.put("thisReg", node_Attr_Val.get(ctx.unaryExp()).get("thisReg"));
//            }
//        } else if (ctx.children.size() == 3) { //mulExp ( MUL | DIV | MOD ) unaryExp;
//            Long mulExpVal = 0L, unaryExpVal = 0L;
//            Integer mulExpReg = 0, unaryExpReg = 0;
//
//            visit(ctx.mulExp());
//            String mulExpType = "i32";
//            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal")) {
//                mulExpVal = (Long) node_Attr_Val.get(ctx.mulExp()).get("numberVal");
//            } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg")) {
//                mulExpReg = (Integer) node_Attr_Val.get(ctx.mulExp()).get("thisReg");
//            }
//
//            visit(ctx.unaryExp());
////            String unaryExpType = "i32";
//            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
//                unaryExpVal = (Long) node_Attr_Val.get(ctx.unaryExp()).get("numberVal");
//            } else if (node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
//                unaryExpReg = (Integer) node_Attr_Val.get(ctx.unaryExp()).get("thisReg");
//            }
//
//            if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
//                if (ctx.MUL() != null) {
//                    attr_Val.put("numberVal", mulExpVal * unaryExpVal);
//                } else if (ctx.DIV() != null) {
//                    attr_Val.put("numberVal", mulExpVal / unaryExpVal);
//                } else if (ctx.MOD() != null) {
//                    attr_Val.put("numberVal", mulExpVal % unaryExpVal);
//                }
//            } else {
//                Integer thisReg = currentReg++;
//                attr_Val.put("thisReg", thisReg);
//                if (node_Attr_Val.get(ctx.mulExp()).containsKey("numberVal") && node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
//                    if (ctx.MUL() != null) {
//                        IR_List.add("\t%x" + thisReg + " = mul nsw " + mulExpType + " " + mulExpVal + ", %x" + unaryExpReg + "\n");
//                    } else if (ctx.DIV() != null) {
//                        IR_List.add("\t%x" + thisReg + " = sdiv " + mulExpType + " " + mulExpVal + ", %x" + unaryExpReg + "\n");
//                    } else if (ctx.MOD() != null) {
//                        IR_List.add("\t%x" + thisReg + " = srem " + mulExpType + " " + mulExpVal + ", %x" + unaryExpReg + "\n");
//                    }
//                } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
//                    if (ctx.MUL() != null) {
//                        IR_List.add("\t%x" + thisReg + " = mul nsw " + mulExpType + " %x" + mulExpReg + ", " + unaryExpVal + "\n");
//                    } else if (ctx.DIV() != null) {
//                        IR_List.add("\t%x" + thisReg + " = sdiv " + mulExpType + " %x" + mulExpReg + ", " + unaryExpVal + "\n");
//                    } else if (ctx.MOD() != null) {
//                        IR_List.add("\t%x" + thisReg + " = srem " + mulExpType + " %x" + mulExpReg + ", " + unaryExpVal + "\n");
//                    }
//                } else if (node_Attr_Val.get(ctx.mulExp()).containsKey("thisReg") && node_Attr_Val.get(ctx.unaryExp()).containsKey("thisReg")) {
//                    if (ctx.MUL() != null) {
//                        IR_List.add("\t%x" + thisReg + " = mul nsw " + mulExpType + " %x" + mulExpReg + ", %x" + unaryExpReg + "\n");
//                    } else if (ctx.DIV() != null) {
//                        IR_List.add("\t%x" + thisReg + " = sdiv " + mulExpType + " %x" + mulExpReg + ", %x" + unaryExpReg + "\n");
//                    } else if (ctx.MOD() != null) {
//                        IR_List.add("\t%x" + thisReg + " = srem " + mulExpType + " %x" + mulExpReg + ", %x" + unaryExpReg + "\n");
//                    }
//                }
//            }
//        }
//        node_Attr_Val.put(ctx, attr_Val);
//        //System.out.println(";visitMulExp" + " Fin");
//        return null;
//    }
//
//    @Override
////    unaryExp:primaryExp|( ADD | SUB ) unaryExp | Ident LParser (exp ( ',' exp )+)* RParser;
//    public Void visitUnaryExp(P3Parser.UnaryExpContext ctx) {
//        //System.out.println(";visitUnaryExp");
//        HashMap<String, Object> attr_Val = new HashMap<>();
//        if (ctx.Ident() != null) { // Ident LParser (exp ( ',' exp )+)* RParser
////            attr_Val.put("paraExpList",ctx.exp());
//            for (P3Parser.ExpContext exp : ctx.exp()) {
//                if (node_Attr_Val.get(exp).containsKey("thisReg")) {
//
//                } else if (node_Attr_Val.get(exp).containsKey("numberVal")) {
//
//                }
//            }
//
//        } else if (ctx.SUB() == null) { // primaryExp | ADD unaryExp
//            visit(ctx.primaryExp());
//            if (node_Attr_Val.get(ctx.primaryExp()).containsKey("lValReg")) {
//                Integer lValReg = (Integer) node_Attr_Val.get(ctx.primaryExp()).get("lValReg");
//                attr_Val.put("thisReg", lValReg);
//            } else if (node_Attr_Val.get(ctx.primaryExp()).containsKey("expReg")) {
//                Integer expReg = (Integer) node_Attr_Val.get(ctx.primaryExp()).get("expReg");
//                attr_Val.put("thisReg", expReg);
//            } else if (node_Attr_Val.get(ctx.primaryExp()).containsKey("numberVal")) {
//                attr_Val.put("numberVal", node_Attr_Val.get(ctx.primaryExp()).get("numberVal"));
//            }
//        } else { // SUB unaryExp
//            visit(ctx.unaryExp());
//            if (node_Attr_Val.get(ctx.unaryExp()).containsKey("numberVal")) {
//                Long numberVal = (Long) node_Attr_Val.get(ctx.unaryExp()).get("numberVal");
//                attr_Val.put("numberVal", numberVal * -1);
//            } else {
//                String unaryExpType = "i32";
//                Integer unaryExpReg = (Integer) node_Attr_Val.get(ctx.unaryExp()).get("thisReg");
////                int tmpUnaryexpReg = currentReg++;
//                int thisReg = currentReg++;
//                attr_Val.put("thisReg", thisReg);
////                System.out.println("\t%x" + unaryExpReg + " = load " + unaryExpType + ", " + unaryExpType + "* %x" + unaryExpReg + ", align 4");
//                IR_List.add("\t%x" + thisReg + " = sub nsw " + unaryExpType + " 0" + ", %x" + unaryExpReg + "\n");
//            }
//        }
//        node_Attr_Val.put(ctx, attr_Val);
//        //System.out.println(";visitUnaryExp" + " Fin");
//        return null;
//    }
//
//    @Override
////    primaryExp:LParser exp RParser|lVal|number;
//    public Void visitPrimaryExp(P3Parser.PrimaryExpContext ctx) {
//        //System.out.println(";visitPrimaryExp");
//        HashMap<String, Object> attr_Val = new HashMap<>();
//        if (ctx.number() != null) { //number
////            Integer thisReg = currentReg++;
//            visit(ctx.number());
//            attr_Val.put("numberVal", node_Attr_Val.get(ctx.number()).get("nodeVal"));
//            node_Attr_Val.put(ctx, attr_Val);
//        } else if (ctx.exp() != null) { //LParser exp RParser
//            visit(ctx.exp());
//            attr_Val.put("expReg", node_Attr_Val.get(ctx.exp()).get("thisReg"));
//        } else if (ctx.lVal() != null) {
//            visit(ctx.lVal());
//            if (node_Attr_Val.get(ctx.lVal()).containsKey("thisReg")) {
//                attr_Val.put("lValReg", node_Attr_Val.get(ctx.lVal()).get("thisReg"));
//            } else if (node_Attr_Val.get(ctx.lVal()).containsKey("nodeVal")) {
//                attr_Val.put("numberVal", node_Attr_Val.get(ctx.lVal()).get("nodeVal"));
//            }
//        }
//        node_Attr_Val.put(ctx, attr_Val);
//        //System.out.println(";visitPrimaryExp" + " Fin");
//        return null;
//    }
//}
