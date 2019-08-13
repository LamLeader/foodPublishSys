package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dao.comm.CrudDao;
import com.model.Publish;

@Repository
public interface PublishDao  extends CrudDao<Publish>{
	
	/**
	 * @Description  信息发布查询
	 * @Author 
	 * @Date 2019年5月20日 下午8:11:08
	 * @param user_name
	 * @param pub_title
	 * @param userName
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Publish> queryPublishinfo(@Param("pub_type") Integer pub_type,@Param("pub_title") String pub_title, 
			@Param("userName") String userName,@Param("userId") int userId,
			@Param("currentPage") int currentPage,
			@Param("pageSize") int pageSize);
	
	public int countPublishinfo(@Param("pub_type") Integer pub_type,@Param("pub_title") String pub_title, 
			@Param("userName") String userName,@Param("userId") int userId);
}
