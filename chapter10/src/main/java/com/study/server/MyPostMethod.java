package com.study.server;

import com.study.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Haley
 * @Date 2020/3/29 21:52
 **/
@RestController
@Api("这是我的全部post请求")
public class MyPostMethod {

    private Cookie cookie;

    /**
     * 用户登录成功获取到cookies，再访问其它接口
     * @param response
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("登录接口，成功后获取到cookies")
    @ApiImplicitParam(name = "username",value = "用户名")
    public String Login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true)String password){
        if (username.equals("zhangsan") && password.equals("123456")){
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "登录成功";
        }
        return "参数不合法";
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u){

        User user;
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for(Cookie c : cookies){
            if(c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUsername().equals("zhangsan")
                    && u.getPassword().equals("123456")
            ){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return  user.toString();
            }

        }

        return "参数不合法";
    }
}
