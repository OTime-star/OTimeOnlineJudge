package com.otime.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.otime.bean.SubmitRecord;
import com.otime.dao.SubmitRecordDao;

public class SubmitRecordDaoImpl implements SubmitRecordDao{
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	
	@Override
	public SubmitRecord getSubmitRecord(Integer id) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			return mapper.getSubmitRecord(id);
		}
	}
	
	@Override
	public List<SubmitRecord> getSubmitRecords() {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			return mapper.getSubmitRecords();
		}
	}

	@Override
	public List<SubmitRecord> getSubmitRecords(Map<String, Object> map) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			return mapper.getSubmitRecords(map);
		}
	}

	@Override
	public SubmitRecord getSubmitRecordWithJudgeRecord(Integer id) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			return mapper.getSubmitRecordWithJudgeRecord(id);
		}
	}

	@Override
	public List<SubmitRecord> getSubmitRecordsOfProblem(Integer problemId) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			return mapper.getSubmitRecordsOfProblem(problemId);
		}
	}

	@Override
	public List<SubmitRecord> getSubmitRecordsOfUser(Integer userId) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			return mapper.getSubmitRecordsOfUser(userId);
		}
	}

	@Override
	public void addSubmitRecord(SubmitRecord submitRecord) {
		try (SqlSession session = factory.openSession(true)) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			mapper.addSubmitRecord(submitRecord);
		}
	}

	@Override
	public void removeSubmitRecord(Integer id) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			mapper.removeSubmitRecord(id);
		}
	}

	@Override
	public void removeSubmitRecordsOfProblem(Integer problemId) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			mapper.removeSubmitRecordsOfProblem(problemId);
		}
	}

	@Override
	public void removeSubmitRecordsOfUser(Integer userId) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao mapper = session.getMapper(SubmitRecordDao.class);
			mapper.removeSubmitRecordsOfUser(userId);
		}
	}
}
