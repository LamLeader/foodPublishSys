package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PublishDao;
import com.model.Publish;
import com.service.IPublishInfoService;
import com.uitls.PageBean;
@Service
public class PublishServiceImpl implements IPublishInfoService{
    
	@Autowired
	private PublishDao pubDao;


	@Override
	public PageBean<Publish> queryPublishinfo(Integer pub_type, String pub_title, String userName,int userId, int currentPage,
			int pageSize) {
		PageBean<Publish> pageBean=new  PageBean<Publish>();;
		List<Publish> list=null;
		int allRow=0;//总条数
		int offset=0;//偏移量
			try {
				offset = (currentPage == 1 ? 0 : (currentPage-1)*pageSize);//开始页的索引，mysql 默认从零开始
				list=pubDao.queryPublishinfo(pub_type, pub_title, userName, userId,offset, pageSize);//分页查询
				allRow=pubDao.countPublishinfo(pub_type, pub_title, userName, userId);
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
	public boolean savePublish(Publish pub) {
		boolean bol=false;
		int a=pubDao.insert(pub);
		if(a>0){
			bol=true;
		}
		return bol;
	}

	@Override
	public boolean deletePublishById(Publish pub) {
		boolean bol=false;
		int a=pubDao.delete(pub);
		if(a>0){
			bol=true;
		}
		return bol;
	}

	@Override
	public Publish findPublishById(Publish pub) {
		return pubDao.get(pub)!=null?pubDao.get(pub):null;
	}

	


	

}
