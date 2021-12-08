// Generated from D:/Projects/IDEA/Compile/src\P6.g4 by ANTLR 4.9.2
package com.miniSysY.P6;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P6Parser}.
 */
public interface P6Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P6Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P6Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P6Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P6Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P6Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void enterFuncIdent(P6Parser.FuncIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void exitFuncIdent(P6Parser.FuncIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P6Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P6Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P6Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P6Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(P6Parser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(P6Parser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P6Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P6Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(P6Parser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(P6Parser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P6Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P6Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P6Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P6Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(P6Parser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(P6Parser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(P6Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(P6Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(P6Parser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(P6Parser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(P6Parser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(P6Parser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(P6Parser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(P6Parser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void enterLAndExp(P6Parser.LAndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#lAndExp}.
	 * @param ctx the parse tree
	 */
	void exitLAndExp(P6Parser.LAndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void enterLOrExp(P6Parser.LOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#lOrExp}.
	 * @param ctx the parse tree
	 */
	void exitLOrExp(P6Parser.LOrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(P6Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(P6Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(P6Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(P6Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(P6Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(P6Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(P6Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(P6Parser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(P6Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(P6Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(P6Parser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(P6Parser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(P6Parser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(P6Parser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(P6Parser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(P6Parser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(P6Parser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(P6Parser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(P6Parser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(P6Parser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(P6Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(P6Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(P6Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(P6Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P6Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(P6Parser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P6Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(P6Parser.InitValContext ctx);
}