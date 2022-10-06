package compiler;

import compiler.AST.*;
import compiler.exc.VoidException;
import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

import static compiler.lib.FOOLlib.*;

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
        return nlJoin("push 0", declCode, // generate code for declarations
                visit(n.exp), "halt", getCode());
    }

    @Override
    public String visitNode(ProgNode n) {
        if (print) printNode(n);
        visit(n.exp);
        return nlJoin(visit(n.exp), "halt");
    }

    @Override
    public String visitNode(FunNode n) {
        if (print) printNode(n, n.id);
        for (ParNode par : n.parlist) visit(par);
        for (Node dec : n.declist) visit(dec);
        String declCode = "";
        for (Node dec : n.declist) declCode += nlJoin(declCode, visit(dec));
        visit(n.exp);
        String funl = freshFunLabel();
        putCode(
            nlJoin(
                funl + ":"
                // set $fp to $sp value
                // load $ra value
                // generate code for local declarations

//                declCode,// generate code for function body expression

                // set $tm to popped value (function result)
                // remove local declarations from stack
                // set $ra to popped value
                // remove Access Link from stack
                // remove parameters from stack
                // set $fp to popped value (Control Link)
                // load $tm value
                // load $ra value
                // jump to popped address
        ));
        return nlJoin("push " + funl);
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
        return nlJoin(visit(n.exp), "print");
    }

    @Override
    public String visitNode(IfNode n) {
        if (print) printNode(n);
        var l1 = freshLabel();
        var l2 = freshLabel();
        return nlJoin(visit(n.cond), "push 1", "beq " + l1, visit(n.el), "b " + l2, l1 + ":", visit(n.th), l2 + ":");
    }

    @Override
    public String visitNode(EqualNode n) {
        if (print) printNode(n);
        var l1 = freshLabel();
        var l2 = freshLabel();
        return nlJoin(visit(n.left), visit(n.right), "beq " + l1, "push 0", "b " + l2, l1 + ":", "push 1", l2 + ":");
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
        String argCode = null;
        for (int i = n.arglist.size() - 1; i >= 0; i--) argCode = nlJoin(argCode, visit(n.arglist.get(i)));
        String getAR = null;
        for (int i = 0; i < n.nl - n.entry.nl; i++) getAR = nlJoin(getAR, "lw");
        return nlJoin("lfp", // load Control Link (pointer to frame of function "id" caller)
                argCode, // generate code for argument expressions in reversed order
                "lfp", getAR, // retrieve address of frame containing "id" declaration by following the static chan (of Access Link)
                "stm", // set $tm to popped value (with the aim of duplicating top of stack)
                "ltm", // load Access Link (pointer to frame of function "id" declaration)
                "ltm", // duplicate top of stack
                "push " + n.entry.offset, "add", // compute address of "id" declaration
                "lw", // load address of function
                "js" // jump to popped address (saving address of subsequent instruction in $ra)
        );
    }


    @Override
    public String visitNode(IdNode n) {
        if (print) printNode(n, n.id);
        String getAR = null;
        for (int i = 0; i < n.nl - n.entry.nl; i++) getAR = nlJoin(getAR, "lw");
        return nlJoin("lfp",  // retrieve address of frame containing "id" declaration
                getAR,  // by following the static chain (of Access Links)
                "push " + n.entry.offset, "add",  // compute address of "id" declaration
                "lw"    // load value of "id" variable
        );
    }

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



