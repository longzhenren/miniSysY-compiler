// Generated from D:/Projects/IDEA/Compile/src\P2.g4 by ANTLR 4.9.1
package com.miniSysY.P2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P2Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P2Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P2Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#funcIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncIdent(P2Parser.FuncIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P2Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P2Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P2Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P2Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P2Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#reteurnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReteurnStmt(P2Parser.ReteurnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(P2Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(P2Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(P2Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(P2Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P2Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(P2Parser.PrimaryExpContext ctx);
}