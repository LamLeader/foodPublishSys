/**
 * 
 */
package com.model;

/**
 * @ClassName 签到表
 * @Description 
 * @Author 
 * @Date 2019年5月14日下午6:42:19
 */
public class Integral {
	
	 private int id;
	 private int integral;//签到积分签到一次10积分可兑换商品
	 private int pub_id;//发布美食id
	 private String pub_title;//标题
	 private String pub_content;//内容
	 private float price;//价格
	 private String picture;//图片路径
	 private int pub_type;//type 1 食谱发布 2 美食圈发布  3 小知识发布
	 private String userName;//发布人
	 
	 
	 
	 private int user_id;//用户id
	 private String user_name;
	 private String user_pwd;
	 private String user_level;
	 private String user_phone;
	 
	 
	 private String create_date;
	public Integral() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public int getPub_id() {
		return pub_id;
	}
	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getPub_title() {
		return pub_title;
	}
	public void setPub_title(String pub_title) {
		this.pub_title = pub_title;
	}
	public String getPub_content() {
		return pub_content;
	}
	public void setPub_content(String pub_content) {
		this.pub_content = pub_content;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getPub_type() {
		return pub_type;
	}
	public void setPub_type(int pub_type) {
		this.pub_type = pub_type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
