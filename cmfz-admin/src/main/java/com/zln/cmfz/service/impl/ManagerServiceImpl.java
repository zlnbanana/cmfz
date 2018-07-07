package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.ManagerDao;
import com.zln.cmfz.entity.Manager;
import com.zln.cmfz.service.ManagerService;
import com.zln.cmfz.util.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhanglijiao on 2018/7/4.
 */

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    /**
     * @Description     登录
     * @Author          作者
     * @Time
     * @param mgrName   管理员姓名
     * @param mgrPwd    管理员密码
     * @Exception       抛出的异常
     */
    @Override
    public Manager queryManager(String mgrName, String mgrPwd) {
        Manager manager = null;
        try {
            Manager temp = managerDao.selectManager(mgrName);
            String pwd = EncryptionUtils.encryptionCodec(mgrPwd+temp.getMgrSalt());
            if(temp != null && pwd.equals(temp.getMgrPwd())){
                manager = temp;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return manager;
    }
}
