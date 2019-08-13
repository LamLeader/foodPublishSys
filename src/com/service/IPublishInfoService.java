package com.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.model.Publish;
import com.uitls.PageBean;
@Service
public interface IPublishInfoService {
     
    /**
     * 
     * @Description  根据查询条件查询食谱
     * @Author 
     * @Date 2019年5月20日 下午11:01:18
     * @param user_name
     * @param pub_title
     * @param userName
     * @param currentPage
     * @param pageSize
     * @return
     */
 	public PageBean<Publish> queryPublishinfo(Integer pub_type, String pub_title, 
			String userName,int userId,
			int currentPage,
			int pageSize);
 	
 	
 	/**
 	 * 信息添加
 	 * @param pub
 	 * @return
 	 */
	public  boolean savePublish(Publish pub);
	
	/**
 	 * 用户删除
 	 * @param pub
 	 * @return
 	 */
	public  boolean deletePublishById(Publish pub);
	
	
	/**
 	 * 根据id找到发布信息
 	 * @param pub
 	 * @return
 	 */
	public  Publish findPublishById(Publish pub);
 	
	
    
}
