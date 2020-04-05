package com.study.thread;

import org.testng.annotations.Test;

/**
 * 多线程测试--基于xml文件
 *
 * @Author Haley
 * @Date 2020/3/27 22:53
 **/
public class MultiThreadOnXml {
    @Test
    public void Test(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

}
