package com.zln.cmfz.controller;

import com.zln.cmfz.entity.Master;
import com.zln.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 上师 控制层
 * Created by zhanglijiao on 2018/7/6.
 */

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;


    @RequestMapping("/showAllMaster")
    public @ResponseBody Map<String,Object> queryAllMaster(@RequestParam("page") Integer nowPage,@RequestParam("rows") Integer pageSize){
        return masterService.queryAllMaster(nowPage,pageSize);
    }

    @RequestMapping("/addMaster")
    @ResponseBody
    public String addMaster(Master master, HttpSession session, @RequestParam("photo")MultipartFile myFile) throws IOException {
        String realPath = session.getServletContext().getRealPath("").replace("cmfz-admin","upload//master");
        String oldName = myFile.getOriginalFilename();
        myFile.transferTo(new File(realPath + "/" + oldName));
        System.out.println("Hello");
        master.setMasterPhoto(oldName);
        int result = masterService.addMaster(master);
        if(result != 0){
            return "success";
        }
        return null;
    }

    @RequestMapping("/modifyMaster")
    @ResponseBody
    public String modifyMaster(Master master){
        System.out.println(master.getMasterId());
        System.out.println(master);
        int result = masterService.modifyMaster(master);
        if(result != 0){
            return "success";
        }
        return null;
    }


}
