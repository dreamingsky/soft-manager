package com.creditease.application.annotation;

import java.lang.annotation.*;

/**
 * Created by huiyangchen1 on 2017/6/26.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ImageAnno {

    public String name();
}
