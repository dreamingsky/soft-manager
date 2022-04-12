package com.young.application.business.base.impl;

import com.young.application.base.BaseDao;
import com.young.application.business.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements BaseService<T> {


    @Override
    public void save(T t) {
        getDao().insertSelective(t);
    }

    @Override
    public void deleteById(Long id) {
        getDao().deleteByPrimaryKey(id);
    }

    protected abstract BaseDao<T> getDao();


}
