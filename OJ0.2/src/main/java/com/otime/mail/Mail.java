package com.otime.mail;

public class Mail {
    //收件人地址
    private String recipientAddress;
    //邮件主题
    private String subject;
    //邮件内容
    private String content;
     
    public Mail(String recipientAddress, String subject, String content) {
		this.recipientAddress = recipientAddress;
		this.subject = subject;
		this.content = content;
	}
    
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Mail [recipientAddress=" + recipientAddress + ", subject=" + subject + ", content=" + content + "]";
	}
}
