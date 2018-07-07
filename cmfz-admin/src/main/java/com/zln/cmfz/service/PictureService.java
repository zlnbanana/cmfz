package com.zln.cmfz.service;

import com.zln.cmfz.entity.Picture;

import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/5.
 */
public interface PictureService {

    public Map<String,Object> queryAllPic(Integer nowPage, Integer pageSize);

    public int addPic(Picture picture);

    public int modifyPic(Picture picture);

}
