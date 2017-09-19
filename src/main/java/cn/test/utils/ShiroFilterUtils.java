package cn.test.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xuh on 2017/5/31.
 */
public class ShiroFilterUtils {
    final static Class<? extends ShiroFilterUtils> CLAZZ = ShiroFilterUtils.class;
    //登录页面
    static final String LOGIN_URL = "/admin";
    //踢出登录提示
    final static String KICKED_OUT = "/";
    //没有权限提醒
    final static String UNAUTHORIZED = "/admin/unAuthor";

    /**
     * 是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest)request).getHeader("X-Requested-With"));
    }

}
