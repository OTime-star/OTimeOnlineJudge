package com.otime.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.otime.bean.User;
import com.otime.core.JudgerManger;
import com.otime.core.judgerImpl.StandardCPlusPlusCodeJudger;
import com.otime.core.judgerImpl.StandardJavaCodeJudger;

@WebListener
public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("standardJavaCodeJudger regist...");
		JudgerManger.registJudger(new StandardJavaCodeJudger()); 
		JudgerManger.registJudger(new StandardCPlusPlusCodeJudger());
		Map<String, User> waitConfirmUserMap = new HashMap<String, User>();
		sce.getServletContext().setAttribute("waitConfirmUserMap", waitConfirmUserMap);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
}
