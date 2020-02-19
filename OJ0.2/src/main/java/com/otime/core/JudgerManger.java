package com.otime.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.otime.bean.JudgeRecord;
import com.otime.bean.Problem;
import com.otime.excepiton.JudgeException;

public class JudgerManger {
	private JudgerManger() {}
	
	private static Map<String, Judger> judgerMap = new HashMap<String, Judger>();
	
	public static void registJudger(Judger judger) {
		if (judger != null) {
			String contentType = judger.getContentType();
			judgerMap.put(contentType , judger);
		}
	}
	
	public static Judger getJudger(String contentType) {
		if (contentType != null)
			return judgerMap.get(contentType);
		return null;
	}
	
	public static List<JudgeRecord> judge(Problem problem, String contentType, String content) throws JudgeException{
		return getJudger(contentType).judge(problem, content);
	}
}
