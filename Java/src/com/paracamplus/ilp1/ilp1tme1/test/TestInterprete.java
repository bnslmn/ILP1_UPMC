package com.paracamplus.ilp1.ilp1tme1.test;


import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;
import com.paracamplus.ilp1.parser.ParseException;

public class TestInterprete extends InterpreterTest{
    protected static String[] samplesDirName = { "SamplesTME1" }; 

	public TestInterprete(File file) {
		super(file);
	}
	@Parameters(name = "{0}")
	public static Collection<File[]> data() throws Exception {
    	return InterpreterRunner.getFileList(samplesDirName, pattern);
    }    
	@Test
    public void processFile() throws EvaluationException, ParseException, IOException {
    	InterpreterRunner run = new InterpreterRunner();
    	configureRunner(run);
    	run.testFile(file);
    	run.checkPrintingAndResult(file);
    }

	

}
