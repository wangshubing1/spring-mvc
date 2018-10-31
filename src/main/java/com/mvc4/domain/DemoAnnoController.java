package com.mvc4.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: king
 * @Datetime: 2018/10/30
 * @Desc: TODO
 */
@Controller //声明这个类是个控制器
@RequestMapping("/anno") //映射此类的访问路径为/anno
public class DemoAnnoController {
    /*此方法未标注路径，因此使用类级别的路径/anno；produces可定制返回的response的媒体类型和字符集
    （需返回值是json对象，则设置produces="application/json;charset=UTF-8"）*/
    /*http://localhost:8080/mvc4/anno/*/
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:"+request.getRequestURI()+"can access";
    }
    /*
    演示接受路径参数，并在方法参数前结合@PathVariable使用，访问路径为/anno/pathvar/xx
     */
    /*http://localhost:8080/mvc4/anno/pathvar/xx*/
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,
                                            HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str: " + str;
    }
    /*演示常规的request参数获取，访问路径为/anno/requestParam?id=1*/
    /*http://localhost:8080/mvc4/anno/requestParam?id=1*/
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,
                                                 HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,id: " + id;

    }
    /*演示解释参数到对象，访问路径为/anno/obj?id=1&name=xx*/
    /*http://localhost:8080/mvc4/anno/obj?id=1&name=xx*/
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody //@ResponseBody也可以用在方法上
    public String passObj(DemoObj obj, HttpServletRequest request) {

        return "url:" + request.getRequestURL()
                + " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();

    }
    /*演示映射不同的路径到相同方法上，访问路径为/anno/name1或/anno/name2*/
    /*http://localhost:8080/mvc4/anno/name2
      http://localhost:8080/mvc4/anno/name1*/
    @RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access";
    }
}
