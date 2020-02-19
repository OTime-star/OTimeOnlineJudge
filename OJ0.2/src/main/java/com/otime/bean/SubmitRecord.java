package com.otime.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SubmitRecord implements Serializable{
	private static final long serialVersionUID = 4616831246717912175L;
	
	private Integer id;
	private User user;
	private Problem problem;
	private String contentType;
	private String content;
	private Integer executionTime;
	private Integer memoryCost;
	private Integer score;
	private String result;
	private Date date;
	private List<JudgeRecord> judgeRecordList;
	
	public SubmitRecord() {}
	
	public SubmitRecord(User user, Problem problem, String contentType, String content, Integer executionTime,
			Integer memoryCost, Integer score, String result, Date date, List<JudgeRecord> judgeRecordList) {
		this.user = user;
		this.problem = problem;
		this.contentType = contentType;
		this.content = content;
		this.executionTime = executionTime;
		this.memoryCost = memoryCost;
		this.score = score;
		this.result = result;
		this.date = date;
		this.judgeRecordList = judgeRecordList;
	}

	public SubmitRecord(Integer id, User user, Problem problem, String contentType, String content,
			Integer executionTime, Integer memoryCost, Integer score, String result, Date date,
			List<JudgeRecord> judgeRecordList) {
		this.id = id;
		this.user = user;
		this.problem = problem;
		this.contentType = contentType;
		this.content = content;
		this.executionTime = executionTime;
		this.memoryCost = memoryCost;
		this.score = score;
		this.result = result;
		this.date = date;
		this.judgeRecordList = judgeRecordList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<JudgeRecord> getJudgeRecordList() {
		return judgeRecordList;
	}
	public void setJudgeRecordList(List<JudgeRecord> judgeRecordList) {
		this.judgeRecordList = judgeRecordList;
	}
	
	@Override
	public String toString() {
		return "SubmitRecord [id=" + id + ", user=" + user + ", problem=" + problem + ", contentType=" + contentType
				+ ", content=" + content + ", executionTime=" + executionTime + ", memoryCost=" + memoryCost
				+ ", score=" + score + ", result=" + result + ", date=" + date + ", judgeRecordList=" + judgeRecordList
				+ "]";
	}
}
