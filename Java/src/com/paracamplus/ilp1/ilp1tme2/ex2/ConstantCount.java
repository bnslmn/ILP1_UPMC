package com.paracamplus.ilp1.ilp1tme2.ex2;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ConstantCount implements IASTvisitor<Integer, Void, EvaluationException>{

	@Override
	public Integer visit(IASTalternative iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
   
		int counter = iast.getCondition().accept(this, data) + iast.getConsequence().accept(this, data);
		if(iast.isTernary())counter += iast.accept(this, data);
		return counter;
		
		
	}
	
    
    public Integer visit(IASTprogram iast, Void data) 
            throws EvaluationException {
        try {
            return iast.getBody().accept(this, data);
        } catch (Exception exc) {
            return 0;
        }
    }
	@Override
	public Integer visit(IASTbinaryOperation iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return iast.getLeftOperand().accept(this, data) + iast.getRightOperand().accept(this, data);
	} 

	@Override
	public Integer visit(IASTblock iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return iast.getBody().accept(this, data);
	}

	@Override
	public Integer visit(IASTboolean iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTfloat iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTinteger iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTinvocation iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		int counter = 0;
		for(IASTexpression e : iast.getArguments()) {
			counter += e.accept(this, data);
		}
		return counter;
	}

	@Override
	public Integer visit(IASTsequence iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		int counter = 0;
		for(IASTexpression e: iast.getExpressions()) {
			counter += e.accept(this, data);
		}
		return counter;
	}

	@Override
	public Integer visit(IASTstring iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTunaryOperation iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return iast.getOperand().accept(this, data);
		
	}

	@Override
	public Integer visit(IASTvariable iast, Void data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 0;
	}

}