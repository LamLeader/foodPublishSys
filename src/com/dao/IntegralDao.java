package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dao.comm.CrudDao;
import com.model.Integral;

@Repository
public interface IntegralDao  extends CrudDao<Integral>{
	
	public List<Integral> queryIntegralInfoByUserName(@Param("user_name") String user_name,
			@Param("currentPage") int currentPage,
			@Param("pageSize") int pageSize);
	public int countIntegralInfoByUserName(@Param("user_name") String user_name);
	
	
	
	public Integral getIntegralByUserId(@Param("user_id") int user_id);
}
