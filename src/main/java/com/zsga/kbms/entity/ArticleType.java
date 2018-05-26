package com.zsga.kbms.entity;

/**
 * 文章分类实体类
 * @author admin
 *
 */
public class ArticleType {
	
	private Integer id;           //编号
	private String typeName;      //文章类型名称
	private Integer articleCount; //数量
	private Integer orderNo;      //排序 从小到大排序显示
	private Integer level;        //分类层级0 1 2
	private Integer parentId;     //上级分类 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
