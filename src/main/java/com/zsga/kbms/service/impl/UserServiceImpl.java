package com.zsga.kbms.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsga.kbms.dao.UserDao;
import com.zsga.kbms.entity.ArticleType;
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
	public PageInfo<User> getUsers(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<User> userList = userDao.queryUsers();
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		return pageInfo;
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.queryUserById(id);
	}

	@Override
	public int addRoles(User user) {
		return userDao.addRoles(user);
	}

}
