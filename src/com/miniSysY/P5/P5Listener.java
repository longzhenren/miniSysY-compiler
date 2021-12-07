// Generated from D:/Projects/IDEA/Compile/src\P5.g4 by ANTLR 4.9.2
package com.miniSysY.P5;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P5Parser}.
 */
public interface P5Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P5Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P5Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P5Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P5Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P5Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void enterFuncIdent(P5Parser.FuncIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void exitFuncIdent(P5Parser.FuncIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P5Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P5Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P5Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P5Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(P5Parser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(P5Parser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P5Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P5Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(P5Parser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(P5Parser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P5Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P5Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P5Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P5Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(P5Parser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(P5Parser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(P5Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(P5Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(P5Parser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(P5Parser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(P5Parser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(P5Parser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(P5Parser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(P5Parser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(P5Parser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(P5Parser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(P5Parser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(P5Parser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(P5Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(P5Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(P5Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(P5Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(P5Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(P5Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(P5Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(P5Parser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(P5Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(P5Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(P5Parser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(P5Parser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(P5Parser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(P5Parser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(P5Parser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(P5Parser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(P5Parser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(P5Parser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(P5Parser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(P5Parser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(P5Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(P5Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(P5Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(P5Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P5Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(P5Parser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P5Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(P5Parser.InitValContext ctx);
}