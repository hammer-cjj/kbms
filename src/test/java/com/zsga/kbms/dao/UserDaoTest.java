package com.zsga.kbms.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zsga.kbms.BaseTest;
import com.zsga.kbms.entity.User;

public class UserDaoTest extends BaseTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testQuery() {
		User user = userDao.query();
		System.out.println(user.getUserName());
	}
	
	@Test
	public void testqueryUserByUserNameAndPassword() {
		User user = new User();
		user.setUserName("zsga");
		user.setPassword("123");
		User resultUser = userDao.queryUserByUserNameAndPassword(user);
		if (resultUser == null) {
			System.out.println("用户名密码错误");
		} else {
			System.out.println(resultUser.getUserName());
			System.out.println(resultUser.getPassword());
		}
	}
}
