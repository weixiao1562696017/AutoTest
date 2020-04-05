package com.study.param;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Pojo类型传参
 *
 * @Author Haley
 * @Date 2020/3/27 18:06
 **/
public class PojoParamTest {
    /**
     * 单个方法提供pojo参数
     * @param name
     * @param age
     */
    @Test(dataProvider = "pojo")
    public void providerData(String name,int age){
        System.out.println("providerData中name="+name+" ;age="+age);
    }

    @DataProvider(name = "pojo")
    public Object[][] getData(){
        Object[][] objects=new Object[][]{
                {"zhangsan",10},
                {"lisi",20}
        };
        return objects;
    }

    /**
     * 多个测试方法中调用pojo对象参数
     * @param name
     * @param age
     */
    @Test(dataProvider = "data")
    public void Test1(String name,int age){
        System.out.println("Test1中name="+name+" ;age="+age);
    }

    @Test(dataProvider = "data")
    public void Test2(String name,int age){
        System.out.println("Test2中name="+name+" ;age="+age);
    }

    @DataProvider(name = "data")
    public Object[][] getData(Method method){
        Object[][] objects=null;
        if (method.getName().equals("Test1")){
            objects=new Object[][]{
                    {"张三",12},
                    {"李四",21}
            };
        }else if (method.getName().equals("Test2")){
            objects=new Object[][]{
                    {"王五",32},
                    {"赵六",21}
            };
        }
        return objects;
    }

}
