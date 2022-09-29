package compiler.lib;

import compiler.AST.*;

public class BaseASTVisitor<S> {

    protected BaseASTVisitor() {
    }

    protected BaseASTVisitor(final boolean debug) {
        this.print = debug;
    }

    protected Boolean print = false;
    String indent;

    protected void printNode(Node n) {
        System.out.println(indent + extractNodeName(n.getClass().getName()));
    }

    protected void printNode(Node n, String s) {
        System.out.println(indent + extractNodeName(n.getClass().getName()) + ": " + s);
    }

    protected String extractNodeName(String s) { // s is in the form compiler.AST$NameNode
        return s.substring(s.lastIndexOf('$') + 1, s.length() - 4);
    }
    public S visit(Node n) {
        if (print) {
            String temp = indent;
            indent = (indent == null) ? "" : indent + "  ";
            var res = visitByAccept(n);
            indent = temp;
            return res;
        } else {
            return visitByAccept(n);
        }
    }

    public S visitByAccept(Node n) {
        return n.accept(this); //performs the "n"-specific visit
    }

    public S visitNode(ProgNode n) {
        throw new UnimplException();
    }

    public S visitNode(PlusNode n) {
        throw new UnimplException();
    }

    public S visitNode(TimesNode n) {
        throw new UnimplException();
    }

    public S visitNode(IntNode n) {
        throw new UnimplException();
    }

    public S visitNode(EqualNode n) {
        throw new UnimplException();
    }

    public S visitNode(BoolNode n) {
        throw new UnimplException();
    }

    public S visitNode(IfNode n) {
        throw new UnimplException();
    }

    public S visitNode(PrintNode n) {
        throw new UnimplException();
    }
}
