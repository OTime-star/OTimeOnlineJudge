package sandbox;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import database.TestDataBase;
import entity.JudgeData;
import entity.Problem;
import exception.MyException;
import util.Util;

public class JavaCodeJudge implements CodeJudge{
	
	@SuppressWarnings("deprecation")
	@Override
	public Vector<String> judgeCode(int problemId, int userId, String code) throws MyException{
		Vector<String> result = new Vector<String>();
		
		try {
			Problem problem = TestDataBase.readProblem(problemId);
			result.setSize(problem.getTestData().size());
			
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String date = df.format(new Date());
			String addStr = problemId + "_" + userId + "_" + date;
			code = code.replace("Main", "Main" + "_" + addStr);
			String sourceFile = "Main" + "_" + addStr + ".java";
			
			Util.writeFile(code, Util.sourceFileInputPath + sourceFile);
			
			Method m = new JavaCodeRunner().loadMainMethod(sourceFile);
			
			PrintStream stdout = System.out;
			InputStream	stdin = System.in;
			
			for(int i = 0; i < problem.getTestData().size(); i++) {
				JudgeData data = problem.getTestData().get(i); 
			
				System.out.println("judge........... data: " + data);
				String inputFile = addStr + "_" + i + ".txt";
				String outputFile = addStr + "_" + i + ".txt";

				Util.writeFile(data.getInputData(), Util.inputFilePath + inputFile);
				
				Thread n = new Thread(new Runnable() {
					public void run() {
						new JavaCodeRunner().runCode(m, inputFile, outputFile);
					}
				});
				
				n.start();
				
				try {
					Thread.sleep(problem.getTimeLimit());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String rs = "Runtime Error";	
				
				if(n.isAlive()) {
					System.out.println("thread " + i + " is alive");
					rs = "TLE";
					n.stop();
					System.setIn(stdin);
					System.setOut(stdout);
				}else {
					System.out.println("thread " + i + " corrert");
					String out = Util.readFile(Util.outputFilePath + outputFile);
					String ans = data.getOuputData();
					out = out.trim();
					ans = ans.trim();
					System.out.println("out:" + out);
					System.out.println("ans:" + data.getOuputData());
					if(out.equals(data.getOuputData())){
						rs = "AC";
						System.out.println("run .. AC");
					}else {
						rs = "WA";
						System.out.println("run .. WA");
					}
				}
				System.out.println("test " + i + ":" + rs);
				result.set(i, rs);
			}

			System.out.println("run.. result: " + result);
		} catch (Exception e) {
			if(e instanceof MyException){
				throw new MyException(e.getMessage());
			}
			e.printStackTrace();
		}
		return result;
	}
}
