package com.zsga.kbms.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 评论实体类
 * @author admin
 *
 */
public class Comment {
	private Integer id;       //编号
	private String userIp;    //用户IP
	private String content;   //评论内容
	private Date commentDate; //评论日期
	private Integer state;    //审核状态 : 0 待审核 1 审核通过 2 审核未通过
	
	private Article article;  //被评论文章

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}
