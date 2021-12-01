// Generated from D:/Projects/IDEA/Compile/src\P4.g4 by ANTLR 4.9.2
package com.miniSysY.P4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P4Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P4Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P4Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P4Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P4Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#funcIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncIdent(P4Parser.FuncIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P4Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P4Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(P4Parser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P4Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(P4Parser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P4Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P4Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(P4Parser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(P4Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(P4Parser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(P4Parser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(P4Parser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(P4Parser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(P4Parser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(P4Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(P4Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(P4Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(P4Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(P4Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(P4Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(P4Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(P4Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(P4Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(P4Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(P4Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(P4Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P4Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(P4Parser.InitValContext ctx);
}