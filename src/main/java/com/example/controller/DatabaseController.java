package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/freemarker")
public class DatabaseController {

    @RequestMapping("/test")
    public ModelAndView freemarkerTest(ModelAndView mv){
        mv.addObject("","");
        mv.setViewName("test1");//模板名称
        return mv;
    }
}
