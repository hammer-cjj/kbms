package com.zsga.kbms.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.Comment;

/**
 * 评论Service接口
 * @author admin
 *
 */
public interface CommentService {
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public Integer add(Comment comment);
	
	/**
	 * 查找用户评论信息
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String,Object> map);
	
	/**
	 * 分页查询评论信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Comment> findComments(Integer page, Integer rows);
	
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id); 
	
	/**
	 * 审核评论
	 * @param comment
	 * @return
	 */
	public Integer update(Comment comment);
}
