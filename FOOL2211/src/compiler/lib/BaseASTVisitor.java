package compiler.lib;

import compiler.AST.*;
import compiler.exc.IncomplException;
import compiler.exc.UnimplException;

import static compiler.lib.FOOLlib.extractNodeName;

public class BaseASTVisitor<S, E extends Exception> {

    protected boolean print; // enables printing
    protected String indent;
    private boolean incomplExc; // enables throwing IncomplException


    protected BaseASTVisitor() {
    }

    protected BaseASTVisitor(boolean ie) {
        incomplExc = ie;
    }

    protected BaseASTVisitor(boolean ie, boolean p) {
        incomplExc = ie;
        print = p;
    }

    protected void printNode(Node n) {
        System.out.println(indent + extractNodeName(n.getClass().getName()));
    }

    protected void printNode(Node n, String s) {
        System.out.println(indent + extractNodeName(n.getClass().getName()) + ": " + s);
    }

    public S visit(Visitable v, String mark) throws E {
        if (v == null) if (incomplExc) throw new IncomplException();
        else return null;
        if (print) {
            String temp = indent;
            indent = (indent == null) ? "" : indent + "  ";
            indent += mark;
            try {
                return visitByAcc(v);
            } finally {
                indent = temp;
            }
        } else return visitByAcc(v);
    }

    public S visit(Visitable v) throws E {
        return visit(v, "");                //performs unmarked visit
    }

    S visitByAcc(Visitable v) throws E {
        return v.accept(this);
    }

    public S visitNode(ProgLetInNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(ProgNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(FunNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(ParNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(VarNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(ArrowTypeNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(BoolTypeNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(IntTypeNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(PrintNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(IfNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(EqualNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(TimesNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(PlusNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(CallNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(IdNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(BoolNode n) throws E {
        throw new UnimplException();
    }

    public S visitNode(IntNode n) throws E {
        throw new UnimplException();
    }

}






