package database;

import java.util.Vector;

import entity.Problem;
import util.Util;

public class TestDataBase {
	private static String problemSetFile = "problemSet.dat";
	private static int maxId = 1000;
	
	public static Vector<Problem> readProblemSet(){
		Vector<Problem> problemSet = new Vector<Problem>();
		String data = "";

		data = Util.readFile(Util.dataBasePath + problemSetFile);

		String[] problemSetS = data.split("\n");
		for(String s : problemSetS){
			try{
				String[] ss = s.split(Util.splitStr);
				System.out.println("ss:");
				for(String str : ss){
					System.out.println(str);
				}
				int id = Integer.valueOf(ss[0]);
				String title = ss[1];
				int acceptSubmissions = Integer.valueOf(ss[2]);
				int totalSubmissions = Integer.valueOf(ss[3]);
				
				Problem problem = new Problem();
				maxId = Math.max(maxId, id);
				problem.setId(id);
				problem.setTitle(title);
				problem.setAcceptSubmissions(acceptSubmissions);
				problem.setTotalSubmissions(totalSubmissions);
			
				problemSet.add(problem);
			}catch(Exception e){
				System.out.println("TDB Error: ");
				e.printStackTrace();
			}
			
		}
		
		System.out.println("TDB:data: " + data);
		System.out.println("TDB:problemSet: " + problemSet);
		
		return problemSet;
	}
	
	public static Problem readProblem(int problemId) throws Exception {
		return Util.readProblem(problemId);
	}
	
	public static void writeProblem(Problem problem) {
		readProblemSet();
		problem.setId(++maxId);
		String data = problem.getId() + "";
		data += Util.splitStr + problem.getTitle();
		data += Util.splitStr + problem.getAcceptSubmissions();
		data += Util.splitStr + problem.getTotalSubmissions() + "\n";
		
		Util.writeFile(data, Util.dataBasePath + problemSetFile, true);
		
		Util.writeProblem(problem);
	}
	
	public static void problemSubmit(int problemId) throws Exception {
		Problem problem = readProblem(problemId);
		problem.setTotalSubmissions(problem.getTotalSubmissions() + 1 );
		Util.writeProblem(problem);
	}
	
	public static void problemAccept(int problemId) throws Exception {
		Problem problem = readProblem(problemId);
		problem.setAcceptSubmissions(problem.getAcceptSubmissions() + 1 );
		Util.writeProblem(problem);
	}
	
}
