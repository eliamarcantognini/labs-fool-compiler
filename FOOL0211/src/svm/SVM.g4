grammar SVM;

@header {
import java.util.HashMap;
}

@lexer::members {
int lexicalErrors=0;
}

@parser::members {
int[] code = new int[ExecuteVM.CODESIZE];
private int i = 0;

private HashMap<String,Integer> labelDef = new HashMap<String,Integer>();
private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

assembly: instruction* EOF ;

instruction:
        PUSH INTEGER //push INTEGER on the stack
	  | PUSH LABEL 	 //push the location address pointed by LABEL on the stack
	  | POP		//pop the top of the stack
	  | ADD		//replace the two values on top of the stack with their sum
	  | SUB		//pop the two values v1 and v2 (respectively) and push v2-v1
	  | MULT	//replace the two values on top of the stack with their product
	  | DIV		//pop the two values v1 and v2 (respectively) and push v2/v1
	  | STOREW	///pop two values:
	  		//  the second one is written at the memory address pointed by the first one
	  | LOADW       ///read the content of the memory cell pointed by the top of the stack
	                //  and replace the top of the stack with such value
	  | LABEL COL   //LABEL points at the location of the subsequent instruction
	  | BRANCH LABEL      //jump at the instruction pointed by LABEL
	  | BRANCHEQ LABEL    //pop two values and jump if they are equal
	  | BRANCHLESSEQ LABEL  //pop two values and jump if the second one is less or equal to the first one
	  | JS                ///pop one value from the stack:
	  		      //  copy the instruction pointer in the RA register and jump to the popped value
	  | LOADRA      ///push in the stack the content of the RA register
	  | STORERA     ///pop the top of the stack and copy it in the RA register
	  | LOADTM      //push in the stack the content of the TM register
	  | STORETM     //pop the top of the stack and copy it in the TM register
	  | LOADFP      ///push in the stack the content of the FP register
	  | STOREFP     ///pop the top of the stack and copy it in the FP register
	  | COPYFP      ///copy in the FP register the currest stack pointer
	  | LOADHP      ///push in the stack the content of the HP register
	  | STOREHP     ///pop the top of the stack and copy it in the HP register
	  | PRINT       //visualize the top of the stack without removing it
	  | HALT        //terminate the execution
	  ;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PUSH		: 'push' ;
POP	 		: 'pop' ;
ADD	 		: 'add' ;
SUB	 		: 'sub' ;
MULT	 	: 'mult' ;
DIV	 		: 'div' ;
STOREW	 	: 'sw' ;
LOADW	 	: 'lw' ;
BRANCH	 	: 'b' ;
BRANCHEQ 	: 'beq' ;
BRANCHLESSEQ: 'bleq' ;
JS	 		: 'js' ;
LOADRA	 	: 'lra' ;
STORERA  	: 'sra' ;
LOADTM	 	: 'ltm' ;
STORETM  	: 'stm' ;
LOADFP	 	: 'lfp' ;
STOREFP	 	: 'sfp' ;
COPYFP   	: 'cfp' ;
LOADHP	 	: 'lhp' ;
STOREHP	 	: 'shp' ;
PRINT	 	: 'print' ;
HALT	 	: 'halt' ;

COL	 		: ':' ;
LABEL	 	: ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
INTEGER	 	: '0' | ('-')?(('1'..'9')('0'..'9')*) ;

WHITESP  	: (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN) ;

ERR	     	: . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN);
