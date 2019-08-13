package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IntegralDao;
import com.model.Integral;
import com.service.IntegralService;
import com.uitls.PageBean;
@Service
public class IntegralServiceImpl implements IntegralService{
   
	@Autowired
	private IntegralDao inteDao;
	
	@Override
	public PageBean<Integral> queryIntegralInfoByUserName(String user_name, int currentPage, int pageSize) {
		PageBean<Integral> pageBean=new  PageBean<Integral>();;
		List<Integral> list=null;
		int allRow=0;//总条数
		int offset=0;//偏移量
			try {
				offset = (currentPage == 1 ? 0 : (currentPage-1)*pageSize);//开始页的索引，mysql 默认从零开始
				list=inteDao.queryIntegralInfoByUserName(user_name, offset, pageSize);
				allRow=inteDao.countIntegralInfoByUserName(user_name);
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
	public boolean saveIntegral(Integral inte) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Integral findIntegralById(Integral inte) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean updateIntegralById(Integral inte) {
		boolean bol=false;
		Integral in=inteDao.get(inte);//获取积分
		if(null==in){
			inteDao.insert(inte);//如果数据库中没有签到记录则插入一条数据
		}else{
			inte.setIntegral(in.getIntegral()+10);//每次签到是在之前的前一次签到的基础上累加10
			int a=inteDao.update(inte);
			if(a>0){
				bol=true;
			}
		}
		return bol;
	}
  
  
}
