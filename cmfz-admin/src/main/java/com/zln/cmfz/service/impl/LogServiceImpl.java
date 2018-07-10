package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.LogDao;
import com.zln.cmfz.entity.Log;
import com.zln.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/10.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public Map<String,Object> queryAllLog(Integer nowPage, Integer pageSize) {
        List<Log> logs = logDao.selectLog((nowPage-1)*pageSize,pageSize);
        int totalRows = logDao.count();
        Map<String,Object> map = new HashMap<>();
        map.put("total",totalRows);
        map.put("rows",logs);
        return map;
    }
}
