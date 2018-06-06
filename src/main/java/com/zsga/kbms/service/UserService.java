package com.zsga.kbms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.User;

/**
 * 用户Service接口
 * @author admin
 *
 */
public interface UserService {
	
	/**
	 * 查询用户信息用于测试
	 * @return
	 */
	public User find();
	
	/**
	 * 根据用户ID添加权限
	 * @param user
	 * @return
	 */
	public int addRoles(User user);
	
	/**
	 * 根据用户ID查询用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param user
	 * @return
	 */
	public User findUserByUserNameAndPassword(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public Integer editUser(User user);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public PageInfo<User> getUsers(Integer page, Integer rows);
}
