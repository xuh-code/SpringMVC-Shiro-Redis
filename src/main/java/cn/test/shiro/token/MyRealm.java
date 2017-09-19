package cn.test.shiro.token;

import cn.test.bean.Admin;
import cn.test.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义Realm 实现用户的 登录
 * 和用户的权限认证
 * Created by xuh on 2017/8/16.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private AdminService adminService;

    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("myRealm");
        //super();
    }
    public MyRealm() {
        super();
    }


    /**
     * 获取用户的授权信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //数据库中获取 用户的角色  以及权限

        String username = (String) principals.getPrimaryPrincipal(); //获取用户名
        System.out.println("获取" + username + "授权信息");

        authorizationInfo.setRoles(adminService.getRoles(username));
        authorizationInfo.setStringPermissions(adminService.getPermissions(username));

        return authorizationInfo;
    }


    /**
     * 用户登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("用户登录认证!");
        String username = (String) token.getPrincipal(); // 获取用户名
        //String password = String.valueOf(token.getCredentials());
        //获取客户端ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取用户的信息
        Admin admin = adminService.getAdminByUserName(username);

        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getSalt());

        if(admin != null) {
            AuthenticationInfo authcInfo = //new SimpleAuthenticationInfo(admin.getUserName(), admin.getUserPwd(), "myRealm");
                    new SimpleAuthenticationInfo(username, admin.getUserPwd(), credentialsSalt, getName());
//            new SimpleAuthenticationInfo();
            return authcInfo;
        } else {
            throw new UnknownAccountException();
        }
    }



    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
