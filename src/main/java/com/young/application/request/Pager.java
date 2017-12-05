package com.young.application.request;

import com.young.application.util.Constant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class Pager implements Serializable{
    private static Log log = LogFactory.getLog(Pager.class);

	private Integer showCount = 10;
	private Integer totalResult;
	private Integer currentPage = 1;
	private Integer totalPage;
    private List results;
	public Integer getShowCount() {
		return showCount;
	}
	public void setShowCount(Integer showCount) {
		this.showCount = showCount;
	}
	public Integer getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public void initPage(Query query, Query queryRows) {
        if (this.showCount == 0) {
            this.showCount = Constant.pageSize;
        }
        getQueryRows(queryRows);
        this.results = getQueryResult(query);
    }

    private void getQueryRows(Query query) {
        try {
            this.totalResult = Integer.parseInt(query.getResultList().get(0).toString());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            this.totalResult = 0;
        }
        initPageInfo();
    }

    public void initPageInfo() {
        this.totalPage = (this.totalResult + this.showCount - 1) / this.showCount;
        this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
        this.currentPage = getCurrentPage();
    }

    private List getQueryResult(Query query) {
        List listResult;

        if (currentPage < 1)
            currentPage = 1;
        listResult = query.setFirstResult((currentPage - 1) * showCount).setMaxResults(showCount).getResultList();
        return listResult;
    }
}
