package com.young.application.annotation;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huiyangchen1 on 2017/6/27.
 */
public class AnnoUtil {

    /**
     *
     * @param cla//目标obj
     * @param dataList//原始list
     */
    public static List<Object> convertBean(Class cla,List<Object> dataList) throws Exception{

        List<Object> entityList = new ArrayList<Object>();
        if(!CollectionUtils.isEmpty(dataList)){
            for(Object obj : dataList){
                Object target = cla.newInstance();

                Field[] declaredFields = cla.getDeclaredFields();
                Field.setAccessible(declaredFields,true);
                for(Field field : declaredFields){

                    if(field.isAnnotationPresent(FieldAnno.class)){
                        //获取注解中的name
                        FieldAnno annotation = field.getAnnotation(FieldAnno.class);
                        String name = annotation.name();
                        //通过反射获取值
                        Field declaredField = obj.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);
                        Object value = declaredField.get(obj);
                        if(value == null)
                            value = "";
                        field.set(target,value.toString());
                    }

                }
                entityList.add(target);

            }
        }



        return entityList;

    }
}
