package com.young.application.business.base.impl;

import com.young.application.base.BaseDao;
import com.young.application.business.base.BaseService;
import com.young.application.page.Pager;
import com.young.application.system.request.QueryPageBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {


    @Override
    public void save(T t) {
        getDao().insertSelective(t);
    }

    @Override
    public void deleteById(Long id) {
        getDao().deleteByPrimaryKey(id);
    }

    @Override
    public Pager findListByPage(QueryPageBean bean) {
        Pager pager = new Pager();
        List<T> userInfoList = getDao().findListByPage(bean);
        pager.initPage(userInfoList,bean.getPage(),bean.getRows(),bean.getTotal());
        return pager;
    }

    protected abstract BaseDao<T> getDao();


}
