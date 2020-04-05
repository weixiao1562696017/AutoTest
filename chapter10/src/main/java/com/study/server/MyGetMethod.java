package com.study.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Haley
 * @Date 2020/3/29 18:23
 **/
@RestController
@Api("这是我的全部get方法")
public class MyGetMethod {

    /**
     * 获取到cookies的get请求
     * @param response
     * @return
     */
    @GetMapping("/get/cookies")
    @ApiOperation(value = "获取到cookies的get请求")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        // 在响应中添加cookies
        response.addCookie(cookie);
        return "恭喜获得cookies信息";
    }

    /**
     * 携带cookies的get请求 ---用JMeter测试
     * @param request
     * @return
     */
    @GetMapping("/get/with/cookies")
    @ApiOperation(value = "携带cookies的get请求 ---用JMeter测试")
    public String getWithCookies(HttpServletRequest request){
        // 获取请求中的cookies
        Cookie[] cookies=request.getCookies();
        if (Objects.isNull(cookies)){
            return "没有cookies，不能往下访问";
        }
        for (Cookie cookie : cookies){
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            System.out.println("cookieName = "+ cookieName + ";cookieValue =" + cookieValue);
        }
        return "携带cookies访问的get请求";
    }

    /**
     * 携带参数的get请求
     * 第一种方式: url ? key=value & key=value
     *可加 @RequestParam 注解
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/get/list")
    @ApiOperation(value = "携带参数的get请求,一种方式: url ? key=value & key=value")
    public Map<String,String> getList(Integer start,Integer end){
        Map<String,String> map = new HashMap<>(16);
        map.put("衣服","200");
        map.put("鞋子","200");
        return map;
    }

    /**
     * 携带参数的get请求
     * 第二种方式：url /param1/param2
     *需要加 @PathVariable 注解
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/get/list/{start}/{end}")
    @ApiOperation(value = "携带参数的get请求,第二种方式：url /param1/param2")
    public Map<String,String> getList2(@PathVariable Integer start, @PathVariable Integer end){
        Map<String,String> map = new HashMap<>();
        map.put("衣服","200");
        map.put("鞋子","200");
        map.put("书包","100");
        return map;
    }
}
