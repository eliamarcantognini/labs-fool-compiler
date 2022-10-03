package compiler;

import compiler.AST.*;
import compiler.exc.IncomplException;
import compiler.exc.TypeException;
import compiler.lib.BaseEASTVisitor;
import compiler.lib.Node;
import compiler.lib.TypeNode;

import static compiler.lib.FOOLlib.isSubtype;

//visit(n) fa il type checking di un Node n e ritorna: 
//per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode)
//per una dichiarazione, "null"
public class TypeCheckEASTVisitor extends BaseEASTVisitor<TypeNode, TypeException> {

    TypeCheckEASTVisitor() {
        super(true);
    } // enables incomplete tree exceptions

    TypeCheckEASTVisitor(boolean debug) {
        super(true, debug);
    } // enables print for debugging

    @Override
    public TypeNode visitNode(ProgLetInNode n) throws TypeException {
        if (print) printNode(n);
        for (Node dec : n.declist)
            try {
                visit(dec);
            } catch (TypeException e) {
                System.out.println("Type checking error in a declaration: " + e.text);
            } catch (IncomplException e) {

            }
        return visit(n.exp);
    }

    @Override
    public TypeNode visitNode(ProgNode n) throws TypeException {
        if (print) printNode(n);
        return visit(n.exp);
    }

    @Override
    public TypeNode visitNode(FunNode n) throws TypeException {
        if (print) printNode(n, n.id);
        visit(n.retType);
//        for (ParNode par : n.parlist) visit(par); // per le funzioni non faccio il check sui tipi dei parametri
        for (Node dec : n.declist)
            try {
                visit(dec);
            } catch (TypeException e) { // per le funzioni faccio il check sulle dichiarazioni localmente
                System.out.println("Type checking error in a declaration: " + e.text);
            } catch (IncomplException e) {

            }
        visit(n.exp);
        if (!isSubtype(visit(n.exp), n.retType))
            throw new TypeException("Wrong return type for function " + n.id, n.getLine());
        return null;
    }

    @Override
    public TypeNode visitNode(VarNode n) throws TypeException {
        if (print) printNode(n, n.id);
        visit(n.type);
        if (!isSubtype(visit(n.exp), n.type))
            throw new TypeException("Incompatible value for variable " + n.id, n.getLine());
        return null; // no type for a declaration
    }

    @Override
    public TypeNode visitNode(PrintNode n) throws TypeException {
        if (print) printNode(n);
        return visit(n.exp);
    }


    @Override
    public TypeNode visitNode(IfNode n) throws TypeException {
        if (print) printNode(n);
        if (!isSubtype(visit(n.cond), new BoolTypeNode()))
            throw new TypeException("Non boolean condition in if", n.getLine());
        var th = visit(n.th);
        var el = visit(n.el);
        if (isSubtype(th, el)) return el;
        if (isSubtype(el, th)) return th;
        throw new TypeException("Incompatible branches in then-else branches", n.getLine());
    }

    @Override
    public TypeNode visitNode(EqualNode n) throws TypeException {
        if (print) printNode(n);
        var l = visit(n.left);
        var r = visit(n.right);
        if (!isSubtype(l, r) || !isSubtype(r, l)) throw new TypeException("Incompatible types in equal", n.getLine());
        return new BoolTypeNode();
    }

    @Override
    public TypeNode visitNode(TimesNode n) throws TypeException {
        if (print) printNode(n);
        if (!isSubtype(visit(n.left), new IntTypeNode()) && !isSubtype(visit(n.right), new IntTypeNode()))
            throw new TypeException("Non integers in multiplication", n.getLine());
        return new IntTypeNode();
    }

    @Override
    public TypeNode visitNode(PlusNode n) throws TypeException {
        if (print) printNode(n);
        if (!isSubtype(visit(n.left), new IntTypeNode()) && !isSubtype(visit(n.right), new IntTypeNode()))
            throw new TypeException("Non integers in sum", n.getLine());
        return new IntTypeNode();
    }

    @Override
    public TypeNode visitNode(CallNode n) throws TypeException {
        if (print) printNode(n, n.id);
        var t = visit(n.entry);
        if (!(t instanceof ArrowTypeNode at)) throw new TypeException("Calling a non function " + n.id, n.getLine());
        if (at.parlist.size() != n.arglist.size())
            throw new TypeException("Wrong number of arguments in call to " + n.id, n.getLine());
        for (Node arg : n.arglist)
            if (!isSubtype(visit(arg), (at.parlist.get(n.arglist.indexOf(arg)))))
                throw new TypeException("Wrong type for argument " + n.arglist.indexOf(arg) + " in call to " + n.id, n.getLine());
        return at.ret;
    }

    @Override
    public TypeNode visitNode(IdNode n) throws TypeException {
        if (print) printNode(n, n.id);
        var t = visit(n.entry);
        if (t instanceof ArrowTypeNode) {
            throw new TypeException("Wrong usage of function identifier " + n.id, n.getLine());
        }
        return t;
    }

    @Override
    public TypeNode visitNode(BoolNode n) {
        if (print) printNode(n, n.val.toString());
        return new BoolTypeNode();
    }

    @Override
    public TypeNode visitNode(IntNode n) {
        if (print) printNode(n, n.val.toString());
        return new IntTypeNode();
    }

    @Override
    public TypeNode visitNode(ArrowTypeNode n) throws TypeException {
        if (print) printNode(n);
        for (Node par : n.parlist) visit(par);
        visit(n.ret, "->"); //marks return type
        return null;
    }

    @Override
    public TypeNode visitNode(BoolTypeNode n) {
        if (print) printNode(n);
        return null;
    }

    @Override
    public TypeNode visitNode(IntTypeNode n) {
        if (print) printNode(n);
        return null;
    }

    @Override
    public TypeNode visitSTentry(STentry entry) throws TypeException {
        if (print) printSTentry("type");
        visit(entry.type);
        return entry.type;
    }

}