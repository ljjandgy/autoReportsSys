package com.example.domain;

import org.springframework.data.annotation.Id;

public class User {
    private String name;
    private String remark;
    @Id
    private String id;

    public User(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
