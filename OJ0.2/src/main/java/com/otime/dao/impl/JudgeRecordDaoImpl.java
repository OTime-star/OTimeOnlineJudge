package com.otime.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.otime.bean.JudgeRecord;
import com.otime.dao.JudgeRecordDao;

public class JudgeRecordDaoImpl implements JudgeRecordDao{
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	
	@Override
	public JudgeRecord getJudgeRecord(Integer id) {
		try (SqlSession session = factory.openSession()) {
			JudgeRecordDao mapper = session.getMapper(JudgeRecordDao.class);
			return mapper.getJudgeRecord(id);
		}
	}

	@Override
	public List<JudgeRecord> getJudgeRecordsOfSubmitRecord(Integer submitRecordId) {
		try (SqlSession session = factory.openSession()) {
			JudgeRecordDao mapper = session.getMapper(JudgeRecordDao.class);
			return mapper.getJudgeRecordsOfSubmitRecord(submitRecordId);
		}
	}

	@Override
	public void addJudgeRecord(JudgeRecord judgeRecord) {
		try (SqlSession session = factory.openSession(true)) {
			JudgeRecordDao mapper = session.getMapper(JudgeRecordDao.class);
			mapper.addJudgeRecord(judgeRecord);
		}
	}

	@Override
	public void removeJudgeRecord(Integer id) {
		try (SqlSession session = factory.openSession()) {
			JudgeRecordDao mapper = session.getMapper(JudgeRecordDao.class);
			mapper.removeJudgeRecord(id);
		}
	}

	@Override
	public void removeJudgeRecordsOfSubmitRecord(Integer submitRecordId) {
		try (SqlSession session = factory.openSession()) {
			JudgeRecordDao mapper = session.getMapper(JudgeRecordDao.class);
			mapper.removeJudgeRecordsOfSubmitRecord(submitRecordId);
		}
	}

}
