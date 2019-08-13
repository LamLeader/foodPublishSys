package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Order;
import com.uitls.PageBean;

public interface IOrderService {
	   
     /**
 	 * 根据姓名查询订单信息
 	 * @param name
 	 * @return
 	 */
 	public PageBean<Order> queryOrderInfoByUserName(String  userName,int currentPage,int pageSize);
 	
 	
 	/**
 	 * 添加订单
 	 * @param Order order
 	 * @return
 	 */
	public  boolean saveOrder(Order order);
	
	
	
	/**
 	 * 根据id找到订单信息
 	 * @param Order
 	 * @return
 	 */
	public  Order findOrderById(Order order);
 	
	/**
 	 * 订单修改
 	 * @param Order order
 	 * @return
 	 */
	public  boolean updateIntegralById(Order order);
	
	/**
 	 * 订单删除
 	 * @param Order order
 	 * @return
 	 */
	public  boolean deletIntegralById(Order order);
	/**
	 * @Description  获取订单详情
	 * @Author 
	 * @Date 2019年5月22日 下午9:04:22
	 * @param orderId
	 * @return
	 */
	public Order getOrderInfoByOrderId(@Param("orderId") int orderId);
}
