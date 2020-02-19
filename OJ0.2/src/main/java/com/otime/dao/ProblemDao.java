package com.otime.dao;

import java.util.List;
import java.util.Map;

import com.otime.bean.Problem;
import com.otime.excepiton.DaoException;

public interface ProblemDao {
	public Problem getProblem(Integer id) throws DaoException;
	public Problem getProblemWithSampleJudgeData(Integer id) throws DaoException;
	public Problem getProblemWithActualJudgeData(Integer id) throws DaoException;
	public Problem getProblemWithJudgeData(Integer id) throws DaoException;
	
	public List<Problem> getProblems() throws DaoException;
	public List<Problem> getProblems(Map<String,Object> map) throws DaoException;
	
	public void addProblem(Problem problem) throws DaoException;
	public void removeProblem(Integer id) throws DaoException;
	public void updataProblem(Integer id, Map<String,Object> map) throws DaoException;

	public void updateTotalSubmissions(Integer problemId);
	public void updateAcceptSubmissions(Integer problemId);
}
