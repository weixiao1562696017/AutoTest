package com.study.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * HttpClient框架小demo
 *
 * @Author Haley
 * @Date 2020/3/29 14:12
 **/
public class MyHttpClient {
    @Test
    public void Test() throws IOException {
        // 存放结果
        String result;
        // 创建get请求对象
        HttpGet get=new HttpGet("http://www.baidu.com");
        // 执行get请求
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        // 获取响应结果
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }
}
