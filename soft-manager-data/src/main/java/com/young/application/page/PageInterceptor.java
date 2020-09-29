package com.young.application.page;

import com.young.application.system.request.QueryPageBean;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

@Intercepts({@Signature(type= StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {

    private int page;
    private int size;
    private String dbType;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("plugin is running...");
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        while(metaObject.hasGetter("h")){
            Object object = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(object);
        }
        while(metaObject.hasGetter("target")){
            Object object = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(object);
        }
        MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();
        if(mapId.matches(".+ByPage$")){
            ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
            QueryPageBean params = (QueryPageBean)parameterHandler.getParameterObject();
            page = params.getPage();
            size = params.getRows();
            String sql = (String) metaObject.getValue("delegate.boundSql.sql");

            //查询count
            String countSql = "select count(1) " + sql.substring(sql.indexOf("from"));
            Connection connection = (Connection)invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);
            ResultSet rs = countStatement.executeQuery();
            if(rs.next()) {
                params.setTotal(rs.getInt(1));
            }

            sql += " limit "+(page-1)*size +","+size;
            metaObject.setValue("delegate.boundSql.sql", sql);
        }
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.page = 10;
        this.dbType = properties.getProperty("dbType", "mysql");
    }


    public static void main(String[] agr){
        String sql = "select count(1) from 123";

        System.out.println(sql.substring(sql.indexOf("from")));
    }
}
