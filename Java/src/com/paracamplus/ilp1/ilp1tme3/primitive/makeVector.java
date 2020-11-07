package com.paracamplus.ilp1.ilp1tme3.primitive;


import java.math.BigInteger;
import java.util.Vector;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public class makeVector extends Primitive{

	public makeVector() {
		super("makeVector");
	}

	@Override
	public int getArity() {
		return 2;
	}
	
	 @Override
		public Object apply (Object taille, Object val) throws EvaluationException {
		 try {
				if ( taille instanceof BigInteger) {
					BigInteger bi = (BigInteger)taille;
		
						Vector<Object> v = new Vector<>();
						v.setSize(bi.intValue());
						for ( int i =0 ; i < bi.intValue() ; i++) {
						v.set(i,val);
						}
						return v;
						
				}else {
						String msg = "Paramètres faux";
						throw new EvaluationException(msg);
				}
				
			}
			catch(EvaluationException e) {
				 throw new EvaluationException(e);
			}
			
	    }
	
	
	
}
