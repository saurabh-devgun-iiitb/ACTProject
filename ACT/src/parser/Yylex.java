package parser;
import java_cup.runtime.*;
import graph.*;
import java.lang.System;
enum TokenType{SYSTEM,STATES,STATE,STATEID,DESC,INPUT,CLICKABLE,TRANSITION,GUARD,TRIGGER,ACTION,TRANSITIONID,ID,LOGEXPR,CLICKELE,LPAREN,
					RPAREN,LBRACKET,RBRACKET,LBRACES,RBRACES,LANGBRACKET,RANGBRACKET,COMMA}


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

  private int comment_count = 0;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int COMMENT = 1;
	private final int yy_state_dtrans[] = {
		0,
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NO_ANCHOR,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"32:8,31:3,32:2,0,32:18,31,32:7,7,8,32:2,2,32,3,32,30:10,1,32:2,4,32:3,16,25" +
",18,17,14,30,28,30,19,30,24,23,15,20,27,21,30,26,11,13,22,29,30:2,12,30,32," +
"9,32:4,30:13,10,30:12,5,32,6,32:2,33:2")[0];

	private int yy_rmap[] = unpackFromString(1,76,
"0,1:8,2,3,1:2,4:13,1,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24" +
",25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49" +
",50,51,52,53")[0];

	private int yy_nxt[][] = unpackFromString(54,34,
"-1,1,2,3,4,5,6,7,8,9,25,49,25,70,25:2,50,51,75,60,25:8,61,25:2,10,26,11,-1:" +
"44,12,-1:54,10,-1:12,25:21,-1:13,25:4,13,25:16,-1:13,25:9,14,25:11,-1:13,25" +
":3,15,25:4,16,25:12,-1:13,25:4,17,25:16,-1:13,25:3,18,25:17,-1:13,25:7,19,2" +
"5:13,-1:13,25:5,20,25:15,-1:13,25:4,21,25:16,-1:13,25:16,22,25:4,-1:13,25:4" +
",23,25:16,-1:13,25:10,24,25:10,-1:13,25:19,27,25,-1:13,25:3,28,25:17,-1:13," +
"25,29,25:19,-1:13,25:3,30,25:17,-1:13,25:12,31,25:8,-1:13,25:16,32,25:4,-1:" +
"13,25:4,33,25:16,-1:13,25:8,34,25:12,-1:13,25:4,35,25:16,-1:13,25:13,36,25:" +
"7,-1:13,25:17,37,25:3,-1:13,25:2,62,52,25:2,38,25:10,63,25:3,-1:13,25:8,39," +
"25:12,-1:13,25:4,40,25:16,-1:13,25:6,41,25:14,-1:13,25:11,42,25:9,-1:13,25:" +
"6,43,25:14,-1:13,25:3,44,25:17,-1:13,25:16,45,25:4,-1:13,25:18,46,25:2,-1:1" +
"3,25:15,47,25:5,-1:13,25:9,48,25:11,-1:13,25:10,53,25:10,-1:13,25:12,54,25:" +
"8,-1:13,25,55,25:19,-1:13,25:12,56,25:8,-1:13,25:18,57,25:2,-1:13,25:6,58,2" +
"5:14,-1:13,25:3,59,25:17,-1:13,25:6,74,25:2,64,25:11,-1:13,25:14,65,25:6,-1" +
":13,25:9,66,25:11,-1:13,25:16,67,25:4,-1:13,25:8,68,25:12,-1:13,25,69,25:19" +
",-1:13,25:9,71,25:11,-1:13,25:10,72,25:10,-1:13,25:13,73,25:7,-1:3");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 0:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -2:
						break;
					case 1:
						{ System.out.println("Lex: colon");return new Symbol(sym.COLON); }
					case -3:
						break;
					case 2:
						{ System.out.println("Lex: comma");return new Symbol(sym.COMMA); }
					case -4:
						break;
					case 3:
						{ System.out.println("Lex: dot");return new Symbol(sym.DOT); }
					case -5:
						break;
					case 4:
						{ System.out.println("Lex: equal");return new Symbol(sym.EQUAL); }
					case -6:
						break;
					case 5:
						{ System.out.println("Lex: {");return new Symbol(sym.LBRACE); }
					case -7:
						break;
					case 6:
						{ System.out.println("Lex: }");return new Symbol(sym.RBRACE); }
					case -8:
						break;
					case 7:
						{ System.out.println("Lex: (");return new Symbol(sym.openBracket); }
					case -9:
						break;
					case 8:
						{ System.out.println("Lex: )");return new Symbol(sym.closeBracket); }
					case -10:
						break;
					case 9:
						{System.out.println("Lex: Illegal character: <" + yytext() + ">");}
					case -11:
						break;
					case 10:
						{ }
					case -12:
						break;
					case 11:
						
					case -13:
						break;
					case 12:
						{; }
					case -14:
						break;
					case 13:
						{ System.out.println("Lex: save");return new Symbol(sym.SAVE); }
					case -15:
						break;
					case 14:
						{ System.out.println("Lex: action");return new Symbol(sym.ACTI); }
					case -16:
						break;
					case 15:
						{ System.out.println("Lex: dest");return new Symbol(sym.DEST); }
					case -17:
						break;
					case 16:
						{ System.out.println("Lex: desc");return new Symbol(sym.DESC); }
					case -18:
						break;
					case 17:
						{ System.out.println("Lex: state");return new Symbol(sym.STATE); }
					case -19:
						break;
					case 18:
						{ System.out.println("Lex: input");return new Symbol(sym.INPUT); }
					case -20:
						break;
					case 19:
						{ System.out.println("Lex: guard");return new Symbol(sym.GUARD); }
					case -21:
						break;
					case 20:
						{ System.out.println("Lex: system");return new Symbol(sym.SYSTEM); }
					case -22:
						break;
					case 21:
						{ System.out.println("Lex: source");return new Symbol(sym.SOURCE); }
					case -23:
						break;
					case 22:
						{ System.out.println("Lex: trigger");return new Symbol(sym.TRIGGER); }
					case -24:
						break;
					case 23:
						{ System.out.println("Lex: clickable");return new Symbol(sym.CLICKABLE); }
					case -25:
						break;
					case 24:
						{ System.out.println("Lex: transition");return new Symbol(sym.TRANSITION); }
					case -26:
						break;
					case 25:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -27:
						break;
					case 26:
						{System.out.println("Lex: Illegal character: <" + yytext() + ">");}
					case -28:
						break;
					case 27:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -29:
						break;
					case 28:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -30:
						break;
					case 29:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -31:
						break;
					case 30:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -32:
						break;
					case 31:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -33:
						break;
					case 32:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -34:
						break;
					case 33:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -35:
						break;
					case 34:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -36:
						break;
					case 35:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -37:
						break;
					case 36:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -38:
						break;
					case 37:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -39:
						break;
					case 38:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -40:
						break;
					case 39:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -41:
						break;
					case 40:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -42:
						break;
					case 41:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -43:
						break;
					case 42:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -44:
						break;
					case 43:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -45:
						break;
					case 44:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -46:
						break;
					case 45:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -47:
						break;
					case 46:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -48:
						break;
					case 47:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -49:
						break;
					case 48:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -50:
						break;
					case 49:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -51:
						break;
					case 50:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -52:
						break;
					case 51:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -53:
						break;
					case 52:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -54:
						break;
					case 53:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -55:
						break;
					case 54:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -56:
						break;
					case 55:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -57:
						break;
					case 56:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -58:
						break;
					case 57:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -59:
						break;
					case 58:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -60:
						break;
					case 59:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -61:
						break;
					case 60:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -62:
						break;
					case 61:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -63:
						break;
					case 62:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -64:
						break;
					case 63:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -65:
						break;
					case 64:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -66:
						break;
					case 65:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -67:
						break;
					case 66:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -68:
						break;
					case 67:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -69:
						break;
					case 68:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -70:
						break;
					case 69:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -71:
						break;
					case 70:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -72:
						break;
					case 71:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -73:
						break;
					case 72:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -74:
						break;
					case 73:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -75:
						break;
					case 74:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -76:
						break;
					case 75:
						{System.out.println("Lex: string/ID");System.out.println("LEX:"+yytext());return new Symbol(sym.ID, new String(yytext()));}
					case -77:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
