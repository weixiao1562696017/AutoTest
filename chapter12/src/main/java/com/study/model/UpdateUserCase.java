package com.study.model;

import lombok.Data;

/**
 * @Author Haley
 * @Date 2020/3/30 10:24
 **/
@Data
public class UpdateUserCase {
    private Integer id;
    private Integer userId;
    private String userName;
    private String password;
    private Integer age;
    private Integer sex;
    private Integer permission;
    private Integer isDelete;
    private String expected;
}
