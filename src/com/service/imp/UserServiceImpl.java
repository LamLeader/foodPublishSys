package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.dao.IntegralDao;
import com.dao.UserDao;
import com.model.Integral;
import com.model.User;
import com.service.IUserInfoService;
import com.uitls.PageBean;
@Service
public class UserServiceImpl implements IUserInfoService{
    
	@Autowired
	private UserDao userDao;
	@Autowired
	private IntegralDao inteDao;

	@Override
	public User loginUser(String user_num,String psw, String type) {
		// TODO Auto-generated method stub
		User info=userDao.loginUserInfo(user_num, psw, type);
		return info!=null?info:null;
	}

	@SuppressWarnings("static-access")
	@Override
	public PageBean<User> queryUserByName(String user_name,int userId, int currentPage, int pageSize) {
		PageBean<User> pageBean=new  PageBean<User>();;
		List<User> list=null;
		int allRow=0;//总条数
		int offset=0;//偏移量
			try {
				offset = (currentPage == 1 ? 0 : (currentPage-1)*pageSize);//开始页的索引，mysql 默认从零开始
				if (!(StringUtils.isEmpty(user_name))) {
					list=userDao.queryUserInfoByName(user_name,userId,offset, pageSize);//分页查询
				}else {
					list=userDao.queryUserInfoByName(null,userId,offset, pageSize);//分页查询
				}
				allRow=userDao.countUserInfoByName(user_name,userId);//统计
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
	public boolean saveUser(User user) {
		boolean bol=false;
		user.setUser_level("用户");
		int a=userDao.insert(user);
		Integral inte=new Integral();
		inte.setIntegral(1000);//默认注册的时候赠送1000积分
		inte.setUser_id(user.getId());
		int a1=inteDao.insert(inte);//插入
		if(a>0&&a1>0){
			bol=true;
		}
		return bol;
	}

	@Override
	public boolean deleteUserByiId(User user) {
		boolean bol=false;
		int a=userDao.delete(user);
		if(a>0){
			bol=true;
		}
		return bol;
	}

	@Override
	public User findUserById(User user) {
		User info=userDao.get(user);
		return info!=null?info:null;
	}

	@Override
	public boolean updateUserByiId(User user) {
		boolean bol=false;
		int a=userDao.update(user);
		if(a>0){
			bol=true;
		}
		return bol;
	}

}
