package com.study.exception;

import org.testng.annotations.Test;

/**
 * TestNG异常测试
 *
 * @Author Haley
 * @Date 2020/3/27 15:13
 **/
public class Exception {

    /**
     * 什么时候会用到异常测试？
     * 在我们期望结果为某个异常的时候
     * 比如：我们传入了某个不合法的参数，程序抛出了异常
     * 也就是说我的预期结果就是这个异常
     */

    @Test(expectedExceptions = RuntimeException.class)
    public void RunTimeFail(){
        System.out.println("这是一个运行失败的异常");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void RunTimeSuccess(){
        System.out.println("这是一个运行成功的异常");
        throw new  RuntimeException();
    }
}
