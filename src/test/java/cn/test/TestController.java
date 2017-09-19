package cn.test;

import cn.test.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * Created by xuh on 2017/8/25.
 */

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestController {
    @Autowired
    private AdminService adminService;

    @Test
    public void getCount(){
//        Integer count = indexService.getArticleCount(2);
//        System.out.println("-------------\n\n\n\n\n\n\n\n\n" + count);
    }

//    @Test
//    public void getList (){
//        List<Article> article = adminService.getArticleList(1*25);
//        System.out.println("-------------\n\n\n\n\n\n\n\n\n" + article.get(0).getId() + "\n\n\n\n\n\n\n\n\n\n------------");
//    }
//
//    @Test
//    public void editAdmin(){
//        Admin admin = new Admin();
//        admin.setUserName("admin");
//        admin.setUserPwd("f8b8e372a98dbe6ae9fdea340f53a755");
//        Integer code = adminService.updateAdmin(admin);
//        System.out.println("-------------\n\n\n\n\n\n\n\n\n" +code + "\n\n\n\n\n\n\n\n\n\n------------");
//    }

    public static void main(String[] args) {
        File file = new File("c:/xuh.sss");
    }
}
