package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Order;
import com.service.IOrderService;
import com.uitls.PageBean;

@Controller
public class OrderController {
	@Autowired
	private IOrderService OrderServiceImpl;
	
	/**
	 * 
	 * @Description 添加订单
	 * @Author 
	 * @Date 2019年5月21日 下午1:39:54
	 * @param session
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/orderSave.do")
	public String orderSave(HttpServletRequest req,Model model,Order order,
			@RequestParam(value="pub_id",required=false,defaultValue="0") int pub_id){
		HttpSession session=req.getSession();
		int user_id=(int) session.getAttribute("user_id");
		order.setPub_id(pub_id);order.setUser_id(user_id);
		boolean bol= OrderServiceImpl.saveOrder(order);
		if(bol){
			return "redirect:/queryOrderInfoByUserName.do?type=2";
		}else{
			return "redirect:/queryOrderInfoByUserName.do?type=2";
		}
		
	}
	/**
	 * 
	 * @Description  根据姓名查询订单信息 type 1 表示 管理员查询所有的订单 2 表示 用户查看自己的订单信息
	 * @Author 
	 * @Date 2019年5月26日 上午12:23:41
	 * @param model
	 * @param type
	 * @param userName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/queryOrderInfoByUserName.do")
	private String queryOrderInfoByUserName(Model model,HttpServletRequest req,
			@RequestParam(value="type",defaultValue="",required=false) int type,
			@RequestParam(value="userName",defaultValue="",required=false) String userName,
			@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
    		@RequestParam(value="pageSize",required=false,defaultValue="12") int pageSize) {
		PageBean<Order> pageBean=null;
		if(type==1){
			pageBean=OrderServiceImpl.queryOrderInfoByUserName(userName, pageNum, pageSize);
		}if(type==2){
			HttpSession session=req.getSession();
			String user_name1=(String) session.getAttribute("name");
			pageBean=OrderServiceImpl.queryOrderInfoByUserName(user_name1, pageNum, pageSize);
		}
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("userName", userName);
		return "web_orderinfo/web_orderinfo";
	}
	/**
	 * 根据姓名查询订单信息
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/getOrderInfoByOrderId.do")
	private String getOrderInfoByOrderId(Model model,@RequestParam(value="orderId",defaultValue="",required=false) int orderId) {
		Order order=OrderServiceImpl.getOrderInfoByOrderId(orderId);
		model.addAttribute("order", order);
		return "web_orderinfo/web_orderinfodetails";
	}
}
