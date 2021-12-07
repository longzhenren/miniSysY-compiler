// Generated from D:/Projects/IDEA/Compile/src\P5.g4 by ANTLR 4.9.2
package com.miniSysY.P5;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P5Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P5Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P5Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P5Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P5Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#funcIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncIdent(P5Parser.FuncIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P5Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P5Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(P5Parser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P5Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(P5Parser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P5Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P5Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(P5Parser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(P5Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(P5Parser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(P5Parser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(P5Parser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(P5Parser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(P5Parser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(P5Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(P5Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(P5Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(P5Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(P5Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(P5Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(P5Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(P5Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(P5Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(P5Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(P5Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(P5Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P5Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(P5Parser.InitValContext ctx);
}