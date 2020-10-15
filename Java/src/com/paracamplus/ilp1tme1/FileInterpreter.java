package com.paracamplus.ilp1tme1;

import java.io.File;

import com.paracamplus.ilp1.interpreter.test.InterpreterTest;

public class FileInterpreter extends InterpreterTest {

	public FileInterpreter(String file) {
		super(new File (file));
	}
		
	public static void main(String[] args) {
		
FileInterpreter fi = new FileInterpreter(args[0]);
try {
	fi.processFile();
}
catch(Exception e) {
	System.err.println(e);
}
	
	}

}
