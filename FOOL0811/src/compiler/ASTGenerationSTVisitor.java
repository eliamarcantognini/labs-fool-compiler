package compiler;

import compiler.AST.*;
import compiler.FOOLParser.*;
import compiler.lib.Node;
import org.antlr.v4.runtime.tree.ParseTree;


public class ASTGenerationSTVisitor extends FOOLBaseVisitor<Node> {

    String indent;

    @Override
    public Node visit(ParseTree t) {             //visit now returns Node
        String temp = indent;
        indent = (indent == null) ? "" : indent + "  ";
        Node result = super.visit(t);
        indent = temp;
        return result;
    }

    @Override
    public Node visitProg(ProgContext c) {
        System.out.println(indent + "prog");

        return new ProgNode(visit(c.exp()));
    }

    @Override
    public Node visitTimes(TimesContext c) {       //modified production tags
        System.out.println(indent + "exp: prod with TIMES");

        return new TimesNode(visit(c.exp(0)), visit(c.exp(1)));
    }

    @Override
    public Node visitPlus(PlusContext c) {
        System.out.println(indent + "exp: prod with PLUS");

        return new PlusNode(visit(c.exp(0)), visit(c.exp(1)));
    }

    @Override
    public Node visitPars(ParsContext c) {
        System.out.println(indent + "exp: prod with LPAR RPAR");

        return visit(c.exp());
    }

    @Override
    public Node visitInteger(IntegerContext c) {
        int v = Integer.parseInt(c.NUM().getText());
        boolean minus = c.MINUS() != null;
        int res = minus ? -v : v;
        System.out.println(indent + "exp: prod with " + (minus ? "MINUS " : "") + "NUM " + res);

        return new IntNode(res);
    }

    @Override
    public Node visitEq(EqContext ctx) {
        System.out.println(indent + "exp: prod with EQ");
        return new EqualNode(visit(ctx.exp(0)), visit(ctx.exp(1)));
    }

    @Override
    public Node visitTrue(TrueContext ctx) {
        System.out.println(indent + "exp: prod with TRUE");
        return new BoolNode(true);
    }

    @Override
    public Node visitFalse(FalseContext ctx) {
        System.out.println(indent + "exp: prod with FALSE");
        return new BoolNode(false);
    }

    @Override
    public Node visitIf(IfContext ctx) {
        System.out.println(indent + "exp: prod with IF THEN CLPAR CRPAR ELSE CLPAR CRPAR");
        return new IfNode(visit(ctx.exp(0)),
                visit(ctx.exp(1)),
                visit(ctx.exp(2)));
    }

    @Override
    public Node visitPrint(PrintContext ctx) {
        System.out.println(indent + "exp: prod with PRINT LPAR RPAR");
        return new PrintNode(visit(ctx.exp()));
    }
}
