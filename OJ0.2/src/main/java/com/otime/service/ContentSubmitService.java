package com.otime.service;

import com.otime.bean.SubmitRecord;
import com.otime.bean.User;

public interface ContentSubmitService {

	SubmitRecord submitContent(User user, Integer problemId, String contentType, String content);
	
}
