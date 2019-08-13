package com.uitls;

public class PageIndex {
	/**
	 * 开始索引
	 */
	private long startindex;
	/**
	 * 结束索引
	 */
	private long endindex;
	
	public PageIndex() {
	}

	public PageIndex(long startindex, long endindex) {
		this.startindex = startindex;
		this.endindex = endindex;
	}

	public long getStartindex() {
		return startindex;
	}

	public void setStartindex(long startindex) {
		this.startindex = startindex;
	}

	public long getEndindex() {
		return endindex;
	}

	public void setEndindex(long endindex) {
		this.endindex = endindex;
	}
	/**
	 * 
	 * @Description: 概述：分页索引<br/>
	 * @MethodName getPageIndex
	 * @author Administrator
	 * @date 2015-1-16 下午11:50:39
	 * @version v1.0
	 * @param maxresult 每页获取的记录个数 
	 * @param pageIndex 当前页码 
	 * @param totalpage 总页数 
	 * @return
	 */
	public static PageIndex getPageIndex(long maxresult,int pageIndex,long totalpage){
		if(maxresult==0)maxresult=10;
		long startpage = pageIndex-(maxresult%2==0?maxresult/2-1:maxresult/2);
		long endpage = pageIndex+maxresult/2;
		if(startpage<1){
			startpage=1;
			if(totalpage>=maxresult){
				endpage = maxresult;
			}else{
				endpage = totalpage;
			}
		}
		if(endpage>totalpage){
			endpage=totalpage;
			if(totalpage>=maxresult){
				startpage=endpage-maxresult+1;
			}else{
				startpage = 1;
			}
		}
		return new PageIndex(startpage, endpage);
	}
	
}