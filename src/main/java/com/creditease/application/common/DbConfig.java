package com.creditease.application.common;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Configuration
@EnableTransactionManagement
public class DbConfig {


    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Value("${spring.datasource.driver-class-name}")
    private String driveClass;

    @Value("${spring.datasource.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.max-active}")
    private int maxActive;

    @Value("${spring.datasource.max-wait}")
    private int maxWait;

    @Value("${spring.datasource.test-on-borrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.test-on-return}")
    private boolean testOnReturn;
    @Value("${spring.datasource.test-while-idle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.validation-query}")
    private String validationQuery;
    @Value("${spring.datasource.time-between-eviction-runs-millis}")
    private int runsMillis;
    @Value("${spring.datasource.min-evictable-idle-time-millis}")
    private int timeMillis;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private String showSql;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Bean(initMethod = "init",destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl);
        druidDataSource.setDriverClassName(driveClass);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        //druidDataSource.setMaxIdle();
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setMaxActive(maxActive);

        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTimeBetweenEvictionRunsMillis(runsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(timeMillis);

        return druidDataSource;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect",dialect);
        hibernateProperties.setProperty("ibernate.show_sql",showSql);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setPackagesToScan("com.creditease.application.entity");
        factoryBean.setJpaProperties(hibernateProperties);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.afterPropertiesSet();
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(dataSource());
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }
}
