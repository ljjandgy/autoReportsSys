package com.example.controller;

import com.example.domain.Child;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DatabaseController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/testInsert",method = RequestMethod.GET)
    public String insertChild(){
        Child child = new Child();
        child.setFatherName("反反复复");
        child.setMotherName("风风光光");
        child.setName("哼哼唧唧");
        userMapper.insertChild(child);
        return "yes";
    }

}
