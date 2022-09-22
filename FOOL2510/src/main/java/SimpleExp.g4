grammar SimpleExp;

// aggiungo un membro al lexer
@lexer::members {
    public int lexicalErrors = 0;
}

// PARSER RULES
// antlr è un parser topdown che fa parsing predittivo

// variabile iniziale
// stiamo matchando dei file di testo, quindi uso EOF per far assicurare al parser
// che il testo sia stato parsato tutto
prog    : exp EOF {System.out.println("Parsing fineshed");};
// E -> E+E | E*E | (E) | n
// <assoc=right> fa l'associazione a destra (<assoc=right> exp PLUS exp), ANTLR di default usa l'associazione a sinistra
// con # do un nome alla produzione
exp     : exp TIMES exp #expProd1
        | exp PLUS exp  #expProd2
        | LPAR exp RPAR #expProd3
        | NUM           #expProd4
        ;

// LEXER RULES
// L'ordine in cui si scrivono le produzioni ne determina la priorità
PLUS    : '+';
TIMES   : '*';
LPAR    : '(';
RPAR    : ')';
// 0 oppure [1-9] seguito da [0-9] opzionale, la stella si riferisce a quello a sx
NUM     : '0' | ('1'..'9')('0'..'9')*;
// il + serve per dire almeno uno (quindi anche più volte), è la chiusura positiva.
// channel(HIDDEN) nasconde il token al parser
WHIESP  : (' ' | '\t' | '\n' | '\r')+ -> channel(HIDDEN);

// . -> un carattere
// .* -> un carattere quante volte voglio
// *? "stella non greedy", "stella non famelica", disattiva il maximal match
// la uso per evitare che .* matchi tutto il programma dall'inizio del commento
// ad esempio avrei problemi con " 4 + /* pippo */ 5 + 7 /* ciao */ * 9
// senza la stella non greedy il commento che parte da '/*' prima di pippo, per la regola di maximal match,
// si chiuderebbe nel '*/' dopo ciao. Quindi il parser riceverebbe 4 + * 9
COMMENT : ('/*') '.*?' ('*/') -> channel(HIDDEN);

// il . sta per "qualsiasi carattere". Tra {} posso mettere del codice Java da eseguire
// getText() è un comando che consente di recuperare il lessema
ERR     : '.' {System.out.println("Invalid char: " + getText()); lexicalErrors++;} -> channel(HIDDEN);




