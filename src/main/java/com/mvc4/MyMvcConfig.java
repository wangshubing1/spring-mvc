package com.mvc4;

import com.mvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;


/**
 * @Author: king
 * @Datetime: 2018/10/29
 * @Desc: TODO MVC 配置类。这里我们配置了一个jsp的ViewResolver，用来映射路径和实际页面的位置,
 * 其中@EnableWebMvc注解会开启一些默认的配置，如一些ViewResolver或者MessageConverter
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("com.mvc4")
//继承WebMvcConfigurerAdapter重写其方法对springMVC进行配置
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // 运行时代码会将页面自动编译到/WEB-INF/classes/views/下
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceLocations 文件放置的目录，addResourceHandler 对外暴露的访问路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver =
                new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return  multipartResolver;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }
    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }

}
