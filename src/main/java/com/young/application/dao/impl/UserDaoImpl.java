package com.young.application.dao.impl;

import com.young.application.request.Pager;
import com.young.application.entity.User;
import com.young.application.request.UserBean;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public class UserDaoImpl {

    @PersistenceContext
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

    public Pager findUserByPage(UserBean bean) {
        Pager pager = new Pager();
        pager.setCurrentPage(bean.getPage());
        pager.setShowCount(bean.getRows());
        String hql = "from User where 1=1";
        Query query = entityManager.createQuery(hql,User.class);

        Query queryCount = entityManager.createQuery("select count(*) "+hql);

        pager.initPage(query,queryCount);

        return pager;

    }
}
