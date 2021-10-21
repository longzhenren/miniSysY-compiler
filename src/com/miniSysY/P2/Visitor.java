package com.miniSysY.P2;

public class Visitor extends P2BaseVisitor<Void> {
    Long addExpVal = 0L, mulExpVal = 0L, primaryExpVal = 0L, unaryExpVal = 0L, numberVal = 0L, expVal = 0L;

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
            numberVal = res;
        }
        return null;
    }

    @Override
    public Void visitReteurnStmt(P2Parser.ReteurnStmtContext ctx) {
        System.out.print("\tret i32 ");
        visit(ctx.exp());
        System.out.print(expVal);
        assert (ctx.Semicolumn() != null);
        return null;
    }

    @Override
    public Void visitExp(P2Parser.ExpContext ctx) {
        visit(ctx.addExp());
        expVal = addExpVal;
        return null;
    }

    @Override
    public Void visitAddExp(P2Parser.AddExpContext ctx) {
        if (ctx.children.size() == 1) { //mulExp
            visit(ctx.mulExp());
            addExpVal = mulExpVal;
        } else if (ctx.children.size() == 3) { //addExp (ADD | SUB) mulExp
            visit(ctx.addExp());
            visit(ctx.mulExp());
            if (ctx.ADD() != null) {
                addExpVal = addExpVal + mulExpVal;
            } else if (ctx.SUB() != null) {
                addExpVal = addExpVal - mulExpVal;
            }
        }
        return null;
    }

    @Override
    public Void visitMulExp(P2Parser.MulExpContext ctx) {
        if (ctx.children.size() == 1) { //unaryExp
            visit(ctx.unaryExp());
            mulExpVal = unaryExpVal;
        } else if (ctx.children.size() == 3) { //mulExp (MUL|DIV|MOD) unaryExp
            visit(ctx.mulExp());
            visit(ctx.unaryExp());
            if (ctx.MUL() != null) {
                mulExpVal = mulExpVal * unaryExpVal;
            } else if (ctx.DIV() != null) {
                mulExpVal = mulExpVal / unaryExpVal;
            } else if (ctx.MOD() != null) {
                mulExpVal = mulExpVal % unaryExpVal;
            }
        }
        return null;
    }

    @Override
    public Void visitUnaryExp(P2Parser.UnaryExpContext ctx) {
        if (ctx.children.size() == 1) { //primaryExp
            visit(ctx.primaryExp());
            unaryExpVal = primaryExpVal;
        } else if (ctx.children.size() == 2) { //unaryOp unaryExp
            visit(ctx.unaryExp());
            if (ctx.ADD() != null) {
                unaryExpVal = unaryExpVal;
            } else if (ctx.SUB() != null) {
                unaryExpVal = -unaryExpVal;
            }
        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(P2Parser.PrimaryExpContext ctx) {
        if (ctx.children.size() == 1) { //number
            visit(ctx.number());
            primaryExpVal = numberVal;
        } else if (ctx.children.size() == 3) { //LParser exp RParser
            assert (ctx.LParser() != null && ctx.RParser() != null);
//            System.out.print("(");
            visit(ctx.exp());
            primaryExpVal = expVal;
//            System.out.println(" pri: "+primaryExpVal);
//            System.out.print(")");
        }
        return null;
    }
}
