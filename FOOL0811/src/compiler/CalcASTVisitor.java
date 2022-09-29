package compiler;

import compiler.AST.IntNode;
import compiler.AST.PlusNode;
import compiler.AST.ProgNode;
import compiler.AST.TimesNode;
import compiler.lib.BaseASTVisitor;

public class CalcASTVisitor extends BaseASTVisitor<Integer> {
    CalcASTVisitor() {
    }

    CalcASTVisitor(boolean debug) {
        super(debug);
    } // enables print for debugging

    @Override
    public Integer visitNode(ProgNode n) {
	   if (print) printNode(n);
        return visit(n.exp);
    }

    @Override
    public Integer visitNode(PlusNode n) {
		if (print) printNode(n);
        return visit(n.left) + visit(n.right);
    }

    @Override
    public Integer visitNode(TimesNode n) {
		if (print) printNode(n);
        return visit(n.left) * visit(n.right);
    }

    @Override
    public Integer visitNode(IntNode n) {
		if (print) printNode(n,": "+n.val);
        return n.val;
    }

}


