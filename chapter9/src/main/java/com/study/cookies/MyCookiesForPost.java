package com.study.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 使用chapter5中cookiesDemo.json的数据
 * 结合mock框架，进行模拟携带cookie、json数据的post请求
 *
 * @Author Haley
 * @Date 2020/3/29 15:44
 **/
public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    @BeforeTest
    public void beforeTest(){
        // 获取到application.properties对象
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        // 获取test.url的值
        url = bundle.getString("test.url");
    }

    /**
     * 测试获取cookie的get请求
     * @throws IOException
     */
    @Test
    public void testGetCookies() throws IOException {
        String result;
        // 获取getCookies.uri值
        String uri;
        uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        // 获取cookies储存对象
        this.cookieStore = client.getCookieStore();
        // 获取cookies
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie : cookieList){
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            System.out.println("cookieName =" + cookieName + "; cookieValue =" + cookieValue);
        }
    }

    /**
     * 携带上面获取到的cookie访问的post请求
     */
    @Test(dependsOnMethods = "testGetCookies")
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("post.with.cookies.uri");
        String testUrl = this.url+uri;
        // 声明post请求对象及执行请求对象
        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        // 添加参数
        JSONObject params = new JSONObject();
        params.put("name","zhangsan");
        params.put("age","20");
        // 设置请求头header信息
        post.setHeader("content-type","application/json");
        // 添加参数到请求中
        StringEntity entity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(entity);
        // 添加cookie
        client.setCookieStore(this.cookieStore);
        // 执行post请求
        HttpResponse response = client.execute(post);
        // 获取响应结果（文本、json数据类型都可以用下面这个方法获取）
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        // 处理结果 将字符串转换成json对象
        JSONObject object = new JSONObject(result);
        String successValue = (String) object.get("success");
        String statusValue = (String) object.get("status");
        // 判断返回的值
        Assert.assertEquals("ok",successValue);
        Assert.assertEquals("1",statusValue);

    }
}
