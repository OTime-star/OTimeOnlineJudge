package com.otime.mail;

public class SigninMail extends Mail{
	private static String subject = "OnlineJudge 账号注册";

	private String signinMail;
	
	public SigninMail(String signinMail, String verificationCode) {
		super(signinMail, subject, generalContent(verificationCode));
	}
	
	private static String generalContent(String verificationCode) {
		return "您好，欢迎注册OnlineJudge平台\r\n" + 
				"此次注册的验证码为：" + verificationCode;
	}

	public String getSigninMail() {
		return signinMail;
	}

	public void setSigninMail(String signinMail) {
		this.signinMail = signinMail;
	}

	@Override
	public String toString() {
		return "RegistMail [signinMail=" + signinMail + "]";
	}
}
