package com.paracamplus.ilp1tme1.sequence;

import java.io.File;
import java.io.StringWriter;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.paracamplus.ilp1.interfaces.IASTfactory;
import com.paracamplus.ilp1.interpreter.GlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.GlobalVariableStuff;
import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.OperatorEnvironment;
import com.paracamplus.ilp1.interpreter.OperatorStuff;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.parser.ilpml.ILPMLParser;
import com.paracamplus.ilp1.parser.xml.IXMLParser;
import com.paracamplus.ilp1.parser.xml.XMLParser;


@RunWith(Parameterized.class)
public class InterpreterTest extends com.paracamplus.ilp1.interpreter.test.InterpreterTest{
	
	public InterpreterTest(File file) {
		super(file);
	}
	
	public void configureRunner(InterpreterRunner run) throws EvaluationException {
		// configuration du parseur
	    IASTfactory factory = new ASTfactory();
	    IXMLParser xmlParser = new XMLParser(factory);
	    xmlParser.setGrammar(new File(XMLgrammarFile));
	    run.setXMLParser(xmlParser);
	    run.setILPMLParser(new ILPMLParser(factory));

	    // configuration de l'interprète
	    StringWriter stdout = new StringWriter();
	    run.setStdout(stdout);
	    IGlobalVariableEnvironment gve = new GlobalVariableEnvironment();
	    GlobalVariableStuff.fillGlobalVariables(gve, stdout);
	    IOperatorEnvironment oe = new OperatorEnvironment();
	    OperatorStuff.fillUnaryOperators(oe);
	    OperatorStuff.fillBinaryOperators(oe);
	    Interpreter interpreter = new Interpreter(gve, oe);        
	    run.setInterpreter(interpreter);
			
		}


}
