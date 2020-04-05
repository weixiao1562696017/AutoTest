package com.study.thread;

import org.testng.annotations.Test;

/**
 * TestNG多线程测试--基于注解
 *
 * @Author Haley
 * @Date 2020/3/27 18:44
 **/
public class MultiThreadOnAnnot {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void Test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
