package com.service;

import org.springframework.stereotype.Service;

import com.model.User;
import com.uitls.PageBean;
@Service
public interface IUserInfoService {
	/**
	 * 用户登录
	 * @param loginId
	 * @param password
	 * @param status
	 * @return
	 */
	public  User loginUser(String user_num,String psw, String type);
     
     /**
 	 * 根据姓名查询用户信息
 	 * @param name
 	 * @return
 	 */
 	public PageBean<User> queryUserByName(String user_name,int userId,int currentPage,int pageSize);
 	
 	
 	/**
 	 * 用户添加（注册）
 	 * @param User
 	 * @return
 	 */
	public  boolean saveUser(User user);
	
	/**
 	 * 用户删除
 	 * @param User
 	 * @return
 	 */
	public  boolean deleteUserByiId(User user);
	
	
	/**
 	 * 根据id找到用户
 	 * @param User
 	 * @return
 	 */
	public  User findUserById(User user);
 	
	/**
 	 * 用户修改
 	 * @param User
 	 * @return
 	 */
	public  boolean updateUserByiId(User user);
    
}
