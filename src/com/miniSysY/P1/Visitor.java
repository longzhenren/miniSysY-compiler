package com.miniSysY.P1;

public class Visitor extends P1BaseVisitor<Void> {
    @Override
    public Void visitFuncIdent(P1Parser.FuncIdentContext ctx) {
        System.out.print('@' + ctx.FuncIdent().getText());
        return null;
    }

    @Override
    public Void visitCompUnit(P1Parser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }

    @Override
    public Void visitFuncType(P1Parser.FuncTypeContext ctx) {
        if (ctx.INT_KW() != null) System.out.print("i32 ");
        return null;
    }

    @Override
    public Void visitFuncDef(P1Parser.FuncDefContext ctx) {
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
    public Void visitBlock(P1Parser.BlockContext ctx) {
        System.out.println(ctx.LBrace().getText());
        visit(ctx.stmt());
        System.out.println();
        System.out.print(ctx.RBrace().getText());
        return null;
    }

    @Override
    public Void visitStmt(P1Parser.StmtContext ctx) {
        if (ctx.reteurnStmt() != null) {
            visit(ctx.reteurnStmt());
        }
        return null;
    }

    @Override
    public Void visitNumber(P1Parser.NumberContext ctx) {
        if (ctx.intConst() != null) {
            System.out.print("i32 ");
            visit(ctx.intConst());
        }
        return null;
    }

    @Override
    public Void visitIntConst(P1Parser.IntConstContext ctx) {
        long res = 0;
        if (ctx.HexadecimalConst() != null) {
            String hex = ctx.HexadecimalConst().getText();
            res = Long.parseLong(hex, 16);
        } else if (ctx.OctalConst() != null) {
            String oct = ctx.OctalConst().getText();
            res = Long.parseLong(oct, 8);
        } else if (ctx.DecimalConst() != null) {
            String dec = ctx.DecimalConst().getText();
            res = Long.parseLong(dec, 10);
        }
//        System.out.println("RES:"+res);
        if (res <= 2147483647 && res >= 0) {
            System.out.print(res);
        }
        return null;
    }

    @Override
    public Void visitReteurnStmt(P1Parser.ReteurnStmtContext ctx) {
        System.out.print("\tret ");
        visit(ctx.number());
        assert(ctx.Semicolumn()!=null);
        return null;
    }
}
