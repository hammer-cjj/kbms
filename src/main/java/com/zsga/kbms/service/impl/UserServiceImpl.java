package com.zsga.kbms.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsga.kbms.dao.UserDao;
import com.zsga.kbms.entity.User;
import com.zsga.kbms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User find() {
		return userDao.query();
	}

	@Override
	public User findUserByUserNameAndPassword(User user) {
		return userDao.queryUserByUserNameAndPassword(user);
	}

	@Override
	public Integer editUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getUsers() {
		return userDao.queryUsers();
	}

}
