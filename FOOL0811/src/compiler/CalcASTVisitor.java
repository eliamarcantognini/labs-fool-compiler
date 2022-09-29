package compiler;

import compiler.AST.*;
import compiler.lib.BaseASTVisitor;

import java.util.Objects;

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
        if (print) printNode(n, ": " + n.val);
        return n.val;
    }

    @Override
    public Integer visitNode(EqualNode n) {
        if (print) printNode(n);
        return Objects.equals(visit(n.left), visit(n.right)) ? 1 : 0;
    }

    @Override
    public Integer visitNode(BoolNode n) {
        if (print) printNode(n, ": " + n.val.toString());
        return n.val ? 1 : 0;
    }

    @Override
    public Integer visitNode(IfNode n) {
        if (print) printNode(n);
        return visit(n.cond)==1 ? visit(n.thenStm) : visit(n.elseStm);
    }

    @Override
    public Integer visitNode(PrintNode n) {
        if (print) printNode(n);
        return visit(n.exp);
    }
}


