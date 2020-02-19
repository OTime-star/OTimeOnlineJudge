package com.otime.mail;

import org.junit.Test;

public class MailUtilTest {

	@Test
	public void test() throws Exception {
		String recipientAddress = "1216713952@qq.com";
		String subject = "TEST";
		String content = "This is a test email";
		Mail mail = new Mail(recipientAddress, subject, content);
		MailUtil.send(mail);
	}
	
	@Test
	public void registMail_test() throws Exception {
		String recipientAddress = "1216713952@qq.com";
		Mail mail = new SigninMail(recipientAddress, "1234");
		MailUtil.send(mail);
	}

}
