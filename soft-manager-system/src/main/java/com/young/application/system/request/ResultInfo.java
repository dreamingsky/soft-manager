package com.young.application.system.request;

import java.util.List;

public class ResultInfo {
	
	/** 响应码（1：成功，2：失败） */
	private int code = 1;
	/** 响应信息描述 */
	private String desc = "操作成功";
	/** 总记录数  */
	private long total;
	/** 记录列表  */
	private List rows;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}

}
