package com.otime.bean;

import java.io.Serializable;
import java.util.Date;

public class ProblemSolveState implements Serializable{
	private static final long serialVersionUID = 1L;

	private User user;
	private Problem problem;
	private Integer submitRecordId;
	private String state;
	private Date date;
	
	public ProblemSolveState() {}

	public ProblemSolveState(User user, Problem problem, Integer submitRecordId, String state, Date date) {
		this.user = user;
		this.problem = problem;
		this.submitRecordId = submitRecordId;
		this.state = state;
		this.date = date;
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

	public Integer getSubmitRecordId() {
		return submitRecordId;
	}

	public void setSubmitRecordId(Integer submitRecordId) {
		this.submitRecordId = submitRecordId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ProblemSolveState [user=" + user + ", problem=" + problem + ", submitRecordId=" + submitRecordId
				+ ", state=" + state + ", date=" + date + "]";
	}
}
