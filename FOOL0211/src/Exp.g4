grammar Exp;

@lexer::members {
public int lexicalErrors=0;
}

// PARSER RULES

prog : exp EOF {System.out.println("Parsing finished!");} ;
 
exp     : exp TIMES exp  #expProd1 // <assoc=right> exp TIMES exp
        | exp PLUS exp   #expProd2 // <assoc=right> exp PLUS exp
        | LPAR exp RPAR  #expProd3
        | NUM            #expProd4
        ;
          
// LEXER RULES
	
PLUS	: '+' ;
TIMES	: '*' ;
LPAR    : '(' ;
RPAR    : ')' ;
NUM     : '0' | ('1'..'9')('0'..'9')* ;

WHITESP	: (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN) ;
COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;

ERR 	: . {System.out.println("Invalid char: "+ getText()); lexicalErrors++;} -> channel(HIDDEN) ; 



