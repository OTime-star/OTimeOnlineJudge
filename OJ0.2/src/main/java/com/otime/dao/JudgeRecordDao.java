package com.otime.dao;

import java.util.List;

import com.otime.bean.JudgeRecord;

public interface JudgeRecordDao {
	public JudgeRecord getJudgeRecord(Integer id);						
	public List<JudgeRecord> getJudgeRecordsOfSubmitRecord(Integer submitRecordId);
	public void addJudgeRecord(JudgeRecord judgeRecord);
	public void removeJudgeRecord(Integer id);
	public void removeJudgeRecordsOfSubmitRecord(Integer submitRecordId);
}
