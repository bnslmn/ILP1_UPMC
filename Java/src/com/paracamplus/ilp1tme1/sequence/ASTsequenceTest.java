package com.paracamplus.ilp1tme1.sequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.paracamplus.ilp1.ast.ASTbinaryOperation;
import com.paracamplus.ilp1.ast.ASTfloat;
import com.paracamplus.ilp1.ast.ASTinteger;
import com.paracamplus.ilp1.ast.ASToperator;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ASTsequenceTest {
	
IASTsequence seq;
IASTexpression[] exprs = {new ASTfloat("3.14"),
						  new ASTinteger("314"),
						  new ASTbinaryOperation(new ASToperator("-"), 
								  				 new ASTinteger("2020"), 
								  				 new ASTinteger("1998"))};

	@Test
	public void test1() {
		seq = new ASTsequence(exprs);
		System.out.println("Running Test");
		assertEquals(exprs.length , 3);
		assertEquals(exprs[0] instanceof ASTfloat , true);
		assertEquals(exprs[1] instanceof ASTinteger , true);
		assertEquals(exprs[2] instanceof ASTbinaryOperation , true);
	
		System.out.println("Testing the new extention : getAllButLastInstruction() ");
		
		try {
			exprs = seq.getAllButLastInstructions();
			assertEquals(exprs[0] instanceof ASTfloat , true);
			assertEquals(exprs[1] instanceof ASTinteger , true);
			assertEquals(exprs.length , 2); // La dernière expression n'est donc pas retenue.
			
		} catch (EvaluationException e) {
			e.printStackTrace();
		}
	}

}
