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
    :   lVal ASSIGN exp Semicolumn
    |   (exp)+ Semicolumn
    |   reteurnStmt
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
    |   lVal
    |   number
    ;
decl
    :   constDecl
    |   varDecl
    ;
constDecl
    :   CONST_KW bType constDef (',' constDef)* Semicolumn
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
    :   bType varDef (',' varDef)* Semicolumn
    ;
varDef
    :   Ident
    |   Ident ASSIGN initVal
    ;
initVal
    :   exp
    ;


//define dso_local i32 @main() #0 {
//  %1 = alloca i32, align 4
//  %2 = alloca i32, align 4
//  %3 = alloca i32, align 4
//  %4 = alloca i32, align 4
//  %5 = alloca i32, align 4
//  store i32 0, i32* %1, align 4
//  store i32 3, i32* %4, align 4
//  %6 = load i32, i32* %2, align 4
//  %7 = mul nsw i32 %6, -1
//  %8 = add nsw i32 2, %7
//  store i32 %8, i32* %5, align 4
//  %9 = load i32, i32* %3, align 4
//  %10 = add nsw i32 %9, 1
//  %11 = load i32, i32* %5, align 4
//  %12 = sub nsw i32 0, %11
//  %13 = add nsw i32 %10, %12
//  store i32 %13, i32* %2, align 4
//  %14 = load i32, i32* %2, align 4
//  %15 = load i32, i32* %3, align 4
//  %16 = add nsw i32 %14, %15
//  %17 = add nsw i32 %16, 1
//  store i32 %17, i32* %4, align 4
//  %18 = load i32, i32* %4, align 4
//  %19 = load i32, i32* %2, align 4
//  %20 = sdiv i32 %18, %19
//  ret i32 %20
//}

//出现变量名时候去查寄存器分配表，并使用load加载值
//等号右侧出现变量时新分配一个寄存器存储左值，并将左值赋给左侧符号对应的寄存器
//纯数字算式直接使用运算结果进行赋值

//int main(){
//    int a,b,c=3;
//    const int s = 2 + (a * (-1));
//    a = b+1 + -s;
//    c = a + b + 1;
//    return c/a;
//}


//int main(){
//    int a,c=3+(-1);
//    const int s = 2 + (a * (-1));
//    return a+b+c-s;
//}

//define dso_local i32 @main() #0 {
//  %1 = alloca i32, align 4
//  %2 = alloca i32, align 4
//  %3 = alloca i32, align 4
//  %4 = alloca i32, align 4
//  store i32 0, i32* %1, align 4
//  store i32 2, i32* %3, align 4
//  store i32 3, i32* %2, align 4
//  %5 = load i32, i32* %2, align 4
//  %6 = mul nsw i32 %5, -1
//  %7 = add nsw i32 2, %6
//  store i32 %7, i32* %4, align 4
//  %8 = load i32, i32* %2, align 4
//  %9 = load i32, i32* %3, align 4
//  %10 = add nsw i32 %8, %9
//  %11 = load i32, i32* %4, align 4
//  %12 = sub nsw i32 %10, %11
//  ret i32 %12
//}

//int main(){
//    int a=3;
//    int c=3+(-1)*a;
//    return a+c;
//}
//define dso_local i32 @main() #0 {
//  %1 = alloca i32, align 4
//  %2 = alloca i32, align 4
//  %3 = alloca i32, align 4
//  store i32 0, i32* %1, align 4
//  store i32 3, i32* %2, align 4
//  %4 = load i32, i32* %2, align 4
//  %5 = mul nsw i32 -1, %4
//  %6 = add nsw i32 3, %5
//  store i32 %6, i32* %3, align 4
//  %7 = load i32, i32* %2, align 4
//  %8 = load i32, i32* %3, align 4
//  %9 = add nsw i32 %7, %8
//  ret i32 %9
//}
