// Generated from D:/Projects/IDEA/Compile/src\P6.g4 by ANTLR 4.9.2
package com.miniSysY.P6;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P6Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P6Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P6Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P6Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P6Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#funcIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncIdent(P6Parser.FuncIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P6Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P6Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(P6Parser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P6Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(P6Parser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P6Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P6Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(P6Parser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(P6Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(P6Parser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(P6Parser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(P6Parser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#lAndExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLAndExp(P6Parser.LAndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#lOrExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOrExp(P6Parser.LOrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(P6Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(P6Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(P6Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(P6Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(P6Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(P6Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(P6Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(P6Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(P6Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(P6Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(P6Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(P6Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P6Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(P6Parser.InitValContext ctx);
}