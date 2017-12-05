package com.young.application.dao.impl;

import com.young.application.entity.Image;
import com.young.application.request.ImageBean;
import com.young.application.request.Pager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public class ImageDaoImpl {

    @PersistenceContext(unitName="myPersistenceUnit")
    private EntityManager entityManager;


    public Pager findImageByPage(ImageBean bean) {
        Pager pager = new Pager();
        pager.setCurrentPage(bean.getPage());
        pager.setShowCount(bean.getRows());
        String hql = "from Image where 1=1";
        Query query = entityManager.createQuery(hql,Image.class);

        Query queryCount = entityManager.createQuery("select count(*) "+hql);

        pager.initPage(query,queryCount);

        return pager;

    }
}
