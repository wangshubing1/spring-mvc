package com.mvc4.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: king
 * @Datetime: 2018/10/30
 * @Desc: TODO
 */
/*使用@RestController，声明是控制器，并且返回数据时不需要@ResponseBody*/
@RestController
@RequestMapping("/rest")
public class DemoRestController{
    //返回数据的媒体类型为json
    /*http://localhost:8080/mvc4/getjson?id=1&name=xx*/
    @RequestMapping(value = "/getjson", produces={"application/json;charset=UTF-8"})
    public DemoObj getjson (DemoObj obj){
        //直接返回对象，对象会自动转换成json
        return new DemoObj(obj.getId()+1, obj.getName()+"yy");
    }
    //返回数据的媒体类型为xml
    /*http://localhost:8080/mvc4/getxml?id=1&name=xx*/
    @RequestMapping(value = "/getxml", produces={"application/xml;charset=UTF-8"})
    public DemoObj getxml(DemoObj obj){
        return new DemoObj(obj.getId()+1, obj.getName()+"yy");
    }

}
