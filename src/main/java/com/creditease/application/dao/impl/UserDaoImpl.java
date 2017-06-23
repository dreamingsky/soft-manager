package com.creditease.application.dao.impl;

import com.creditease.application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public class UserDaoImpl {

    @PersistenceContext(unitName="myPersistenceUnit")
    private EntityManager entityManager;

    public User findUserByUserInfo(String username, String password){

        String hql = "from User where userName=:username and password=:pass";
        Query query = entityManager.createQuery(hql,User.class);
        query.setParameter("username",username);
        query.setParameter("pass",password);
        List<User> resultList = query.getResultList();
        if(!CollectionUtils.isEmpty(resultList)){
            return resultList.get(0);
        }
        return null;
    }
}
