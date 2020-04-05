package com.study.cases;

import com.study.bean.BeanTest;
import com.study.bean.InterfaceNameEnum;
import com.study.model.LoginCase;
import com.study.util.DataBaseUtil;
import com.study.util.GetUrlUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author Haley
 * @Date 2020/3/30 11:32
 **/
public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试前准备工作，获取HttpClient对象")
    public void beforeTest(){
        BeanTest.defaultHttpClient = new DefaultHttpClient();
        BeanTest.addUserUrl = GetUrlUtil.getUrl(InterfaceNameEnum.ADDUSERINFO);
        BeanTest.getUserInfoUrl = GetUrlUtil.getUrl(InterfaceNameEnum.GETUSERINFO);
        BeanTest.getUserListUrl = GetUrlUtil.getUrl(InterfaceNameEnum.GETUSERLIST);
        BeanTest.updateUserInfoUrl = GetUrlUtil.getUrl(InterfaceNameEnum.UPDATEUSERINFO);
        BeanTest.loginUrl = GetUrlUtil.getUrl(InterfaceNameEnum.LOGIN);
    }

    @Test(groups = "loginTrue",description = "用户登录成功接口")
    public void loginTrue() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("LoginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(BeanTest.loginUrl);

        // 数据库的数据是设计测试用例数据
        // 通过测试用例数据的期望值和模拟接口返回的值进行对比，来判断接口测试是否正确
        String result = getResult(loginCase);

        Assert.assertEquals(result,loginCase.getExpected());
    }

    @Test(description = "用户登陆失败接口")
    public void loginFalse() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("LoginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(BeanTest.loginUrl);



        //下边的代码为写完接口的测试代码
        String result = getResult(loginCase);
        //处理结果，就是判断返回结果是否符合预期
        Assert.assertEquals(result,loginCase.getExpected());
    }


    private String getResult(LoginCase loginCase) throws IOException {
        // 对接开发人员的接口  测试代码
        HttpPost post = new HttpPost(BeanTest.loginUrl);
        JSONObject params = new JSONObject();
        params.put("name",loginCase.getUserName());
        params.put("password",loginCase.getPassword());

        // 设置请求头
        post.setHeader("content-type","application/json");
        // 将参数信息添加到请求中
        StringEntity stringEntity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(stringEntity);
        // 执行post方法
        HttpResponse response = BeanTest.defaultHttpClient.execute(post);
        // 获取响应信息
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        // 获取cookies
        BeanTest.cookieStore = BeanTest.defaultHttpClient.getCookieStore();
        return result;
    }
}
