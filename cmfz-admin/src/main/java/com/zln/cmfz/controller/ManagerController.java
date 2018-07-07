package com.zln.cmfz.controller;

import com.zln.cmfz.entity.Manager;
import com.zln.cmfz.service.ManagerService;
import com.zln.cmfz.util.NewValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zhanglijiao on 2018/7/4.
 */

@Controller
@RequestMapping("/mgr")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String mgrName,String mgrPwd,String enCode,HttpSession session){
        String code = (String) session.getAttribute("vCode");
        System.out.println(code);
        if(code.equals(enCode)){
            Manager manager = managerService.queryManager(mgrName,mgrPwd);
            if(manager!= null){
                session.setAttribute("manager",manager);
                return "index";
            }
        }
        return "login";
    }



    //验证码
    @RequestMapping("/imageCode")
    public String imageCode(HttpServletResponse response,HttpSession session) throws IOException {
        NewValidateCodeUtils utils = new NewValidateCodeUtils(80,30,4);
        String vCode = utils.getCode();
        System.out.println(vCode);
        session.setAttribute("vCode",vCode);
        utils.write(response.getOutputStream());
        return null;
    }

}
