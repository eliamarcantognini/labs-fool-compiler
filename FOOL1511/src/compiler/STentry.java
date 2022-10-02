package compiler;

import compiler.lib.BaseASTVisitor;
import compiler.lib.BaseEASTVisitor;
import compiler.lib.Visitable;

public class STentry implements Visitable {
    int nl;

    public STentry(int n) {
        nl = n;
    }

    @Override
    public <S> S accept(BaseASTVisitor<S> visitor) {
        return ((BaseEASTVisitor<S>) visitor).visitSTentry(this);
    }
}
