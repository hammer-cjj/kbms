package com.zsga.kbms.entity;

/**
 * 友情连接实体类
 * @author admin
 *
 */
public class Link {
	private Integer id;      //编号
	private String linkName; //连接名称
	private String linkUrl;  //连接地址   
	private Integer orderNo; //排序号 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	
}
