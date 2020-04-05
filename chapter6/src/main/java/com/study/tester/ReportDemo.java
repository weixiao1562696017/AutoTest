package com.study.tester;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * 模拟测试用例
 *
 * @Author Haley
 * @Date 2020/3/28 10:38
 **/
public class ReportDemo {

    @Test
    public void Test1(){
        // 给个测试逻辑
        Assert.assertEquals(1,2);
    }

    @Test
    public void Test2(){
        Assert.assertEquals("aa","aa");
    }

    @Test
    public void Test3(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void getLog(){
        Reporter.log("这是我自己写的日志");
        throw new RuntimeException("这是我自己运行时的异常");
    }
}
