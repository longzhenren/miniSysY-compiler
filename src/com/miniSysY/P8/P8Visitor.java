// Generated from D:/Projects/IDEA/Compile/src\P8.g4 by ANTLR 4.9.2
package com.miniSysY.P8;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P8Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P8Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P8Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P8Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P8Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P8Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#funcFParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParams(P8Parser.FuncFParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#funcFParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncFParam(P8Parser.FuncFParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P8Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(P8Parser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P8Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(P8Parser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P8Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P8Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(P8Parser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(P8Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(P8Parser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(P8Parser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(P8Parser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(P8Parser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(P8Parser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(P8Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(P8Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(P8Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(P8Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(P8Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(P8Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(P8Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(P8Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(P8Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(P8Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(P8Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(P8Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P8Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(P8Parser.InitValContext ctx);
}