package com.mvc4.web.ch4_4;

import com.mvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: king
 * @Datetime: 2018/10/31
 * @Desc: TODO
 */
@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        throw new IllegalArgumentException("抱歉，参数有误/"+"来自@ModelAttribute"+msg);
    }
}
