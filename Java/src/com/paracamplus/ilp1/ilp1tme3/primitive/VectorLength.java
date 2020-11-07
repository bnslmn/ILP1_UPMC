package com.paracamplus.ilp1.ilp1tme3.primitive;


import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class VectorLength extends UnaryPrimitive {

	public VectorLength() {
		super("vectorLength");
	}
	
	@SuppressWarnings("unchecked")
	public Object apply(Object vec) throws EvaluationException {
		
		
		 try {
			if(vec instanceof Vector<?>) {
				Vector<Object> vecteur = (Vector<Object>) vec;
				
				return vecteur.size();
				}
			else {
				throw new EvaluationException("Ce n'est pas un vecteur !");
			}
	            
	        } catch (Exception e) {
	            throw new EvaluationException(e);
	        }
	}

}
