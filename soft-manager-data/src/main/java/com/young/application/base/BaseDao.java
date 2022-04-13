package com.young.application.base;

import com.young.application.system.request.QueryPageBean;

import java.util.List;

public interface BaseDao<T> {


    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectList(T bean);

    List<T> findListByPage(QueryPageBean bean);
}
