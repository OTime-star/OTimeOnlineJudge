package com.otime.bean.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.otime.bean.Problem;
import com.otime.bean.SubmitRecord;
import com.otime.bean.User;
import com.otime.dao.SubmitRecordDao;
import com.otime.dao.impl.SubmitRecordDaoImpl;

@SuppressWarnings("all")
public class SubmitRecordDaoImplTest {
	SubmitRecordDaoImpl submitRecordDaoImpl = new SubmitRecordDaoImpl();
	
	@Test
	public void test_getSubmitRecord() {
		System.out.println("test_getSubmitRecord()---------------------");
		SubmitRecord submitRecord = submitRecordDaoImpl.getSubmitRecord(1);
		System.out.println(submitRecord);
		System.out.println(submitRecord.getUser());
		System.out.println(submitRecord.getProblem());
	}

	@Test
	public void test_getSubmitRecords() {
		System.out.println("test_getSubmitRecords()---------------------");
		List<SubmitRecord> submitRecords = submitRecordDaoImpl.getSubmitRecords();
		submitRecords.forEach(System.out::println);
	}

	@Test
	public void test_getSubmitRecordWithJudgeRecord() {

	}

	@Test
	public void test_getSubmitRecordsOfProblem() {

	}

	@Test
	public void test_getSubmitRecordsOfUser() {

	}

	@Test
	public void test_addSubmitRecord() {
		User user = new User();
		user.setId(1);
		Problem problem = new Problem();
		problem.setId(1);
		String contentType = "java";
		int score = 0;
		String content = "import java.util.*;";
		int executionTime = 100;
		int memoryCost = 128;
		String reuslt = "Compile Error";
		
		System.out.println("test_addSubmitRecord()---------------------");
		SubmitRecord submitRecord;
		submitRecord = new SubmitRecord(1, user, problem, contentType, content, executionTime, memoryCost, score, reuslt, new Date(), null);
		submitRecordDaoImpl.addSubmitRecord(submitRecord);
		System.out.println(submitRecord);
	}

	@Test
	public void test_removeSubmitRecord() {
		
	}

	@Test
	public void test_removeSubmitRecordsOfProblem() {
		
	}

	@Test
	public void test_removeSubmitRecordsOfUser() {

	}
	
	public static void main(String[] args) {
		new SubmitRecordDaoImplTest().test_getSubmitRecord();
	}

}
