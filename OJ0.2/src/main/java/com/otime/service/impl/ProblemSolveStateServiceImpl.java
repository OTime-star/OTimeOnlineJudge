package com.otime.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.otime.bean.Problem;
import com.otime.bean.ProblemSolveState;
import com.otime.bean.User;
import com.otime.constants.ProblemState;
import com.otime.dao.ProblemSolveStateDao;
import com.otime.dao.impl.SqlSessionFactoryHandler;
import com.otime.service.ProblemSolveStateService;

@Service
public class ProblemSolveStateServiceImpl implements ProblemSolveStateService{
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	
	@Override
	public void updateProblemSolveState(ProblemSolveState problemSolveState) {
		try (SqlSession session = factory.openSession()) {
			ProblemSolveStateDao dao = session.getMapper(ProblemSolveStateDao.class);
			
			User user = problemSolveState.getUser();
			Problem problem = problemSolveState.getProblem();
			
			ProblemSolveState old = dao.selectProblemSolveState(user.getId(), problem.getId());
			if (old == null) {
				dao.insertProblemSolveState(problemSolveState);
			} else {
				String oldState = old.getState();
				String newState = problemSolveState.getState();
				if (isBetter(newState, oldState)) {
					dao.updateProblemSolveState(problemSolveState);
				}
			}
			
			session.commit();
		}
	}

	@Override
	public List<ProblemSolveState> getProblemSolveStatesOfUser(Integer userId) {
		try (SqlSession session = factory.openSession()) {
			ProblemSolveStateDao dao = session.getMapper(ProblemSolveStateDao.class);
			return dao.selectProblemSolveStatesOfUser(userId);
		}
	}
	
	private boolean isBetter(String newState, String oldState) {
		if (getPriority(newState) >= getPriority(oldState))
			return true;
		return false;
	}
	
	private int getPriority(String state) {
		if (ProblemState.ACCEPT.equals(state)) {
			return 3;
		} else if (ProblemState.NOT_ACCEPT.equals(state)) {
			return 2;
		} else if (ProblemState.NOTCOMMITTED.equals(state)) {
			return 1;
		} else {
			return 0;
		}
	}
}
