// Generated from D:/Projects/IDEA/Compile/src\P4.g4 by ANTLR 4.9.2
package com.miniSysY.P4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P4Parser}.
 */
public interface P4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P4Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P4Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P4Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P4Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P4Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void enterFuncIdent(P4Parser.FuncIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void exitFuncIdent(P4Parser.FuncIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P4Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P4Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P4Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P4Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(P4Parser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(P4Parser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P4Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P4Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(P4Parser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(P4Parser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P4Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P4Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P4Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P4Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(P4Parser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(P4Parser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(P4Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(P4Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(P4Parser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(P4Parser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(P4Parser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(P4Parser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(P4Parser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(P4Parser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(P4Parser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(P4Parser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(P4Parser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(P4Parser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(P4Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(P4Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(P4Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(P4Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(P4Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(P4Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(P4Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(P4Parser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(P4Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(P4Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(P4Parser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(P4Parser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(P4Parser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(P4Parser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(P4Parser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(P4Parser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(P4Parser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(P4Parser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(P4Parser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(P4Parser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(P4Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(P4Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(P4Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(P4Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P4Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(P4Parser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P4Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(P4Parser.InitValContext ctx);
}