// Generated from D:/Projects/IDEA/Compile/src\sc.g4 by ANTLR 4.9.2
package com.miniSysY.sc;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link scParser}.
 */
public interface scListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link scParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(scParser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(scParser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(scParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(scParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(scParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(scParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParams(scParser.FuncFParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParams(scParser.FuncFParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParam(scParser.FuncFParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParam(scParser.FuncFParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(scParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(scParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(scParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(scParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(scParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(scParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(scParser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(scParser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(scParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(scParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(scParser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(scParser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(scParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(scParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(scParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(scParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(scParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(scParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(scParser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(scParser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(scParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(scParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(scParser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(scParser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(scParser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(scParser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(scParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(scParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(scParser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(scParser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(scParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(scParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(scParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(scParser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(scParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(scParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(scParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(scParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(scParser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(scParser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(scParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(scParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(scParser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(scParser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(scParser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(scParser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(scParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(scParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(scParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(scParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scParser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(scParser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link scParser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(scParser.InitValContext ctx);
}