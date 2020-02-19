package entity;

import java.io.Serializable;

public class JudgeData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8786020625037863145L;
	
	private String inputData;
	private String ouputData;
	
	public JudgeData() {

	}
	
	public JudgeData(String inputData, String ouputData) {
		this.inputData = inputData.trim();
		this.ouputData = ouputData.trim();
	}
	
	public String getInputData() {
		return inputData;
	}
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
	public String getOuputData() {
		return ouputData;
	}
	public void setOuputData(String ouputData) {
		this.ouputData = ouputData;
	}
	
	@Override
	public String toString() {
		return "JudgeData [inputData=" + inputData + ", ouputData=" + ouputData + "]";
	}
	
}
