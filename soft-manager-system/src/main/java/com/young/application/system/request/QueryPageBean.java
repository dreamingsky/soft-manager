package com.young.application.system.request;


public class QueryPageBean {
	
	/** 当前页码 */
	private int page = 1;
	/** 每页显示记录数（可变） */
	private int rows = 10;
	/** 排序字段 */
	private String sort = "id";
	/** 排序方式 */
	private String order = "desc";
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {

        this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {

        this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {

        this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {

        this.order = order;
	}
	
}
