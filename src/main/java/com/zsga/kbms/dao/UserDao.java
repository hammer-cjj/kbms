package com.zsga.kbms.dao;


import java.util.List;

import com.zsga.kbms.entity.User;

/**
 * 用户Dao接口
 * @author admin
 *
 */
public interface UserDao {

	/**
	 * 查询用户信息用于测试
	 * @return
	 */
	public User query();
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param user
	 * @return
	 */
	public User queryUserByUserNameAndPassword(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> queryUsers();
}
