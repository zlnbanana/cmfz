package com.zln.cmfz.service;

import com.zln.cmfz.entity.Manager;

/**
 * Created by zhanglijiao on 2018/7/4.
 */
public interface ManagerService {

    public Manager queryManager(String mgrName, String mgrPwd);
}
