package compiler;

import compiler.AST.IntNode;
import compiler.AST.PlusNode;
import compiler.AST.ProgNode;
import compiler.AST.TimesNode;
import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

public class PrintASTVisitor extends BaseASTVisitor<Void> {

    PrintASTVisitor() {
        super(true);
    }

    String indent;

    public Void visitNode(ProgNode n) {
        printNode(n);
        visit(n.exp);
        return null;
    }

    public Void visitNode(PlusNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    public Void visitNode(TimesNode n) {
        printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    public Void visitNode(IntNode n) {
        printNode(n, n.val.toString());
        return null;
    }
}





