package com.study.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * TestNg方法分组测试
 *
 * @Author Haley
 * @Date 2020/3/27 15:00
 **/
public class GroupOnMethod {
    @Test(groups = "server")
    public void Test1(){
        System.out.println("这是服务端组测试方法1");
    }
    @Test(groups = "server")
    public void Test2(){
        System.out.println("这是服务端组测试方法2");
    }
    @Test(groups = "client")
    public void Test3(){
        System.out.println("这是客户端组测试方法3");
    }
    @Test(groups = "client")
    public void Test4(){
        System.out.println("这是服务端组测试方法4");
    }

    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.println("服务端组运行之前运行的方法");
    }
    @AfterGroups("server")
    public void afterGroupOnServer(){
        System.out.println("服务端组运行之后运行的方法");
    }

    @BeforeGroups("client")
    public void beforeGroupOnClient(){
        System.out.println("客户端组运行之前运行的方法");
    }
    @AfterGroups("client")
    public void afterGroupOnClient(){
        System.out.println("客户端组运行之后运行的方法");
    }
}
