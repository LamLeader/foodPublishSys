/**
 * 
 */
package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.IUserInfoService;
import com.uitls.PageBean;

/**
 * @ClassName UserController
 * @Description 
 * @Author 
 * @Date 2019年5月14日下午7:20:30
 */
@Controller
public class UserController {
    
	@Autowired
	private IUserInfoService  userInfoService;
	
    /**
     * 登录
     * @param userInfo
     * @return
     */
	@RequestMapping(value="/loginUserInfo.do")
	private String loginUserInfo(@RequestParam(value="user_phone",defaultValue="",required=false) String user_phone,
			@RequestParam(value="user_pwd",defaultValue="",required=false) String user_pwd,
			@RequestParam(value="type",defaultValue="",required=false) String type
			,Model model,HttpSession session){
		User userInfo= userInfoService.loginUser(user_phone, user_pwd, type);
		if(null!=userInfo){
			session.setAttribute("user_id", userInfo.getId());
			session.setAttribute("name", userInfo.getUser_name());
			session.setAttribute("type", userInfo.getUser_level());
			return "web_main";
		}else{
			model.addAttribute("msg", "账号或者密码有误请检查");
			return "web_login";
		}
		
		
	}
	/**
	 * 退出登录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/exitLogin.do")
	private String exitLogin(HttpSession session) {
		session.invalidate();//退出清除session
		return "web_login";
	}
	
	/**
	 * 打开注册窗口
	 * @Description  TODO
	 * @Author 
	 * @Date 2019年5月15日 上午11:46:22
	 * @return
	 */
	@RequestMapping(value="/regiser.do")
	public String regiser(){
		
		return "web_userinfo/register";
	}
	/**
	 * 用户注册
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/userInfoRegister.do")
	private String userInfoRegister(User userInfo,Model model) {
		boolean bol= userInfoService.saveUser(userInfo);
		if(bol){
			model.addAttribute("msg", "注册成功");
			return "web_login";
		}else{
			model.addAttribute("msg", "注册失败");
			return "web_login";
		}
		
	}
	/**
	 * 打开添加窗口
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/openUserInfoAdd.do")
	private String openUserInfoAdd() {
		
		return "web_userinfo/web_adduserinfo";
	}
	/**
	 * 用户添加
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/userInfoSave.do")
	private String userInfoSave(User userInfo,Model model) {
		boolean bol= userInfoService.saveUser(userInfo);
		if(bol){
			model.addAttribute("msg", "添加成功");
			return "redirect:/queryUserInfoByName.do";
		}else{
			model.addAttribute("msg", "添加失败");
			return "redirect:/queryUserInfoByName.do";
		}
		
	}
	/**
	 * 打开修改窗口
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/findUserById.do")
	private String findUserById(User userInfo,Model model,@RequestParam(value="id",defaultValue="",required=false) int id) {
		userInfo.setId(id);
		User 	userInfo1= userInfoService.findUserById(userInfo);
		if(null!=userInfo1){
			model.addAttribute("userInfo1", userInfo1);
			return "web_userinfo/web_updateuserinfo";
		}else{
			return "redirect:/queryUserInfoByName.do";
		}
		
	}
	/**
	 * 用户修改
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updateUserByiId.do")
	private String updateUserByiId(User userInfo,Model model) {
		boolean bol= userInfoService.updateUserByiId(userInfo);
		if(bol){
			model.addAttribute("msg", "添加成功");
			return "redirect:/queryUserInfoByName.do";
		}else{
			model.addAttribute("msg", "添加失败");
			return "redirect:/queryUserInfoByName.do";
		}
		
	}
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value="/deleteUserByiId.do")
	private String deleteUserByiId(@RequestParam(value="id",defaultValue="",required=false) int id) {
		User userInfo=new User();
		userInfo.setId(id);
		boolean bol=userInfoService.deleteUserByiId(userInfo);
		if(bol){
			return "redirect:/queryUserInfoByName.do";
		}else{
			return "redirect:/queryUserInfoByName.do";
		}
	}
	
	/**
	 * 根据姓名查询用户信息
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/queryUserInfoByName.do")
	private String queryUserInfoByName(Model model,HttpServletRequest req,
			@RequestParam(value="user_name",defaultValue="",required=false) String user_name,
			@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
    		@RequestParam(value="pageSize",required=false,defaultValue="12") int pageSize) {
		PageBean<User> pageBean=null;
		HttpSession session=req.getSession();
		String type=(String) session.getAttribute("type");
		if(!("").equals(type)&&null!=type&&type.equals("管理员")){
			pageBean=userInfoService.queryUserByName(user_name,-2, pageNum, pageSize);
		}else{
			int userId=(int) session.getAttribute("user_id");
			if(userId>0){
				pageBean=userInfoService.queryUserByName(user_name,userId, pageNum, pageSize);
			}
			
		}
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("user_name", user_name);
		return "web_userinfo/web_userinfo";
	}
	
	
	
	
	
	
}
