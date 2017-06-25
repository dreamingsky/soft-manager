package com.creditease.application.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by huiyangchen1 on 2017/6/24.
 */
@Configuration
@EnableWebMvc
public class InterceptorConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/").addResourceLocations("/**");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/leaf/**").addResourceLocations("/leaf/");
        registry.addResourceHandler("/public/**").addResourceLocations("/public/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DeaultInterceptor()).addPathPatterns("/**").excludePathPatterns("/leaf/");
    }

    @Override
     public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
         converters.add(new FormHttpMessageConverter());
     }

}
