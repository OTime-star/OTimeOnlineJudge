package com.otime.bean;

import java.io.Serializable;
import java.util.List;

public class Problem implements Serializable{
	private static final long serialVersionUID = -9146202052432516535L;
	
	private Integer id;
	private String title;
	private String description;
	private String inputFormat;
	private String outputFormat;
	private Integer timeLimit;
	private Integer memoryLimit;
	private Integer totalSubmissions;
	private Integer acceptSubmissions;
	private List<JudgeData> sampleJudgeDataList;
	private List<JudgeData> actualJudgeDataList;
	
	public Problem() {}
	
	public Problem(String title, String description, String inputFormat, String outputFormat, Integer timeLimit,
			Integer memoryLimit, List<JudgeData> sampleJudgeDataList, List<JudgeData> actualJudgeDataList) {
		this.title = title;
		this.description = description;
		this.inputFormat = inputFormat;
		this.outputFormat = outputFormat;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.sampleJudgeDataList = sampleJudgeDataList;
		this.actualJudgeDataList = actualJudgeDataList;
		
		this.acceptSubmissions = 0;
		this.totalSubmissions = 0;
	}

	public Problem(String title, String description, String inputFormat, String outputFormat, Integer timeLimit,
			Integer memoryLimit, Integer totalSubmissions, Integer acceptSubmissions,
			List<JudgeData> sampleJudgeDataList, List<JudgeData> actualJudgeDataList) {
		this.title = title;
		this.description = description;
		this.inputFormat = inputFormat;
		this.outputFormat = outputFormat;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.totalSubmissions = totalSubmissions;
		this.acceptSubmissions = acceptSubmissions;
		this.sampleJudgeDataList = sampleJudgeDataList;
		this.actualJudgeDataList = actualJudgeDataList;
	}

	public Problem(Integer id, String title, String description, String inputFormat, String outputFormat,
			Integer timeLimit, Integer memoryLimit, Integer totalSubmissions, Integer acceptSubmissions,
			List<JudgeData> sampleJudgeDataList, List<JudgeData> actualJudgeDataList) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.inputFormat = inputFormat;
		this.outputFormat = outputFormat;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.totalSubmissions = totalSubmissions;
		this.acceptSubmissions = acceptSubmissions;
		this.sampleJudgeDataList = sampleJudgeDataList;
		this.actualJudgeDataList = actualJudgeDataList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInputFormat() {
		return inputFormat;
	}
	public void setInputFormat(String inputFormat) {
		this.inputFormat = inputFormat;
	}
	public String getOutputFormat() {
		return outputFormat;
	}
	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}
	public Integer getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}
	public Integer getMemoryLimit() {
		return memoryLimit;
	}
	public void setMemoryLimit(Integer memoryLimit) {
		this.memoryLimit = memoryLimit;
	}
	public Integer getTotalSubmissions() {
		return totalSubmissions;
	}
	public void setTotalSubmissions(Integer totalSubmissions) {
		this.totalSubmissions = totalSubmissions;
	}
	public Integer getAcceptSubmissions() {
		return acceptSubmissions;
	}
	public void setAcceptSubmissions(Integer acceptSubmissions) {
		this.acceptSubmissions = acceptSubmissions;
	}
	public List<JudgeData> getSampleJudgeDataList() {
		return sampleJudgeDataList;
	}
	public void setSampleJudgeDataList(List<JudgeData> sampleJudgeDataList) {
		this.sampleJudgeDataList = sampleJudgeDataList;
	}
	public List<JudgeData> getActualJudgeDataList() {
		return actualJudgeDataList;
	}
	public void setActualJudgeDataList(List<JudgeData> actualJudgeDataList) {
		this.actualJudgeDataList = actualJudgeDataList;
	}
	
	// 手动添加的方法
	public String getAcceptRate() {
		if (totalSubmissions == 0) {
			return "---";
		} else {
			Integer rate = acceptSubmissions * 100 / totalSubmissions;
			return String.valueOf(rate);
		}
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", title=" + title + ", description=" + description + ", inputFormat="
				+ inputFormat + ", outputFormat=" + outputFormat + ", timeLimit=" + timeLimit + ", memoryLimit="
				+ memoryLimit + ", totalSubmissions=" + totalSubmissions + ", acceptSubmissions=" + acceptSubmissions
				+ ", sampleJudgeDataList=" + sampleJudgeDataList + ", actualJudgeDataList=" + actualJudgeDataList + "]";
	}
	
}
