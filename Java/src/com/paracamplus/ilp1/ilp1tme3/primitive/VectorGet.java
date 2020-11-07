package com.paracamplus.ilp1.ilp1tme3.primitive;

import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class VectorGet extends Primitive{

	public VectorGet() {
		super("vectorGet");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getArity() {
		return 2;
	}
	
	@SuppressWarnings("unchecked")
	public Object apply(Object vec , Object index) throws EvaluationException {
		
		
		 try {
			 
			 if (vec instanceof Vector<?>) {
				 Vector<Object> v = (Vector<Object>) vec;
				 BigInteger ind = (BigInteger) index;
				 
				 if(ind.intValue()>0) {
					 
					 if (ind.intValue()< v.size()) {
						 return v.get(ind.intValue());
					 	}else {
					 		throw new EvaluationException("L'index dépasse la taille du vecteur !");
					 	}
					 }else {
						 throw new EvaluationException("Index négatif, erreur !");
					 }
				 
			 }else {
				 
				 throw new EvaluationException("Ce n'est pas un vecteur");
			 }
		       } catch (Exception e) {
	            throw new EvaluationException(e);
	        }
	}

}
