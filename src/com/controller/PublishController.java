/**
 * 
 */
package com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Publish;
import com.service.IPublishInfoService;
import com.uitls.CommonUtils;
import com.uitls.PageBean;

/**
 * @ClassName PublishController
 * @Description 
 * @Author 
 * @Date 2019年5月14日下午7:20:30
 */
@Controller
public class PublishController {
    
	@Autowired
	private IPublishInfoService  pubInfoService;
	
	
	/**
	 * 
	 * @Description  初始化页面
	 * @Author 
	 * @Date 2019年5月20日 下午11:11:20
	 * @param model
	 * @param pub_type
	 * @param pub_title
	 * @param userName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/initIndex.do")
	private String initIndex(Model model,
			HttpServletRequest req,
			@RequestParam(value="pub_type",defaultValue="",required=false) Integer pub_type,
			@RequestParam(value="pub_title",defaultValue="",required=false) String pub_title,
			@RequestParam(value="userName",defaultValue="",required=false) String userName,
			@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
    		@RequestParam(value="pageSize",required=false,defaultValue="3") int pageSize) {
		
		
		PageBean<Publish> theRecipe=pubInfoService.queryPublishinfo(1, pub_title, userName,-1, pageNum, pageSize);
		PageBean<Publish> foodCircle=pubInfoService.queryPublishinfo(2, pub_title, userName,-1, pageNum, pageSize);
		PageBean<Publish> foodknowledge=pubInfoService.queryPublishinfo(3, pub_title, userName,-1, pageNum, pageSize);
		model.addAttribute("theRecipe", theRecipe);
		model.addAttribute("foodCircle", foodCircle);
		model.addAttribute("foodknowledge", foodknowledge);
		return "index";
	}
	
	
	/**
	 * 
	 * @Description  美食查询
	 * @Author 
	 * @Date 2019年5月20日 下午11:11:20
	 * @param model
	 * @param pub_type
	 * @param pub_title
	 * @param userName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/queryPublishInfo.do")
	private String queryPublishInfo(Model model,
			HttpServletRequest req,
			@RequestParam(value="pub_type",defaultValue="",required=false) Integer pub_type,
			@RequestParam(value="pub_title",defaultValue="",required=false) String pub_title,
			@RequestParam(value="userName",defaultValue="",required=false) String userName,
			@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
    		@RequestParam(value="pageSize",required=false,defaultValue="12") int pageSize) {
		PageBean<Publish> pageBean=null;
		HttpSession session=req.getSession();
		String type=(String) session.getAttribute("type");
		if(!("").equals(type)&&null!=type&&type.equals("管理员")){
			 pageBean=pubInfoService.queryPublishinfo(pub_type, pub_title,userName,-3,  pageNum, pageSize);
		}else{
			int userId=(int) session.getAttribute("user_id");
			if(userId>0){
				pageBean=pubInfoService.queryPublishinfo(pub_type, pub_title, userName,userId, pageNum, pageSize);
			}
			
		}
		model.addAttribute("pub_type", pub_type);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("userName", userName);
		model.addAttribute("pub_title", pub_title);
		return "web_pubinfo/web_publishinfo";
	}
	
	/**
	 * 打开美食发布窗口
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/openPublishInfoAdd.do")
	private String openPublishInfoAdd() {
		
		return "web_pubinfo/web_pubinfopublish";
	}
	/**
	 * 信息发布
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/publishInfoSave.do")
	private String publishInfoSave(@ModelAttribute Publish pub,Model model,HttpServletRequest request,
			HttpSession session) throws IllegalStateException, IOException {
	        boolean bol= false;
	        //如果文件不为空，写入上传路径
			if(!pub.getUpFile().isEmpty()) {
				//获取工程名
				String conetextPath=request.getSession().getServletContext().getContextPath();
				//上传文件路径
				String path = request.getSession().getServletContext().getRealPath("/fileStorage/");
				//上传文件名  需要保存的文件名
				String filename = pub.getUpFile().getOriginalFilename();
				String subStr=filename.substring(0, filename.indexOf("."));//截取以 . 结束的字符
				//用随机生成的时间替换目标元素并且以图片后缀 .png拼接 
				String strfilename=subStr.replace(subStr, CommonUtils.getCuttentDateTime())+".png";
			    File filepath = new File(path,strfilename);
			    String subStrPath=conetextPath+"/fileStorage/"+strfilename;
				System.out.println("--上传路径--："+path+"--文件保存的路径--："+subStrPath);
				//判断路径是否存在，如果不存在就创建一个
		        if (!filepath.getParentFile().exists()) { 
		        	filepath.getParentFile().mkdirs();
		        }
		        //将上传文件保存到一个目标文件当中
		        pub.getUpFile().transferTo(new File(path + File.separator + strfilename));
		        String userName=(String) session.getAttribute("name");//通过seeing获取登录的姓名
		        int userId=(int) session.getAttribute("user_id");
		        pub.setPicture(subStrPath);//图片存取路径
		        pub.setUserName(userName);
		        pub.setUserId(userId);
		        bol= pubInfoService.savePublish(pub);
		        if(bol){
		        	 return "redirect:/queryPublishInfo.do";//刷新页面
		        }else {
		        	return "redirect:/queryPublishInfo.do";//刷新页面
				}
		       
			} else {
				return "redirect:/queryPublishInfo.do";//刷新页面
			}
		
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value="/deletePublishById.do")
	private String deletePublishById(@RequestParam(value="id",defaultValue="",required=false) int id) {
		Publish pubInfo=new Publish();
		pubInfo.setId(id);
		boolean bol=pubInfoService.deletePublishById(pubInfo);
		if(bol){
			return "redirect:/queryPublishInfo.do";//刷新页面
		}else{
			return "redirect:/queryPublishInfo.do";//刷新页面
		}
	}
	/**
	 * 根据id获取发布美食详情
	 * @return
	 */
	@RequestMapping(value="/getPublishById.do")
	private String getPublishById(@RequestParam(value="id",defaultValue="",required=false) int id,Model model) {
		Publish pubInfo=new Publish();
		pubInfo.setId(id);
		Publish pub=pubInfoService.findPublishById(pubInfo);
		if(null!=pub){
			model.addAttribute("pub", pub);
			return "web_pubinfo/web_pubinfodetails";
		}else{
			return "web_pubinfo/web_pubinfodetails";
		}
	}
	
	
	
	
	
	
}
