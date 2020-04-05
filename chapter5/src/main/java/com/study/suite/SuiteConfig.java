package com.study.suite;

import org.testng.annotations.*;

/**
 * 套件测试
 *
 * @Author Haley
 * @Date 2020/3/27 14:00
 **/
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite运行了");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite运行了");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest在测试方法运行之前运行");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest在测试方法运行之后运行");
    }
}
