package com.otime.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.otime.bean.Problem;
import com.otime.dao.ProblemDao;

public class ProblemDaoImpl implements ProblemDao{
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	
	@Override
	public Problem getProblem(Integer id) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			return mapper.getProblem(id);
		}
	}

	@Override
	public Problem getProblemWithSampleJudgeData(Integer id) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			return mapper.getProblemWithSampleJudgeData(id);
		}
	}

	@Override
	public Problem getProblemWithActualJudgeData(Integer id) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			return mapper.getProblemWithActualJudgeData(id);
		}
	}

	@Override
	public Problem getProblemWithJudgeData(Integer id) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			return mapper.getProblemWithJudgeData(id);
		}
	}

	@Override
	public List<Problem> getProblems() {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			return mapper.getProblems();
		}
	}

	@Override
	public List<Problem> getProblems(Map<String, Object> map) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			return mapper.getProblems(map);
		}
	}

	@Override
	public void addProblem(Problem problem) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			mapper.addProblem(problem);
		}
	}

	@Override
	public void removeProblem(Integer id) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			mapper.removeProblem(id);
		}
	}

	@Override
	public void updataProblem(Integer id, Map<String, Object> map) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao mapper = session.getMapper(ProblemDao.class);
			mapper.updataProblem(id, map);
		}
	}

	@Override
	public void updateTotalSubmissions(Integer problemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAcceptSubmissions(Integer problemId) {
		// TODO Auto-generated method stub
		
	}

}
