package com.otime.dao;

import java.util.List;
import java.util.Map;

import com.otime.bean.SubmitRecord;

public interface SubmitRecordDao {
	public SubmitRecord getSubmitRecord(Integer id); 		
	public List<SubmitRecord> getSubmitRecords();
	public List<SubmitRecord> getSubmitRecords(Map<String, Object> map);
	public SubmitRecord getSubmitRecordWithJudgeRecord(Integer id);
	public List<SubmitRecord> getSubmitRecordsOfProblem(Integer problemId);
	public List<SubmitRecord> getSubmitRecordsOfUser(Integer userId);
	public void addSubmitRecord(SubmitRecord submitRecord);
	public void removeSubmitRecord(Integer id);
	public void removeSubmitRecordsOfProblem(Integer problemId);
	public void removeSubmitRecordsOfUser(Integer userId);
}
