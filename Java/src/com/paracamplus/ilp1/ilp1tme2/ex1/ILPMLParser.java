package com.paracamplus.ilp1.ilp1tme2.ex1;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.paracamplus.ilp1.ilp1tme2.ex2.ILPMLListener;
import com.paracamplus.ilp1.interfaces.IASTfactory;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.parser.ParseException;
import antlr4.ILPMLgrammar1tme2Lexer;
import antlr4.ILPMLgrammar1tme2Parser;

public class ILPMLParser extends com.paracamplus.ilp1.parser.ilpml.ILPMLParser{

	public ILPMLParser(IASTfactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IASTprogram getProgram() throws ParseException{
		try{
			
			ANTLRInputStream inputStream = new ANTLRInputStream(input.getText());
			ILPMLgrammar1tme2Lexer lexer = new ILPMLgrammar1tme2Lexer(inputStream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ILPMLgrammar1tme2Parser parser = new ILPMLgrammar1tme2Parser(tokens);
			ILPMLgrammar1tme2Parser.ProgContext tree = parser.prog();
			ParseTreeWalker walker = new ParseTreeWalker();
			com.paracamplus.ilp1.ilp1tme2.ex2.ILPMLListener extractor = new ILPMLListener(factory);
			
			walker.walk(extractor, tree);

			return tree.node;
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new ParseException(e);
		}
		
		
	}
	
	
	

}