package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.MasterDao;
import com.zln.cmfz.entity.Master;
import com.zln.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/6.
 */

@Service
@Transactional
public class MasterServiceImpl implements MasterService{

    @Autowired
    private MasterDao masterDao;


    @Override
    public Map<String, Object> queryAllMaster(Integer nowPage, Integer pageSize) {
        List<Master> masters = masterDao.selectAllMaster((nowPage-1)*pageSize, pageSize );
        int totalRows = masterDao.count();
        Map<String,Object> map = new HashMap<>();
        map.put("total",totalRows);
        map.put("rows",masters);
        return map;
    }

    @Override
    public int addMaster(Master master) {
        int result = masterDao.insertMaster(master);
        return result;
    }


    @Override
    public int modifyMaster(Master master) {
        int result = masterDao.updateMaster(master);
        return result;
    }

    @Override
    public Map<String, Object> queryMaster(String value, Integer nowPage, Integer pageSize) {
        List<Master> persons = masterDao.selectMaster(value,(nowPage-1)*pageSize , pageSize);
        int totalRows = masterDao.total(value);
        Map<String, Object> map = new HashMap<>();
        map.put("total", totalRows);
        map.put("rows", persons);
        return map;
    }

    @Override
    public int addBatch(List<Master> masters) {
        int result = masterDao.insertBatch(masters);
        return result;
    }
}
