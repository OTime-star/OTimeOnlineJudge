package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.Problem;

public class Util {
	private static String RootPath = "D:/OnlineJudgeFile";
	public static String sourceFileInputPath = RootPath + "/SourceFile/";
	public static String classFileOutputPath = RootPath + "/ClassFile";
	public static String inputFilePath = RootPath + "/ProblemsFile/InputFile/";
	public static String outputFilePath = RootPath + "/ProblemsFile/OutputFile/";
	public static String ansFilePath = RootPath + "/ProblemsFile/AnsFile/";
	public static String dataBasePath = RootPath + "/DataBase/";
	public static String splitStr = "@:";
	
	 public static String readFile(String file) {
	    String data = "";
	    BufferedReader br = null;
		try{
	        br = new BufferedReader(new FileReader(file)); 
	        
	        String line;
	        while ((line = br.readLine()) != null) {
	            data += line + "\n";
	        }
        } catch (IOException e) {
            System.out.println("Util: " + file + "not Found");
        }
		
    	try {
			if(br != null)
				br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        return data;
    }
	 
	 public static void writeFile(String data, String file){
		writeFile(data, file, false);	
	 }
	 
	 public static void writeFile(String data, String file, boolean append){
		BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(new File(file), append));
            
            out.write(data); 
            out.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		try {
			if(out != null)
				out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
	 
	public static void appendData(String data, String file) {
		
	}
	 
	 public static Problem readProblem(int problemId) throws Exception {
		 String file = dataBasePath + "Q" + problemId + ".dat";
		 System.out.println("read problem :" + file);
		 ObjectInputStream in = null;
		 Problem problem = null;
	 
		 in = new ObjectInputStream(new FileInputStream(file));
		 problem = (Problem) in.readObject();

		 try {
			 if(in != null)
				 in.close();
		 } catch (IOException e) {
			e.printStackTrace();
		 }
		 
		 return problem;
	 }
	 
	 public static void writeProblem(Problem problem) {
		 String file = dataBasePath + "Q" + problem.getId() + ".dat";
		 System.out.println("wirte problem :" + file);
		 ObjectOutputStream out = null;
		 
		 try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(problem);
		 } catch (IOException e) {
			e.printStackTrace();
		 }
		 
		 try {
			if(out != null)
				out.close();
		 } catch (IOException e) {
			e.printStackTrace();
		 }
	 }

}
