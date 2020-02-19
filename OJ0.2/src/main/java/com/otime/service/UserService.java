package com.otime.service;

import com.otime.bean.User;

public interface UserService {
	void signin(User user);
	User login(String email, String password);
	void signinConfirm(User user, String verificationCode);
}
