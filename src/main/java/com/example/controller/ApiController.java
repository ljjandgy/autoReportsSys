package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.TestProperties;


@RestController
public class ApiController {
	@Value("${com.name}")
	public String title;
	
	@RequestMapping("/hello")
    public String index() {
		String result = title;
        return result;
    }
}
