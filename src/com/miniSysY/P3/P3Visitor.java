// Generated from D:/Projects/IDEA/Compile/src\P3.g4 by ANTLR 4.9.2
package com.miniSysY.P3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P3Parser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(P3Parser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(P3Parser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#funcIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncIdent(P3Parser.FuncIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(P3Parser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(P3Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(P3Parser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(P3Parser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(P3Parser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(P3Parser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#intConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(P3Parser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#reteurnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReteurnStmt(P3Parser.ReteurnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(P3Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(P3Parser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(P3Parser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(P3Parser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(P3Parser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(P3Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(P3Parser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(P3Parser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(P3Parser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(P3Parser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(P3Parser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(P3Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(P3Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P3Parser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(P3Parser.InitValContext ctx);
}