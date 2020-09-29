package com.young.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * Created by huiyangchen1 on 2017/6/24.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/").addResourceLocations("/**");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DeaultInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/static/**","/public/**","/favicon/**");
    }

    @Override
     public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
         converters.add(new FormHttpMessageConverter());
     }

}
