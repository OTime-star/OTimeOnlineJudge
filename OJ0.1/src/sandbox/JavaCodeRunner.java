package sandbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import exception.MyException;
import util.JavaCompilerUtil;
import util.Util;

public class JavaCodeRunner implements CodeRunner{
	
	@Override
	public Method loadMainMethod(String sourceFile) throws MyException {
		String sourceFileInputPath = Util.sourceFileInputPath;
		String classFileOutputPath = Util.classFileOutputPath;		
		
		if(!JavaCompilerUtil.CompilerJavaFile(sourceFileInputPath + sourceFile, classFileOutputPath) ) {
			System.out.println("compiler....result is false");
			throw new MyException("Compiler Error");
		}

		ClassLoader loader = new DirClassLoader(classFileOutputPath);
		
		Class<?> loaderClass = null;
		
		String ClassName = sourceFile.substring(0,sourceFile.lastIndexOf(".java"));
		System.out.println(ClassName);
		try {
			loaderClass = loader.loadClass(ClassName);
		} catch (ClassNotFoundException e) {
			throw new MyException("Class Not Found Error");
		}
		
		System.out.println("loaderClass:" + loaderClass);
		
		Method method = null;

		try {
			method = loaderClass.getMethod("main", String[].class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new MyException("main Method Not Found Error");
		}

		
		return method;
	}
	
	@Override
	public boolean runCode(Method m, String inputFile, String outputFile) {
		PrintStream stdout = System.out;
		InputStream	stdin = System.in;
		
		inputFile = Util.inputFilePath + inputFile;
		outputFile = Util.outputFilePath + outputFile;
		
		try {
			InputStream in = new FileInputStream(inputFile);
			PrintStream out = new PrintStream(new File(outputFile));
			System.setIn(in);
			System.setOut(out);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			m.invoke(null, new Object[] {null} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("main method error");
		}
		
		System.setIn(stdin);
		System.setOut(stdout);
		System.out.println("run code end....");
		return true;
	}		
	
}
