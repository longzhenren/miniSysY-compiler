// Generated from D:/Projects/IDEA/Compile/src\P2.g4 by ANTLR 4.9.1
package com.miniSysY.P2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P2Parser}.
 */
public interface P2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P2Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P2Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P2Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P2Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P2Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void enterFuncIdent(P2Parser.FuncIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void exitFuncIdent(P2Parser.FuncIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P2Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P2Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P2Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P2Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P2Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P2Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P2Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P2Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#reteurnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReteurnStmt(P2Parser.ReteurnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#reteurnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReteurnStmt(P2Parser.ReteurnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(P2Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(P2Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(P2Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(P2Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(P2Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(P2Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(P2Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(P2Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P2Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(P2Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P2Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(P2Parser.PrimaryExpContext ctx);
}