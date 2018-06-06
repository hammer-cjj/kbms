package com.zsga.kbms.entity;

/**
 * 用户实体类
 * @author admin
 *
 */
public class User {
	private Integer id;       //编号
	private String userName;  //用户名
	private String password;  //密码
	private String proFile;   //简介
	private String nickName;  //昵称
	private String imageName; //头像
	private String sign;      //个性签名
	private Integer manage;   //0：普通用户；1：管理员
	private String role;      //权限
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProFile() {
		return proFile;
	}
	public void setProFile(String proFile) {
		this.proFile = proFile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Integer getManage() {
		return manage;
	}
	public void setManage(Integer manage) {
		this.manage = manage;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
