package com.zln.cmfz.service.impl;

import com.zln.cmfz.dao.ArticleDao;
import com.zln.cmfz.entity.Article;
import com.zln.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by zhanglijiao on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public int addArticle(Article article) {
        article.setArticleTime(new Date());
        int result = articleDao.insertArticle(article);
        return result;
    }

}
