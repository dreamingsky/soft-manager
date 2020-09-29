package com.young.application.system.request;

import lombok.Data;

@Data
public class QueryPageBean {
	
	/** 当前页码 */
	private int page = 1;
	/** 每页显示记录数（可变） */
	private int rows = 10;
	/** 排序字段 */
	private String sort = "id";
	/** 排序方式 */
	private String order = "desc";

	private int total;

}
