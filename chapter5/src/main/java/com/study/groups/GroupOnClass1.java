package com.study.groups;

import org.testng.annotations.Test;

/**
 * TestNG类分组测试，基于xml文件实行
 *
 * @Author Haley
 * @Date 2020/3/27 17:41
 **/
@Test(groups = "student")
public class GroupOnClass1 {

    public void Test1(){
        System.out.println("GroupOnClass1中的Test1方法执行");
    }

    public void Test2(){
        System.out.println("GroupOnClass1中的Test2方法执行");
    }
}
