package cn.test.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuh on 2017/6/27.
 */
public class AdminOnline extends Admin implements Serializable{

    //Session Id
    private String sessionId;
    //Session Host
    private String host;
    //Session创建时间
    private Date startTime;
    //Session最后交互时间
    private Date lastAccess;
    //Session timeout
    private long timeout;
    //session 是否踢出
    private boolean sessionStatus = Boolean.TRUE;

    public AdminOnline() {
    }

    public AdminOnline(Admin admin) {
        super(admin);
    }


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public boolean isSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(boolean sessionStatus) {
        this.sessionStatus = sessionStatus;
    }


}
