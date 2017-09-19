package cn.test.service;

import cn.test.bean.Admin;

import java.util.Set;

/**
 * Created by xuh on 2017/8/16.
 */
public interface AdminService {

    public Admin getAdminByUserName(String userName);

    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);
}
