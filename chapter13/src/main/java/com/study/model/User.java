package com.study.model;

import lombok.Data;

/**
 * @Author Haley
 * @Date 2020/3/30 14:04
 **/
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private Integer sex;
    private Integer permission;
    private Integer isDelete;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", permission=" + permission +
                ", isDelete=" + isDelete +
                '}';
    }
}
