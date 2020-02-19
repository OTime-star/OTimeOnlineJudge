package com.otime.dao;

import java.util.List;

import com.otime.bean.ProblemSolveState;

public interface ProblemSolveStateDao {
	ProblemSolveState selectProblemSolveState(Integer userId, Integer problemId);
	
	Integer insertProblemSolveState(ProblemSolveState problemSolveState);
	
	List<ProblemSolveState> selectProblemSolveStatesOfUser(Integer userId);

	void updateProblemSolveState(ProblemSolveState problemSolveState);
}
