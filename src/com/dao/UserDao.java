package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dao.comm.CrudDao;
import com.model.User;

@Repository
public interface UserDao  extends CrudDao<User>{
	/**
	 * 用户登录
	 * @Description  TODO
	 * @Date 2019年5月14日 下午8:07:36
	 * @param user_name
	 * @param user_pwd
	 * @param user_level
	 * @return
	 */
	public User loginUserInfo(@Param("user_name") String user_name,@Param("user_pwd") String user_pwd,
			@Param("user_level") String user_level);
	/**
	 * 用户查询
	 * @Description  TODO
	 * @Date 2019年5月14日 下午8:07:48
	 * @param user_name
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<User> queryUserInfoByName(@Param("user_name") String user_name,@Param("userId") int userId,@Param("currentPage") int currentPage,
			@Param("pageSize") int pageSize);
	
	public int countUserInfoByName(@Param("user_name") String user_name,@Param("userId") int userId);
}
