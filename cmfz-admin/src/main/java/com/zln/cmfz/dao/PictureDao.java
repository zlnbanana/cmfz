package com.zln.cmfz.dao;

import com.zln.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhanglijiao on 2018/7/5.
 */
public interface PictureDao {

    public List<Picture> selectAllPic(@Param("begin")Integer begin , @Param("end")Integer end);

    public Integer count();

    public int insertPic(Picture picture);

    public int updatePic(Picture picture);

}
