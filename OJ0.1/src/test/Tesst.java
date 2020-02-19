package test;

import java.util.Vector;

import database.TestDataBase;
import entity.JudgeData;
import entity.Problem;
import exception.MyException;
import sandbox.JavaCodeJudge;

public class Tesst {
	public static void main(String[] args) {
		Problem problem = new Problem();
		
		int id = 1002;
		String title = "A * B";
		String description = "Calculate a*b";
		String inputFormat = "Two integer a,b (0<=a,b<=10)";
		String outputFormat = "Output a*b";
		int timeLimit = 1000;
		int memoryLimit = 256;
		int totalSubmissions = 0;
		int acceptSubmissions = 0;
		Vector<JudgeData> sampleData = new Vector<JudgeData>();
		Vector<JudgeData> testData = new Vector<JudgeData>();
		sampleData.add(new JudgeData("2 3", "4"));
		testData.add(new JudgeData("3 2", "1"));
		testData.add(new JudgeData("110 90", "20"));
		testData.add(new JudgeData("3000 2000", "1000"));
		testData.add(new JudgeData("999999 444444", "555555"));
		testData.add(new JudgeData("1000000000 1", "999999999"));
		
		problem.setId(id);
		problem.setTitle(title);
		problem.setDescription(description);
		problem.setInputFormat(inputFormat);
		problem.setOutputFormat(outputFormat);
		problem.setTimeLimit(timeLimit);
		problem.setMemoryLimit(memoryLimit);
		problem.setTotalSubmissions(totalSubmissions);
		problem.setAcceptSubmissions(acceptSubmissions);
		problem.setSampleData(sampleData);
		problem.setTestData(testData);
		
		TestDataBase.readProblemSet();
		TestDataBase.writeProblem(problem);
		
		JavaCodeJudge codeJudge = new JavaCodeJudge();
		String code = "import java.io.File;\r\n" + 
				"import java.io.FileInputStream;\r\n" + 
				"import java.util.Scanner;\r\n" + 
				"\r\n" + 
				"public class Main {\r\n" + 
				"\r\n" + 
				"	public static void main(String[] args) {\r\n" + 
				"		\r\n" + 
				"		Scanner sc = new Scanner(System.in);\r\n" + 
				"		int a = sc.nextInt();\r\n" + 
				"		int b = sc.nextInt();\r\n" +
				"		while(true){if(a != 1000) break;}" + 
				"		System.out.println(a + b);\r\n" + 
				"		System.out.println();\r\n" + 
				"		sc.close();\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"";
		try {
			codeJudge.judgeCode(1001, 1, code);
		} catch (MyException e) {
			System.out.println("tesst myexcepiton error");
			e.printStackTrace();
		}	
	}
}
