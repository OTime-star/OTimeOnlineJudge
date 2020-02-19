package com.otime.core.judgerImpl.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaCodeRunner {
	
	public static boolean runCode(Method m, InputStream input, OutputStream output) throws Exception{
		PrintStream stdout = System.out;
		InputStream	stdin = System.in;
		
		InputStream in = input;
		PrintStream out = new PrintStream(output);
		
		System.setIn(in);
		System.setOut(out);
		
		try {
			m.invoke(null, new Object[] {null} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("main method error");
			throw new Exception("RunTime Error");
		} finally {
			System.setIn(stdin);
			System.setOut(stdout);
		}
		
		System.out.println("run code end....");
		return true;
	}		
	
}
