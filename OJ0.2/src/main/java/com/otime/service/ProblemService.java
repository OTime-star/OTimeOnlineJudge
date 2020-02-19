package com.otime.service;

import java.util.List;

import com.otime.bean.Problem;

public interface ProblemService {

	Problem getProblemWithSampleJudgeData(Integer id);

	void updateTotalSubmissions(Integer problemId);

	void updateAcceptSubmissions(Integer problemId);

	List<Problem> getProblems();

	void addProblem(Problem problem);

}
