package com.mvc4.interceptor;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;


/**
 * @Author: king
 * @Datetime: 2018/10/31
 * @Desc: TODO
 */
//继承HandlerInterceptorAdapter类实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter {


    /************解决乱码的问题*******************************/
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    @Override //请求完成前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }
    @Override //请求完成后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime =System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+ new Long(endTime-startTime));
        request.setAttribute("handLingTime",endTime-startTime);
    }

}
