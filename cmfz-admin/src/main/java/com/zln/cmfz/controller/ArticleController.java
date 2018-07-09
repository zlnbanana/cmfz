package com.zln.cmfz.controller;

import com.zln.cmfz.entity.Article;
import com.zln.cmfz.entity.RichTextResult;
import com.zln.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by zhanglijiao on 2018/7/8.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    /**
     * 创建文章
     */
    @RequestMapping("/addArticle")
    @ResponseBody
    public String addArticle(Article article , MultipartFile myFile, HttpSession session) throws Exception{
        String realPath = session.getServletContext().getRealPath("").replace("cmfz-admin","upload/article");
        String picName = myFile.getOriginalFilename();
        myFile.transferTo(new File(realPath+"/"+picName));//直接将myFile代表的对象写入到新文件中
        article.setArticlePic(picName);
        int result = articleService.addArticle(article);
        if(result > 0){
            return "success";
        }
        return null;
    }

    /**
     * 使用 wangEditor 富文本编辑器
     */
    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload\\article";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));
                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/article/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }
}

