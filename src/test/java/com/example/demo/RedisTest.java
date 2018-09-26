package com.example.demo;

import com.example.domain.Child;
import com.example.domain.RedisRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * redis操作测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisRepository redisRepository;
    @Test
    public void test(){
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
        Child child2 = redisRepository.getOne("child First");
        System.out.println(child2.getFatherName());
        redisRepository.delete("child First");
        List<Child> list = new ArrayList<Child>();
        for (int i = 0;i<10;i++){
            Child c = new Child();
            c.setSort(i);
            c.setFatherName("fatherName"+i);
            c.setName("name"+i);
            c.setMotherName("mother name"+i);
            list.add(c);
        }
        redisRepository.add("childList",list,10000);
        List<Child> sList = redisRepository.getList("childList");
        for (Child child1:sList){
            System.out.println(child1.getFatherName());
        }
    }
    @Before
    public void testBefore(){
        System.out.println("开始测试啦");
    }
    @After
    public void testAfter(){
        System.out.println("结束测试啦");
    }
}
