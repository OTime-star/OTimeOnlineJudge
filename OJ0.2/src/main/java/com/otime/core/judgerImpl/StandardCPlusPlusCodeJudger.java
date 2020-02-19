package com.otime.core.judgerImpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.otime.bean.JudgeData;
import com.otime.bean.JudgeRecord;
import com.otime.bean.Problem;
import com.otime.core.Judger;
import com.otime.core.judgerImpl.util.Util;
import com.otime.excepiton.JudgeException;

public class StandardCPlusPlusCodeJudger implements Judger{
	private final String contentType = "C++";
	private Logger logger = Logger.getRootLogger();
	
	@Override
	public String getContentType() {
		return contentType;
	}
	
	@Override
	public List<JudgeRecord> judge(Problem problem, String content) throws JudgeException {
		List<JudgeRecord> result = new ArrayList<JudgeRecord>();
		
		String code = preprocess(content);
		
		String sourceCodeFile = writeToFile(code);
		
		String objectCodeFile = complieFile(sourceCodeFile);
		
		List<FutureTask<JudgeRecord>> taskList = new ArrayList<FutureTask<JudgeRecord>>();		
		List<JudgeData> judgeDataList = problem.getActualJudgeDataList();
		for(int i = 0; i < judgeDataList.size(); i++) {
			JudgeData data = judgeDataList.get(i);
			FutureTask<JudgeRecord> task = executeObjectCode(objectCodeFile, data, problem);
			
			taskList.add(task);
		}
		
		for (int i = 0; i < taskList.size(); i++) {
			JudgeRecord judgeRecord = null;
			try {
				judgeRecord = taskList.get(i).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			result.add(judgeRecord);
		}
		
		return result;
	}

	private String preprocess(String code) {
		return code;
	}

	private String writeToFile(String code) {
		String suffix = String.valueOf(new Date().getTime());
		String sourceCodeFile = "Main" + "_" + suffix + ".cpp";
		
		Util.writeFile(code, Util.sourceCodeFilePath + sourceCodeFile);
		
		return sourceCodeFile;
	}
	
	private String complieFile(String sourceCodeFile) {
		String objectCodeFile = sourceCodeFile.substring(0, sourceCodeFile.length() - 4);
		String sourceCodeFilePath = Util.sourceCodeFilePath + sourceCodeFile;
		String ojbectCodeFilePath = Util.ObjectCodeFilePath + "/" + objectCodeFile;
		logger.debug("ojbectCodeFilePath:" +  ojbectCodeFilePath);
		
		String complieCommand = "g++ " + sourceCodeFilePath + 
								" -o " + ojbectCodeFilePath;
		try {
			Process exec = Runtime.getRuntime().exec(complieCommand);
			FutureTask<String> task = readMessage(exec.getErrorStream());
			logger.info("compile sourceCode:" + complieCommand);
			exec.waitFor();
			String errorMessage = task.get();
			if (errorMessage != null) {
				logger.info(errorMessage);
				throw new JudgeException("Compile Error");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return objectCodeFile;
	}


	private FutureTask<String> readMessage(InputStream inputStream) {
		Callable<String> callable = new MessageReader(inputStream);
		FutureTask<String> futureTask = new FutureTask<String>(callable);
		Thread thread = new Thread(futureTask);
		thread.start();
		return futureTask;
	}
	
	
	private FutureTask<JudgeRecord> executeObjectCode(String objectCodeFile, JudgeData data, Problem problem) {
		Callable<JudgeRecord> callable = new ObjectCodeExecuteor(objectCodeFile, data, problem);
		FutureTask<JudgeRecord> futureTask = new FutureTask<JudgeRecord>(callable);
		Thread thread = new Thread(futureTask);
		thread.start();
		return futureTask;
	}
	
	private String compareResult(String outResult, String resultData) {
		outResult = outResult.trim();
		resultData = resultData.trim();
		logger.debug("compareResult(): outResult:" + outResult + " ,resultData:" + resultData);
		if (outResult.equals(resultData)) {
			return JudgeRecord.AC;
		}
		return JudgeRecord.WA;
	}

	private String generalUniqueMark(String info) {
		Long time = new Date().getTime();
		return String.valueOf(time) + info;
	}

	class MessageReader implements Callable<String>{
		private InputStream inputStream;
		public MessageReader(InputStream inputStream) {
			this.inputStream = inputStream;
		}
		@Override
		public String call() throws Exception {
			Scanner scanner = new Scanner(inputStream);
			StringBuilder message = new StringBuilder();
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				message.append(line);
				if (scanner.hasNext()) {
					message.append("\n");
				}
			}
			scanner.close();
			if (message.length() == 0)
				return null;
			return message.toString();
		}
	}

	class ObjectCodeExecuteor implements Callable<JudgeRecord> {
		private String objectCodeFile;
		private JudgeData data;
		private Problem problem;
		
		public ObjectCodeExecuteor(String objectCodeFile, JudgeData data, Problem problem) {
			this.objectCodeFile = objectCodeFile;
			this.data = data;
			this.problem = problem;
		}

		@Override
		public JudgeRecord call() throws Exception {
			String executeCommand = Util.ObjectCodeFilePath + "\\" + objectCodeFile + ".exe";
			
			String mark = generalUniqueMark(String.valueOf(data.getId()));
			String inputFilePath = Util.inputFilePath + mark + ".txt"; 
			String outputFilePath = Util.outputFilePath + mark + ".txt";
			logger.debug("inputFilePath:" + inputFilePath);
			logger.debug("outputFilePath:" + outputFilePath);
			
			Util.writeFile(data.getInputData(), inputFilePath);
			Util.writeFile("", outputFilePath);
			
			ProcessBuilder pb = new ProcessBuilder(executeCommand);
			pb.redirectInput(new File(inputFilePath));
			pb.redirectOutput(new File(outputFilePath));

			int executeTime = 0;
			String judgeResult;
			try {
				Process process = pb.start();
				Long startTime = new Date().getTime();
				logger.debug("start judge...");
				boolean stop = process.waitFor(problem.getTimeLimit(), TimeUnit.MILLISECONDS);
				
				Long endTime = new Date().getTime();
				executeTime = (int) (endTime - startTime);
				if (!stop && process.isAlive()) {
					process.destroyForcibly();
					process.waitFor();
					judgeResult = JudgeRecord.TLE;
				} else {
					String outResult = Util.readFile(outputFilePath);
					judgeResult = compareResult(outResult, data.getResultData());
				}
			} catch (IOException | InterruptedException e) {
				judgeResult = JudgeRecord.RE;
				e.printStackTrace();
			}
			
			JudgeRecord judgeRecord = new JudgeRecord(executeTime, 100, judgeResult);
			return judgeRecord;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Logger logger = Logger.getRootLogger();
		StandardCPlusPlusCodeJudger judger = new StandardCPlusPlusCodeJudger();
		String complieFile = judger.complieFile("Hello.cpp");
		logger.info("complieFile:" + complieFile);

		JudgeData data = new JudgeData(1, 1, "10 10", "20");
		Problem problem = new Problem();
		problem.setTimeLimit(1000);
		FutureTask<JudgeRecord> task = judger.executeObjectCode(complieFile, data, problem);
		logger.info(task.get());
	}
}
