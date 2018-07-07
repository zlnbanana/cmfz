package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.PictureDao;
import com.zln.cmfz.entity.Picture;
import com.zln.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by zhanglijiao on 2018/7/5.
 */

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;


    @Override
    public Map<String, Object> queryAllPic(Integer nowPage, Integer pageSize) {
        List<Picture> pictures = pictureDao.selectAllPic((nowPage - 1) * pageSize, pageSize);
        int totalRows = pictureDao.count();
        Map<String,Object> map = new HashMap<>();
        map.put("total",totalRows);
        map.put("rows",pictures);

        return map;
    }

    @Override
    public int addPic(Picture picture) {
        picture.setPictureId(UUID.randomUUID().toString().replace("-", ""));
        picture.setPictureDate(new Date());
        int result = pictureDao.insertPic(picture);
        return result;
    }

    @Override
    public int modifyPic(Picture picture) {
        int result = pictureDao.updatePic(picture);
        return result;
    }
}
