package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.MenuDao;
import com.zln.cmfz.entity.Menu;
import com.zln.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhanglijiao on 2018/7/5.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;


    @Override
    public List<Menu> queryAllMenus() {
        List<Menu> menus = menuDao.selectAllMenus();
        return menus;
    }
}
