package entity;

import java.io.Serializable;
import java.util.Vector;

public class Problem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -657853364394959597L;
	
	private int id;
	private String title;
	private String description;
	private String inputFormat;
	private String outputFormat;
	private int timeLimit;
	private int memoryLimit;
	private int totalSubmissions;
	private int acceptSubmissions;
	private Vector<JudgeData> sampleData;
	private Vector<JudgeData> testData;
	
	public Problem() {}

	public Problem(int id, String title, String description, String inputFormat, String outputFormat, int timeLimit,
			int memoryLimit, int totalSubmissions, int acceptSubmissions, Vector<JudgeData> sampleData,
			Vector<JudgeData> testData) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.inputFormat = inputFormat;
		this.outputFormat = outputFormat;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.totalSubmissions = totalSubmissions;
		this.acceptSubmissions = acceptSubmissions;
		this.sampleData = sampleData;
		this.testData = testData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getMemoryLimit() {
		return memoryLimit;
	}

	public void setMemoryLimit(int memoryLimit) {
		this.memoryLimit = memoryLimit;
	}

	public int getTotalSubmissions() {
		return totalSubmissions;
	}

	public void setTotalSubmissions(int totalSubmissions) {
		this.totalSubmissions = totalSubmissions;
	}

	public int getAcceptSubmissions() {
		return acceptSubmissions;
	}

	public void setAcceptSubmissions(int acceptSubmissions) {
		this.acceptSubmissions = acceptSubmissions;
	}

	public Vector<JudgeData> getSampleData() {
		return sampleData;
	}

	public void setSampleData(Vector<JudgeData> sampleData) {
		this.sampleData = sampleData;
	}

	public Vector<JudgeData> getTestData() {
		return testData;
	}

	public void setTestData(Vector<JudgeData> testData) {
		this.testData = testData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Problem [id=" + id + ", title=" + title + ", description=" + description + ", inputFormat="
				+ inputFormat + ", outputFormat=" + outputFormat + ", timeLimit=" + timeLimit + ", memoryLimit="
				+ memoryLimit + ", totalSubmissions=" + totalSubmissions + ", acceptSubmissions=" + acceptSubmissions
				+ ", sampleData=" + sampleData + ", testData=" + testData + "]";
	}

	
	

	
}
