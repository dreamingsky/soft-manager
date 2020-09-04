package com.young.application.dao;

import com.young.application.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Repository
public interface ImageDao extends JpaRepository<Image,Long> {

}
