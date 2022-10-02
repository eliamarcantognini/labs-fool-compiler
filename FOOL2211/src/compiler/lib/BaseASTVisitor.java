package compiler.lib;

import compiler.AST.*;
import compiler.exc.UnimplException;

import static compiler.lib.FOOLlib.extractNodeName;

public class BaseASTVisitor<S, E extends Exception> {

    protected boolean print; // enables printing
    protected String indent;

    protected BaseASTVisitor() {
    }

    protected BaseASTVisitor(boolean p) {
        print = p;
    }

    protected void printNode(Node n) {
        System.out.println(indent + extractNodeName(n.getClass().getName()));
    }

    protected void printNode(Node n, String s) {
        System.out.println(indent + extractNodeName(n.getClass().getName()) + ": " + s);
    }

    public S visit(Visitable v) throws E {
        if (print) {
            String temp = indent;
            indent = (indent == null) ? "" : indent + "  ";
            try {
                return visitByAcc(v);
            } finally {
                indent = temp;
            }
        } else
            return visitByAcc(v);
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

    //	public S visitNode(ArrowTypeNode n) throws E {throw new UnimplException();}
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


//	public S visit(Visitable v) throws E {
//		return visit(v, "");                //performs unmarked visit
//	}

//when printing marks this visit with string mark
//indent += mark; //inserts mark

//private boolean incomplExc; // enables throwing IncomplException

//protected BaseASTVisitor(boolean ie) { incomplExc = ie; }

//if (v==null) 
//if (incomplExc) throw new IncomplException();
//else return null;



