package com.example.controller;

import com.mappper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseController {
    @Autowired
    UserMapper userMapper;

}
