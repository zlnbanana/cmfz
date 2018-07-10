package com.zln.cmfz.service;

import com.zln.cmfz.entity.Article;
import com.zln.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/8.
 */

public interface ArticleService {

    /**
     * 创建文章
     * @param article
     * @return
     */
    public int addArticle(Article article);


    /**
     * 文章列表
     * @param nowPage
     * @param pageSize
     * @return
     */
    public Map<String,Object> queryAllArticles(Integer nowPage, Integer pageSize);


    public List<Master> queryMaster();
}
