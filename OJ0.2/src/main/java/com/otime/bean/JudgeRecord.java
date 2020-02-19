package com.otime.bean;

import java.io.Serializable;

public class JudgeRecord implements Serializable{
	private static final long serialVersionUID = -2886586483885077346L;
	
	public static final String AC = "AC";
	public static final String WA = "WA";
	public static final String TLE = "TLE";
	public static final String MLE = "MLE";
	public static final String RE = "RE";
	
	private Integer id;
	private Integer submitRecordId;
	private Integer executionTime; 
	private Integer memoryCost;
	private String result;
	
	public JudgeRecord() {}

	public JudgeRecord(Integer executionTime, Integer memoryCost, String result) {
		this.executionTime = executionTime;
		this.memoryCost = memoryCost;
		this.result = result;
	}

	public JudgeRecord(Integer submitRecordId, Integer executionTime, Integer memoryCost, String result) {
		this.submitRecordId = submitRecordId;
		this.executionTime = executionTime;
		this.memoryCost = memoryCost;
		this.result = result;
	}

	public JudgeRecord(Integer id, Integer submitRecordId, Integer executionTime, Integer memoryCost, String result) {
		this.id = id;
		this.submitRecordId = submitRecordId;
		this.executionTime = executionTime;
		this.memoryCost = memoryCost;
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubmitRecordId() {
		return submitRecordId;
	}

	public void setSubmitRecordId(Integer submitRecordId) {
		this.submitRecordId = submitRecordId;
	}

	public Integer getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Integer executionTime) {
		this.executionTime = executionTime;
	}

	public Integer getMemoryCost() {
		return memoryCost;
	}

	public void setMemoryCost(Integer memoryCost) {
		this.memoryCost = memoryCost;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "JudgeRecord [id=" + id + ", submitRecordId=" + submitRecordId + ", executionTime=" + executionTime
				+ ", memoryCost=" + memoryCost + ", result=" + result + "]";
	}
}
