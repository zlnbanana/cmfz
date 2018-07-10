package com.zln.cmfz.service;


import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/9.
 */

public interface LogService {

    public Map<String,Object> queryAllLog(Integer nowPage, Integer pageSize);

}
