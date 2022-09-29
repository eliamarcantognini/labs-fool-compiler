package compiler;

public class AST {
	public static class ProgNode implements Node {
		Node exp;
		ProgNode(Node e) { exp=e; }
	}

	public static class PlusNode implements Node {
		Node left;
		Node right;
		PlusNode(Node l, Node r) { left=l; right=r; }
	}

	public static class TimesNode implements Node {
		Node left;
		Node right;
		TimesNode(Node l, Node r) { left=l; right=r; }
	}

	public static class IntNode implements Node {
		Integer val;
		IntNode(Integer n) { val=n; }
	}
}






//		@Override
//		public void accept(PrintASTVisitor visitor) {
//			visitor.visitNode(this);
//		}
