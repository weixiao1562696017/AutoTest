package com.study.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 *
 * @Author Haley
 * @Date 2020/3/29 14:21
 **/
public class MyCookiesForGet {

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
        String uri = bundle.getString("getCookies.uri");
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
     * 携带上面获取到的cookie访问的get请求
     */
    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("get.with.cookies.uri");
        String testUrl = this.url + uri;
        HttpGet httpGet = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        // 设置携带cookie
        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(httpGet);
        // 获取响应成功的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}
