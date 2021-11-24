// Generated from D:/Projects/IDEA/Compile/src\P3.g4 by ANTLR 4.9.2
package com.miniSysY.P3;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link P3Parser}.
 */
public interface P3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link P3Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(P3Parser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(P3Parser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(P3Parser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(P3Parser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void enterFuncIdent(P3Parser.FuncIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#funcIdent}.
	 * @param ctx the parse tree
	 */
	void exitFuncIdent(P3Parser.FuncIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(P3Parser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(P3Parser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(P3Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(P3Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(P3Parser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(P3Parser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(P3Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(P3Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(P3Parser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(P3Parser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(P3Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(P3Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(P3Parser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#intConst}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(P3Parser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(P3Parser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(P3Parser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(P3Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(P3Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(P3Parser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(P3Parser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(P3Parser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(P3Parser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(P3Parser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(P3Parser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(P3Parser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(P3Parser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(P3Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(P3Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(P3Parser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(P3Parser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(P3Parser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(P3Parser.BTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(P3Parser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(P3Parser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(P3Parser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(P3Parser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(P3Parser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(P3Parser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(P3Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(P3Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(P3Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(P3Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link P3Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(P3Parser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link P3Parser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(P3Parser.InitValContext ctx);
}