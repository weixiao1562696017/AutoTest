package com.study.util;

import com.study.bean.InterfaceNameEnum;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author Haley
 * @Date 2020/3/30 10:36
 **/
public class GetUrlUtil {
    /**
     * 获取interfaceURL.properties配置
      */
    private static ResourceBundle bundle = ResourceBundle.getBundle("interfaceURL", Locale.CHINA);

    public static String getUrl(InterfaceNameEnum name){
        String address = bundle.getString("test.url");
        String uri = "";
        if (name.equals(InterfaceNameEnum.ADDUSERINFO)){
            uri = bundle.getString("addUser.uri");
        }else if (name.equals(InterfaceNameEnum.GETUSERINFO)){
            uri = bundle.getString("getUserInfo.uri");
        }else if (name.equals(InterfaceNameEnum.GETUSERLIST)){
            uri = bundle.getString("getUserList.uri");
        }else if (name.equals(InterfaceNameEnum.UPDATEUSERINFO)){
            uri = bundle.getString("updateUserInfo.uri");
        }else if (name.equals(InterfaceNameEnum.LOGIN)){
            uri = bundle.getString("login.uri");
        }
        String testUrl = address + uri;
        return testUrl;
    }
}
