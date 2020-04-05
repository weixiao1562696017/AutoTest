package com.study.controller;

import com.study.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * @Author Haley
 * @Date 2020/3/30 14:06
 **/
@RestController
@Slf4j
@RequestMapping("v1")
@Api(value = "v1",description = "用户管理系统")
public class UserManager {

    /**获取sql语句执行对象
     */
    @Autowired
    private SqlSessionTemplate template;


    @PostMapping("/login")
    @ApiOperation(value = "登录接口，响应信息携带cookie",httpMethod = "post")
    public boolean Login(HttpServletResponse response, @RequestBody User user){
        int num = template.selectOne("login",user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        log.info("查看到的结果是" + num);
        if (num == 1){
            return true;
        }
        return false;
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户接口",httpMethod = "post")
    public boolean AddUser(HttpServletRequest request,@RequestBody User user){
        boolean flag = verifyCookies(request);
        int result = 0;
        if (flag != false){
            result = template.insert("addUser",user);
        }
        if (result > 0){
            log.info("添加用户的数量是："+ result);
            return true;
        }
        return false;
    }

    @ApiOperation(value = "获取用户(列表)信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        if(x==true){
            List<User> users = template.selectList("getUserInfo",user);
            log.info("getUserInfo获取到的用户数量是" +users.size());
            return users;
        }else {
            return null;
        }
    }


    @ApiOperation(value = "更新/删除用户接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        int i = 0;
        if(x==true) {
            i = template.update("updateUserInfo", user);
        }
        log.info("更新数据的条目数为:" + i);
        return i;

    }

    private boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            log.info("cookies为空");
            return false;
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                log.info("cookies验证通过");
                return true;
            }
        }
        return false;
    }
}
