package com.example.controller;

import com.example.domain.Child;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.TestProperties;


@RestController
public class ApiController {
	@Autowired
	UserMapper userMapper;
	@Value("${com.name}")
	public String title;
	
	@RequestMapping("/hello")
    public String index() {
		String result = title;
        return result;
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
	public String getChildFatherName(String id){
		Child child = userMapper.selectFatherNameById(id);
		return child.getFatherName();
	}

}
