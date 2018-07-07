package com.zln.cmfz.controller;

import com.zln.cmfz.entity.Menu;
import com.zln.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhanglijiao on 2018/7/5.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @RequestMapping("/showAllMenu")
    public @ResponseBody List<Menu> showMenu(){
        List<Menu> menus = menuService.queryAllMenus();
        return menus;
    }




}
