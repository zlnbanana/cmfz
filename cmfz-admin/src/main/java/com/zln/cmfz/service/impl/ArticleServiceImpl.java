package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.ArticleDao;
import com.zln.cmfz.dao.MasterDao;
import com.zln.cmfz.entity.Article;
import com.zln.cmfz.entity.Master;
import com.zln.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private MasterDao masterDao;

    @Override
    public int addArticle(Article article) {
        article.setArticleTime(new Date());
        int result = articleDao.insertArticle(article);
        return result;
    }

    @Override
    public Map<String, Object> queryAllArticles(Integer nowPage, Integer pageSize) {
        List<Article> articles = articleDao.selectArticles((nowPage-1)*pageSize,pageSize);
        int totalRows = articleDao.count();
        Map<String ,Object> map = new HashMap<>();
        map.put("total",totalRows);
        map.put("rows",articles);
        return map;
    }

    @Override
    public List<Master> queryMaster() {
        List<Master> masters = masterDao.selectAllMaster(0,masterDao.count());
        return masters;
    }


}
