package com.zsga.kbms.dao;

import java.util.List;

import com.zsga.kbms.entity.Link;

/**
 * 友情连接Dao接口
 * @author admin
 *
 */
public interface LinkDao {
	
	/**
	 * 添加友情连接
	 * @param link
	 * @return
	 */
	public int insertLink(Link link);
	
	/**
	 * 修改友情连接
	 * @param link
	 * @return
	 */
	public int updateLink(Link link);
	
	/**
	 * 删除友情连接
	 * @param id
	 * @return
	 */
	public int deleteLink(Integer id);
	
	/**
	 * 按照ID查询友情连接信息
	 * @param id
	 * @return
	 */
	public Link queryLinkById(Integer id);
	
	/**
	 * 分页查询友情连接
	 * @return
	 */
	public List<Link> queryLink();
	
	/**
	 * 查询排名前五的连接
	 * @return
	 */
	public List<Link> queryTop5Link();
}
