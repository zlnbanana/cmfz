package com.zln.cmfz.controller;

import com.zln.cmfz.entity.Manager;
import com.zln.cmfz.service.ManagerService;
import com.zln.cmfz.util.NewValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by zhanglijiao on 2018/7/4.
 */

@Controller
@RequestMapping("/mgr")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String login(String mgrName, String mgrPwd, String enCode, HttpSession session, String checkbox, HttpServletResponse response) throws Exception {
        String code = (String) session.getAttribute("vCode");
        if(code.equals(enCode)){
            Manager manager = managerService.queryManager(mgrName,mgrPwd);
            if(manager!= null){
                if(checkbox != null){
                    mgrName = URLEncoder.encode(mgrName, "UTF-8");
                    Cookie c1 = new Cookie("name",mgrName);
                    Cookie c2 = new Cookie("pwd",mgrPwd);
                    c1.setMaxAge(60*60*24);
                    c2.setMaxAge(60*60*24);
                    c1.setPath("/");
                    c2.setPath("/");
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                session.setAttribute("manager",manager);
                return "main/main";
            }
        }
        return "login";
    }


    //验证码
    @RequestMapping("/imageCode")
    public void imageCode(HttpServletResponse response,HttpSession session) throws IOException {
        NewValidateCodeUtils utils = new NewValidateCodeUtils(80,30,4);
        session.setAttribute("vCode",utils.getCode());
        utils.write(response.getOutputStream());
    }


}
