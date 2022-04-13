package com.young.application.business.base;

import com.young.application.page.Pager;
import com.young.application.system.request.QueryPageBean;

public interface BaseService<T> {

    void save(T t);

    void deleteById(Long id);

    Pager findListByPage(QueryPageBean bean);

}
