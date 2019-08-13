/**
 * 
 */
package com.model;

/**
 * @ClassName User
 * @Description 
 * @Author
 * @Date 2019年5月14日下午7:54:58
 */
public class User {
	 
	  
	 private int  id;
	 private String user_name;
	 private String user_pwd;
	 private String create_date;
	 private String user_level;
	 private String user_phone;
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUser_level() {
		return user_level;
	}
	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	 
	 
	 
	  
}
