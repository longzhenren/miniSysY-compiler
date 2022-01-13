// Generated from D:/Projects/IDEA/Compile/src\sc.g4 by ANTLR 4.9.2
package com.miniSysY.sc;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link scParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface scVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link scParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(scParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(scParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(scParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#funcFParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParams(scParser.FuncFParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#funcFParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParam(scParser.FuncFParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(scParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(scParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(scParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(scParser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(scParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(scParser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(scParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(scParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(scParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(scParser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(scParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(scParser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(scParser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(scParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(scParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(scParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(scParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(scParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(scParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(scParser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(scParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(scParser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(scParser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(scParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(scParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scParser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(scParser.InitValContext ctx);
}