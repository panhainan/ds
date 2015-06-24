package com.ds.dreamstation.dto;

/**
 * @author phn
 * 
 */
public class Pages {

	private int currentPage; // 当前页数
	private int pageSize; // 每页显示的记录数
	private int totalPages; // 总页数
	private int allRecords; // 总记录数

	public Pages() {
		super();
	}

	/**
	 * @param pageSize
	 * @param allRecords
	 */
	public Pages(int size, int all, int current) {
		this.pageSize = size;
		this.allRecords = all;
		this.totalPages = calculateTotalPage(size, all);
		this.currentPage = judgeCurrentPage(current, this.totalPages);
	}

	/**
	 * TODO 计算总页数
	 * 
	 * @param pageSize
	 *            :每页的记录数
	 * @param allRecords
	 *            :总记录数
	 * @return 总页数
	 */
	private int calculateTotalPage(int size, int all) {
		int total = (all % size == 0) ? all / size : all / size + 1;
		if (total == 0) {
			total = 1;
		}
		return total;
	}

	/**
	 * TODO 计算当前页的开始记录数
	 * 
	 * @param pageSize
	 *            :每页记录数
	 * @param currentPage
	 *            :当前第几页
	 * @return 当前页开始记录数
	 */
	public int currentPageStartRecord() {
		int startRecord = this.pageSize * (this.currentPage - 1);
		return startRecord;
	}

	/**
	 * TODO 判断当前页是否为0或者大于总页数
	 * 
	 * @param page
	 *            :当前页
	 * @return 判断当前页的结果
	 */
	private int judgeCurrentPage(int current, int totalPages) {
		int currentPage = (current <= 0 || current > totalPages) ? 0 : current;
		return currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getAllRecords() {
		return allRecords;
	}

	@Override
	public String toString() {
		return "Pages [currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", allRecords=" + allRecords
				+ "]";
	}

}
