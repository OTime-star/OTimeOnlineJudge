package com.otime.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.otime.bean.SubmitRecord;
import com.otime.bean.User;
import com.otime.service.ContentSubmitService;

@Controller
public class ContentSubmitController {
	private ContentSubmitService contentSubmitService;
	
	@Autowired
	public ContentSubmitController(ContentSubmitService contentSubmitService) {
		this.contentSubmitService = contentSubmitService;
		System.out.println("SubmitRecordController constructor...");
	}
	
	@RequestMapping("/user/contentSubmit")
	protected String doPost(Integer problemId, String contentType, String content, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		SubmitRecord submitRecord = contentSubmitService.submitContent(user, problemId, contentType, content);
		
		model.addAttribute("submitRecord", submitRecord);
		return "user/submitRecord";
	}
	
}
