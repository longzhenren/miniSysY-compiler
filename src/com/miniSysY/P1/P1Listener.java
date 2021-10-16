// Generated from D:/Projects/IDEA/Compile/src\P1.g4 by ANTLR 4.9.1
package com.miniSysY.P1;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P1Parser}.
 */
public interface P1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P1Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P1Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P1Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P1Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P1Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void enterFuncIdent(P1Parser.FuncIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void exitFuncIdent(P1Parser.FuncIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P1Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P1Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P1Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P1Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P1Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P1Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P1Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P1Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P1Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P1Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P1Parser#reteurnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReteurnStmt(P1Parser.ReteurnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P1Parser#reteurnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReteurnStmt(P1Parser.ReteurnStmtContext ctx);
}