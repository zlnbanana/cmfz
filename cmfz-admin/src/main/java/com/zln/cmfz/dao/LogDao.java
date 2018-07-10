package com.zln.cmfz.dao;

import com.zln.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhanglijiao on 2018/7/9.
 */
public interface LogDao {

    public int insertLog(Log log);

    public List<Log> selectLog(@Param("begin") Integer begin,@Param("end") Integer end);

    public int count();

}
