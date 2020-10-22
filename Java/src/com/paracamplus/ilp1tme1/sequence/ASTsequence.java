package com.paracamplus.ilp1tme1.sequence;

import java.util.Arrays;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ASTsequence extends com.paracamplus.ilp1.ast.ASTsequence implements IASTsequence{

	public ASTsequence(IASTexpression[] expressions) {
		super(expressions);
	}

	@Override
	public IASTexpression[] getAllButLastInstructions() throws EvaluationException {
		
		return Arrays.copyOf(this.expressions,this.expressions.length-1);
	}
	

}
