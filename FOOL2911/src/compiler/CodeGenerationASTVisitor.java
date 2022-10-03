package compiler;

import compiler.AST.*;
import compiler.exc.VoidException;
import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

import static compiler.lib.FOOLlib.freshLabel;
import static compiler.lib.FOOLlib.nlJoin;

public class CodeGenerationASTVisitor extends BaseASTVisitor<String, VoidException> {

    CodeGenerationASTVisitor() {
    }

    CodeGenerationASTVisitor(boolean debug) {
        super(false, debug);
    } //enables print for debugging

    @Override
    public String visitNode(ProgLetInNode n) {
        if (print) printNode(n);
        String declCode = "";
        for (Node dec : n.declist) declCode += nlJoin(declCode, visit(dec));
        visit(n.exp);
        return nlJoin(
                declCode, // generate code for declarations
                visit(n.exp),
                "halt"
        );
    }

    @Override
    public String visitNode(ProgNode n) {
        if (print) printNode(n);
        visit(n.exp);
        return nlJoin(
                visit(n.exp),
                "halt"
        );
    }

    @Override
    public String visitNode(FunNode n) {
        if (print) printNode(n, n.id);
        for (ParNode par : n.parlist) visit(par);
        for (Node dec : n.declist) visit(dec);
        visit(n.exp);
        return null;
        //return nlJoin();
    }

    @Override
    public String visitNode(VarNode n) {
        if (print) printNode(n, n.id);
        visit(n.exp);
        return visit(n.exp);
    }

    @Override
    public String visitNode(PrintNode n) {
        if (print) printNode(n);
        return nlJoin(
                visit(n.exp),
                "print"
        );
    }

    @Override
    public String visitNode(IfNode n) {
        if (print) printNode(n);
        var l1 = freshLabel();
        var l2 = freshLabel();
        return nlJoin(
                visit(n.cond),
                "push 1",
                "beq " + l1,
                visit(n.el),
                "b " + l2,
                l1 + ":",
                visit(n.th),
                l2 + ":"
        );
    }

    @Override
    public String visitNode(EqualNode n) {
        if (print) printNode(n);
        var l1 = freshLabel();
        var l2 = freshLabel();
        return nlJoin(
                visit(n.left),
                visit(n.right),
                "beq " + l1,
                "push 0",
                "b " + l2,
                l1 + ":",
                "push 1",
                l2 + ":");
    }

    @Override
    public String visitNode(TimesNode n) {
        if (print) printNode(n);
        return nlJoin(visit(n.left), visit(n.right), "mult");
    }

    @Override
    public String visitNode(PlusNode n) {
        if (print) printNode(n);
        return nlJoin(visit(n.left), visit(n.right), "add");
    }

    @Override
    public String visitNode(CallNode n) {
        if (print) printNode(n, n.id);
        for (Node arg : n.arglist) visit(arg);
        return null;
        //return nlJoin();
    }

    @Override
    public String visitNode(IdNode n) {
        if (print) printNode(n, n.id);
        return nlJoin(
                "lfp",  // load address of current frame (containing "id" declaration)
                "push " + n.entry.offset, "add",  // compute address of "id" declaration
                "lw"    // load value of "id" variable
        );
    }

    // Arrivato a 2h35 di 2911
    @Override
    public String visitNode(BoolNode n) {
        if (print) printNode(n, n.val.toString());
        return "push " + (n.val ? 1 : 0);
    }

    @Override
    public String visitNode(IntNode n) {
        if (print) printNode(n, n.val.toString());
        return "push " + n.val;
    }
}




//	String getAR = null;
//	for (int i = 0; i < n.nl - n.entry.nl; i++) getAR = nlJoin(getAR, "lw");

// by following the static chain (of Access Links)


//	String funl = freshFunLabel();


//	for (int i = n.arglist.size() - 1; i >= 0; i--) argCode = nlJoin(argCode, visit(n.arglist.get(i)));

// load Control Link (pointer to frame of function "id" caller)
// generate code for argument expressions in reversed order

// set $tm to popped value (with the aim of duplicating top of stack)
// load Access Link (pointer to frame of function "id" declaration)
// duplicate top of stack 

// jump to popped address (saving address of subsequent instruction in $ra)
