package com.study.suite;

import org.testng.annotations.Test;

/**
 * 忽略测试 --本次测试，使不必要的测试用例执行
 *
 * @Author Haley
 * @Date 2020/3/27 14:49
 **/
public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore1执行");
    }

    /**
     * ignore2方法没有执行
     */
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2执行");
    }
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3执行");
    }
}
