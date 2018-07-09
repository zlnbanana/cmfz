package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.LogDao;
import com.zln.cmfz.entity.Log;
import com.zln.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhanglijiao on 2018/7/9.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public int addLog(Log log) {
        int result = logDao.insertLog(log);
        return result;
    }


}
