package com.otime.bean.impl;

import java.util.List;

import org.junit.Test;

import com.otime.bean.JudgeRecord;
import com.otime.dao.JudgeRecordDao;
import com.otime.dao.impl.JudgeRecordDaoImpl;

@SuppressWarnings("all")
public class JudgeRecordDaoImplTest{
	JudgeRecordDao judgeRecordDao = new JudgeRecordDaoImpl();
	
	@Test
	public void test_getJudgeRecord() {
		System.out.println("test_getJudgeRecord()------------------------------");
		JudgeRecord judgeRecord = judgeRecordDao.getJudgeRecord(1);
		System.out.println(judgeRecord);
	}

	@Test
	public void test_getJudgeRecordsOfSubmitRecord() {
		System.out.println("test_getJudgeRecordsOfSubmitRecord()---------------");
		List<JudgeRecord> judgeRecords = judgeRecordDao.getJudgeRecordsOfSubmitRecord(1);
		judgeRecords.forEach(System.out::println);
	}

	@Test
	public void test_addJudgeRecord() {
		System.out.println("test_addJudgeRecord()------------------------------");
		JudgeRecord judgeRecord = new JudgeRecord(7, 1, 12, 30, "WA");
		judgeRecordDao.addJudgeRecord(judgeRecord);
	}

	@Test
	public void test_removeJudgeRecord() {
		
	}

	@Test
	public void test_removeJudgeRecordsOfSubmitRecord() {
		
	}

	public static void main(String[] args) {
		JudgeRecordDaoImplTest judgeRecordDaoImplTest = new JudgeRecordDaoImplTest();
		judgeRecordDaoImplTest.test_addJudgeRecord();
	}
}
