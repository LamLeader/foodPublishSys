/**
 * 
 */
package com.model;

/**
 * @ClassName Order
 * @Description 
 * @Author 
 * @Date 2019年5月22日上午11:20:52
 */
public class Order extends Publish{
   
	 private int id;
	 private int user_id;//用户id
	 private int pub_id;//发布美食id
	 private int integral_id;//积分
	 private String create_date;//时间
	 
	 public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPub_id() {
		return pub_id;
	}

	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}

	public int getIntegral_id() {
		return integral_id;
	}

	public void setIntegral_id(int integral_id) {
		this.integral_id = integral_id;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	 
	
}
