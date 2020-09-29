package com.young.application.page;

import com.young.application.system.util.Constant;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

@Data
public class Pager implements Serializable{
    private static Logger log = LoggerFactory.getLogger(Pager.class);

	private Integer showCount = 10;
	private Integer totalResult;
	private Integer currentPage = 1;
	private Integer totalPage;
    private List results;

    public void initPage(List resultList, int currentPage,int showCount,int totalResult) {
        if (this.showCount == 0) {
            this.showCount = Constant.pageSize;
        }
        this.results = resultList;
        this.totalResult = totalResult;
        this.currentPage = currentPage;
        this.showCount = showCount;
        initPageInfo();
    }


    public void initPageInfo() {
        this.totalPage = (this.totalResult + this.showCount - 1) / this.showCount;
        this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
        this.currentPage = getCurrentPage();
    }

}
