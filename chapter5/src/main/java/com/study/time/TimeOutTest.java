package com.study.time;

import org.testng.annotations.Test;

/**
 * 超时测试
 *
 * @Author Haley
 * @Date 2020/3/27 23:17
 **/
public class TimeOutTest {
    @Test(timeOut = 3000)
    public void Success() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void Fail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
