package com.otime.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.otime.bean.JudgeData;
import com.otime.bean.Problem;
import com.otime.dao.ActualJudgeDataDao;
import com.otime.dao.ProblemDao;
import com.otime.dao.SampleJudgeDataDao;
import com.otime.dao.impl.SqlSessionFactoryHandler;
import com.otime.service.ProblemService;

@Service
public class ProblemServiceImpl implements ProblemService{
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	
	@Override
	public Problem getProblemWithSampleJudgeData(Integer id) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao problemDao = session.getMapper(ProblemDao.class);
			return problemDao.getProblemWithSampleJudgeData(id);
		}
	}

	@Override
	public void updateTotalSubmissions(Integer problemId) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao problemDao = session.getMapper(ProblemDao.class);
			problemDao.updateTotalSubmissions(problemId);
			session.commit();
		}
	}

	@Override
	public void updateAcceptSubmissions(Integer problemId) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao problemDao = session.getMapper(ProblemDao.class);
			problemDao.updateAcceptSubmissions(problemId);
			session.commit();
		}
	}

	@Override
	public List<Problem> getProblems() {
		try (SqlSession session = factory.openSession()) {
			ProblemDao problemDao = session.getMapper(ProblemDao.class);
			return problemDao.getProblems();
		}
	}

	@Override
	public void addProblem(Problem problem) {
		try (SqlSession session = factory.openSession()) {
			ProblemDao problemDao = session.getMapper(ProblemDao.class);
			SampleJudgeDataDao sampleJudgeDataDao = session.getMapper(SampleJudgeDataDao.class);
			ActualJudgeDataDao actualJudgeDataDao = session.getMapper(ActualJudgeDataDao.class);
			
			problemDao.addProblem(problem);
			
			for (JudgeData judgeData : problem.getSampleJudgeDataList()) {
				judgeData.setProblemId(problem.getId());
				sampleJudgeDataDao.insert(judgeData);
			}
			
			for (JudgeData judgeData : problem.getActualJudgeDataList()) {
				judgeData.setProblemId(problem.getId());
				actualJudgeDataDao.insert(judgeData);
			}
			session.commit();
		}
	}
	
}
