package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Integral;
import com.service.IntegralService;
import com.uitls.PageBean;

@Controller
public class IntegralController {
	@Autowired
	private IntegralService integralService;
	
	 
	
	/**
	 * 
	 * @Description  签到
	 * @Author 
	 * @Date 2019年5月21日 下午1:39:54
	 * @param session
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/signIn.do")
	public String SignIn(HttpServletRequest req,Model model,Integral inte,@RequestParam(value="id",defaultValue="",required=false) Integer id){
		HttpSession session=req.getSession();
		if(null!=id){
			inte.setId(id);
		}
		int userId=(int) session.getAttribute("user_id");
		inte.setUser_id(userId);
		boolean bol= integralService.updateIntegralById(inte);
		if(bol){
			return "redirect:/querySingnByUserName.do?type=2";
		}else{
			return "redirect:/querySingnByUserName.do?type=2";
		}
		
	}
	/**
	 * 
	 * @Description  根据姓名查询签到信息 type 1 表示 管理员查询所有的签到 2 表示 用户查看自己的签到信息
	 * @Author 
	 * @Date 2019年5月25日 下午11:45:17
	 * @param model
	 * @param req
	 * @param type
	 * @param user_name
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/querySingnByUserName.do")
	private String querySingnByUserName(Model model,HttpServletRequest req,
			@RequestParam(value="type",defaultValue="",required=false) int type,
			@RequestParam(value="user_name",defaultValue="",required=false) String user_name,
			@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
    		@RequestParam(value="pageSize",required=false,defaultValue="12") int pageSize) {
		PageBean<Integral> pageBean=null;
		if(type==1){
			pageBean=integralService.queryIntegralInfoByUserName(user_name, pageNum, pageSize);
		}if(type==2){
			HttpSession session=req.getSession();
			String user_name1=(String) session.getAttribute("name");
			pageBean=integralService.queryIntegralInfoByUserName(user_name1, pageNum, pageSize);
		}
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("user_name", user_name);
		return "web_singnnfo/web_signinfo";
	}
}
