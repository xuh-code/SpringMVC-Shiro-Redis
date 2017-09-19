package cn.test.shiro.token;

import cn.test.shiro.session.SessionManager;
import cn.test.utils.SpringContextUtil;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.List;

/**
 * Shiro管理下的Token工具类
 *
 * Created by xuh on 2017/6/30.
 */
public class TokenManager {

    public static final MyRealm realm = SpringContextUtil.getBean("myRealm", MyRealm.class);

    public static final SessionManager adminSessionManager = SpringContextUtil.getBean("adminSessionManager",SessionManager.class);



    /**
     * 根据UserIds 	清空权限信息。
     * @param userIds	用户ID
     */
    public static void clearUserAuthByUserId(Integer...userIds){

        if(null == userIds || userIds.length == 0)	return ;
        List<SimplePrincipalCollection> result = adminSessionManager.getSimplePrincipalCollectionByUserId(userIds);

        for (SimplePrincipalCollection simplePrincipalCollection : result) {
            realm.clearCachedAuthorizationInfo(simplePrincipalCollection);
        }
    }


}
