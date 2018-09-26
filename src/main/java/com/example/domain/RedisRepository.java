package com.example.domain;

import com.google.gson.Gson;
import static org.apache.commons.lang.StringUtils.*;

import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepository {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 用于单对象存储
     * @param key
     * @param child
     * @param time
     */
    public void add(String key,Child child,long time){
        Gson gson = new Gson();
        stringRedisTemplate.opsForValue().set(key,gson.toJson(child),time, TimeUnit.MINUTES);
    }

    /**
     * 用于多对象存储
     * @param key
     * @param list
     * @param time
     */
    public void add(String key, List<Child> list,long time){
        Gson gson = new Gson();
        stringRedisTemplate.opsForValue().set(key,gson.toJson(list),time, TimeUnit.MINUTES);
    }

    /**
     * 获取单个对象
     * @param key
     * @return
     */
    public Child getOne(String key){
        String result = stringRedisTemplate.opsForValue().get(key);
        if (isNotBlank(result)){
            return new Gson().fromJson(result,Child.class);
        }
        return null;
    }

    /**
     * 获取集合
     * @param key
     * @return
     */
    public List<Child> getList(String key){
        String result = stringRedisTemplate.opsForValue().get(key);
        if (isNotBlank(result)){
            return new Gson().fromJson(result,new TypeToken<List<Child>>(){
            }.getType());
        }
        return null;
    }

    /**
     * 删除单条记录
     * @param key
     */
    public void delete(String key){
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }
}

