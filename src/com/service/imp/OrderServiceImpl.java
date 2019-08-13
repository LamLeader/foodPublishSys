package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IntegralDao;
import com.dao.OrderDao;
import com.dao.PublishDao;
import com.dao.UserDao;
import com.model.Integral;
import com.model.Order;
import com.model.Publish;
import com.model.User;
import com.service.IOrderService;
import com.uitls.PageBean;
@Service
public class OrderServiceImpl implements IOrderService{
   
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private IntegralDao inteDao;
	@Autowired
	private PublishDao pubDao;
	@Override
	public PageBean<Order> queryOrderInfoByUserName(String userName, int currentPage, int pageSize) {
		PageBean<Order> pageBean=new  PageBean<Order>();;
		List<Order> list=null;
		int allRow=0;//总条数
		int offset=0;//偏移量
			try {
				offset = (currentPage == 1 ? 0 : (currentPage-1)*pageSize);//开始页的索引，mysql 默认从零开始
				
				if(!("").equals(userName)&&null!=userName){
					User use=new User();
					use.setUser_name(userName);
					User info=userDao.get(use);
					list=orderDao.queryOrderInfoByUserName(info.getId(), offset, pageSize);
					allRow=orderDao.countOrderInfoByUserName(info.getId());
				}else{
					list=orderDao.queryOrderInfoByUserName(-1, offset, pageSize);
					allRow=orderDao.countOrderInfoByUserName(-1);
				}
				pageBean.setAllRow(allRow);//设置总条数数据
				pageBean.setCurrentPage(PageBean.countCurrentPage(currentPage));//当前页
				pageBean.setPageSize(pageSize);//页面大小
				pageBean.setTotalPage(pageBean.totalPage(pageSize, allRow));//计算总页数
				pageBean.setList(list);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return	pageBean;
	}

	
	@Override
	public boolean saveOrder(Order order) {
		boolean bol=false;
		int a=orderDao.insert(order);
		
		Integral inter=new Integral();
		inter.setUser_id(order.getUser_id());
		Integral interInfo=inteDao.getIntegralByUserId(order.getUser_id());//根据id获取积分信息
		
		Publish pub=new Publish();
		pub.setId(order.getPub_id());
		Publish pubInfo=pubDao.get(pub);//根据id获取发布的美食信息
		
		inter.setIntegral(interInfo.getIntegral()-(int)pubInfo.getPrice());//积分剩余扣除 计算方法=积分-美食价格
		int a1=inteDao.update(inter);//修改
		
		if(a>0&&a1>0){
			bol=true;
		}
		return bol;
	}

	
	@Override
	public Order findOrderById(Order order) {
		return (Order) (orderDao.get(order)==null?null:orderDao.get(order));
	}

	
	@Override
	public boolean updateIntegralById(Order order) {
		boolean bol=false;
		int a=orderDao.update(order);
		if(a>0){
			bol=true;
		}
		return bol;
	}
	
	@Override
	public boolean deletIntegralById(Order order) {
		boolean bol=false;
		int a=orderDao.delete(order);
		if(a>0){
			bol=true;
		}
		return bol;
	}


	@Override
	public Order getOrderInfoByOrderId(int orderId) {
		return orderDao.getOrderInfoByOrderId(orderId);
	}
	
	
  
  
}
