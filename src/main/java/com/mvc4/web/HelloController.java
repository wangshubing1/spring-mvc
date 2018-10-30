package com.mvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: king
 * @Datetime: 2018/10/29
 * @Desc: TODO
 */
@Controller // 声明是一个控制器
public class HelloController {
    // 通过@RequestMapping配置URL和方法之间的映射
    @RequestMapping("/index")
    public String hello(){
        // 通过InternalResourceViewResolver的Bean配置，说明我们的放置路径是/WEB-INF/classes/views/index.jsp
        return "index";
    }
}
