package com.zsga.kbms.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 文章实体类
 * @author admin
 *
 */
public class Article {
	private Integer id;       //编号
	private String title;     //文章标题
	private String summary;   //摘要
	private Date releaseDate; //发布日期
	private Integer clickHit; //查看次数
	private Integer replyHit; //回复次数
	private String content;   //文章内容
	private String keyWord;   //关键字，空格隔开
	private ArticleType articleType; //文章类型
	private User user;          //作者
	 
	private String contentNoTag;     //文章内容 无网页标签 Lucene分词用
	private String releaseDateStr;   //发布日期字符串，只取年和月
	private Integer articleCount;    //文章数量
	private List<String> imagesList = new LinkedList<String>(); //文章里存在的图片 主要用于列表展示显示缩略图
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	public Integer getReplyHit() {
		return replyHit;
	}
	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public ArticleType getArticleType() {
		return articleType;
	}
	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}
	public String getContentNoTag() {
		return contentNoTag;
	}
	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
	public List<String> getImagesList() {
		return imagesList;
	}
	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
