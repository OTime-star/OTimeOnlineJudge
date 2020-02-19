package com.otime.bean.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.otime.bean.User;
import com.otime.dao.UserDao;
import com.otime.dao.impl.SqlSessionFactoryHandler;

public class UserDaoImplTest {
	private SqlSessionFactory factory = SqlSessionFactoryHandler.getSqlSessionFactory();
	@Test
	public void test_insert() {
		System.out.println("test_insert()----------------------------------");
		try (SqlSession session = factory.openSession()) {
			UserDao mapper = session.getMapper(UserDao.class);
			
			User user = new User("OTimeCoder", "123456789@qq.com", "123456");
			mapper.insert(user);
			System.out.println("user:" + user);
		}
	}

	@Test
	public void test_selectByPrimaryKey() {
		System.out.println("test_selectByPrimaryKey()----------------------");
		try (SqlSession session = factory.openSession()) {
			UserDao mapper = session.getMapper(UserDao.class);
			
			User user = mapper.selectByPrimaryKey(1);
			System.out.println("user:" + user);
		}
	}

	@Test
	public void test_selectByEmail() {
		System.out.println("test_selectByEmail()----------------------");
		try (SqlSession session = factory.openSession()) {
			UserDao mapper = session.getMapper(UserDao.class);
			
			User user = mapper.selectByEmail("17361563928@qq.com");
			System.out.println("user:" + user);
		}
	}

	@Test
	public void test_selectAll() {
		System.out.println("test_selectAll()----------------------");
		try (SqlSession session = factory.openSession()) {
			UserDao mapper = session.getMapper(UserDao.class);
			
			List<User> users = mapper.selectAll();
			users.forEach(System.out::println);
		}
	}

	@Test
	public void test_updateByPrimaryKey() {
		System.out.println("test_updateByPrimaryKey()----------------------");
		try (SqlSession session = factory.openSession()) {
			UserDao mapper = session.getMapper(UserDao.class);
			User user = new User(1, "OTimeCoder", "17361563928@qq.com", "123456");
			mapper.updateByPrimaryKey(user);
			System.out.println(user);
		}
	}

	@Test
	public void test_deleteByPrimaryKey() {
		System.out.println("test_deleteByPrimaryKey()----------------------");
		try (SqlSession session = factory.openSession()) {
			UserDao mapper = session.getMapper(UserDao.class);
			mapper.deleteByPrimaryKey(2);
		}
	}

}
