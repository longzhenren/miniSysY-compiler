//grammar P1;
//
//
//LParser     :'(';
//RParser     :')';
//LBrace      :'{';
//RBrace      :'}';
////Ret         :'\r\n' | '\n' | '\r';
//Return      :'return';
//Semicolumn  :';';
//WhiteSpace  : [ \t\n] : skip;
//FuncType    : 'int';
//Ident       : 'main';
//
//HexadecimalPrefix : '0x' | '0X';
//Digit             : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
//NonzeroDigit      : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
//OctalDigit        : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7';
//HexadecimalDigit  : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
//                      | 'a' | 'b' | 'c' | 'd' | 'e' | 'f'
//                      | 'A' | 'B' | 'C' | 'D' | 'E' | 'F';
//
//
//DecimalConst      : NonzeroDigit (Digit)*;
//OctalConst        : '0' (OctalDigit)*;
//HexadecimalConst  : HexadecimalPrefix (HexadecimalDigit)*;
//
//compUnit: funcDef;
//funcDef : FuncType Ident LParser RParser block;
//block   : LBrace stmt RBrace;
//stmt    : Return number Semicolumn;
//number  : DecimalConst | OctalConst | HexadecimalConst;



grammar P1;


LParser     :'(';
RParser     :')';
LBrace      :'{';
RBrace      :'}';
//Ret         :'\r\n' | '\n' | '\r';
RETURN_KW   :'return';
INT_KW      :'int';
Semicolumn  :';';
WhiteSpace  : [ \r\n\t] -> skip;
FuncIdent       : 'main';
DecimalConst      : [1-9] [0-9]*;
OctalConst        : [0] [0-7]*;
HexadecimalConst  : [0] [xX] [0-9a-fA-F]+;
BlockComment      :   '/*' .*? '*/' -> skip;
LineComment       :   '//' ~[\r\n]* -> skip;

compUnit: funcDef;
funcType: INT_KW;
funcIdent:FuncIdent;
funcDef : funcType funcIdent LParser RParser block;
block   : LBrace stmt RBrace;
stmt    : reteurnStmt;
number  : intConst;
intConst: DecimalConst | OctalConst | HexadecimalConst;
reteurnStmt:RETURN_KW number Semicolumn;
