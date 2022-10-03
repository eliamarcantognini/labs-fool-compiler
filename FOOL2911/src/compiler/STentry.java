package compiler;

import compiler.lib.BaseASTVisitor;
import compiler.lib.BaseEASTVisitor;
import compiler.lib.TypeNode;
import compiler.lib.Visitable;

public class STentry implements Visitable {
    int nl;
    TypeNode type;

    public STentry(int n, TypeNode t) {
        nl = n;
        type = t;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return ((BaseEASTVisitor<S, E>) visitor).visitSTentry(this);
    }
}
