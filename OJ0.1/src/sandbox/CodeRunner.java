package sandbox;

import java.lang.reflect.Method;

import exception.MyException;

public interface CodeRunner {
	boolean runCode(Method m, String inputFile, String outputFile);

	Method loadMainMethod(String sourceFile) throws MyException;
}
