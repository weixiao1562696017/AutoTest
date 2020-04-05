package com.study.model;

import lombok.Data;

/**
 * @Author Haley
 * @Date 2020/3/30 10:19
 **/
@Data
public class AdeUserCase {
    private String userName;
    private String password;
    private Integer age;
    private Integer sex;
    private Integer permission;
    private Integer isDelete;
    private String expected;
}
