package com.mappper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM sys_user")
    List<User> getAll();
}
