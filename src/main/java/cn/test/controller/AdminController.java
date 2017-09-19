package cn.test.controller;

import cn.test.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 后台管理controller
 * Created by xuh on 2017/8/16.
 */
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/admin/login")
    public void goLogin(HttpServletRequest request){
        System.out.println("admin login");
    }

    /**
     * 登录成功进入后台管理首页
     *
     * @return
     */
    @RequestMapping(value = "/admin/index")
    public ModelAndView goAdminIndex(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/index");
        mav.addObject("info", null);

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //服务器时间
        mav.addObject("serviceTime", format.format(new Date()));
        return mav;
    }

    @RequestMapping(value = "/admin")
    public String goAddArticle() {

        return "/admin/login";
    }

}
