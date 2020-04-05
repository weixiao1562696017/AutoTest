package com.study.groups;

import org.testng.annotations.Test;

/**
 * @Author Haley
 * @Date 2020/3/27 17:41
 **/
@Test(groups = "teacher")
public class GroupOnClass3 {

    public void Test1(){
        System.out.println("GroupOnClass3中的Test1方法执行");
    }

    public void Test2(){
        System.out.println("GroupOnClass3中的Test2方法执行");
    }
}
