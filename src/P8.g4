grammar P8;

LParser: '(';
RParser: ')';
LBrace: '{';
RBrace: '}';
LBracket: '[';
RBracket: ']';
RETURN_KW: 'return';
INT_KW: 'int';
VOID_KW: 'void';
CONST_KW: 'const';
WHILE_KW: 'while';
IF_KW: 'if';
ELSE_KW: 'else';
BREAK_KW: 'break';
CONTINUE_KW: 'continue';
LT_KW: '<';
GT_KW: '>';
LE_KW: '<=';
GE_KW: '>=';
EQ_KW: '==';
NEQ_KW: '!=';
LAND_KW: '&&';
LOR_KW: '||';
ASSIGN:
	'='
	| '*='
	| '/='
	| '%='
	| '+='
	| '-='
	| '<<='
	| '>>='
	| '&='
	| '^='
	| '|=';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';
NOT: '!';
Semicolon: ';';
WhiteSpace: [ \r\n\t] -> skip;
//FuncIdent: 'main';
DecimalConst: [1-9] [0-9]*;
OctalConst: [0] [0-7]*;
HexadecimalConst: [0] [xX] [0-9a-fA-F]+;
BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;
Ident: [_a-zA-Z][_a-zA-Z0-9]*;

compUnit: (decl | funcDef)* (decl | funcDef);
funcType: INT_KW | VOID_KW;
//funcIdent: FuncIdent;
funcDef: funcType Ident LParser (funcFParams)? RParser block;
funcFParams: funcFParam ( ',' funcFParam)*;
funcFParam:
	bType Ident (LBracket RBracket ( LBracket exp RBracket)*)?;
block: LBrace (blockItem)* RBrace;
blockItem: decl | stmt;
stmt:
	lVal ASSIGN exp Semicolon
	| block
	| (exp)? Semicolon
	| IF_KW LParser cond RParser stmt (ELSE_KW stmt)?
	| WHILE_KW LParser cond RParser stmt
	| BREAK_KW Semicolon
	| CONTINUE_KW Semicolon
	| returnStmt;
lVal: Ident (LBracket exp RBracket)*;
number: intConst;
intConst: DecimalConst | OctalConst | HexadecimalConst;
returnStmt: RETURN_KW (exp)? Semicolon;

exp: addExp;
cond: lOrExp;
relExp: addExp | relExp ( LT_KW | GT_KW | LE_KW | GE_KW) addExp;
eqExp: relExp | eqExp (EQ_KW | NEQ_KW) relExp;
lAndExp: eqExp | lAndExp LAND_KW eqExp;
lOrExp: lAndExp | lOrExp LOR_KW lAndExp;
addExp: mulExp | addExp ( ADD | SUB) mulExp;
mulExp: unaryExp | mulExp ( MUL | DIV | MOD) unaryExp;
unaryExp:
	Ident LParser (exp ( ',' exp)*)? RParser
	| ( ADD | SUB | NOT) unaryExp
	| primaryExp;
primaryExp: LParser exp RParser | lVal | number;
decl: constDecl | varDecl;
constDecl: CONST_KW bType constDef (',' constDef)* Semicolon;
bType: INT_KW;
constDef:
	Ident (LBracket constExp RBracket)* ASSIGN constInitVal;
constInitVal:
	constExp
	| LBrace ( constInitVal ( ',' constInitVal)*)? RBrace;
constExp: addExp;
varDecl: bType varDef (',' varDef)* Semicolon;
varDef:
	Ident (LBracket constExp RBracket)*
	| Ident (LBracket constExp RBracket)* ASSIGN initVal;
initVal: exp | LBrace ( initVal ( ',' initVal)*)? RBrace;
