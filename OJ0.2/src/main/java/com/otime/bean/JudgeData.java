package com.otime.bean;

import java.io.Serializable;

public class JudgeData implements Serializable{
	private static final long serialVersionUID = 2190904923845119569L;
	
	private Integer id;
	private Integer problemId;
	private String inputData;
	private String resultData;
	
	public JudgeData() {}
	
	public JudgeData(String inputData, String resultData) {
		this.inputData = inputData;
		this.resultData = resultData;
	}

	public JudgeData(Integer problemId, String inputData, String resultData) {
		this.problemId = problemId;
		this.inputData = inputData;
		this.resultData = resultData;
	}

	public JudgeData(Integer id, Integer problemId, String inputData, String resultData) {
		this.id = id;
		this.problemId = problemId;
		this.inputData = inputData;
		this.resultData = resultData;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProblemId() {
		return problemId;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public String getInputData() {
		return inputData;
	}
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
	public String getResultData() {
		return resultData;
	}
	public void setResultData(String resultData) {
		this.resultData = resultData;
	}
	
	@Override
	public String toString() {
		return "JudgeData [id=" + id + ", problemId=" + problemId + ", inputData=" + inputData + ", resultData="
				+ resultData + "]";
	}
}
