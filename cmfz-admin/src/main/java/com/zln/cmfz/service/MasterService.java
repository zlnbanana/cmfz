package com.zln.cmfz.service;

import com.zln.cmfz.entity.Master;

import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/6.
 */
public interface MasterService {

    /**
     * 查询所有上师
     * @param nowPage 当前页面
     * @param pageSize 页面大小
     * @return
     */
    public Map<String,Object> queryAllMaster(Integer nowPage,Integer pageSize);

    /**
     * 添加上师
     * @param master
     * @return
     */
    public int addMaster(Master master);

    /**
     * 修改上师信息
     * @param master
     * @return
     */
    public int modifyMaster(Master master);

}
