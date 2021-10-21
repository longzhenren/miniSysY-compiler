grammar P2;

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
Semicolumn
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
    :   LBrace stmt RBrace
    ;
stmt
    :   reteurnStmt
    ;
number
    :   intConst
    ;
intConst
    :   DecimalConst
    |   OctalConst
    |   HexadecimalConst
    ;
reteurnStmt
    :   RETURN_KW exp Semicolumn
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
    :   primaryExp
    |   ( ADD | SUB ) unaryExp
    ;
primaryExp
    :   LParser exp RParser
    |   number
    ;