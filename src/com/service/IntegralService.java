package com.service;

import com.model.Integral;
import com.uitls.PageBean;

public interface IntegralService {
	   
     /**
 	 * 根据姓名查询签到信息
 	 * @param name
 	 * @return
 	 */
 	public PageBean<Integral> queryIntegralInfoByUserName(String user_name,int currentPage,int pageSize);
 	
 	
 	/**
 	 * 签到
 	 * @param Integral inte
 	 * @return
 	 */
	public  boolean saveIntegral(Integral inte);
	
	
	
	/**
 	 * 根据id找到签到信息
 	 * @param User
 	 * @return
 	 */
	public  Integral findIntegralById(Integral inte);
 	
	/**
 	 * 签到叠加
 	 * @param User
 	 * @return
 	 */
	public  boolean updateIntegralById(Integral inte);
	
}
