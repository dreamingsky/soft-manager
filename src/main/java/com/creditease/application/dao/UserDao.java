package com.creditease.application.dao;

import com.creditease.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {


    @Query("from User where userName=?1 and password=?2")
    public User getUserInfo(String username,String password);
}
