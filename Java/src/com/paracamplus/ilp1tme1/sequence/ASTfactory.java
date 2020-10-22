package com.paracamplus.ilp1tme1.sequence;

import com.paracamplus.ilp1.interfaces.IASTexpression;


public class ASTfactory extends com.paracamplus.ilp1.ast.ASTfactory {
	
	 @Override
		public IASTsequence newSequence(IASTexpression[] asts) {
	        return new ASTsequence(asts);
	    }

}
