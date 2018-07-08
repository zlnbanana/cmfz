package com.zln.cmfz.dao;

import com.zln.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhanglijiao on 2018/7/6.
 * 上师 DAO
 */
public interface MasterDao {

    public List<Master> selectAllMaster(@Param("begin") Integer begin, @Param("end") Integer end);

    public int count();

    public int insertMaster(Master master);

//    public int deleteMaster(Master master);

    public int updateMaster(Master master);


    //模糊查询
    public List<Master> selectMaster(@Param("value") String value, @Param("begin")Integer begin ,@Param("end")Integer end);
    public int total(@Param("value") String value);

    //批量插入
    public int insertBatch(@Param("list") List<Master> masters);




}
