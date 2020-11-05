package com.paracamplus.ilp1.ilp1tme3.primitive;

import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class Sinus extends UnaryPrimitive {
	

	public Sinus(Writer out) {
		super("sinus");
		
	}

	@Override
	public Object apply(Object arg1) throws EvaluationException {
		
		
		 try {
			 if(arg1 instanceof BigInteger ) {
				 BigInteger bi = (BigInteger) arg1;
	        		return Math.sin(bi.doubleValue());}
			 
	         if (arg1 instanceof BigDecimal) {
	        	 BigDecimal bd = (BigDecimal) arg1;
     			return Math.sin(bd.doubleValue()); }
	         else
	        	 System.err.println("Not a number !");
	            
	        } catch (Exception e) {
	            throw new EvaluationException(e);
	        }
	        return Boolean.FALSE;
	}

}
