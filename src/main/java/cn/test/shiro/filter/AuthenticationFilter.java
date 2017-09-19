package cn.test.shiro.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter - 权限认证
 * Created by xuh on 2017/6/6.
 */
public class AuthenticationFilter extends FormAuthenticationFilter{

    //@Autowired
    //private AdminService adminService;
    /**
     * 判断是否被踢出
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        System.out.println("admin 判断是否被踢出");
        return super.isAccessAllowed(request, response, mappedValue);
    }

    /**
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        System.out.println("admin on");
        return super.onAccessDenied(request, response, mappedValue);
    }

    /**
     * 登录成功返回
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("登录成功-------------!");
        String userName = (String) token.getPrincipal(); // 获取用户名
//        HttpServletRequest servletRequest = (HttpServletRequest)request;

//        String ip = SigarInfoUtils.getLocalIP(servletRequest);
//        System.out.println(ip);
//        LoginInfo info = new LoginInfo(userName,"admin",ip);
//        adminService.saveLoginInfo(info);
        return super.onLoginSuccess(token, subject, request, response);
    }

    /**
     * 这里处理ajax 登录超时请求
     * 页面js中获取 返回的login_status 进行跳转操作
     *
     * 登录失败执行操作
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        System.out.println("admin 登录失败");
//        Map<String,String> resultMap = new HashMap<String, String>();
////        boolean s = isLoginRequest(request, response);
//        if(null == token && ShiroFilterUtils.isAjax(request)){// && isEnabled()
//            resultMap.put("login_status", "300");
//            resultMap.put("message",
//                    "\u5F53\u524D\u7528\u6237\u6CA1\u6709\u767B\u5F55\uFF01");// 当前用户没有登录！
//            PrintWriter out = null;
//            try {
//                response.setCharacterEncoding("UTF-8");
//                out = response.getWriter();
//                out.println(JSONObject.fromObject(resultMap).toString());
//            } catch (Exception e1) {
//            }finally{
//                if(null != out){
//                    out.flush();
//                    out.close();
//                }
//            }
//        }
        return super.onLoginFailure(token, e, request, response);
    }
}
