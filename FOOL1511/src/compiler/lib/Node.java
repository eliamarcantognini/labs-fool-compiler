package compiler.lib;

public abstract class Node {
	
	int line=-1;  // line -1 means unset
	
	public void setLine(int l) { line=l; }

	public int getLine() { return line; }

	public abstract <S> S accept(BaseASTVisitor<S> visitor);
}

	  