package com.otime.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otime.bean.JudgeData;
import com.otime.bean.Problem;
import com.otime.bean.ProblemSolveState;
import com.otime.bean.User;
import com.otime.service.ProblemService;
import com.otime.service.ProblemSolveStateService;

@Controller
public class ProblemController {
	private ProblemService problemService;
	private ProblemSolveStateService problemSolveStateService;
	
	public ProblemController(ProblemService problemService, ProblemSolveStateService problemSolveStateService) {
		this.problemService = problemService;
		this.problemSolveStateService = problemSolveStateService;
		System.out.println("ProblemController constructor...");
	}
	
	@RequestMapping("/user/problem")
	public String problem(@RequestParam Integer problemId, Model model) {
		Problem problem = problemService.getProblemWithSampleJudgeData(problemId);
		model.addAttribute("problem", problem); 
		return "user/problem";
	}
	
	@RequestMapping({"/", "/problemList"})
	public String problemList(HttpSession session) {
		List<ProblemSolveState> problemSolveStates = new ArrayList<ProblemSolveState>();
		
		String msg="未提交";
		if (session != null && session.getAttribute("user") != null) {
			User user = (User)session.getAttribute("user");
			problemSolveStates = problemSolveStateService.getProblemSolveStatesOfUser(user.getId());
		} else {
			msg = "未登录";
		}
		
		List<Problem> problemList = problemService.getProblems();
		Map<Integer, ProblemSolveState> map = wrapperToMap(problemList, msg); 
		map = merge(map, problemSolveStates);
		
		problemSolveStates = convert(map);
		session.setAttribute("problemSolveStateList", problemSolveStates);
		return "problemList";
	}
	
	@RequestMapping("/user/uploadProblem")
	public void problemUpload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		try{
			List<JudgeData> sampleJudgeData = new ArrayList<JudgeData>();
			List<JudgeData> actualJudgeData = new ArrayList<JudgeData>();
			
			
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String inputFormat = req.getParameter("inputFormat");
			String outputFormat = req.getParameter("outputFormat");
			String timeLimit = req.getParameter("timeLimit");
			String memoryLimit = req.getParameter("memoryLimit");
			
			try{
				for(int i = 1; true; i++){
					String sampleDataIn = req.getParameter("sampleJudgeData" + i + "In");
					String sampleDataOut = req.getParameter("sampleJudgeData" + i + "Out");
					if(sampleDataIn.isEmpty())
						break;
					sampleJudgeData.add(new JudgeData(sampleDataIn, sampleDataOut));
				}
			}catch(Exception e){
			}
			
			try{
				for(int i = 1; true; i++){
					String testDataIn = req.getParameter("actualJudgeData" + i + "In");
					String testDataOut = req.getParameter("actualJudgeData" + i + "Out");
					if(testDataIn.isEmpty())
						break;
					actualJudgeData.add(new JudgeData(testDataIn, testDataOut));
				}
			}catch(Exception e){
			}
			
			Problem problem = new Problem();
			problem.setTitle(title);
			problem.setDescription(description);
			problem.setInputFormat(inputFormat);
			problem.setOutputFormat(outputFormat);
			problem.setTimeLimit(Integer.valueOf(timeLimit));
			problem.setMemoryLimit(Integer.valueOf(memoryLimit));
			problem.setAcceptSubmissions(0);
			problem.setTotalSubmissions(0);
			problem.setSampleJudgeDataList(sampleJudgeData);
			problem.setActualJudgeDataList(actualJudgeData);
			
			problemService.addProblem(problem);
			System.out.println("PB Sub:" + problem);
			msg = "提交成功";
		}catch(Exception e){
			e.printStackTrace();
			msg = "输入数据有误";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/user/uploadProblemResult.jsp").forward(req, resp);
	}
	
	
	private List<ProblemSolveState> convert(Map<Integer, ProblemSolveState> map) {
		int size = map.size();
		List<ProblemSolveState> problemSolveStates = new ArrayList<ProblemSolveState>(size);
		
		for(ProblemSolveState problemSolveState : map.values()) {
			problemSolveStates.add(problemSolveState);
		}
		
		return problemSolveStates;
	}


	private Map<Integer, ProblemSolveState> merge(Map<Integer, ProblemSolveState> map,
			List<ProblemSolveState> problemSolveStates) {
		for (ProblemSolveState problemSolveState : problemSolveStates) {
			Problem problem = problemSolveState.getProblem();
			map.put(problem.getId(), problemSolveState);
		}
		return map;
	}



	private Map<Integer, ProblemSolveState> wrapperToMap(List<Problem> problemList, String msg) {
		Map<Integer, ProblemSolveState> map = new HashMap<Integer, ProblemSolveState>();
		
		for (Problem problem : problemList) {
			ProblemSolveState problemSolveState = new ProblemSolveState();
			problemSolveState.setProblem(problem);
			problemSolveState.setState(msg);
			
			map.put(problem.getId(), problemSolveState);
		}
		return map;
	}
}
