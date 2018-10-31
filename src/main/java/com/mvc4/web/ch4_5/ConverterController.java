package com.mvc4.web.ch4_5;

import com.mvc4.domain.DemoObj;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: king
 * @Datetime: 2018/10/31
 * @Desc: TODO
 */
@Controller
public class ConverterController {
   //接收字符串转化为对象，然后把对象又转化为字符串输出。
    @RequestMapping(value="/convert",produces = {"application/x-wisely"})
    public @ResponseBody
    DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }

}
