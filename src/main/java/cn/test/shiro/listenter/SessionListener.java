package cn.test.shiro.listenter;

import cn.test.shiro.session.ShiroSessionRepository;
import org.apache.shiro.session.Session;

/**
 * shiro 会话 监听
 *
 * Created by xuh on 2017/6/27.
 */
public class SessionListener implements org.apache.shiro.session.SessionListener{

    private ShiroSessionRepository shiroSessionRepository;

    /**
     * 一个回话的生命周期开始
     */
    @Override
    public void onStart(Session session) {
        System.out.println("on onStart");
    }

    @Override
    public void onStop(Session session) {
        System.out.println("on onStop");
    }

    @Override
    public void onExpiration(Session session) {
        shiroSessionRepository.deleteSession(session.getId());
    }

    public ShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }

    public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }
}
