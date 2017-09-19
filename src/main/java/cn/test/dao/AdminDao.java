package cn.test.dao;

import cn.test.bean.Admin;

import java.util.Set;

/**
 * Created by xuh on 2017/8/16.
 */
public interface AdminDao {

    public Admin getAdminByUserName(String userName);

    Set<String> getPermissions(String username);

    Set<String> getRoles(String username);
}
