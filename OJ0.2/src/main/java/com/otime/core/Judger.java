package com.otime.core;

import java.util.List;

import com.otime.bean.JudgeRecord;
import com.otime.bean.Problem;
import com.otime.excepiton.JudgeException;

public interface Judger {
	public List<JudgeRecord> judge(Problem problem, String content) throws JudgeException;
	public String getContentType();
}
