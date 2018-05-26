package com.zsga.kbms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.Link;

/**
 * 友情连接Service层
 * @author admin
 *
 */
public interface LinkService {
	
	/**
	 * 查询排名前五的连接
	 * @return
	 */
	public List<Link> findTop5Link();
	
	/**
	 * 分页查询连接
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Link> findLink(Integer page, Integer rows);
	
	/**
	 * 添加连接
	 * @param link
	 * @return
	 */
	public Integer addLink(Link link);
	
	/**
	 * 更新连接
	 * @param link
	 * @return
	 */
	public Integer editLink(Link link);
	
	/**
	 * 删除连接
	 * @param id
	 * @return
	 */
	public Integer removeLink(Integer id);
}
