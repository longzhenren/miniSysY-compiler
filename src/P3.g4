grammar P3;

LParser
    :   '('
    ;
RParser
    :   ')'
    ;
LBrace
    :   '{'
    ;
RBrace
    :   '}'
    ;
RETURN_KW
    :   'return'
    ;
INT_KW
    :   'int'
    ;
CONST_KW
    :   'const'
    ;
ASSIGN
	:   '='
	|   '*='
	|   '/='
	|   '%='
	|   '+='
	|   '-='
	|   '<<='
	|   '>>='
	|   '&='
	|   '^='
	|   '|='
	;
ADD
    :   '+'
    ;
SUB
    :   '-'
    ;
MUL
    :   '*'
    ;
DIV
    :   '/'
    ;
MOD
    :   '%'
    ;
Semicolon
    :   ';'
    ;
WhiteSpace
    :   [ \r\n\t] -> skip
    ;
FuncIdent
    :   'main'
    ;
DecimalConst
    :   [1-9] [0-9]*
    ;
OctalConst
    :   [0] [0-7]*
    ;
HexadecimalConst
    :   [0] [xX] [0-9a-fA-F]+
    ;
BlockComment
    :   '/*' .*? '*/' -> skip
    ;
LineComment
    :   '//' ~[\r\n]* -> skip
    ;
Ident
    :   [_a-zA-Z][_a-zA-Z0-9]*
    ;

compUnit
    :   funcDef
    ;
funcType
    :   INT_KW
    ;
funcIdent
    :   FuncIdent
    ;
funcDef
    :   funcType funcIdent LParser RParser block
    ;
block
    :   LBrace (blockItem)* RBrace
    ;
blockItem
    :   decl
    |   stmt
    ;
stmt
    :   lVal ASSIGN exp Semicolon
    |   (exp)+ Semicolon
    |   returnStmt
    ;
lVal
    :   Ident
    ;
number
    :   intConst
    ;
intConst
    :   DecimalConst
    |   OctalConst
    |   HexadecimalConst
    ;
returnStmt
    :   RETURN_KW exp Semicolon
    ;

exp
    :   addExp
    ;
addExp
    :   mulExp
    |   addExp ( ADD | SUB ) mulExp
    ;
mulExp
    :   unaryExp
    |   mulExp ( MUL | DIV | MOD ) unaryExp
    ;
unaryExp
    :   Ident LParser (exp ( ',' exp )*)* RParser
    |   ( ADD | SUB ) unaryExp
    |   primaryExp
    ;
primaryExp
    :   LParser exp RParser
    |   lVal
    |   number
    ;
decl
    :   constDecl
    |   varDecl
    ;
constDecl
    :   CONST_KW bType constDef (',' constDef)* Semicolon
    ;
bType
    :   INT_KW
    ;
constDef
    :   Ident ASSIGN constInitVal
    ;
constInitVal
    :   constExp
    ;
constExp
    :   addExp
    ;
varDecl
    :   bType varDef (',' varDef)* Semicolon
    ;
varDef
    :   Ident
    |   Ident ASSIGN initVal
    ;
initVal
    :   exp
    ;
