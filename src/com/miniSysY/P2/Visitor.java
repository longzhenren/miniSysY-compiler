package com.miniSysY.P2;

public class Visitor extends P2BaseVisitor<Void> {
    double nodeVal = 0.0;

    @Override
    public Void visitCompUnit(P2Parser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }

    @Override
    public Void visitFuncType(P2Parser.FuncTypeContext ctx) {
        if (ctx.INT_KW().getText().equals("int")) System.out.print("i32 ");
        return null;
    }

    @Override
    public Void visitFuncIdent(P2Parser.FuncIdentContext ctx) {
        System.out.print('@' + ctx.FuncIdent().getText());
        return null;
    }

    @Override
    public Void visitFuncDef(P2Parser.FuncDefContext ctx) {
        System.out.print("define dso_local ");
        assert (ctx.funcType() != null && ctx.funcIdent() != null && ctx.LParser() != null && ctx.RParser() != null && ctx.block() != null);
        visit(ctx.funcType());
        visit(ctx.funcIdent());
        System.out.print(ctx.LParser().getText());
        System.out.print(ctx.RParser().getText());
        visit(ctx.block());
        return null;
    }

    @Override
    public Void visitBlock(P2Parser.BlockContext ctx) {
        System.out.println(ctx.LBrace().getText());
        visit(ctx.stmt());
        System.out.println();
        System.out.print(ctx.RBrace().getText());
        return null;
    }

    @Override
    public Void visitStmt(P2Parser.StmtContext ctx) {
        if (ctx.reteurnStmt() != null) {
            visit(ctx.reteurnStmt());
        }
        return null;
    }

    @Override
    public Void visitNumber(P2Parser.NumberContext ctx) {
        if (ctx.intConst() != null) {
//            System.out.print("i32 ");
            visit(ctx.intConst());
        }
        return null;
    }

    @Override
    public Void visitIntConst(P2Parser.IntConstContext ctx) {
        Long res = 0L;
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
            nodeVal = res;
        }
        return null;
    }

    @Override
    public Void visitReteurnStmt(P2Parser.ReteurnStmtContext ctx) {
        System.out.print("\tret i32 ");
        visit(ctx.exp());
        System.out.print((int)nodeVal);
        assert (ctx.Semicolumn() != null);
        return null;
    }

    @Override
    public Void visitExp(P2Parser.ExpContext ctx) {
        visit(ctx.addExp());
//        nodeVal = nodeVal;
        return null;
    }

    @Override
    public Void visitAddExp(P2Parser.AddExpContext ctx) {
        if (ctx.children.size() == 1) { //mulExp
            visit(ctx.mulExp());
//            addExpVal = mulExpVal;
        } else if (ctx.children.size() == 3) { //addExp (ADD | SUB) mulExp
            double addExpVal = 0.0, mulExpVal = 0.0;
            visit(ctx.addExp());
            addExpVal = nodeVal;
            visit(ctx.mulExp());
            mulExpVal = nodeVal;
            if (ctx.ADD() != null) {
                nodeVal = addExpVal + mulExpVal;
            } else if (ctx.SUB() != null) {
                nodeVal = addExpVal - mulExpVal;
            }
        }
        return null;
    }

    @Override
    public Void visitMulExp(P2Parser.MulExpContext ctx) {
        if (ctx.children.size() == 1) { //unaryExp
            visit(ctx.unaryExp());
//            nodeVal = unaryExpVal;
        } else if (ctx.children.size() == 3) { //mulExp (MUL|DIV|MOD) unaryExp
            double mulExpVal = 0.0, unaryExpVal = 0.0;
            visit(ctx.mulExp());
            nodeVal = mulExpVal;
            visit(ctx.unaryExp());
            nodeVal = unaryExpVal;
            if (ctx.MUL() != null) {
                nodeVal = mulExpVal * unaryExpVal;
            } else if (ctx.DIV() != null) {
                nodeVal = mulExpVal / unaryExpVal;
            } else if (ctx.MOD() != null) {
                nodeVal = mulExpVal % unaryExpVal;
            }
        }
        return null;
    }

    @Override
    public Void visitUnaryExp(P2Parser.UnaryExpContext ctx) {
        if (ctx.children.size() == 1) { //primaryExp
            visit(ctx.primaryExp());
//            nodeVal = primaryExpVal;
        } else if (ctx.children.size() == 2) { //unaryOp unaryExp
            double unaryExpVal = 0.0;
            visit(ctx.unaryExp());
            unaryExpVal = nodeVal;
            if (ctx.ADD() != null) {
                nodeVal = unaryExpVal;
            } else if (ctx.SUB() != null) {
                nodeVal = -unaryExpVal;
            }
        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(P2Parser.PrimaryExpContext ctx) {
        if (ctx.children.size() == 1) { //number
            double numberVal = 0.0;
            visit(ctx.number());
            numberVal = nodeVal;
            nodeVal = numberVal;
        } else if (ctx.children.size() == 3) { //LParser exp RParser
            double expVal = 0.0;
            assert (ctx.LParser() != null && ctx.RParser() != null);
            visit(ctx.exp());
            expVal = nodeVal;

            nodeVal = expVal;
        }
        return null;
    }
}
