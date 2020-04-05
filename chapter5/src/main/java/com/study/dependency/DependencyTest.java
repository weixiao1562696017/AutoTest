package com.study.dependency;

import org.testng.annotations.Test;

/**
 * TestNG依赖测试
 *
 * @Author Haley
 * @Date 2020/3/27 16:42
 **/
public class DependencyTest {
    /**
     * 方法A执行依赖方法B时，当B不成功，A也执行不了
     */
    @Test
    public void test1(){
        System.out.println("test1执行了");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2执行了");
    }
}
