package cn.test.service.impl;

import cn.test.bean.Admin;
import cn.test.dao.AdminDao;
import cn.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by xuh on 2017/8/16.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdminByUserName(String userName) {
        return adminDao.getAdminByUserName(userName);
    }

    @Override
    public Set<String> getRoles(String username) {
        return adminDao.getRoles(username);
    }



    @Override
    public Set<String> getPermissions(String username) {
        return adminDao.getPermissions(username);
    }


}
