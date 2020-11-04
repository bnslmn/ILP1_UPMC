package com.paracamplus.ilp1.ilp1tme2.ex1;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;


import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfactory;
import com.paracamplus.ilp1.interfaces.IASTvariable;


import antlr4.ILPMLgrammar1tme2Listener;
import antlr4.ILPMLgrammar1tme2Parser.AffectationContext;
import antlr4.ILPMLgrammar1tme2Parser.AlternativeContext;
import antlr4.ILPMLgrammar1tme2Parser.BinaryContext;
import antlr4.ILPMLgrammar1tme2Parser.BindingContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstFalseContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstFloatContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstIntegerContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstStringContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstTrueContext;
import antlr4.ILPMLgrammar1tme2Parser.FunctionContext;
import antlr4.ILPMLgrammar1tme2Parser.InvocationContext;
import antlr4.ILPMLgrammar1tme2Parser.ProgContext;
import antlr4.ILPMLgrammar1tme2Parser.SequenceContext;
import antlr4.ILPMLgrammar1tme2Parser.UnaryContext;
import antlr4.ILPMLgrammar1tme2Parser.VariableContext;
import antlr4.ILPMLgrammar1tme2Parser.WhileloopContext;

public class ILPMLListener implements ILPMLgrammar1tme2Listener{
	protected IASTfactory factory;
	
	
	public ILPMLListener(IASTfactory factory) {
		super();
		this.factory = factory;		
	}
	
	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterBinding(BindingContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitBinding(BindingContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newBlock(
				toBindings(ctx.vars, ctx.vals),
				ctx.body.node);
		
	}

	@Override
	public void enterWhileloop(WhileloopContext ctx) {
	 
		System.out.println("Boucle While detectée !");
	}

	@Override
	public void exitWhileloop(WhileloopContext ctx) {
		System.out.println("Sortie de la boucle while...");
		
	}

	@Override
	public void enterVariable(VariableContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitVariable(VariableContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newVariable(ctx.getText());
	}

	@Override
	public void enterAlternative(AlternativeContext ctx) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void exitAlternative(AlternativeContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newAlternative(
				ctx.condition.node, 
				ctx.consequence.node, 
				(ctx.alternant == null ? null : ctx.alternant.node));
		
	}

	@Override
	public void enterInvocation(InvocationContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitInvocation(InvocationContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newInvocation(
				ctx.fun.node, 
				toExpressions(ctx.args));
	}

	@Override
	public void enterConstFloat(ConstFloatContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstFloat(ConstFloatContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newFloatConstant(ctx.floatConst.getText());
		
	}

	@Override
	public void enterSequence(SequenceContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSequence(SequenceContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newSequence(toExpressions(ctx.exprs));
	}

	@Override
	public void enterConstFalse(ConstFalseContext ctx) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void exitConstFalse(ConstFalseContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newBooleanConstant("false");
	}

	@Override
	public void enterProg(ProgContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitProg(ProgContext ctx) {
		// TODO Auto-generated method stub
		IASTexpression e = factory.newSequence(toExpressions(ctx.exprs));
		ctx.node = factory.newProgram(e);
		
	}

	@Override
	public void enterUnary(UnaryContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitUnary(UnaryContext ctx) {
		ctx.node = factory.newUnaryOperation(
				factory.newOperator(ctx.op.getText()),
				ctx.arg.node);
		
	}

	@Override
	public void enterConstTrue(ConstTrueContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstTrue(ConstTrueContext ctx) {
		ctx.node = factory.newBooleanConstant("true");
	}

	@Override
	public void enterConstInteger(ConstIntegerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstInteger(ConstIntegerContext ctx) {
		ctx.node = factory.newIntegerConstant(ctx.intConst.getText());
		
	}

	@Override
	public void enterFunction(FunctionContext ctx) {
		System.out.println("Fonction détectée !");
		
	}

	@Override
	public void exitFunction(FunctionContext ctx) {
		System.out.println("Sortie de la fonction...");
	
	}

	@Override
	public void enterAffectation(AffectationContext ctx) {
			System.out.println("Affectation détectée !");

		
	}

	@Override
	public void exitAffectation(AffectationContext ctx) {
		System.out.println("Sortie de l'affectation...");


	}

	@Override
	public void enterConstString(ConstStringContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitConstString(ConstStringContext ctx) {
		// TODO Auto-generated method stub
 
			/*
			 * On enlève le " initial et final, et on interprète les codes
			 * d'échapement \n, \r, \t, \"
			 */
			String s = ctx.getText();
			StringBuilder buf = new StringBuilder();
			for (int i = 1; i < s.length() - 1; i++) {
				if (s.charAt(i) == '\\' && i < s.length() - 2) {
					switch (s.charAt(i+1)) {
					case 'n': buf.append('\n'); i++; break;
					case 'r': buf.append('\r'); i++; break;
					case 't': buf.append('\t'); i++; break;
					case '"': buf.append('\"'); i++; break;
					default: buf.append(s.charAt(i));
					}
				}
				else buf.append(s.charAt(i));
			}
			ctx.node = factory.newStringConstant(buf.toString());
	}

	@Override
	public void enterBinary(BinaryContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitBinary(BinaryContext ctx) {
		// TODO Auto-generated method stub
		ctx.node = factory.newBinaryOperation(
				factory.newOperator(ctx.op.getText()),
				ctx.arg1.node,
				ctx.arg2.node);		
	}
	
	/* Utilitaires de conversion ANTLR vers AST */
	
	protected IASTexpression[] toExpressions(
			List<antlr4.ILPMLgrammar1tme2Parser.ExprContext> exprs) {
		if (exprs == null) return new IASTexpression[0];
		IASTexpression[] r = new IASTexpression[exprs.size()];
		int pos = 0;
		for (antlr4.ILPMLgrammar1tme2Parser.ExprContext e : exprs) {
			r[pos++] = e.node;
		}
		return r;
	}
	
	protected IASTvariable[] toVariables(
			List<Token> vars, boolean addSelf) {
		if (vars == null) return new IASTvariable[0];
		IASTvariable[] r = new IASTvariable[vars.size() + (addSelf ? 1 : 0)];
		int pos = 0;
		if (addSelf) {
			// Les déclarations de méthodes ont une variable "self" implicite
			r[pos++] = factory.newVariable("self");
		}
		for (Token v : vars) {
			r[pos++] = factory.newVariable(v.getText());
		}
		return r;
	}

	protected String[] toStrings(List<Token> vars) {
		if (vars == null) return new String[0];
		String[] r = new String[vars.size()];
		int pos = 0;
		for (Token v : vars) {
			r[pos++] = v.getText();
		}
		return r;
	}

	protected IASTblock.IASTbinding[] toBindings(
			List<Token> vars, 
			List<antlr4.ILPMLgrammar1tme2Parser.ExprContext> vals) {
		if (vars == null) return new IASTblock.IASTbinding[0];
		/* par construction, vars et ctxs ont la même taille */
		assert(vars.size() == vals.size());
		IASTblock.IASTbinding[] r = new IASTblock.IASTbinding[vals.size()];
		int pos = 0;
		for (Token v : vars) {
			r[pos] = factory.newBinding(
					factory.newVariable(v.getText()),
					vals.get(pos).node
					);
			pos++;
		}
		return r;			
	}

	

	

}