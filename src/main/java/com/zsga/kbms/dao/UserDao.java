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
	 * 根据用户ID添加权限
	 * @param user
	 * @return
	 */
	public int addRoles(User user);
	
	/**
	 * 根据用户ID查找用户信息
	 * @param id
	 * @return
	 */
	public User queryUserById(Integer id);
	
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
