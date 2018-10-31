package com.mvc4.web.advice;


import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: king
 * @Datetime: 2018/10/31
 * @Desc: TODO
 */
@ControllerAdvice //声明一个控制器建言
public class ExceptionHanderAdvice {
    @ExceptionHandler(value = Exception.class) //定义全局处理
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }
    @ModelAttribute //将键值对添加到全局
    public void addAttributes(Model model){
        model.addAttribute("msg", "额外信息");
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
