package com.otime.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.otime.bean.Problem;
import com.otime.bean.ProblemSolveState;
import com.otime.bean.User;
import com.otime.dao.ProblemSolveStateDao;

public class ProblemSolveStateDaoTest {
	SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	
	@Test
	public void test_selectProblemSolveState() {
		System.out.println("test_selectProblemSolveState()------------------");
		try (SqlSession session = factory.openSession()) {
			ProblemSolveStateDao dao = session.getMapper(ProblemSolveStateDao.class);
			
			Integer userId = 1; 
			Integer problemId = 1;
			ProblemSolveState ProblemSolveState = dao.selectProblemSolveState(userId, problemId);
			System.out.println(ProblemSolveState);
		}
	}

	@Test
	public void test_insertProblemSolveState() {
		System.out.println("test_insertProblemSolveState()------------------");
		try (SqlSession session = factory.openSession()) {
			ProblemSolveStateDao dao = session.getMapper(ProblemSolveStateDao.class);
			
			User user = new User(); user.setId(1);
			Problem problem = new Problem(); problem.setId(2);
			Integer submitRecordId = 1;
			String state = "Accept";
			Date date = new Date();
			
			ProblemSolveState problemSolveState;
			problemSolveState = new ProblemSolveState(user, problem, submitRecordId, state, date);
			dao.insertProblemSolveState(problemSolveState);
//			session.commit();
		}
	}

	@Test
	public void test_selectProblemSolveStatesOfUser() {
		System.out.println("test_selectProblemSolveStatesOfUser()------------------");
		try (SqlSession session = factory.openSession()) {
			ProblemSolveStateDao dao = session.getMapper(ProblemSolveStateDao.class);
			
			Integer userId = 3; 
			List<ProblemSolveState> problemSolveStates = dao.selectProblemSolveStatesOfUser(userId);
			problemSolveStates.forEach(System.out::println);
		}
	}

	@Test
	public void test_updateProblemSolveState() {
		System.out.println("test_updateProblemSolveState()------------------");
		try (SqlSession session = factory.openSession()) {
			ProblemSolveStateDao dao = session.getMapper(ProblemSolveStateDao.class);
			
			User user = new User(); user.setId(2);
			Problem problem = new Problem(); problem.setId(1);
			Integer submitRecordId = 1;
			String state = "AC";
			Date date = new Date();
			
			ProblemSolveState problemSolveState;
			problemSolveState = new ProblemSolveState(user, problem, submitRecordId, state, date);
			dao.updateProblemSolveState(problemSolveState);
//			session.commit();
		}
		
	}

}
