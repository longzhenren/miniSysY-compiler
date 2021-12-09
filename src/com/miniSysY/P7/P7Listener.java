// Generated from D:/Projects/IDEA/Compile/src\P7.g4 by ANTLR 4.9.2
package com.miniSysY.P7;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P7Parser}.
 */
public interface P7Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P7Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P7Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P7Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P7Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P7Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void enterFuncIdent(P7Parser.FuncIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void exitFuncIdent(P7Parser.FuncIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P7Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P7Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P7Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P7Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(P7Parser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(P7Parser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P7Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P7Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(P7Parser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(P7Parser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P7Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P7Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P7Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P7Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(P7Parser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(P7Parser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(P7Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(P7Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(P7Parser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(P7Parser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(P7Parser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(P7Parser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(P7Parser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(P7Parser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(P7Parser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(P7Parser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(P7Parser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(P7Parser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(P7Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(P7Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(P7Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(P7Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(P7Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(P7Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(P7Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(P7Parser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(P7Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(P7Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(P7Parser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(P7Parser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(P7Parser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(P7Parser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(P7Parser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(P7Parser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(P7Parser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(P7Parser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(P7Parser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(P7Parser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(P7Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(P7Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(P7Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(P7Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P7Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(P7Parser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P7Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(P7Parser.InitValContext ctx);
}