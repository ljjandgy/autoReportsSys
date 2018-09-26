package com.example.controller;

import com.example.domain.Child;
import com.example.domain.RedisRepository;
import com.example.domain.User;
import com.example.domain.UserRepository;
import com.example.mapper.UserMapper;
import com.example.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ApiController {
	static final Logger log = LoggerFactory.getLogger(ApiController.class);
	@Autowired
	UserMapper userMapper;
	@Autowired
	ReportService reportService;
	@Autowired
	RedisRepository redisRepository;
	@Autowired
	UserRepository userRepository;
	@Value("${com.name}")
	public String title;
	
	@RequestMapping("/hello")
    public String index() {
		String result = title;
		log.error("日志测试");
        return result;
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
	public String getChildFatherName(String id){
		Child child = userMapper.selectFatherNameById(id);
		return child.getFatherName();
	}
	@RequestMapping(value = "/test1",method = RequestMethod.GET)
	public String getChildFatherName1(){
		return reportService.test();
	}

	@RequestMapping(value = "/redisTest",method = RequestMethod.GET)
	public void insertRedis(){
		Child child = new Child();
		child.setName("redisTest");
		child.setMotherName("this is motherName");
		child.setFatherName("this is fatherName");
		child.setAddr("JiNan");
		child.setId("1");
		child.setSort(1);
		String key = "child First";
		long time = 100000l;
		redisRepository.add(key,child,time);
	}

	@RequestMapping(value = "mongoDBTest",method = RequestMethod.GET)
	public void insertMongoDB(){
		userRepository.deleteAll();
		userRepository.save(new User("嘻嘻","这只是个备注"));
		User user = userRepository.findByName("嘻嘻");
		System.out.println(user.getRemark());
	}

}
