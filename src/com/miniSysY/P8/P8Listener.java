// Generated from D:/Projects/IDEA/Compile/src\P8.g4 by ANTLR 4.9.2
package com.miniSysY.P8;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P8Parser}.
 */
public interface P8Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P8Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P8Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P8Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P8Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P8Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P8Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P8Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParams(P8Parser.FuncFParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#funcFParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParams(P8Parser.FuncFParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncFParam(P8Parser.FuncFParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#funcFParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncFParam(P8Parser.FuncFParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P8Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P8Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(P8Parser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(P8Parser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P8Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P8Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(P8Parser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(P8Parser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P8Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P8Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P8Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P8Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(P8Parser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(P8Parser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(P8Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(P8Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(P8Parser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(P8Parser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(P8Parser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(P8Parser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(P8Parser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(P8Parser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(P8Parser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(P8Parser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(P8Parser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(P8Parser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(P8Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(P8Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(P8Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(P8Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(P8Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(P8Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(P8Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(P8Parser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(P8Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(P8Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(P8Parser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(P8Parser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(P8Parser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(P8Parser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(P8Parser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(P8Parser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(P8Parser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(P8Parser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(P8Parser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(P8Parser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(P8Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(P8Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(P8Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(P8Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P8Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(P8Parser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P8Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(P8Parser.InitValContext ctx);
}