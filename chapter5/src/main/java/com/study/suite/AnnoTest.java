package com.study.suite;

import org.testng.annotations.*;

/**
 * TestNG常用注解
 *
 * @Author Haley
 * @Date 2020/3/27 13:28
 **/
public class AnnoTest {
    // 用来把方法标记成测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod这是在测试方法前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod这是在测试方法后运行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在类运行之前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之后运行的");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
