package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Haley
 * @Date 2020/4/3 10:31
 **/
@RestController
@RequestMapping("v2")
public class TestController {

    @GetMapping("/test")
    public String getData(String name,String param){
        System.out.println("name =" + name + "，param =" +param);
        return "测试并发情况";
    }
}
