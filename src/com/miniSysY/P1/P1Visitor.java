// Generated from D:/Projects/IDEA/Compile/src\P1.g4 by ANTLR 4.9.1
package com.miniSysY.P1;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P1Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P1Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P1Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#funcIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncIdent(P1Parser.FuncIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P1Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P1Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P1Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P1Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P1Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P1Parser#reteurnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReteurnStmt(P1Parser.ReteurnStmtContext ctx);
}