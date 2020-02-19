package com.otime.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otime.bean.SubmitRecord;
import com.otime.service.SubmitRecordService;

@Controller
public class SubmitRecordController {
	private SubmitRecordService submitRecordService;
	
	@Autowired
	public SubmitRecordController(SubmitRecordService submitRecordService) {
		this.submitRecordService = submitRecordService;
		System.out.println("SubmitRecordController constructor...");
	}
	
	@RequestMapping("/user/submitRecord")
	public String submitRecord(@RequestParam Integer submitRecordId, Model model) {		
		SubmitRecord submitRecord = submitRecordService.getSubmitRecordWithJudgeRecords(submitRecordId);
		model.addAttribute("submitRecord", submitRecord);
		return "user/submitRecord";
	}
	
	@RequestMapping("/user/submitRecords")
	public String submitRecords(Model model) {
		List<SubmitRecord> submitRecords = submitRecordService.getSubmitRecords();
		model.addAttribute("submitRecords", submitRecords);
		return "user/submitRecords";
	}
}
