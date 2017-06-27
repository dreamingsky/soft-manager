package com.creditease.application.annotation;

import java.lang.annotation.*;

/**
 * Created by huiyangchen1 on 2017/6/27.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldAnno {

    public String name();
}
