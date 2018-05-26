package com.zsga.kbms.dao;

import java.util.List;
import java.util.Map;

import com.zsga.kbms.entity.Comment;

/**
 * 评论Dao层
 * @author admin
 *
 */
public interface CommentDao {
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public Integer insert(Comment comment);
	
	/**
	 * 查询所有评论
	 * @return
	 */
	public List<Comment> queryList(Map<String, Object> map);
	
	/**
	 * 分页查询所有评论
	 * @return
	 */
	public List<Comment> queryComments();
	
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	public Integer deleteComments(Integer id);
	
	/**
	 * 审核评论 
	 * @param comment
	 * @return
	 */
	public Integer updateComment(Comment comment);
}
