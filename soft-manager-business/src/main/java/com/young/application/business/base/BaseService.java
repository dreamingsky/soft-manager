package com.young.application.business.base;

public interface BaseService<T> {

    public void save(T t);

    public void deleteById(Long id);

}
