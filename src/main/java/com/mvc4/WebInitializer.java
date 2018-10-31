package com.mvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * @Author: king
 * @Datetime: 2018/10/29
 * @Desc: TODO web 配置类
 */
//WebApplicationInitializer是spring提供用来配置servlet3.0的配置接口，替代了web.xml

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 新建一个WebApplicationContext的注册配置类，并和当前的servletContext关联
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);

        // 注册Spring mvc的DispatchServlet
        Dynamic servlet = servletContext.addServlet("dispatcher",
                new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);

        // 日志配置(如果 classpath 里有  logback.xml文件， logback 会试图用它进行自我配置，所以下面两句代码可以不写)
        /*servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);*/

    }
}
