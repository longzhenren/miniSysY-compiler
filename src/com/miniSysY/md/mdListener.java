// Generated from D:/Projects/IDEA/Compile/src\md.g4 by ANTLR 4.9.2
package com.miniSysY.md;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mdParser}.
 */
public interface mdListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mdParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(mdParser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(mdParser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(mdParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(mdParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(mdParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(mdParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParams(mdParser.FuncFParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParams(mdParser.FuncFParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParam(mdParser.FuncFParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParam(mdParser.FuncFParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(mdParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(mdParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(mdParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(mdParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(mdParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(mdParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(mdParser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(mdParser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(mdParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(mdParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(mdParser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(mdParser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(mdParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(mdParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(mdParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(mdParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(mdParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(mdParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(mdParser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(mdParser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(mdParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(mdParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(mdParser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(mdParser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(mdParser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(mdParser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(mdParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(mdParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(mdParser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(mdParser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(mdParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(mdParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(mdParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(mdParser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(mdParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(mdParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(mdParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(mdParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(mdParser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(mdParser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(mdParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(mdParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(mdParser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(mdParser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(mdParser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(mdParser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(mdParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(mdParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(mdParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(mdParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link mdParser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(mdParser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link mdParser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(mdParser.InitValContext ctx);
}