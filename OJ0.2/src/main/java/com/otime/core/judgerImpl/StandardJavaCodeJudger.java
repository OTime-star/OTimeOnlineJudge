package com.otime.core.judgerImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.otime.bean.JudgeData;
import com.otime.bean.JudgeRecord;
import com.otime.bean.Problem;
import com.otime.core.Judger;
import com.otime.core.judgerImpl.util.DirClassLoader;
import com.otime.core.judgerImpl.util.JavaCodeRunner;
import com.otime.core.judgerImpl.util.JavaCompilerUtil;
import com.otime.core.judgerImpl.util.Util;
import com.otime.excepiton.JudgeException;

public class StandardJavaCodeJudger implements Judger{
	private final String contentType = "JAVA";
	
	private PrintStream stdout = System.out;
	private InputStream	stdin = System.in;
	
	@Override
	public String getContentType() {
		return contentType;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public synchronized List<JudgeRecord> judge(Problem problem, String content) throws JudgeException{
		
		List<JudgeRecord> result = new ArrayList<JudgeRecord>();
		
		try {
			String code = content;
			String suffix = String.valueOf(new Date().getTime());

			code = code.replace("Main", "Main" + "_" + suffix);
			String sourceFile = "Main" + "_" + suffix + ".java";
			
			Util.writeFile(code, Util.sourceCodeFilePath + sourceFile);
			
			Method m = loadMainMethod(sourceFile);
			
			List<JudgeData> judgeDataList = problem.getActualJudgeDataList();
			
			for(int i = 0; i < judgeDataList.size(); i++) {
				JudgeData data = judgeDataList.get(i); 
			
				System.out.println("judge........... data: " + data);
				ByteArrayInputStream input = new ByteArrayInputStream(data.getInputData().getBytes());
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				
				Work work = new Work(m, input, output, Thread.currentThread());
				Thread n = new Thread(work);
				
				Long startTime = new Date().getTime();
				long startMemory = Runtime.getRuntime().freeMemory();
				 
				n.start();
				
				try {
					Thread.sleep(problem.getTimeLimit());
				} catch (InterruptedException e) {
					System.out.println("isInteruppt, run end");
					Thread.sleep(1);
				}
				
				Long endTime = new Date().getTime();
				long endMemory = Runtime.getRuntime().freeMemory();
				
				String rs = "Runtime Error";	
				
				if(n.isAlive()) {
					System.out.println("thread " + i + " is alive");
					rs = "TLE";
					n.stop();
					System.setIn(stdin);
					System.setOut(stdout);
				}else {
					System.out.println("thread " + i + " corrert");
					String out = output.toString("UTF-8");
					String ans = data.getResultData();
					out = out.trim();
					ans = ans.trim();
					System.out.println("out:" + out);
					System.out.println("ans:" + ans);
					if(out.equals(ans)){
						rs = "AC";
						System.out.println("run .. AC");
					}else {
						rs = "WA";
						System.out.println("run .. WA");
					}
				}
				System.out.println("test " + i + ":" + rs);
				
				int executeTime = (int) (endTime - startTime);
				int cost = (int) (startMemory - endMemory) / 1024;
				int memoryCost = cost > 0 ? cost : 1;
				
				JudgeRecord judgeRecord = new JudgeRecord(executeTime, memoryCost, rs);
				result.add(i, judgeRecord);
			}

			System.out.println("run.. result: " + result);
		} catch (Exception e) {
			if(e instanceof JudgeException){
				throw new JudgeException(e.getMessage());
			}
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	private Method loadMainMethod(String sourceFile) throws JudgeException {
		String sourceFileInputPath = Util.sourceCodeFilePath;
		String classFileOutputPath = Util.ObjectCodeFilePath;		
		
		if(!JavaCompilerUtil.CompilerJavaFile(sourceFileInputPath + sourceFile, classFileOutputPath) ) {
			System.out.println("compiler....result is false");
			throw new JudgeException("Compiler Error");
		}

		ClassLoader loader = new DirClassLoader(classFileOutputPath);
		
		Class<?> loaderClass = null;
		
		String ClassName = sourceFile.substring(0,sourceFile.lastIndexOf(".java"));
		System.out.println(ClassName);
		try {
			loaderClass = loader.loadClass(ClassName);
		} catch (ClassNotFoundException e) {
			throw new JudgeException("Class Not Found Error");
		}
		
		System.out.println("loaderClass:" + loaderClass);
		
		Method method = null;

		try {
			method = loaderClass.getMethod("main", String[].class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new JudgeException("main Method Not Found Error");
		}

		return method;
	}
	
	class Work implements Runnable{
		private Method method;
		private InputStream input;
		private OutputStream output;
		private Thread thread;
		
		private Exception exception = null;
		
		public Work(Method method, InputStream input, OutputStream output, Thread thread) {
			this.method = method;
			this.input = input;
			this.output = output;
			this.thread = thread;
		}

		@Override
		public void run() {
			try {
				JavaCodeRunner.runCode(method, input, output);
				thread.interrupt();
			} catch (Exception e) {
				e.printStackTrace();
				exception = e;
			}
		}

		public Exception getException() {
			return exception;
		}
	}
}
