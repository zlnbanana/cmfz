package com.zln.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
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
import java.util.List;
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
        int result = masterService.modifyMaster(master);
        if(result != 0){
            return "success";
        }
        return null;
    }

    @RequestMapping("/queryPersonByOther")
    @ResponseBody
    public Map<String, Object> queryPersonByOther(@RequestParam("value")String value,@RequestParam("page")Integer nowPage,@RequestParam("rows")Integer pageSize){
        /*
        Map<String, Object> map = masterService.queryMaster(value, nowPage, pageSize);
        for (Object o : map.values()) {
            System.out.println(o);
        }*/
        return masterService.queryMaster(value, nowPage, pageSize);
    }


    @RequestMapping("/batchMaster")
    @ResponseBody
    public String batchMaster(MultipartFile excel) throws Exception{
        /**
         * 参数一：输入流
         * 参数二：pojo
         * 参数三：导入参数对象
         */
        ImportParams importParams = new ImportParams();
      //  importParams.setHeadRows(1);
        List<Master> masters = ExcelImportUtil.importExcel(excel.getInputStream(),Master.class,importParams);
      //  System.out.println(masters.size());
      /*  for (Master master : masters) {
            System.out.println(master);
        }*/
        int result = masterService.addBatch(masters);
        if(result != 0){
            return "success";
        }
        return null;
    }

}
