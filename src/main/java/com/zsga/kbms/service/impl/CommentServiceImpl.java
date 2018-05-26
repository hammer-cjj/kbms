package com.zsga.kbms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsga.kbms.dao.CommentDao;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.entity.Comment;
import com.zsga.kbms.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public Integer add(Comment comment) {
		return commentDao.insert(comment);
	}

	@Override
	public List<Comment> list(Map<String, Object> map) {
		return commentDao.queryList(map);
	}

	@Override
	public PageInfo<Comment> findComments(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Comment> commentList = commentDao.queryComments();
		PageInfo<Comment> pageInfo = new PageInfo<Comment>(commentList);
		return pageInfo;
	}

	@Override
	public Integer delete(Integer id) {
		return commentDao.deleteComments(id);
	}

	@Override
	public Integer update(Comment comment) {
		return commentDao.updateComment(comment);
	}

}
