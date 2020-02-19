package com.otime.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.otime.bean.User;
import com.otime.dao.UserDao;
import com.otime.dao.impl.SqlSessionFactoryHandler;
import com.otime.excepiton.ServiceException;
import com.otime.mail.MailUtil;
import com.otime.mail.SigninMail;
import com.otime.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();

	private Map<User, String> waitConfirmUsers = new HashMap<User, String>();
	
	@Override
	public void signin(User user) {
		try (SqlSession session = factory.openSession()) {
			UserDao userDao = session.getMapper(UserDao.class);
			
			String verificationCode = randomVerificationCode();
			waitConfirmUsers.put(user, verificationCode);
			
			if (userDao.selectByEmail(user.getEmail()) != null)
				throw new ServiceException("该邮箱已被注册");
			if (userDao.selectByNickname(user.getNickname()) != null)
				throw new ServiceException("该昵称已被使用");
			
			SigninMail signinMail = new SigninMail(user.getEmail(), verificationCode);
			try {
				MailUtil.send(signinMail);
			} catch (Exception e) {
				e.printStackTrace();
				waitConfirmUsers.remove(user);
				throw new ServiceException("邮件未能成功发送！请检查您的邮箱地址！");
			}
		}
	}
	
	private String randomVerificationCode() {
		Integer tem = (int) (Math.random() * 8999) + 1000;
		return String.valueOf(tem);
	}

	@Override
	public void signinConfirm(User user, String verificationCode) {
		try (SqlSession session = factory.openSession()) {
			UserDao userDao = session.getMapper(UserDao.class);
			String expectation = waitConfirmUsers.get(user);
			if (!verificationCode.equals(expectation)) 
				throw new ServiceException("验证码错误");
			if (userDao.selectByEmail(user.getEmail()) != null)
				throw new ServiceException("该邮箱已被注册");
			if (userDao.selectByNickname(user.getNickname()) != null)
				throw new ServiceException("该昵称已被使用");
			
			userDao.insert(user);
			session.commit();
		}
	}

	@Override
	public User login(String email, String password) {
		try (SqlSession session = factory.openSession()) {
			UserDao userDao = session.getMapper(UserDao.class);
			
			User user = userDao.selectByEmail(email);
			if (user == null)
				throw new ServiceException("该邮箱未注册");
			
			if (!password.equals(user.getPassword())) {
				throw new ServiceException("密码错误，请重新输入");
			}
			
			return user;
		}
	}

	

}
