package com.example.mapper;

import com.example.domain.Child;
import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM child where _id=#{id}")
    Child selectFatherNameById(String id);
    @Insert("INSERT into child VALUES(UUID(),#{name},'济南',1,#{fatherName},#{motherName})")
    void insertChild(Child child);
}
