package com.zln.cmfz.controller;

import com.zln.cmfz.entity.Picture;
import com.zln.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/5.
 */

@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("showAllPic")
    public @ResponseBody Map<String,Object> queryAllPic(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        return pictureService.queryAllPic(nowPage,pageSize);
    }

    @RequestMapping("/addPic")
    @ResponseBody
    public String addPic(Picture picture,@RequestParam("myFile") MultipartFile myFile,HttpSession session) throws Exception {

        //上传文件
        //获得文件夹名称
        System.out.println(picture);
        String realPath = session.getServletContext().getRealPath("").replace("cmfz-admin","upload/picture");
        String oldName = myFile.getOriginalFilename();
        myFile.transferTo(new File(realPath+"/"+oldName));//直接将myFile代表的对象写入到新文件中
        picture.setPicturePath(oldName);
        int result = pictureService.addPic(picture);
        if(result != 0){
            return "success";
        }
        return null;
    }

    @RequestMapping("/modifyPic")
    @ResponseBody
    public String modifyPic(Picture picture,String picturePath, String pictureDesc, String pictureStatus){
        picture.setPicturePath(picturePath);
        picture.setPictureDesc(pictureDesc);
        picture.setPictureStatus(pictureStatus);
        int result = pictureService.modifyPic(picture);
        if (result != 0){
            return "success";
        }
        return null;
    }


}
