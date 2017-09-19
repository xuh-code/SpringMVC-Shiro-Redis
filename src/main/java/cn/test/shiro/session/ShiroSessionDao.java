package cn.test.shiro.session;

import cn.test.utils.LoggerUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 *
 * Created by xuh on 2017/9/19.
 */
public class ShiroSessionDao extends AbstractSessionDAO {

    private ShiroSessionRepository shiroSessionRepository;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        shiroSessionRepository.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable id) {
        return shiroSessionRepository.getSession(id);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        shiroSessionRepository.saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if(session == null){
            LoggerUtils.error(getClass(), "Session 不能为null");
            return;
        }else{
            Serializable id = session.getId();
            if(id != null) {
                shiroSessionRepository.deleteSession(id);
            }
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }

    public ShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }

    public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }
}
