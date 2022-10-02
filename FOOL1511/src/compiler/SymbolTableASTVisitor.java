package compiler;

import compiler.AST.*;
import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements the symbol table visitor.
 * Check the symbol table and enrich the AST with the symbol table information.
 * Remember to use the symbol table to check the type of the variables and functions.
 * At the end of the visit, the symbol table should be empty.
 */
public class SymbolTableASTVisitor extends BaseASTVisitor<Void> {

    // Counter degli errori rilevati nella symbol table
    int stErrors = 0;
    // symbol table
    private final List<Map<String, STentry>> symTable = new ArrayList<>();
    // level 0 -> global
    // level 1 -> function body
    // level 2 -> function's function body
    // ...
    private int nestingLevel = 0;
    //livello ambiente con dichiarazioni piu' esterno e' 0 (prima posizione ArrayList) invece che 1 (slides)
    //il "fronte" della lista di tabelle e' symTable.get(nestingLevel)

    SymbolTableASTVisitor() {
    }

    SymbolTableASTVisitor(boolean debug) {
        super(debug);
    } // p=true enables print for debugging

    @Override
    public Void visitNode(ProgNode n) {
        if (print) printNode(n);
        visit(n.exp);
        return null;
    }

    @Override
    public Void visitNode(IntNode n) {
        if (print) printNode(n, n.val.toString());
        return null;
    }

    @Override
    public Void visitNode(PlusNode n) {
        if (print) printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(TimesNode n) {
        if (print) printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(EqualNode n) {
        if (print) printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
    }

    @Override
    public Void visitNode(BoolNode n) {
        if (print) printNode(n, n.val.toString());
        return null;
    }

    @Override
    public Void visitNode(IfNode n) {
        if (print) printNode(n);
        visit(n.cond);
        visit(n.th);
        visit(n.el);
        return null;
    }

    @Override
    public Void visitNode(PrintNode n) {
        if (print) printNode(n);
        visit(n.exp);
        return null;
    }

    //
    @Override
    public Void visitNode(ProgLetInNode n) {
        if (print) printNode(n);
        Map<String, STentry> hm = new HashMap<>();
        symTable.add(hm);
        for (Node dec : n.declist) visit(dec);
        visit(n.exp);
        symTable.remove(0);
        return null;
    }

    @Override
    public Void visitNode(VarNode n) {
        if (print) printNode(n, n.id);
        visit(n.exp);
        if (symTable.get(nestingLevel).put(n.id, new STentry(nestingLevel)) != null) {
            System.out.println("Var id " + n.id + " at line " + n.getLine() + " already declared");
            stErrors++;
        }
        return null;
    }

    @Override
    public Void visitNode(FunNode n) {
        if (print) printNode(n, n.id);
        if (symTable.get(nestingLevel).put(n.id, new STentry(nestingLevel)) != null) {
            System.out.println("Fun id " + n.id + " at line " + n.getLine() + " already declared");
            stErrors++;
        }
        // entro in un nuovo scope
        nestingLevel++;
        symTable.add(new HashMap<String, STentry>());
        for (ParNode par : n.parlist) {
            if (symTable.get(nestingLevel).put(par.id, new STentry(nestingLevel)) != null) {
                System.out.println("Par id " + par.id + " at line " + par.getLine() + " already declared");
                stErrors++;
            }
        }
        for (Node dec : n.declist) visit(dec);
        visit(n.exp);
        // esco dallo scope
        symTable.remove(nestingLevel--);
        return null;
    }

    private STentry stLookup(String id) {
        var j = nestingLevel;
        STentry entry = null;
        while (j >= 0 && entry == null)
            entry = symTable.get(j--).get(id);
        return entry;
    }

    @Override
    public Void visitNode(IdNode n) {
        if (print) printNode(n);
        var entry = stLookup(n.id);
        if (entry == null) {
            System.out.println("Var or Par id " + n.id + " at line " + n.getLine() + " not declared");
            stErrors++;
        } else {
            n.entry = entry;
        }
        return null;
    }

    @Override
    public Void visitNode(CallNode n) {
        if (print) printNode(n);
        var entry = stLookup(n.id);
        if (entry == null) {
            System.out.println("Fun id " + n.id + " at line " + n.getLine() + " not declared");
            stErrors++;
        } else {
            n.entry = entry;
        }
        for (Node arg : n.arglist) visit(arg);
        return null;
    }
}