package com.paracamplus.ilp1.ilp1tme2.ex2;

import com.paracamplus.ilp1.interfaces.IASTfactory;

import antlr4.ILPMLgrammar1tme2Parser.ConstFalseContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstFloatContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstIntegerContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstStringContext;
import antlr4.ILPMLgrammar1tme2Parser.ConstTrueContext;


public class ILPMLListener extends com.paracamplus.ilp1.ilp1tme2.ex1.ILPMLListener{
	
	protected int nb_const = 0;

	public int getNb_Const() {
		return nb_const;
	}
	public ILPMLListener(IASTfactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterConstFloat(ConstFloatContext ctx) {
		// TODO Auto-generated method stub
		nb_const++;
	}

	@Override
	public void enterConstFalse(ConstFalseContext ctx) {
		// TODO Auto-generated method stub
		nb_const++;
	}

	@Override
	public void enterConstTrue(ConstTrueContext ctx) {
		// TODO Auto-generated method stub
		nb_const++;
	}

	@Override
	public void enterConstInteger(ConstIntegerContext ctx) {
		// TODO Auto-generated method stub
		nb_const++;
	}

	@Override
	public void enterConstString(ConstStringContext ctx) {
		// TODO Auto-generated method stub
		nb_const++;
	}
	
	

}