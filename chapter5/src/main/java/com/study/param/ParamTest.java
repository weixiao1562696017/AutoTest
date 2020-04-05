package com.study.param;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * TestNG参数化测试
 *
 * @Author Haley
 * @Date 2020/3/27 17:03
 **/
public class ParamTest {
    /**
     * 参数化测试，基于xml文件
     */
    @Test
    @Parameters({"name","age"})
    public void test(String name,int age){
        System.out.println("name="+name+"; age="+age);
    }
}
