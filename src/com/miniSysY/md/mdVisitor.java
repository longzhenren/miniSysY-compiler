// Generated from D:/Projects/IDEA/Compile/src\md.g4 by ANTLR 4.9.2
package com.miniSysY.md;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mdParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mdVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mdParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(mdParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(mdParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(mdParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#funcFParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParams(mdParser.FuncFParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#funcFParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParam(mdParser.FuncFParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(mdParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(mdParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(mdParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(mdParser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(mdParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(mdParser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(mdParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(mdParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(mdParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(mdParser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(mdParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(mdParser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(mdParser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(mdParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(mdParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(mdParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(mdParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(mdParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(mdParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(mdParser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(mdParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(mdParser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(mdParser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(mdParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(mdParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link mdParser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(mdParser.InitValContext ctx);
}