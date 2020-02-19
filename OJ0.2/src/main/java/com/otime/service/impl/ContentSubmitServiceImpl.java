package com.otime.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.otime.bean.JudgeRecord;
import com.otime.bean.Problem;
import com.otime.bean.ProblemSolveState;
import com.otime.bean.SubmitRecord;
import com.otime.bean.User;
import com.otime.constants.JudgeConstants;
import com.otime.constants.ProblemState;
import com.otime.core.JudgerManger;
import com.otime.dao.JudgeRecordDao;
import com.otime.dao.SubmitRecordDao;
import com.otime.dao.impl.JudgeRecordDaoImpl;
import com.otime.dao.impl.ProblemDaoImpl;
import com.otime.dao.impl.SubmitRecordDaoImpl;
import com.otime.excepiton.JudgeException;
import com.otime.service.ContentSubmitService;
import com.otime.service.ProblemService;
import com.otime.service.ProblemSolveStateService;

@Service
public class ContentSubmitServiceImpl implements ContentSubmitService {
	
	private SubmitRecordDao submitRecordDao = new SubmitRecordDaoImpl();
	private JudgeRecordDao judgeRecordDao = new JudgeRecordDaoImpl();
	private ProblemDaoImpl problemDaoImpl = new ProblemDaoImpl();
	private ProblemService problemService = new ProblemServiceImpl();
	private ProblemSolveStateService problemSolveStateService = new ProblemSolveStateServiceImpl();
	
	@Override
	public SubmitRecord submitContent(User user, Integer problemId, String contentType, String content) {
		Problem problem = problemDaoImpl.getProblemWithActualJudgeData(problemId);
		
		String errorMsg = null;
		List<JudgeRecord> judgeRecords = null;
		try {
			judgeRecords = JudgerManger.judge(problem, contentType, content);			
			judgeRecords.forEach(System.out::println);
		} catch (JudgeException e) {
			errorMsg = e.getMessage();
		}
		
		Integer executionTime;
		Integer memoryCost;
		Integer score; 
		String result;
		Date date = new Date();
		
		if (errorMsg == null && judgeRecords != null && judgeRecords.size() != 0) {
			executionTime = calculateExecutionTime(judgeRecords);
			memoryCost = calculateMemoryCost(judgeRecords);
			score = calculateScore(judgeRecords);
			result = calculateResult(judgeRecords);
		} else {
			executionTime = 0;
			memoryCost = 0;
			score = 0;
			result = errorMsg;
		} 
		
		SubmitRecord submitRecord = new SubmitRecord(user, problem, contentType, content, executionTime, memoryCost, score, result, date, judgeRecords);
		
		System.out.println("submitRecord:" + submitRecord);
		
		submitRecordDao.addSubmitRecord(submitRecord);
		
		if (judgeRecords != null) {
			for (JudgeRecord judgeRecord : judgeRecords) {
				judgeRecord.setSubmitRecordId(submitRecord.getId());
				judgeRecordDao.addJudgeRecord(judgeRecord);
			}
		}
		
		problemService.updateTotalSubmissions(problemId);
		if (submitRecord.getResult().equals(ProblemState.ACCEPT)) {
			problemService.updateAcceptSubmissions(problemId);
		}
		
		ProblemSolveState problemSolveState = new ProblemSolveState(user, problem, submitRecord.getId(), result, date);
		problemSolveStateService.updateProblemSolveState(problemSolveState);
		
		return submitRecord;
	}
	
	private Integer calculateExecutionTime(List<JudgeRecord> judgeRecords) {
		int executionTime = 0;
		for (JudgeRecord judgeRecord : judgeRecords) {
			executionTime += judgeRecord.getExecutionTime();
		}
		return executionTime;
	}
	
	private Integer calculateMemoryCost(List<JudgeRecord> judgeRecords) {
		int memoryCost = 0;
		for (JudgeRecord judgeRecord : judgeRecords) {
			memoryCost += judgeRecord.getMemoryCost();
		}
		return memoryCost;
	}

	private Integer calculateScore(List<JudgeRecord> judgeRecords) {
		int acceptCount = 0;
		for (JudgeRecord judgeRecord : judgeRecords) {
			if (judgeRecord.getResult().equals(JudgeConstants.ACCEPET)) {
				acceptCount++;
			}
		}
		return acceptCount * 100 / judgeRecords.size();
	}
	
	private String calculateResult(List<JudgeRecord> judgeRecords) {
		String result = ProblemState.ACCEPT;
		for (JudgeRecord judgeRecord : judgeRecords) {
			if (!judgeRecord.getResult().equals(JudgeConstants.ACCEPET)) {
				result = ProblemState.NOT_ACCEPT;
				break;
			}
		}
		return result;
	}
}
