package com.mvc4.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: king
 * @Datetime: 2018/10/31
 * @Desc: TODO
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    /*******************这里是拦截器的调用********************/
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }
    @Override //注册拦截器
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");
    }

}
