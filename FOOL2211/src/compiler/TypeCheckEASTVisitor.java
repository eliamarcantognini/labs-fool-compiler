package compiler;

import compiler.AST.*;
import compiler.lib.*;
import compiler.exc.*;

//visit(n) fa il type checking di un Node n e ritorna: 
//per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode)
//per una dichiarazione, "null"
public class TypeCheckEASTVisitor extends BaseEASTVisitor<TypeNode,TypeException> {

	TypeCheckEASTVisitor() {}
	TypeCheckEASTVisitor(boolean debug) { super(debug); } // enables print for debugging

	@Override
	public TypeNode visitNode(ProgLetInNode n) throws TypeException {
		if (print) printNode(n);
		for (Node dec : n.declist) visit(dec);
		visit(n.exp);
		return null;
	}

	@Override
	public TypeNode visitNode(ProgNode n) throws TypeException {
		if (print) printNode(n);
		visit(n.exp);
		return null;
	}

	@Override
	public TypeNode visitNode(FunNode n) throws TypeException {
		if (print) printNode(n,n.id);
		visit(n.retType);
		for (ParNode par : n.parlist) visit(par);
		for (Node dec : n.declist) visit(dec);
		visit(n.exp);
		return null;
	}

	@Override
	public TypeNode visitNode(VarNode n) throws TypeException {
		if (print) printNode(n,n.id);
		visit(n.type);
		visit(n.exp);
		return null;
	}

	@Override
	public TypeNode visitNode(PrintNode n) throws TypeException {
		if (print) printNode(n);
		visit(n.exp);
		return null;
	}


	@Override
	public TypeNode visitNode(IfNode n) throws TypeException {
		if (print) printNode(n);
		visit(n.cond);
		visit(n.th);
		visit(n.el);
		return null;
	}

	@Override
	public TypeNode visitNode(EqualNode n) throws TypeException {
		if (print) printNode(n);
		visit(n.left);
		visit(n.right);
		return null;
	}

	@Override
	public TypeNode visitNode(TimesNode n) throws TypeException {
		if (print) printNode(n);
		visit(n.left);
		visit(n.right);
		return null;
	}

	@Override
	public TypeNode visitNode(PlusNode n) throws TypeException {
		if (print) printNode(n);
		visit(n.left);
		visit(n.right);
		return null;
	}

	@Override
	public TypeNode visitNode(CallNode n) throws TypeException {
		if (print) printNode(n,n.id);
		visit(n.entry);
		for (Node arg : n.arglist) visit(arg);
		return null;
	}

	@Override
	public TypeNode visitNode(IdNode n) throws TypeException {
		if (print) printNode(n,n.id);
		visit(n.entry);
		return null;
	}

	@Override
	public TypeNode visitNode(BoolNode n) {
		if (print) printNode(n,n.val.toString());
		return null;
	}

	@Override
	public TypeNode visitNode(IntNode n) {
		if (print) printNode(n,n.val.toString());
		return null;
	}

	@Override
	public TypeNode visitNode(ArrowTypeNode n) throws TypeException {
		printNode(n);
		for (Node par: n.parlist) visit(par);
		visit(n.ret,"->"); //marks return type
		return null;
	}

	@Override
	public TypeNode visitNode(BoolTypeNode n) {
		printNode(n);
		return null;
	}

	@Override
	public TypeNode visitNode(IntTypeNode n) {
		printNode(n);
		return null;
	}

	@Override
	public TypeNode visitSTentry(STentry entry) throws TypeException {
		printSTentry("type");
		visit(entry.type);
		return null;
	}

}


//throw new TypeException("Wrong usage of function identifier "+n.id,n.getLine());
//throw new TypeException("Non integers in sum",n.getLine());
//throw new TypeException("Non integers in multiplication",n.getLine());
//throw new TypeException("Incompatible types in equal",n.getLine());
//throw new TypeException("Incompatible types in then-else branches",n.getLine());
//throw new TypeException("Non boolean condition in if",n.getLine());
//throw new TypeException("Incompatible value for variable " + n.id,n.getLine());
//throw new TypeException("Wrong return type for function " + n.id,n.getLine());


//} catch (TypeException e) {
//	System.out.println("Type checking error in a declaration: "+e.text);

//super(true); enables incomplete tree exceptions 

//} catch (IncomplException e) {
