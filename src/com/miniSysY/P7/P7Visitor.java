// Generated from D:/Projects/IDEA/Compile/src\P7.g4 by ANTLR 4.9.2
package com.miniSysY.P7;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P7Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P7Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P7Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P7Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P7Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#funcIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncIdent(P7Parser.FuncIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P7Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P7Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(P7Parser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P7Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(P7Parser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P7Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P7Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(P7Parser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(P7Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(P7Parser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(P7Parser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(P7Parser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(P7Parser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(P7Parser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(P7Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(P7Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(P7Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(P7Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(P7Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(P7Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(P7Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(P7Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(P7Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(P7Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(P7Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(P7Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P7Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(P7Parser.InitValContext ctx);
}