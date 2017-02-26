package parser;

import java_cup.runtime.*;
import graph.*;
import java.lang.System;
enum TokenType{SYSTEM,STATES,STATE,STATEID,DESC,INPUT,CLICKABLE,TRANSITION,GUARD,TRIGGER,ACTION,TRANSITIONID,ID,LOGEXPR,CLICKELE,LPAREN,
					RPAREN,LBRACKET,RBRACKET,LBRACES,RBRACES,LANGBRACKET,RANGBRACKET,COMMA}



%%

%{
  private int comment_count = 0;
%}
%cup
%line
%char
%state COMMENT

ALPHA=[A-Za-z]
DIGIT=[0-9]
NONNEWLINE_WHITE_SPACE_CHAR=[\ \t\b\012]
WHITE_SPACE_CHAR=[\n\ \t\b\012]
STRING_TEXT=(\\\"|[^\n\"]|\\{WHITE_SPACE_CHAR}+\\)*
COMMENT_TEXT=([^/*\n]|[^*\n]"/"[^*\n]|[^/\n]"*"[^/\n]|"*"[^/\n]|"/"[^*\n])*
LOGICAL_EXPR=(\\|[^\n\"]|\\{WHITE_SPACE_CHAR}+\\)*
CLICK=(#[^\n]*[#])
%% 
":" { System.out.println("Lex: colon");return new Symbol(sym.COLON); }
"," { System.out.println("Lex: comma");return new Symbol(sym.COMMA); }
"." { System.out.println("Lex: dot");return new Symbol(sym.DOT); }
"=" { System.out.println("Lex: equal");return new Symbol(sym.EQUAL); }
"{" { System.out.println("Lex: {");return new Symbol(sym.LBRACE); }
"}" { System.out.println("Lex: }");return new Symbol(sym.RBRACE); }
"(" { System.out.println("Lex: (");return new Symbol(sym.openBracket); }
")" { System.out.println("Lex: )");return new Symbol(sym.closeBracket); }

"\n" {; }
SYSTEM { System.out.println("Lex: system");return new Symbol(sym.SYSTEM); }
STATE { System.out.println("Lex: state");return new Symbol(sym.STATE); }
DESC { System.out.println("Lex: desc");return new Symbol(sym.DESC); }
INPUT { System.out.println("Lex: input");return new Symbol(sym.INPUT); }
CLICKABLE { System.out.println("Lex: clickable");return new Symbol(sym.CLICKABLE); }
TRANSITION { System.out.println("Lex: transition");return new Symbol(sym.TRANSITION); }
SOURCE { System.out.println("Lex: source");return new Symbol(sym.SOURCE); }
DEST { System.out.println("Lex: dest");return new Symbol(sym.DEST); }
TRIGGER { System.out.println("Lex: trigger");return new Symbol(sym.TRIGGER); }
GUARD { System.out.println("Lex: guard");return new Symbol(sym.GUARD); }
ACTI { System.out.println("Lex: action");return new Symbol(sym.ACTI); }
SAVE { System.out.println("Lex: save");return new Symbol(sym.SAVE); }
[A-Za-z0-9]* {System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
[0-9]+ { System.out.println("Lex: number");return new Symbol(sym.NUMBER, new Integer(yytext())); }

{NONNEWLINE_WHITE_SPACE_CHAR}+ { }
. {System.out.println("Lex: Illegal character: <" + yytext() + ">");}

