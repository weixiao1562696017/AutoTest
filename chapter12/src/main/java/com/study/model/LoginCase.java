package com.study.model;

import lombok.Data;

/**
 * @Author Haley
 * @Date 2020/3/30 10:23
 **/
@Data
public class LoginCase {
    private Integer id;
    private String userName;
    private String password;
    private String expected;
}
