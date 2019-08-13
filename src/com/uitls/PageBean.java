package com.uitls;
import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3635727820524554980L;
	/**list*/
	private List<T> list;
	/**总记录数*/
	private int allRow;
	/**总页数*/
	private int totalPage;
	/**当前页*/
	private int currentPage;
	/**每页记录数*/
	private int pageSize;
	/**页码开始索引和结束索引**/
	private PageIndex pageIndex;
	
	public PageIndex getPageIndex() {
		return pageIndex;
	}
	
	public void setPageIndex(PageIndex pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		this.pageIndex = PageIndex.getPageIndex(pageSize, currentPage, totalPage);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 当前页
	 * 
	 * @param page
	 * @return
	 */
	public static int countCurrentPage(int page) {
		int currentPage = 0;
		try {
			currentPage = (page == 0 ? 1 : page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentPage;
	}

	/**
	 * 总页数
	 * 
	 * @param pageSize
	 *            每页记录数
	 * @param allRow
	 *            总记录数
	 * @return
	 */
	public static int totalPage(int pageSize, int allRow) {
		int totalPage = 0;
		try {
			totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPage;
	}

	/**
	 * 当前页开始记录
	 * 
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public static int startRecords(int pageSize, int currentPage) {
		int offset = 0;
		try {
			if (currentPage > 0) {
				offset = pageSize * (currentPage - 1);
			} else {
				offset = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offset;
	}
}
