grammar P4;

LParser: '(';
RParser: ')';
LBrace: '{';
RBrace: '}';
RETURN_KW: 'return';
INT_KW: 'int';
CONST_KW: 'const';
IF_KW: 'if';
ELSE_KW: 'else';
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
FuncIdent: 'main';
DecimalConst: [1-9] [0-9]*;
OctalConst: [0] [0-7]*;
HexadecimalConst: [0] [xX] [0-9a-fA-F]+;
BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;
Ident: [_a-zA-Z][_a-zA-Z0-9]*;

compUnit: funcDef;
funcType: INT_KW;
funcIdent: FuncIdent;
funcDef: funcType funcIdent LParser RParser block;
block: LBrace (blockItem)* RBrace;
blockItem: decl | stmt;
stmt:
	lVal ASSIGN exp Semicolon
	| block
	| (exp)+ Semicolon
	| IF_KW LParser cond RParser stmt ( ELSE_KW stmt)*
	| returnStmt;
lVal: Ident;
number: intConst;
intConst: DecimalConst | OctalConst | HexadecimalConst;
returnStmt: RETURN_KW exp Semicolon;

exp: addExp;
cond: lOrExp;
relExp: addExp | relExp ( LT_KW | GT_KW | LE_KW | GE_KW) addExp;
eqExp: relExp | eqExp (EQ_KW | NEQ_KW) relExp;
lAndExp: eqExp | lAndExp LAND_KW eqExp;
lOrExp: lAndExp | lOrExp LOR_KW lAndExp;
addExp: mulExp | addExp ( ADD | SUB) mulExp;
mulExp: unaryExp | mulExp ( MUL | DIV | MOD) unaryExp;
unaryExp:
	Ident LParser (exp ( ',' exp)*)* RParser
	| ( ADD | SUB | NOT) unaryExp
	| primaryExp;
primaryExp: LParser exp RParser | lVal | number;
decl: constDecl | varDecl;
constDecl: CONST_KW bType constDef (',' constDef)* Semicolon;
bType: INT_KW;
constDef: Ident ASSIGN constInitVal;
constInitVal: constExp;
constExp: addExp;
varDecl: bType varDef (',' varDef)* Semicolon;
varDef: Ident | Ident ASSIGN initVal;
initVal: exp;
