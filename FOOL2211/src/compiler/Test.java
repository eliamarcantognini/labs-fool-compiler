package compiler;

import compiler.lib.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Test {
    public static void main(String[] args) throws Exception {

        String fileName = "prova.fool";

        CharStream chars = CharStreams.fromFileName(fileName);
        FOOLLexer lexer = new FOOLLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);

        System.out.println("Generating ST via lexer and parser.");
        ParseTree st = parser.prog();
        System.out.println("You had " + lexer.lexicalErrors + " lexical errors and " +
                parser.getNumberOfSyntaxErrors() + " syntax errors.\n");

        System.out.println("Generating AST.");
        ASTGenerationSTVisitor visitor = new ASTGenerationSTVisitor(); // use true to visualize the ST
        Node ast = visitor.visit(st);
        System.out.println("");

        System.out.println("Enriching AST via symbol table.");
        SymbolTableASTVisitor symtableVisitor = new SymbolTableASTVisitor();
        symtableVisitor.visit(ast);
        System.out.println("You had " + symtableVisitor.stErrors + " symbol table errors.\n");

        System.out.println("Visualizing Enriched AST.");
        new PrintEASTVisitor().visit(ast);
        System.out.println("");

//    	System.out.println("Checking Types.");
//    	TypeCheckEASTVisitor typeCheckVisitor = new TypeCheckEASTVisitor();
//    	TypeNode mainType = typeCheckVisitor.visit(ast);
//    	System.out.print("Type of main program expression is: ");
//    	new PrintEASTVisitor().visit(mainType);
//    	System.out.println("You had "+FOOLlib.typeErrors+" type checking errors.\n");
//
//    	int frontEndErrors = lexer.lexicalErrors+parser.getNumberOfSyntaxErrors()+symtableVisitor.stErrors+FOOLlib.typeErrors;
//    	System.out.println("You had a total of "+frontEndErrors+" front-end errors.\n");

    }
}


//    	} catch (TypeException e) {
//    		System.out.println("Type checking error in main program expression: "+e.text);     		


//    	} catch (IncomplException e) {    		
//    		System.out.println("Could not determine main program expression type due to errors detected before type checking.");

    		    	



