package cn.test.bean;

import java.util.Date;

/**
 * Created by xuh on 2017/8/16.
 */
public class Admin {

    private Integer id;
    private String userName;
    private String userPwd;
    private Date createTime;
    private Date lastLoginTime;
    private String salt;
    private Integer status;
    private String userDesc;

    public Admin() {
    }

    public Admin(Integer id, String userName, String userPwd, Date createTime, Date lastLoginTime, String salt, Integer status, String userDesc) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.salt = salt;
        this.status = status;
        this.userDesc = userDesc;
    }
    public Admin(Admin admin) {
        this.id = admin.getId();
        this.userName = admin.getUserName();
        this.userPwd = admin.getUserPwd();
        this.userDesc = admin.getUserDesc();
        this.createTime = admin.getCreateTime();
        this.lastLoginTime = admin.getLastLoginTime();
        this.status = admin.getStatus();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", status=" + status +
                ", salt='" + salt + '\'' +
                '}';
    }
}
