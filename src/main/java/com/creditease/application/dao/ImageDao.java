package com.creditease.application.dao;

import com.creditease.application.entity.Image;
import com.creditease.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Repository
public interface ImageDao extends JpaRepository<Image,Long> {

}
