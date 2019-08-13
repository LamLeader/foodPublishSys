package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dao.comm.CrudDao;
import com.model.Order;

@Repository
public interface OrderDao  extends CrudDao<Object>{
	
	public List<Order> queryOrderInfoByUserName(@Param("user_id") int user_id,
			@Param("currentPage") int currentPage,
			@Param("pageSize") int pageSize);
	public int countOrderInfoByUserName(@Param("user_id") int user_id);
	/**
	 * @Description  获取订单详情
	 * @Author 
	 * @Date 2019年5月22日 下午9:04:22
	 * @param orderId
	 * @return
	 */
	public Order getOrderInfoByOrderId(@Param("orderId") int orderId);
}
