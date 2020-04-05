package com.study.model;

import lombok.Data;

/**
 * @Author Haley
 * @Date 2020/3/30 10:22
 **/
@Data
public class GetUserIListCase {
    private String userName;
    private Integer age;
    private Integer sex;
    private String expected;
}
