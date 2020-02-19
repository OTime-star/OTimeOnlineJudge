package com.otime.service;

import java.util.List;

import com.otime.bean.SubmitRecord;

public interface SubmitRecordService {

	List<SubmitRecord> getSubmitRecords();

	SubmitRecord getSubmitRecordWithJudgeRecords(Integer submitRecordId);
}
