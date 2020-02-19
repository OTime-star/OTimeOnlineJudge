package com.otime.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otime.bean.ProblemSolveState;
import com.otime.bean.User;
import com.otime.constants.Constants;
import com.otime.constants.ProblemState;
import com.otime.excepiton.ServiceException;
import com.otime.service.ProblemSolveStateService;
import com.otime.service.UserService;

@Controller
public class UserController {
	private UserService userService;
	private ProblemSolveStateService problemSolveStateService;
	
	@Autowired
	public UserController(UserService userService, ProblemSolveStateService problemSolveStateService) {
		this.userService = userService;
		this.problemSolveStateService = problemSolveStateService;
		System.out.println("UserController constructor...");
	}
	
	@RequestMapping("/userSignin")
	public String signin(User user, HttpSession session, Model model) {
		String path = "verificationCode";
		try {
			userService.signin(user);
			session.setAttribute("user", user);
		} catch (ServiceException e) {
			path = "signin";
			model.addAttribute(Constants.ERROR_MESSAGE, e.getMessage());
		}
		return path;
	}
	
	@RequestMapping("/verificationCodeConfirm")
	public String signinConfirm(
			@RequestParam String verificationCode, 
			HttpSession session,
			Model model) {

		String path = "login";
		try {
			User user = (User) session.getAttribute("user");
			userService.signinConfirm(user, verificationCode);
			model.addAttribute(Constants.ERROR_MESSAGE, "注册成功:" + user.getNickname());
		} catch (ServiceException e) {
			path = "verificationCode";
			model.addAttribute(Constants.ERROR_MESSAGE, e.getMessage());
		}
		return path;		
	}
	
	@RequestMapping("/userLogin")
	public String login(@RequestParam String email,@RequestParam String password, HttpSession session, Model model) {
		try {
			User user = userService.login(email, password);
			session.setAttribute("user", user);
			
			return "forward:/problemList";
		} catch (ServiceException e) {
			model.addAttribute(Constants.ERROR_MESSAGE, e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/problemList";		
	}
	
	@RequestMapping("/user/userHome")
	public void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		
		List<ProblemSolveState> problemSolveStates = problemSolveStateService.getProblemSolveStatesOfUser(user.getId());
		
		List<ProblemSolveState> passProblemSovleStateList = new ArrayList<ProblemSolveState>();
		List<ProblemSolveState> notpassProblemSovleStateList = new ArrayList<ProblemSolveState>();
		
		split(problemSolveStates, passProblemSovleStateList, notpassProblemSovleStateList);
		
		req.setAttribute("passProblemSovleStateList", passProblemSovleStateList);
		req.setAttribute("notpassProblemSovleStateList", notpassProblemSovleStateList);
		req.getRequestDispatcher("/user/userHome.jsp").forward(req, resp);
	}
	
	private void split(List<ProblemSolveState> problemSolveStates, List<ProblemSolveState> passProblemSovleStateList,
			List<ProblemSolveState> notpassProblemSovleStateList) {
		for (ProblemSolveState problemSolveState : problemSolveStates) {
			if (problemSolveState.getState().equals(ProblemState.ACCEPT)) {
				passProblemSovleStateList.add(problemSolveState);
			} else {
				notpassProblemSovleStateList.add(problemSolveState);
			}
		}
	}
}
