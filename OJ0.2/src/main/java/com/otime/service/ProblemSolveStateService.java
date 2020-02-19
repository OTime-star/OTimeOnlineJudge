package com.otime.service;

import java.util.List;

import com.otime.bean.ProblemSolveState;

public interface ProblemSolveStateService {
	void updateProblemSolveState(ProblemSolveState problemSolveState);
	
	List<ProblemSolveState> getProblemSolveStatesOfUser(Integer userId);
}
