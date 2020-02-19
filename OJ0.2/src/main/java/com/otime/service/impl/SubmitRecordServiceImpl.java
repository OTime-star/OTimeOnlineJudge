package com.otime.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.otime.bean.JudgeRecord;
import com.otime.bean.SubmitRecord;
import com.otime.dao.JudgeRecordDao;
import com.otime.dao.SubmitRecordDao;
import com.otime.dao.impl.SqlSessionFactoryHandler;
import com.otime.service.SubmitRecordService;

@Service
public class SubmitRecordServiceImpl implements SubmitRecordService {
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	
	@Override
	public List<SubmitRecord> getSubmitRecords() {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao submitRecordDao = session.getMapper(SubmitRecordDao.class);
			return submitRecordDao.getSubmitRecords();
		}
	}

	@Override
	public SubmitRecord getSubmitRecordWithJudgeRecords(Integer submitRecordId) {
		try (SqlSession session = factory.openSession()) {
			SubmitRecordDao submitRecordDao = session.getMapper(SubmitRecordDao.class);
			JudgeRecordDao judgeRecordDao = session.getMapper(JudgeRecordDao.class);
			
			SubmitRecord submitRecord = submitRecordDao.getSubmitRecord(submitRecordId);
			List<JudgeRecord> judgeRecords = judgeRecordDao.getJudgeRecordsOfSubmitRecord(submitRecordId);
			
			submitRecord.setJudgeRecordList(judgeRecords);
			
			return submitRecord;
		}
	}

}
