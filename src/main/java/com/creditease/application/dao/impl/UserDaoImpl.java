package com.creditease.application.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public class UserDaoImpl {

    @PersistenceContext(unitName="myPersistenceUnit")
    private EntityManager entityManager;
}
