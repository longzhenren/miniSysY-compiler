#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
int isReserve(char str[])
{
  if (strcmp(str, "if")==0)
  {
    printf("If\n");
    return 1;
  }
  else if (strcmp(str, "else")==0)
  {
    printf("Else\n");
    return 1;
  }
  else if (strcmp(str, "while")==0)
  {
    printf("While\n");
    return 1;
  }
  else if (strcmp(str, "break")==0)
  {
    printf("Break\n");
    return 1;
  }
  else if (strcmp(str, "continue")==0)
  {
    printf("Continue\n");
    return 1;
  }
  else if (strcmp(str, "return")==0)
  {
    printf("Return\n");
    return 1;
  }
  else
  {
    return 0;
  }
}
int main()
{
  char ch = 0;
  char token[1024];
  int errcode=0;
  while (1)
  {
    memset(token, 0, sizeof(token));
    int t_ptr = 0;
    while (1)
    {
      ch = getc(stdin);
      if (!isspace(ch))
        break;
    }
    if (ch == EOF)
    {
      break;
    }
    if (errcode==1){
      printf("Err\n");
      return 0;
    }
    if (isalpha(ch)||ch=='_')
    {
      while (isalnum(ch)||ch=='_')
      {
        token[t_ptr++] = ch;
        ch = getc(stdin);
      }
      token[t_ptr++] = 0;
      ungetc(ch, stdin);
      if (!isReserve(token))
      {
        printf("Ident(%s)\n", token);
      }
    }
    else if (isdigit(ch))
    {
      while (isdigit(ch))
      {
        token[t_ptr++] = ch;
        ch = getc(stdin);
      }
      token[t_ptr++] = 0;
      ungetc(ch, stdin);
      printf("Number(%s)\n", token);
    }
    else
    {
      switch (ch)
      {
      case '+':
        printf("Plus\n");
        break;
      case '*':
        printf("Mult\n");
        break;
      case '/':
        printf("Div\n");
        break;
      case '<':
        printf("Lt\n");
        break;
      case '>':
        printf("Gt\n");
        break;
      case '=':
        ch = getc(stdin);
        if (ch == '=')
        {
          printf("Eq\n");
        }
        else
        {
          ungetc(ch, stdin);
          printf("Assign\n");
        }
        break;
      case ';':
        printf("Semicolon\n");
        break;
      case '(':
        printf("LPar\n");
        break;
      case ')':
        printf("RPar\n");
        break;
      case '{':
        printf("LBrace\n");
        break;
      case '}':
        printf("RBrace\n");
        break;
      default:
        errcode = 1;
        // printf("RBrace\n");
        break;
        // break;
      }
    }
  }
}