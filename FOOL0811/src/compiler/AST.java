package compiler;

import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

public class AST {
    public static class ProgNode implements Node {
        Node exp;

        ProgNode(Node e) {
            exp = e;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }

    public static class PlusNode implements Node {
        Node left;
        Node right;

        PlusNode(Node l, Node r) {
            left = l;
            right = r;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }

    public static class TimesNode implements Node {
        Node left;
        Node right;

        TimesNode(Node l, Node r) {
            left = l;
            right = r;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }

    public static class IntNode implements Node {
        Integer val;

        IntNode(Integer n) {
            val = n;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }

    public static class EqualNode implements Node {
        Node left;
        Node right;

        public EqualNode(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visit(this);
        }
    }

    public static class BoolNode implements Node {

        Boolean val;

        public BoolNode(Boolean val) {
            this.val = val;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visit(this);
        }
    }

    public static class IfNode implements Node {

        Node cond;
        Node thenStm;
        Node elseStm;

        public IfNode(Node cond, Node thenStm, Node elseStm) {
            this.cond = cond;
            this.thenStm = thenStm;
            this.elseStm = elseStm;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visit(this);
        }
    }

    public static class PrintNode implements Node {

        Node print;

        public PrintNode(Node print) {
            this.print = print;
        }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visit(this);
        }
    }
}
