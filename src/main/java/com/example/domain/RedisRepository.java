package com.example.domain;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepository {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void addOne(String key,Child child,long time){
        Gson gson = new Gson();
        stringRedisTemplate.opsForValue().set(key,gson.toJson(child),time, TimeUnit.MINUTES);
    }
}

