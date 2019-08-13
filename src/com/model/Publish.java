/**
 * 
 */
package com.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName Publish
 * @Description 
 * @Author 
 * @Date 2019年5月20日下午7:55:58
 */
public class Publish implements Serializable{
	  
	 private int id;
	 private String pub_title;//标题
	 private String pub_content;//内容
	 private float price;//价格
	 private String picture;//图片路径
	 private int pub_type;//type 1 食谱发布 2 美食圈发布  3 小知识发布
	 private String create_date;//发布时间
	 private String userName;//发布人
	 private int userId;
	 private MultipartFile upFile;//文件上传对象
	 public Publish(){
		 
	 }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getCreate_date() {
		return create_date;
	}


	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public MultipartFile getUpFile() {
		return upFile;
	}


	public void setUpFile(MultipartFile upFile) {
		this.upFile = upFile;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	 
	 
}
