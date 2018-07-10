package com.zln.cmfz.test;


import com.zln.cmfz.dao.*;
import com.zln.cmfz.entity.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * Created by zhanglijiao on 2018/7/4.
 */
public class ManagerTest {

    @Test
    public void login(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerDao = (ManagerDao) context.getBean("managerDao");
        Manager manager = managerDao.selectManager("admin");
        System.out.println(manager);
    }

    @Test
    public void menu(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuDao menuDao = (MenuDao) context.getBean("menuDao");
//        Menu menu = menuDao.selectMenuById("1");
//        System.out.println(menu);
        List<Menu> menus = menuDao.selectAllMenus();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    @Test
    public void pic(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureDao picDao = (PictureDao) context.getBean("pictureDao");
        List<Picture> pictures = picDao.selectAllPic(0,3);
        for (Picture picture : pictures) {
            System.out.println(picture);
        }
    }

    @Test
    public void master(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterDao masterDao = (MasterDao) context.getBean("masterDao");
        List<Master> masters = masterDao.selectAllMaster(0,3);
        for (Master master : masters) {
            System.out.println(master);
        }
    }


    @Test
    public void log(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LogDao logDao = (LogDao) context.getBean("logDao");
        List<Log> logs = logDao.selectLog(0,3);
        for (Log log : logs) {
            System.out.println(log);
        }

    }

}
