package com.zln.cmfz.controller;


import com.zln.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/9.
 */

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("showAllLogs")
    public @ResponseBody
    Map<String,Object> queryAllLog(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        return logService.queryAllLog(nowPage,pageSize);
    }

}

